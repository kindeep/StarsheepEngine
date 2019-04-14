package devTool.Panels;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import devTool.models.EditableJob;

/**
 * 
 * @author peakyDicers
 *
 */
public class JobInfoPanel extends JPanel {
	private static final long serialVersionUID = 8307437995922181547L;

	private EditableJob currJob;
	private JTextField txtField_jobName;
	private JTextField txtField_jobId;
	private JTextField txtField_description;
	private JTextField txtField_reward;
	private JTextField txtField_headChoiceId;
	private ChoicesGraph graph;

	/**
	 * Create the panel.
	 */
	public JobInfoPanel(EditableJob currJob, ChoicesGraph graph) {
		this.graph = graph;
		
		String jobName = null;
		String description = null;
		String id = null;
		String headChoice = null;

		if (currJob != null) {
			this.currJob = currJob;
			jobName = currJob.name;
			description = currJob.description;
			id = currJob.id;
			headChoice = currJob.headChoice;
			graph.setHeadChoiceId(headChoice);
		}
		initalize();

		txtField_jobName.setText(jobName);
		txtField_jobId.setText(id);
		txtField_description.setText(description);
		txtField_headChoiceId.setText(headChoice);
	}

	public void save() {
		currJob.name = txtField_jobName.getText();
		currJob.description = txtField_description.getText();
	}

	public void initalize() {
		setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(63dlu;default)"),
						FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"), },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, }));

		JLabel lbl_jobName = new JLabel("Job Name");
		add(lbl_jobName, "2, 2, left, default");

		txtField_jobName = new JTextField();
		add(txtField_jobName, "4, 2, fill, top");
		txtField_jobName.setColumns(10);

		JLabel lbl_jobId = new JLabel("Job Id");
		add(lbl_jobId, "2, 4, left, default");

		txtField_jobId = new JTextField();
		add(txtField_jobId, "4, 4, fill, default");
		txtField_jobId.setColumns(10);
		txtField_jobId.setEditable(false);

		JLabel lbl_description = new JLabel("Description");
		add(lbl_description, "2, 6, left, default");

		txtField_description = new JTextField();
		add(txtField_description, "4, 6, fill, default");
		txtField_description.setColumns(10);

		JLabel lbl_reward = new JLabel("Reward");
		add(lbl_reward, "2, 8, left, default");

		txtField_reward = new JTextField();
		add(txtField_reward, "4, 8, default, fill");
		txtField_reward.setColumns(10);
		
		txtField_headChoiceId = new JTextField();
		txtField_headChoiceId.setEditable(false);
		add(txtField_headChoiceId, "4, 12, fill, default");
		txtField_headChoiceId.setColumns(10);
		
		JLabel lbl_headChoice = new JLabel("Head Choice");
		add(lbl_headChoice, "2, 10, left, default");

		JButton btnSelectHeadChoice = new JButton("select head choice");
		btnSelectHeadChoice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ChoiceListDisplay choiceListDisplay = new ChoiceListDisplay(currJob.choices, currJob, txtField_headChoiceId, graph);
				choiceListDisplay.setVisible(true);
			}
		});
		add(btnSelectHeadChoice, "4, 10");

		JLabel lbl_headChoiceId = new JLabel("HeadChoice id");
		add(lbl_headChoiceId, "2, 12, left, default");
	}
}
