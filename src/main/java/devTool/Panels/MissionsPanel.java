package devTool.Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.UUID;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

import com.jgoodies.common.collect.ArrayListModel;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import devTool.models.MissionsModel;
import devTool.models.EditableJobFlyer;
import devTool.models.EditableMission;

public class MissionsPanel extends JPanel {
	private static final long serialVersionUID = -9215001740566008009L;
	private MissionsModel missionsModel;
	private EditableMission currMission;
	private EditableJobFlyer selectedJob = null;

	private JTextField txtField_missionTitle;
	private JTextField txtField_missionDescription;
	private JTextField txtField_staminaCost;
	private JTextField txtField_missionId;
	private JButton btn_editJob;
	private JButton btn_newJob;
	
private JButton btn_newMission;

	private ArrayListModel<EditableJobFlyer> jobListModel;
	private ArrayListModel<EditableMission> missionListModel = null;
	private JList<EditableMission> jList_missionList;
	private JList<EditableJobFlyer> jList_jobList;

	/**
	 * Create the panel.
	 */

	public void updateMissions(MissionsModel missionsModel) {
		this.missionsModel = missionsModel;
		this.missionListModel = missionsModel.getMissions();
		jList_missionList.setModel(missionListModel);
	}
	
	private void deleteMission() {
		missionsModel.getMissions().remove(currMission); //remove mission.
		
		//clear fields.
		txtField_missionId.setText("");
		txtField_missionTitle.setText("");
		txtField_missionDescription.setText("");
		txtField_staminaCost.setText("");
		jobListModel = null;
		btn_editJob.setEnabled(false);
		btn_newJob.setEnabled(false);
	}

	public MissionsPanel() {

		setLayout(new BorderLayout(0, 0));

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
		jList_missionList = new JList<EditableMission>();
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

		jobListModel = new ArrayListModel<EditableJobFlyer>();

		listPanel.add(jList_missionList);
		jList_missionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JPanel rightPanel = new JPanel();
		add(rightPanel, BorderLayout.EAST);
		rightPanel.setBorder(new LineBorder(Color.ORANGE));
		rightPanel.setLayout(new BorderLayout(0, 0));

		jList_jobList = new JList<EditableJobFlyer>();
		jList_jobList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // only one item can be selected.

		rightPanel.add(jList_jobList);

		// job button panel --------------
		JPanel jobBtns = new JPanel();
		rightPanel.add(jobBtns, BorderLayout.SOUTH);
		jobBtns.setLayout(new BoxLayout(jobBtns, BoxLayout.Y_AXIS));

		btn_editJob = new JButton("Edit Job");
		jobBtns.add(btn_editJob);

		btn_newJob = new JButton("New Job");
		jobBtns.add(btn_newJob);

		//==================== listeners ====================
		
		//clicked on a job.
		jList_jobList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedJob = jList_jobList.getSelectedValue();
			}
		});

		//edit job button pressed.
		btn_editJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JobEditor jobEditor = new JobEditor(missionsModel, currMission, selectedJob.id);
				jobEditor.setVisible(true);
			}
		});

		//new job button pressed.
		btn_newJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JobEditor jobEditor = new JobEditor(missionsModel, currMission);
				jobEditor.setVisible(true);
			}
		});

		//delete a mission.
		btn_deleteMission.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete mission: " + currMission.title, "ARE YOU SURE?", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					reply = JOptionPane.showConfirmDialog(null, currMission.title + " and all its jobs and choices will be DELETED. Are you sure?", "FINAL WARNING", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION)
						deleteMission();
				}
			}
		});

		//clicked on a mission.
		jList_missionList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedJob = null;
				currMission = jList_missionList.getSelectedValue();
				
				//update data in fields.
				txtField_missionTitle.setText(currMission.title);
				txtField_missionDescription.setText(currMission.description);
				txtField_staminaCost.setText(String.valueOf(currMission.staminaCost));
				txtField_missionId.setText(currMission.id);
				btn_editJob.setEnabled(true);
				btn_newJob.setEnabled(true);

				//update job list.
				jList_jobList.setModel(currMission.jobFlyers);
			}
		});

		//new mission button pressed.
		btn_newMission.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EditableMission mission = new EditableMission();
				mission.title = "unnamed mission";
				mission.id = UUID.randomUUID().toString();
				missionListModel.add(mission);

			}
		});

		txtField_missionTitle.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				currMission.title = txtField_missionTitle.getText();
				jList_missionList.updateUI();
			}
		});
	}
}
