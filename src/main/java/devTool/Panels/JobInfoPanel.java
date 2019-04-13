package devTool.Panels;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import devTool.models.EditableJob;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JobInfoPanel extends JPanel {
	private static final long serialVersionUID = 8307437995922181547L;

	private EditableJob currJob;
	private JTextField txtField_jobName;
	private JTextField txtField_jobId;
	private JTextField txtField_description;
	private JTextField txtField_reward;

	String jobName = null;
	String description = null;
	String id = null;

	/**
	 * Create the panel.
	 */
	public JobInfoPanel(EditableJob currJob) {

		if (currJob != null) {
			this.currJob = currJob;
			jobName = currJob.name;
			description = currJob.description;
			id = currJob.id;
		}
		initalize();

		txtField_jobName.setText(this.jobName);
		txtField_jobId.setText(this.id);
		txtField_description.setText(this.description);
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
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, }));

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
		txtField_description.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				description = txtField_description.getText();
			}
		});
		add(txtField_description, "4, 6, fill, default");
		txtField_description.setColumns(10);

		JLabel lbl_reward = new JLabel("Reward");
		add(lbl_reward, "2, 8, left, default");

		txtField_reward = new JTextField();
		add(txtField_reward, "4, 8, default, fill");
		txtField_reward.setColumns(10);
	}
}
