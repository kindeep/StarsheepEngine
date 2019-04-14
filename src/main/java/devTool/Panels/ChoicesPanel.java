package devTool.Panels;

import devTool.models.EditableChoice;
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
import javax.swing.ListSelectionModel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.UUID;

//TODO: (MEDIUM PRIORITY) auto select a choice, don't let the fields be editable if no choice selected
// TODO: Remove Select button for child, click=select
public class ChoicesPanel extends JPanel {
	private static final long serialVersionUID = -3584319698203595596L;
	private JTextField txtField_choiceName;
	private JTextField txtField_choiceId;
	private JTextField txtField_description;
	private JTextField textField;
	private JLabel lbl_viewer_choiceName;
	private JList<String> list_children;
	private JList<EditableChoice> list_choices;

	private EditableJob currJob;
	private EditableChoice selectedChoice;
	private String selectedChild;
	private ChoicesGraph graph;

	/**
	 * Create the panel.
	 */
	public ChoicesPanel(EditableJob currJob, ChoicesGraph graph) {
		this.currJob = currJob;
		this.graph = graph;
		initalize();
	}

	public void updateDisplay() {
		clearDisplay();
		txtField_choiceName.setText(selectedChoice.name);
		txtField_choiceId.setText(selectedChoice.id);
		txtField_description.setText(selectedChoice.description);
		list_children.setModel(selectedChoice.children);
	}

	private void save() {
		selectedChoice.name = txtField_choiceName.getText();
		selectedChoice.description = txtField_description.getText();
		
		//update choices list.
		list_choices.repaint();
	}

	private void clearDisplay() {
		txtField_choiceName.setText("");
		txtField_choiceId.setText("");
		txtField_description.setText("");
		lbl_viewer_choiceName.setText("");
	}

	void updateGraph() {
		graph.populateGraph();
	}

	public void initalize() {
		setLayout(new BorderLayout(0, 0));
		JPanel panel_choiceList = new JPanel();
		panel_choiceList.setBorder(new LineBorder(Color.CYAN));
		this.add(panel_choiceList, BorderLayout.EAST);
		panel_choiceList.setLayout(new BorderLayout(0, 0));

		list_choices = new JList<EditableChoice>();
		list_choices.setModel(currJob.choices);
		list_choices.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		panel_choiceList.add(list_choices, BorderLayout.CENTER);

		JPanel panel_choiceBtns = new JPanel();
		panel_choiceList.add(panel_choiceBtns, BorderLayout.SOUTH);
		panel_choiceBtns.setLayout(new BoxLayout(panel_choiceBtns, BoxLayout.Y_AXIS));

		JButton btn_newChoice = new JButton("New Choice");
		panel_choiceBtns.add(btn_newChoice);

		JButton btn_deleteChoice = new JButton("Delete Choice");
		panel_choiceBtns.add(btn_deleteChoice);

		JPanel panel_choiceData = new JPanel();
		add(panel_choiceData, BorderLayout.CENTER);
		panel_choiceData.setLayout(new FormLayout(
				new ColumnSpec[] { ColumnSpec.decode("max(56dlu;default)"), ColumnSpec.decode("default:grow"), },
				new RowSpec[] { FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("top:default:grow"), FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, }));

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

		JLabel lbl_children = new JLabel("Children");
		panel_choiceData.add(lbl_children, "1, 7, left, default");

		JPanel panel_children = new JPanel();
		panel_choiceData.add(panel_children, "2, 7, fill, fill");
		panel_children.setLayout(new BorderLayout(0, 0));

		list_children = new JList<String>();

		panel_children.add(list_children, BorderLayout.CENTER);

		JPanel panel_childrenBtns = new JPanel();
		panel_children.add(panel_childrenBtns, BorderLayout.SOUTH);

		JButton btn_addChild = new JButton("Add New Child");

		panel_childrenBtns.add(btn_addChild);

		JButton btn_removeChild = new JButton("Remove Child");

		panel_childrenBtns.add(btn_removeChild);

		JPanel panel_childViewer = new JPanel();
		panel_children.add(panel_childViewer, BorderLayout.NORTH);

		lbl_viewer_choiceName = new JLabel("");
		panel_childViewer.add(lbl_viewer_choiceName);

		JLabel lbl_reward = new JLabel("Reward:");
		panel_choiceData.add(lbl_reward, "1, 9, left, default");

		textField = new JTextField();
		panel_choiceData.add(textField, "2, 9, fill, default");
		textField.setColumns(10);

		JButton btn_saveChoice = new JButton("Save Choice");
		add(btn_saveChoice, BorderLayout.NORTH);

		// ================ LISTENERS ================

		// save choice
		btn_saveChoice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				save();
				updateGraph();
			}
		});

		// add a new choice.
		btn_newChoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditableChoice choice = new EditableChoice();
				choice.id = UUID.randomUUID().toString();
				choice.name = "Unnamed choice.";
				currJob.choices.add(choice);
				updateGraph();
			}
		});

		// delete choice.
		btn_deleteChoice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO: potentially need to update xml file

				// remove this choice from the children of other choices.
				for (EditableChoice choice : currJob.choices) {
					ArrayList<String> toRemove = new ArrayList<String>();
					for (String child : choice.children) {
						if (child.compareTo(selectedChoice.id) == 0) {
							toRemove.add(child);
						}
					}
					choice.children.removeAll(toRemove);
				}

				// delete this choice.
				currJob.choices.remove(selectedChoice);

				updateGraph();
			}
		});

		// select a choice.
		list_choices.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedChoice = list_choices.getSelectedValue();

				System.out.println("choice cliked on." + selectedChoice);
				updateDisplay();
			}
		});

		// add a child.
		btn_addChild.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChoiceListDisplay display = new ChoiceListDisplay(currJob.choices, selectedChoice.children, graph);
				display.setVisible(true);
			}
		});

		// select a child.
		list_children.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedChild = list_children.getSelectedValue();
				EditableChoice choice = null;
				for (EditableChoice c : currJob.choices) {
					if (c.id.compareTo(selectedChild) == 0) {
						choice = c;
					}
				}
				if (choice != null)
					lbl_viewer_choiceName.setText(choice.name);
			}
		});

		// delete a child
		btn_removeChild.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedChoice.children.remove(selectedChild);
				selectedChoice = null;
				updateDisplay();
			}
		});
	}
}
