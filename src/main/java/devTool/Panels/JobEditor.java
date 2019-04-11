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
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.UUID;

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
	
	//common code for both constructors.
	private void setup(MissionsModel mm, EditableMission currMission) {
		this.currMission = currMission;
		this.missionsModel = mm;
	}
	/**
	 * Create the frame.
	 * @wbp.parser.constructor
	 *
	 * Start JobEditor with a brand new job.
	 */
	public JobEditor(MissionsModel mm, EditableMission currMission) {
		this.setup( mm, currMission);
		
		currJob = new EditableJob();
		currJob.id = UUID.randomUUID().toString();
		initalize();
	}
	
	/** 
	 * Start JobEditor with an existing job.
	 * 
	 * @param mm MissionsModel required to update missions.xml upon save.
	 */
	public JobEditor(MissionsModel mm, EditableMission currMission, String jobId) {
		this.setup(mm, currMission);
		
		//read the job.xml file. load the data into a EditableJob object.
		currJob = DevStarReader.readJob(jobId);
		initalize();
	}
	
	private void saveBtnPressed() {
		jobInfoPanel.save(); 
		
		XMLBuilder.getInstance().buildJobFile(currJob);
		
		///create job flyer and add to job list.
		EditableJobFlyer flyer = new EditableJobFlyer();
		flyer.description = currJob.description;
		flyer.id = currJob.id;
		flyer.name = currJob.name;
		
		//update jobFlyer in missionsModel.
		this.updateJobList(flyer);
		
		//update Missions xml.
		XMLBuilder.getInstance().buildMissionsFile(this.missionsModel);
	}
	
	/**
	 * updates jobflyers.
	 * 
	 * @param newFlyer The updated jobflyer.
	 */
	private void updateJobList(EditableJobFlyer newFlyer) {
		
		ArrayListModel<EditableJobFlyer> jobs = currMission.jobFlyers;
		
		if (jobs.getSize() == 0) {
			jobs.add(newFlyer);
			return;
		}
		
		//for each jobflyer in the current mission:
		for (int i = 0; i < jobs.getSize(); i++) {
			EditableJobFlyer flyer = jobs.get(i);
			if (flyer.id.compareTo(currJob.id) == 0) { //replace jobflyer.
					jobs.set(i, newFlyer);
					break;
			} else {
				if (i == jobs.getSize() -1 ) {
					jobs.add(newFlyer); //add new jobflyer.
					break;
				}
			}
		}
	}
	
	private void initalize() {
		this.setTitle("Job Editor");
		getContentPane().setLayout(new BorderLayout(0, 0));
		this.setSize(725, 455);
		
		JToolBar toolBar = new JToolBar();
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnSaveJob = new JButton("Save Job");
		btnSaveJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveBtnPressed();
			}
		});
		toolBar.add(btnSaveJob);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		jobInfoPanel = new JobInfoPanel(currJob);
		tabbedPane.addTab("jobInfoPanel", null, jobInfoPanel, null);
		
		ChoicesPanel choicesPanel = new ChoicesPanel();
		tabbedPane.addTab("Choices", null, choicesPanel, null);
	}
}
