package developerTool.Panels;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import developerTool.XMLBuilder.MissionModel;
import developerTool.XMLBuilder.MissionsModel;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.BoxLayout;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class MissionsPanel extends JPanel {
	private static final long serialVersionUID = -9215001740566008009L;
	private JTextField missionTitleTxtField;
	private JTextField missionDescriptionTxtField;
	private JTextField staminaCostTxtField;
	private MissionModel currMission;

	/**
	 * Create the panel.
	 */
	public MissionsPanel(MissionsModel missionsModel) {
		setLayout(new BorderLayout(0, 0));
		LinkedListModel<MissionModel> missionsList = new LinkedListModel<MissionModel>(missionsModel.getMissions());
		JPanel listPanel = new JPanel();
		listPanel.setBorder(new LineBorder(Color.MAGENTA));
		add(listPanel, BorderLayout.WEST);
		listPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel missionBtns = new JPanel();
		listPanel.add(missionBtns, BorderLayout.SOUTH);
		missionBtns.setLayout(new BoxLayout(missionBtns, BoxLayout.Y_AXIS));
		
		JButton newMissionBtn = new JButton("New Mission");
		missionBtns.add(newMissionBtn);
		
		JButton btnNewButton = new JButton("Delete Mission");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				missionsList.removeElement(currMission);
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.RED);
		missionBtns.add(btnNewButton);
		newMissionBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MissionModel mission = new MissionModel(missionsModel.getNextMissionId());
				mission.setTitle("unnamed mission");
				//missionsModel.addMission(mission);
				
				missionsList.push(mission);
			}
		});
		
		LinkedList<MissionModel> missions = missionsModel.getMissions();
		for (int i = 0; i < missions.size(); i++){
			missionsList.push(missions.get(i));
		}
		
		JPanel missionEditor = new JPanel();
		missionEditor.setBackground(Color.GREEN);
		add(missionEditor, BorderLayout.CENTER);
		missionEditor.setLayout(new BorderLayout(0, 0));
		
		JPanel leftPanel = new JPanel();
		missionEditor.add(leftPanel, BorderLayout.WEST);
		leftPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("left:50dlu"),
				ColumnSpec.decode("center:70dlu:grow"),},
			new RowSpec[] {
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblMissionTitle = new JLabel("Mission title:");
		leftPanel.add(lblMissionTitle, "1, 1, center, default");
		
		missionTitleTxtField = new JTextField();
		missionTitleTxtField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				currMission.setTitle(missionTitleTxtField.getText());
			}
		});
		leftPanel.add(missionTitleTxtField, "2, 1, fill, default");
		missionTitleTxtField.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description:");
		leftPanel.add(lblDescription, "1, 3, center, default");
		
		missionDescriptionTxtField = new JTextField();
		leftPanel.add(missionDescriptionTxtField, "2, 3, fill, default");
		missionDescriptionTxtField.setColumns(10);
		
		JLabel lblStaminaCost = new JLabel("Stamina Cost:");
		leftPanel.add(lblStaminaCost, "1, 5, center, default");
		
		staminaCostTxtField = new JTextField();
		leftPanel.add(staminaCostTxtField, "2, 5, fill, default");
		staminaCostTxtField.setColumns(10);
		
		JLabel lblImage = new JLabel("Image:");
		leftPanel.add(lblImage, "1, 7, center, default");
		
		JButton btnBrowse = new JButton("Browse");
		leftPanel.add(btnBrowse, "2, 7");
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBorder(new LineBorder(Color.ORANGE));
		missionEditor.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		
		JList<MissionModel> list = new JList<MissionModel>();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				currMission = list.getSelectedValue();
				missionTitleTxtField.setText(currMission.getTitle());
				missionDescriptionTxtField.setText(currMission.getDescription());
				staminaCostTxtField.setText(String.valueOf(currMission.getStaminaCost()));
			}
		});
		listPanel.add(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		list.setModel(missionsList);
		
		JList list_1 = new JList();
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"job1", "job2", "job3"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		centerPanel.add(list_1);
		
		JPanel jobBtns = new JPanel();
		centerPanel.add(jobBtns, BorderLayout.SOUTH);
		jobBtns.setLayout(new BoxLayout(jobBtns, BoxLayout.Y_AXIS));
		
		JButton editJobBtn = new JButton("Edit Job");
		editJobBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JobEditor jobEditor = new JobEditor();
				jobEditor.setVisible(true);
			}
		});
		jobBtns.add(editJobBtn);
		
		JButton btnNewJob = new JButton("New Job");
		btnNewJob.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JobEditor jobEditor = new JobEditor();
				jobEditor.setVisible(true);
			}
		});
		jobBtns.add(btnNewJob);
	}
}
