package devTool.Panels;

import devTool.XMLBuilder.MissionsModel;
import devTool.models.EditableMission;
import engine.starsheep.space.Job.JobFlyer;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.common.collect.LinkedListModel;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.border.LineBorder;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;

import java.util.List;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MissionsPanel extends JPanel {
	private static final long serialVersionUID = -9215001740566008009L;
	private JTextField txtField_missionTitle;
	private JTextField txtField_missionDescription;
	private JTextField txtField_staminaCost;
	private EditableMission currMission;
	private List<JobFlyer> jobList;
	private LinkedListModel<JobFlyer> jobListModel;
	private JTextField txtField_missionId;
	private JobFlyer selectedJob = null;

	LinkedListModel<EditableMission> missionsList = null;
	/**
	 * Create the panel.
	 */

	public void updateMissions(List<EditableMission> list) {
		missionsList.clear();
		System.out.println("list updated" + list.size());
		missionsList.addAll(0, list);
		missionsList.fireContentsChanged(0, missionsList.getSize()-1);
	}

	public MissionsPanel(MissionsModel missionsModel) {

		setLayout(new BorderLayout(0, 0));
		missionsList = new LinkedListModel<EditableMission>();
		JPanel listPanel = new JPanel();
		listPanel.setBorder(new LineBorder(Color.MAGENTA));
		add(listPanel, BorderLayout.WEST);
		listPanel.setLayout(new BorderLayout(5, 0));

		JPanel missionBtns = new JPanel();
		listPanel.add(missionBtns, BorderLayout.SOUTH);
		missionBtns.setLayout(new BoxLayout(missionBtns, BoxLayout.Y_AXIS));

		JButton btn_newMission = new JButton("New Mission");
		missionBtns.add(btn_newMission);

		JButton btn_deleteMission = new JButton("Delete Mission");
		missionBtns.add(btn_deleteMission);

		
		// mission form labels + textfields.
		JPanel missionEditor = new JPanel();
		missionEditor.setBackground(Color.GREEN);
		add(missionEditor, BorderLayout.CENTER);
		missionEditor.setLayout(new BorderLayout(0, 0));

		JPanel centerPanel = new JPanel();
		missionEditor.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new FormLayout(
				new ColumnSpec[] { ColumnSpec.decode("left:50dlu"), ColumnSpec.decode("center:53dlu:grow"), },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, }));

		JLabel lbl_missionId = new JLabel("Mission id:");
		centerPanel.add(lbl_missionId, "1, 2, center, default");

		txtField_missionId = new JTextField();
		txtField_missionId.setEnabled(false);
		txtField_missionId.setEditable(false);
		centerPanel.add(txtField_missionId, "2, 2, fill, default");
		txtField_missionId.setColumns(10);

		JLabel lbl_missionTitle = new JLabel("Mission title:");
		centerPanel.add(lbl_missionTitle, "1, 3, center, default");
		JList<EditableMission> list = new JList<EditableMission>();
		txtField_missionTitle = new JTextField();

		centerPanel.add(txtField_missionTitle, "2, 3, fill, default");
		txtField_missionTitle.setColumns(10);

		JLabel lbl_description = new JLabel("Description:");
		centerPanel.add(lbl_description, "1, 5, center, default");

		txtField_missionDescription = new JTextField();
		centerPanel.add(txtField_missionDescription, "2, 5, fill, default");
		txtField_missionDescription.setColumns(10);

		JLabel lbl_staminaCost = new JLabel("Stamina Cost:");
		centerPanel.add(lbl_staminaCost, "1, 7, center, default");

		txtField_staminaCost = new JTextField();
		centerPanel.add(txtField_staminaCost, "2, 7, fill, default");
		txtField_staminaCost.setColumns(10);

		JLabel lblImage = new JLabel("Image:");
		centerPanel.add(lblImage, "1, 9, center, default");

		JButton btnBrowse = new JButton("Browse");
		centerPanel.add(btnBrowse, "2, 9");

		jobListModel = new LinkedListModel<JobFlyer>();
		
		//if a mission is selected, and it has jobflyers.
		if (currMission != null && currMission.getJobFlyers() != null) {
			jobListModel = new LinkedListModel<JobFlyer>(jobList);
		}

		listPanel.add(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(missionsList);

		JPanel rightPanel = new JPanel();
		add(rightPanel, BorderLayout.EAST);
		rightPanel.setBorder(new LineBorder(Color.ORANGE));
		rightPanel.setLayout(new BorderLayout(0, 0));

		JList<JobFlyer> jList_jobList = new JList<JobFlyer>();
		jList_jobList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // only one item can be selected.

		jList_jobList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedJob = jList_jobList.getSelectedValue();
			}
		});
		jList_jobList.setModel(jobListModel);
		rightPanel.add(jList_jobList);

		// job button panel --------------
		JPanel jobBtns = new JPanel();
		rightPanel.add(jobBtns, BorderLayout.SOUTH);
		jobBtns.setLayout(new BoxLayout(jobBtns, BoxLayout.Y_AXIS));

		JButton btn_editJob = new JButton("Edit Job");
		jobBtns.add(btn_editJob);

		JButton btn_newJob = new JButton("New Job");
		jobBtns.add(btn_newJob);

		// listeners ---------------------
		btn_editJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JobEditor jobEditor = new JobEditor(jobListModel, missionsModel, selectedJob.getJobId(), currMission);
				jobEditor.setVisible(true);
			}
		});

		btn_newJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JobEditor jobEditor = new JobEditor(jobListModel, missionsModel);
				jobEditor.setVisible(true);
			}
		});

		btn_deleteMission.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				missionsList.remove(currMission);
				txtField_missionId.setText("");
				txtField_missionTitle.setText("");
				txtField_missionDescription.setText("");
				txtField_staminaCost.setText("");
				jobListModel = null;
				btn_editJob.setEnabled(false);
				btn_newJob.setEnabled(false);

			}
		});

		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedJob = null;
				currMission = list.getSelectedValue();
				txtField_missionTitle.setText(currMission.getTitle());
				txtField_missionDescription.setText(currMission.getDescription());
				txtField_staminaCost.setText(String.valueOf(currMission.getStaminaCost()));
				txtField_missionId.setText(currMission.getId());
				btn_editJob.setEnabled(true);
				btn_newJob.setEnabled(true);
				
				//update job list.
				jobListModel.clear();
				jobListModel.addAll(0, currMission.getJobFlyers());
			}
		});

		btn_newMission.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EditableMission mission = new EditableMission();
				mission.setTitle("unnamed mission");
				missionsList.push(mission);
			}
		});

		txtField_missionTitle.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				currMission.setTitle(txtField_missionTitle.getText());
				list.updateUI();
			}
		});
	}
}
