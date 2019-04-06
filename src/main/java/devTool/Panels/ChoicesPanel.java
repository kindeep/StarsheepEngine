package devTool.Panels;

import devTool.models.EditableJob;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.LineBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

public class ChoicesPanel extends JPanel {
	private static final long serialVersionUID = -3584319698203595596L;
	private JTextField txtField_choiceName;
	private JTextField txtField_choiceId;
	private JTextField txtField_description;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public ChoicesPanel() {
		initalize();
	}
	
	public void initalize() {
		setLayout(new BorderLayout(0, 0));
		JPanel panel_choiceList = new JPanel();
		panel_choiceList.setBorder(new LineBorder(Color.CYAN));
		this.add(panel_choiceList, BorderLayout.EAST);
		panel_choiceList.setLayout(new BorderLayout(0, 0));
		
		JList<EditableJob> list_choices = new JList<EditableJob>();
		panel_choiceList.add(list_choices, BorderLayout.NORTH);
		
		JPanel panel_choiceBtns = new JPanel();
		panel_choiceList.add(panel_choiceBtns, BorderLayout.SOUTH);
		panel_choiceBtns.setLayout(new BoxLayout(panel_choiceBtns, BoxLayout.Y_AXIS));
		
		JButton btn_newChoice = new JButton("New Choice");
		btn_newChoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_choiceBtns.add(btn_newChoice);
		
		JButton btn_editChoice = new JButton("Edit Choice");
		panel_choiceBtns.add(btn_editChoice);
		
		JPanel panel_choiceData = new JPanel();
		add(panel_choiceData, BorderLayout.CENTER);
		panel_choiceData.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(56dlu;default)"),
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("top:default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lbl_choiceName = new JLabel("Choice Name");
		panel_choiceData.add(lbl_choiceName, "1, 1, left, default");
		
		txtField_choiceName = new JTextField();
		panel_choiceData.add(txtField_choiceName, "2, 1, fill, default");
		txtField_choiceName.setColumns(10);
		
		JLabel lbl_choiceId = new JLabel("Choice ID");
		panel_choiceData.add(lbl_choiceId, "1, 3, left, default");
		
		txtField_choiceId = new JTextField();
		txtField_choiceId.setEditable(false);
		panel_choiceData.add(txtField_choiceId, "2, 3, fill, default");
		txtField_choiceId.setColumns(10);
		
		JLabel lbl_description = new JLabel("Description");
		panel_choiceData.add(lbl_description, "1, 5, left, default");
		
		txtField_description = new JTextField();
		panel_choiceData.add(txtField_description, "2, 5, fill, default");
		txtField_description.setColumns(10);
		
		JLabel lblChildren = new JLabel("Children");
		panel_choiceData.add(lblChildren, "1, 7, left, default");
		
		JPanel panel_children = new JPanel();
		panel_choiceData.add(panel_children, "2, 7, fill, fill");
		panel_children.setLayout(new BorderLayout(0, 0));
		
		JList list_children = new JList();
		panel_children.add(list_children, BorderLayout.CENTER);
		
		JPanel panel_childrenBtns = new JPanel();
		panel_children.add(panel_childrenBtns, BorderLayout.SOUTH);
		
		JButton btn_addChild = new JButton("Add New Child");
		panel_childrenBtns.add(btn_addChild);
		
		JButton btn_removeChild = new JButton("Remove Child");
		panel_childrenBtns.add(btn_removeChild);
		
		JLabel lbl_reward = new JLabel("Reward:");
		panel_choiceData.add(lbl_reward, "1, 9, left, default");
		
		textField = new JTextField();
		panel_choiceData.add(textField, "2, 9, fill, default");
		textField.setColumns(10);
	}

}
