package devTool.Panels;

import devTool.models.EditableChoice;
import devTool.models.EditableJob;
import devTool.models.EditableTraitDependency;
import engine.starsheep.space.Job.TraitDependency;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.LineBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.common.collect.ArrayListModel;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.UUID;
import javax.swing.JFormattedTextField;

//TODO: (MEDIUM PRIORITY) auto select a choice, don't let the fields be editable if no choice selected
// TODO: Remove Select button for child, click=select
public class ChoicesPanel extends JPanel {
	private static final long serialVersionUID = -3584319698203595596L;
	private JTextField txtField_choiceName;
	private JTextField txtField_choiceId;
	private JTextField txtField_description;
	private JTextField txtField_staminaCost;
	private JTextField textField;
	private JLabel lbl_viewer_choiceName;
	private JList<String> jList_children;
	private JList<EditableChoice> jList_choices;
	private JList<EditableTraitDependency> jList_traitDependencies;

	private EditableJob currJob;
	private EditableChoice selectedChoice;
	private EditableTraitDependency selectedTrait;
	private String selectedChild;
	
	private ChoicesGraph graph;
	private JTextField txtField_trait_id;
	private JTextField txtField_trait_weight;

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
		txtField_staminaCost.setText(String.valueOf(selectedChoice.staminaCost));
		jList_children.setModel(selectedChoice.children);
		jList_traitDependencies.setModel(selectedChoice.traitDependencies);
	}

	private void save() {
		selectedChoice.name = txtField_choiceName.getText();
		selectedChoice.description = txtField_description.getText();
		String staminaCost = txtField_staminaCost.getText();
		if (isInteger(staminaCost))
			selectedChoice.staminaCost = Integer.valueOf(staminaCost);
		else
			JOptionPane.showMessageDialog(this, "Stamina Cost must be an integer.");
		//update choices list.
		jList_choices.repaint();
	}
	
	public boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    return true;
	}

	private void clearDisplay() {
		txtField_choiceName.setText("");
		txtField_choiceId.setText("");
		txtField_description.setText("");
		txtField_trait_id.setText("");
		txtField_trait_weight.setText("");
		txtField_staminaCost.setText("");
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

		jList_choices = new JList<EditableChoice>();
		jList_choices.setModel(currJob.choices);
		jList_choices.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		panel_choiceList.add(jList_choices, BorderLayout.CENTER);

		JPanel panel_choiceBtns = new JPanel();
		panel_choiceList.add(panel_choiceBtns, BorderLayout.SOUTH);
		panel_choiceBtns.setLayout(new BoxLayout(panel_choiceBtns, BoxLayout.Y_AXIS));

		JButton btn_newChoice = new JButton("New Choice");
		panel_choiceBtns.add(btn_newChoice);

		JButton btn_deleteChoice = new JButton("Delete Choice");
		panel_choiceBtns.add(btn_deleteChoice);

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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
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

		JLabel lbl_children = new JLabel("Children");
		panel_choiceData.add(lbl_children, "1, 7, left, default");

		JPanel panel_children = new JPanel();
		panel_choiceData.add(panel_children, "2, 7, fill, fill");
		panel_children.setLayout(new BorderLayout(0, 0));

		jList_children = new JList<String>();

		panel_children.add(jList_children, BorderLayout.CENTER);

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
		
		JLabel lbl_staminaCost = new JLabel("Stamina Cost");
		panel_choiceData.add(lbl_staminaCost, "1, 9, left, default");
		
		txtField_staminaCost = new JTextField();
		panel_choiceData.add(txtField_staminaCost, "2, 9, fill, default");
		
		JLabel lbl_traitDependencies = new JLabel("Trait Dependencies");
		panel_choiceData.add(lbl_traitDependencies, "1, 11");
		
		JPanel panel_traitDependencies = new JPanel();
		panel_choiceData.add(panel_traitDependencies, "2, 11, fill, fill");
		panel_traitDependencies.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_traitBtns = new JPanel();
		panel_traitDependencies.add(panel_traitBtns, BorderLayout.SOUTH);
		
		JButton btn_addTrait = new JButton("Add Trait");
		
		panel_traitBtns.add(btn_addTrait);
		
		JButton btn_removeTrait = new JButton("Remove Trait");
		
		panel_traitBtns.add(btn_removeTrait);
		
		JPanel panel_traitDisplay = new JPanel();
		panel_traitDependencies.add(panel_traitDisplay, BorderLayout.CENTER);
		panel_traitDisplay.setLayout(new BorderLayout(0, 0));
		
		jList_traitDependencies = new JList();
		
		panel_traitDisplay.add(jList_traitDependencies, BorderLayout.CENTER);
		
		JPanel panel_traitSummary = new JPanel();
		panel_traitDisplay.add(panel_traitSummary, BorderLayout.EAST);
		panel_traitSummary.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lbl_id = new JLabel("id");
		panel_traitSummary.add(lbl_id, "2, 2, left, default");
		
		txtField_trait_id = new JTextField();
		txtField_trait_id.setEditable(false);
		panel_traitSummary.add(txtField_trait_id, "4, 2, fill, default");
		txtField_trait_id.setColumns(10);
		
		JLabel lbl_weight = new JLabel("Weight");
		panel_traitSummary.add(lbl_weight, "2, 4, right, default");
		
		txtField_trait_weight = new JTextField();
		txtField_trait_weight.setEditable(false);
		panel_traitSummary.add(txtField_trait_weight, "4, 4, fill, default");
		txtField_trait_weight.setColumns(10);

		JLabel lbl_reward = new JLabel("Reward:");
		panel_choiceData.add(lbl_reward, "1, 13, left, default");

		textField = new JTextField();
		panel_choiceData.add(textField, "2, 13, fill, default");
		textField.setColumns(10);

		JButton btn_saveChoice = new JButton("Save Choice");
		add(btn_saveChoice, BorderLayout.NORTH);

		// ================ LISTENERS ================

		//adds a trait.
		btn_addTrait.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TraitDependencyPicker picker = new TraitDependencyPicker(selectedChoice);
			}
		});
		
		//deletes a trait.
		btn_removeTrait.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedChoice.traitDependencies.remove(selectedTrait);
			}
		});
		
		
		//selected a trait dependency
		jList_traitDependencies.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedTrait = jList_traitDependencies.getSelectedValue();
				txtField_trait_id.setText(selectedTrait.id);
				txtField_trait_weight.setText(selectedTrait.weight);
			}
		});
		
		
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
		jList_choices.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedChoice = jList_choices.getSelectedValue();
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
		jList_children.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedChild = jList_children.getSelectedValue();
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
