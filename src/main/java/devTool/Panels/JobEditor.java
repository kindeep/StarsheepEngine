package devTool.Panels;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

public class JobEditor extends JFrame {

	private JPanel contentPane;
	private JTextField txtField_jobName;
	private JTextField txtField_description;
	private JTextField txtField_staminaCost;

	/**
	 * Create the frame.
	 */
	public JobEditor() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel choiceEditorPanel = new JPanel();
		contentPane.add(choiceEditorPanel, BorderLayout.CENTER);
		choiceEditorPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel choicesListPanel = new JPanel();
		choiceEditorPanel.add(choicesListPanel, BorderLayout.NORTH);
		
		JPanel jobInfoPanel = new JPanel();
		contentPane.add(jobInfoPanel, BorderLayout.WEST);
		FormLayout fl_jobInfoPanel = new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,});
		fl_jobInfoPanel.setColumnGroup(new int[] {2});
		fl_jobInfoPanel.setRowGroup(new int[] {3});
		jobInfoPanel.setLayout(fl_jobInfoPanel);
		
		JLabel lblJobName = new JLabel("Job Name:");
		jobInfoPanel.add(lblJobName, "1, 1, left, default");
		
		txtField_jobName = new JTextField();
		jobInfoPanel.add(txtField_jobName, "3, 1, fill, default");
		txtField_jobName.setColumns(10);
		
		JLabel lblDescription = new JLabel("description:");
		jobInfoPanel.add(lblDescription, "1, 3, left, default");
		
		txtField_description = new JTextField();
		jobInfoPanel.add(txtField_description, "3, 3, fill, default");
		txtField_description.setColumns(10);
		
		JLabel lblImage = new JLabel("primary image:");
		jobInfoPanel.add(lblImage, "1, 5");
		
		JButton btnBrowse = new JButton("Browse");
		jobInfoPanel.add(btnBrowse, "3, 5");
		
		JLabel lblSecondaryImage = new JLabel("secondary image:");
		jobInfoPanel.add(lblSecondaryImage, "1, 7");
		
		JButton btnBrowse_1 = new JButton("Browse");
		jobInfoPanel.add(btnBrowse_1, "3, 7");
		
		JLabel lblStaminaCost = new JLabel("stamina cost:");
		jobInfoPanel.add(lblStaminaCost, "1, 9, right, default");
		
		txtField_staminaCost = new JTextField();
		jobInfoPanel.add(txtField_staminaCost, "3, 9, fill, default");
		txtField_staminaCost.setColumns(10);
		
		JPanel choiceListPanel = new JPanel();
		contentPane.add(choiceListPanel, BorderLayout.EAST);
		
		JList choicesList = new JList();
		choiceListPanel.add(choicesList);
	}
}
