package devTool.Panels;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import devTool.DevStarReader;
import devTool.XMLBuilder.MissionsModel;
import devTool.XMLBuilder.XMLBuilder;
import devTool.models.EditableChoice;
import devTool.models.EditableJob;
import devTool.models.EditableJobFlyer;
import devTool.models.EditableMission;

import engine.starsheep.space.Job.JobFlyer;
import engine.starsheep.space.Job.JobFlyerBuilder;

import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

import com.jgoodies.common.collect.LinkedListModel;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JobEditor extends JFrame {
	
	private EditableMission currMission;
	private LinkedList<EditableChoice> choices;
	private LinkedListModel<JobFlyer> jobList;
	private MissionsModel missionsModel;
	private EditableJob currJob = null;
	private JobInfoPanel jobInfoPanel;

	
	
	//common code for both constructors.
	private void setup(LinkedListModel<JobFlyer> jobListModel, MissionsModel mm, EditableMission currMission) {
		this.currMission = currMission;
		this.missionsModel = mm;
		this.jobList = jobListModel;
	}
	/**
	 * Create the frame.
	 * @wbp.parser.constructor
	 */
	
	/**
	 * This construcotr is used to open a brand new job.
	 */
	public JobEditor(LinkedListModel<JobFlyer> jobListModel, MissionsModel mm, EditableMission currMission) {
		this.setup(jobListModel, mm, currMission);
		
		currJob = new EditableJob();
		currJob.setId(UUID.randomUUID().toString());
		choices = new LinkedList<EditableChoice>();
		
		initalize();
	}
	
	/** 
	 * This constructor is used to open an existing job.
	 * 
	 * @param mm MissionsModel required to update missions.xml upon save.
	 */
	public JobEditor(LinkedListModel<JobFlyer> jobListModel, MissionsModel mm, EditableMission currMission, String jobId) {
		this.setup(jobListModel, mm, currMission);
		
		//read the job.xml file. load the data into a EditableJob object.
		currJob = DevStarReader.readJob(jobId);
		initalize();
	}
	
	private void saveBtnPressed() {
		//save to xml file.
		jobInfoPanel.save();
		//update this job xml.
		XMLBuilder.getInstance().buildJobFile(currJob);
		
		///create job flyer and add to job list.
		EditableJobFlyer flyer = new EditableJobFlyer();
		flyer.setDescription(currJob.getDescription());
		flyer.setJobId(currJob.getId());
		flyer.setName(currJob.getName());
		
		//update the LinkedListModel<JobFLyer>
		this.updateJobList(flyer);
		
		//update the jobList in MissionsModel.
		List<JobFlyer> flyers = currMission.getJobFlyers();
		flyers.clear();
		System.out.println("JobList size: " + jobList);
		flyers.addAll(jobList);
		
		//update Missions xml.
		XMLBuilder.getInstance().buildMissionsFile(this.missionsModel);
	}
	
	/**
	 * Checks if the job is already in the job list. If it is not,
	 * we add the the new JobFlyer. If it is, we replace the old 
	 * flyer with the new.
	 * 
	 * @param newFlyer The updated jobflyer.
	 */
	private void updateJobList(JobFlyer newFlyer) {
		if (jobList.getSize() == 0) {
			this.jobList.add(newFlyer);
			return;
		}
		
		for (int i = 0; i < jobList.getSize(); i++) {
			JobFlyer flyer = jobList.getElementAt(i);
			if (flyer.getJobId().compareTo(currJob.getId()) == 0) { //replace jobflyer.
					jobList.set(i, newFlyer);
					System.out.println("repaced a jobflyer.");
					break;
			} else {
				if (i == jobList.getSize() -1 ) {
					this.jobList.add(newFlyer); //add new jobflyer.
					System.out.println("added a jobflyer.");
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
