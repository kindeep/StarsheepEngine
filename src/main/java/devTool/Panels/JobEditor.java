package devTool.Panels;

import java.util.LinkedList;
import java.util.UUID;

import devTool.XMLBuilder.JobFlyerModel;
import devTool.XMLBuilder.MissionsModel;
import devTool.XMLBuilder.MissionModel;
import devTool.XMLBuilder.ChoiceModel;
import devTool.XMLBuilder.XMLBuilder;
import devTool.XMLBuilder.JobModel;

import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;

public class JobEditor extends JFrame {
	private MissionModel currMission;
	private String jobTitle;
	private String jobDescription;
	private String jobOrder;
	private String id;
	private LinkedList<ChoiceModel> choices;
	private LinkedListModel<JobFlyerModel> jobList;
	private MissionsModel missionsModel;
	
	
	private JTextField txtFieldJobTItle;
	private JTextField textField;
	private JTextField txtFieldDescription;

	/**
	 * Create the frame.
	 * @wbp.parser.constructor
	 */
	public JobEditor(LinkedListModel<JobFlyerModel> jobList, MissionsModel mm) {
		this.missionsModel = mm;
		this.jobList = jobList;
		initalize();
		jobTitle = "unnamed job";
		jobDescription = "no description.";
		jobOrder = "0";
		id = UUID.randomUUID().toString();
		choices = new LinkedList<ChoiceModel>();
	}
	
	/*TODO: complete constructor for editing existing jobs.
	 */
	public JobEditor(LinkedListModel<JobFlyerModel> jobList, MissionsModel mm, String jobId) {
		this.missionsModel = mm;
		this.jobList = jobList;
		initalize();
	}
	
	private void saveBtnPressed() {
		//save to xml file.
		JobModel jobModel = new JobModel();
		jobModel.setId(this.id);
		jobModel.setTitle(this.jobTitle);
		jobModel.setDescription(this.jobDescription);
		jobModel.setChoices(this.choices);
		XMLBuilder.buildJobFile(jobModel);
		
		///create job flyer and add to job list.
		JobFlyerModel flyer = new JobFlyerModel();
		flyer.setDescription(this.jobDescription);
		flyer.setId(this.id);
		flyer.setImageId("image id missing");
		flyer.setName(this.jobTitle);
		this.jobList.push(flyer);
		
		//update Missions xml.
		XMLBuilder.buildMissionsFile(this.missionsModel);
	}
	
	private void initalize() {
		this.setTitle("Job Editor");
		getContentPane().setLayout(new BorderLayout(0, 0));
		this.setSize(500, 220);
		
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
		getContentPane().add(tabbedPane, BorderLayout.NORTH);
		
		JobInfoPanel jobInfoPanel = new JobInfoPanel();
		tabbedPane.addTab("jobInfoPanel", null, jobInfoPanel, null);
		
		ChoicesPanel choicesPanel = new ChoicesPanel();
		tabbedPane.addTab("Choices", null, choicesPanel, null);
		
	}
}
