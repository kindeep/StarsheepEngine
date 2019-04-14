package devTool.Panels;

import devTool.DevStarReader;
import devTool.models.MissionsModel;
import devTool.XMLBuilder.XMLBuilder;
import devTool.models.EditableJob;
import devTool.models.EditableJobFlyer;
import devTool.models.EditableMission;

import com.jgoodies.common.collect.ArrayListModel;

import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.xml.bind.JAXBException;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.UUID;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author peakyDicers
 *
 */
public class JobEditor extends JFrame {
	private static final long serialVersionUID = 3708943064065821431L;

	private EditableMission currMission;
	private EditableJob currJob = null;
	private MissionsModel missionsModel;
	private JobInfoPanel jobInfoPanel;
	private ChoicesGraph graph;

	// common code for both constructors.
	private void setup(MissionsModel mm, EditableMission currMission) {
		this.currMission = currMission;
		this.missionsModel = mm;
	}

	/**
	 * Create the frame.
	 * 
	 * @wbp.parser.constructor
	 *
	 * 						Start JobEditor with a brand new job.
	 */
	public JobEditor(MissionsModel mm, EditableMission currMission) {
		this.setup(mm, currMission);

		currJob = new EditableJob();
		currJob.id = UUID.randomUUID().toString();
		initalize();
	}

	/**
	 * Start JobEditor with an existing job.
	 * 
	 * @param mm
	 *            MissionsModel required to update missions.xml upon save.
	 */
	public JobEditor(MissionsModel mm, EditableMission currMission, String jobId) {
		this.setup(mm, currMission);

		// read the job.xml file. load the data into a EditableJob object.
		currJob = DevStarReader.readJob(jobId);
		initalize();
	}

	private void saveBtnPressed() {
		jobInfoPanel.save();

		XMLBuilder.getInstance().buildJobFile(currJob);

		/// create job flyer and add to job list.
		EditableJobFlyer flyer = new EditableJobFlyer();
		flyer.description = currJob.description;
		flyer.id = currJob.id;
		flyer.name = currJob.name;

		// update jobFlyer in missionsModel.
		this.updateJobList(flyer);

		// update Missions xml.
		try {
			XMLBuilder.getInstance().buildMissionsFile(this.missionsModel);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "This job has been saved.");
	}

	private void deleteJob() {
		// delete the job.xml file.
		boolean success = XMLBuilder.getInstance().deleteJobFile(currJob.id);
		if (!success)
			JOptionPane.showMessageDialog(null, "The job file: j_" + currJob.id + " could not be deleted.");

		// remove job from missions.xml
		EditableJobFlyer toDelete = null;
		for (EditableJobFlyer flyer : currMission.jobFlyers) {
			if (flyer.id.compareTo(currJob.id) == 0) {
				toDelete = flyer;
				break;
			}
		}
		currMission.jobFlyers.remove(toDelete);

		// save missions.xml
		try {
			XMLBuilder.getInstance().buildMissionsFile(this.missionsModel);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "This job has been deleted.");
		setVisible(false);
		dispose();
	}

	/**
	 * updates jobflyers.
	 * 
	 * @param newFlyer
	 *            The updated jobflyer.
	 */
	private void updateJobList(EditableJobFlyer newFlyer) {

		ArrayListModel<EditableJobFlyer> jobs = currMission.jobFlyers;

		if (jobs.getSize() == 0) {
			jobs.add(newFlyer);
			return;
		}

		// for each jobflyer in the current mission:
		for (int i = 0; i < jobs.getSize(); i++) {
			EditableJobFlyer flyer = jobs.get(i);
			if (flyer.id.compareTo(currJob.id) == 0) { // replace jobflyer.
				jobs.set(i, newFlyer);
				break;
			} else {
				if (i == jobs.getSize() - 1) {
					jobs.add(newFlyer); // add new jobflyer.
					break;
				}
			}
		}
	}

	private void initalize() {
		// create graph.
		graph = new ChoicesGraph(currJob.choices);
		graph.setTitle(currJob.name);
		graph.populateGraph();

		this.setTitle("Job Editor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		this.setSize(725, 455);

		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		getContentPane().add(toolBar, BorderLayout.NORTH);

		JButton btnSaveJob = new JButton("Save Job");
		btnSaveJob.setBackground(new Color(51, 255, 102));
		btnSaveJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveBtnPressed();
			}
		});
		toolBar.add(btnSaveJob);

		JButton btnNewButton = new JButton("DELETE JOB");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this job?",
						"ARE YOU SURE?", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION)
					deleteJob();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(255, 0, 0));
		toolBar.add(btnNewButton);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		jobInfoPanel = new JobInfoPanel(currJob, graph);
		tabbedPane.addTab("jobInfoPanel", null, jobInfoPanel, null);

		ChoicesPanel choicesPanel = new ChoicesPanel(currJob, graph);
		tabbedPane.addTab("Choices", null, choicesPanel, null);
	}
}
