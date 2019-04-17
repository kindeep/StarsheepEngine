package devTool.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import devTool.models.EditableChoice;
import devTool.models.EditableTrait;
import devTool.models.EditableTraitDependency;
import devTool.models.GameDataManager;

/**
 * 
 * @author peakyDicers
 *
 */
public class TraitDependencyPicker extends JFrame {
	private static final long serialVersionUID = -5198085762569721500L;
	private JPanel contentPane;
	private JTextField txtField_weight;
	private JTextField txtField_traitDependency;
	private JTextField txtField_id;
	private JList<EditableTrait> jList_traits;
	private EditableTrait selectedTrait;
	private EditableChoice currChoice;

	public TraitDependencyPicker(EditableChoice currChoice) {
		initalize();

		this.currChoice = currChoice;
		jList_traits.setModel(GameDataManager.getInstance().getTraitsModel().traits);
	}

	public void initalize() {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel form_traitData = new JPanel();
		contentPane.add(form_traitData, BorderLayout.CENTER);
		form_traitData.setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(46dlu;default)"),
						FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"), },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, }));

		JLabel lbl_traitDependency = new JLabel("Trait Dependency");
		form_traitData.add(lbl_traitDependency, "2, 2, right, default");

		txtField_traitDependency = new JTextField();
		txtField_traitDependency.setEditable(false);
		form_traitData.add(txtField_traitDependency, "4, 2, fill, default");
		txtField_traitDependency.setColumns(10);

		JLabel lbl_id = new JLabel("id");
		form_traitData.add(lbl_id, "2, 4, left, default");

		txtField_id = new JTextField();
		txtField_id.setEditable(false);
		form_traitData.add(txtField_id, "4, 4, fill, default");
		txtField_id.setColumns(10);

		JLabel lbl_weight = new JLabel("Weight");
		form_traitData.add(lbl_weight, "2, 6, left, bottom");

		txtField_weight = new JTextField();
		form_traitData.add(txtField_weight, "4, 6, fill, default");
		txtField_weight.setColumns(10);

		JPanel panel_traitList = new JPanel();
		contentPane.add(panel_traitList, BorderLayout.WEST);
		panel_traitList.setLayout(new BorderLayout(0, 0));

		jList_traits = new JList();

		panel_traitList.add(jList_traits);

		JButton btn_selectTrait = new JButton("Select Trait");
		panel_traitList.add(btn_selectTrait, BorderLayout.SOUTH);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 204, 0));
		contentPane.add(panel, BorderLayout.NORTH);

		JButton btn_save = new JButton("Save");
		panel.add(btn_save);
		btn_save.setForeground(Color.BLACK);
		btn_save.setBackground(Color.GREEN);

		// listeners ------------------

		// selecting a trait.
		jList_traits.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedTrait = jList_traits.getSelectedValue();

				// update txt fields.
				txtField_traitDependency.setText(selectedTrait.name);
				txtField_id.setText(selectedTrait.id);
			}
		});

		// clicking save btn.
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditableTraitDependency td = new EditableTraitDependency();
				td.name = txtField_traitDependency.getText();
				td.id = txtField_id.getText();
				td.weight = txtField_weight.getText();
				currChoice.traitDependencies.add(td);
			}
		});
	}

}
