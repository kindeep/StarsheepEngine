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
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.BoxLayout;

public class MissionsPanel extends JPanel {
	private static final long serialVersionUID = -9215001740566008009L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public MissionsPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel listPanel = new JPanel();
		listPanel.setBorder(new LineBorder(Color.MAGENTA));
		add(listPanel, BorderLayout.WEST);
		listPanel.setLayout(new BorderLayout(0, 0));
		
		JButton newMissionBtn = new JButton("New Mission");
		listPanel.add(newMissionBtn, BorderLayout.SOUTH);
		
		JList list = new JList();
		listPanel.add(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"batman", "spiderman", "superman", "aquaman"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
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
		
		textField = new JTextField();
		leftPanel.add(textField, "2, 1, fill, default");
		textField.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description:");
		leftPanel.add(lblDescription, "1, 3, center, default");
		
		textField_1 = new JTextField();
		leftPanel.add(textField_1, "2, 3, fill, default");
		textField_1.setColumns(10);
		
		JLabel lblStaminaCost = new JLabel("Stamina Cost:");
		leftPanel.add(lblStaminaCost, "1, 5, center, default");
		
		textField_2 = new JTextField();
		leftPanel.add(textField_2, "2, 5, fill, default");
		textField_2.setColumns(10);
		
		JLabel lblImage = new JLabel("Image:");
		leftPanel.add(lblImage, "1, 7, center, default");
		
		JButton btnBrowse = new JButton("Browse");
		leftPanel.add(btnBrowse, "2, 7");
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBorder(new LineBorder(Color.ORANGE));
		missionEditor.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		
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
		jobBtns.add(editJobBtn);
		
		JButton btnNewJob = new JButton("New Job");
		jobBtns.add(btnNewJob);

	}

}
