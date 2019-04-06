package devTool.Panels;

import java.util.LinkedList;
import java.util.UUID;

import devTool.XMLBuilder.MissionsModel;
import devTool.XMLBuilder.XMLBuilder;
import devTool.models.EditableChoice;
import devTool.models.EditableJobBuilder;
import devTool.models.EditableMission;

import engine.starsheep.space.Job.JobFlyer;
import engine.starsheep.space.Job.JobFlyerBuilder;

import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JobEditor extends JFrame {
	private EditableMission currMission;
	private String jobTitle;
	private String jobDescription;
	private String jobOrder;
	private String id;
	private LinkedList<EditableChoice> choices;
	private LinkedListModel<JobFlyer> jobList;
	private MissionsModel missionsModel;
	
	
	private JTextField txtFieldJobTItle;
	private JTextField textField;
	private JTextField txtFieldDescription;

	/**
	 * Create the frame.
	 * @wbp.parser.constructor
	 */
	public JobEditor(LinkedListModel<JobFlyer> jobListModel, MissionsModel mm) {
		this.missionsModel = mm;
		this.jobList = jobListModel;
		initalize();
		jobTitle = "unnamed job";
		jobDescription = "no description.";
		jobOrder = "0";
		id = UUID.randomUUID().toString();
		choices = new LinkedList<EditableChoice>();
	}
	
	/*TODO: complete constructor for editing existing jobs.
	 */
	public JobEditor(LinkedListModel<JobFlyer> jobList, MissionsModel mm, String jobId) {
		this.missionsModel = mm;
		this.jobList = jobList;
		initalize();
	}
	
	private void saveBtnPressed() {
		//save to xml file.
		EditableJobBuilder jobBuilder = new EditableJobBuilder();
		jobBuilder.setId(this.id);
		jobBuilder.setName(this.jobTitle);
		jobBuilder.setDescription(this.jobDescription);
		jobBuilder.setChoices(this.choices);
		//update this job xml.
		XMLBuilder.getInstance().buildJobFile(jobBuilder.build());
		
		///create job flyer and add to job list.
		JobFlyerBuilder flyerBuilder = new JobFlyerBuilder();
		flyerBuilder.setDescription(this.jobDescription);
		flyerBuilder.setJobId(this.id);
		flyerBuilder.setName(this.jobTitle);
		flyerBuilder.setName(this.jobTitle);
		this.jobList.push(flyerBuilder.build());
		
		//update Missions xml.
		XMLBuilder.getInstance().buildMissionsFile(this.missionsModel);
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
		
		JobInfoPanel jobInfoPanel = new JobInfoPanel();
		tabbedPane.addTab("jobInfoPanel", null, jobInfoPanel, null);
		
		ChoicesPanel choicesPanel = new ChoicesPanel();
		tabbedPane.addTab("Choices", null, choicesPanel, null);
		
	}
}
