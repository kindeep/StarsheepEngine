package devTool.Panels;

import java.util.LinkedList;
import java.util.UUID;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

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
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import javax.swing.BoxLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		getContentPane().setLayout(new BorderLayout(0, 0));
		this.setSize(500, 220);
		
		JPanel jobInfoPanel = new JPanel();
		getContentPane().add(jobInfoPanel, BorderLayout.CENTER);
		jobInfoPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblJobTitle = new JLabel("Job Title");
		jobInfoPanel.add(lblJobTitle, "1, 1, right, default");
		
		txtFieldJobTItle = new JTextField();
		jobInfoPanel.add(txtFieldJobTItle, "2, 1, fill, default");
		txtFieldJobTItle.setColumns(10);
		txtFieldJobTItle.setText(this.jobTitle);
		
		JLabel lblId = new JLabel("id:");
		jobInfoPanel.add(lblId, "1, 3, right, default");
		
		textField = new JTextField();
		textField.setEditable(false);
		jobInfoPanel.add(textField, "2, 3, fill, default");
		textField.setColumns(10);
		textField.setText(this.id);
		
		JLabel lblDescription = new JLabel("description:");
		jobInfoPanel.add(lblDescription, "1, 5, right, default");
		
		txtFieldDescription = new JTextField();
		jobInfoPanel.add(txtFieldDescription, "2, 5, fill, default");
		txtFieldDescription.setColumns(10);
		txtFieldDescription.setText(this.jobDescription);
		
		JPanel choiceInfoPanel = new JPanel();
		choiceInfoPanel.setBorder(new LineBorder(Color.CYAN));
		getContentPane().add(choiceInfoPanel, BorderLayout.EAST);
		choiceInfoPanel.setLayout(new BorderLayout(0, 0));
		
		JList<JobModel> choicesList = new JList<JobModel>();
		
		choiceInfoPanel.add(choicesList, BorderLayout.NORTH);
		
		JPanel choicesBtnsPanel = new JPanel();
		choiceInfoPanel.add(choicesBtnsPanel, BorderLayout.SOUTH);
		choicesBtnsPanel.setLayout(new BoxLayout(choicesBtnsPanel, BoxLayout.Y_AXIS));
		
		JButton newChoiceBtn = new JButton("New Choice");
		choicesBtnsPanel.add(newChoiceBtn);
		
		JButton editChoiceBtn = new JButton("Edit Choice");
		choicesBtnsPanel.add(editChoiceBtn);
		
		JToolBar toolBar = new JToolBar();
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnSaveJob = new JButton("Save Job");
		btnSaveJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveBtnPressed();
			}
		});
		toolBar.add(btnSaveJob);
	}
}
