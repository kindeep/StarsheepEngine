package devTool.Panels;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JobInfoPanel extends JPanel {
	private JTextField txtField_jobName;
	private JTextField txtField_jobId;

	/**
	 * Create the panel.
	 */
	public JobInfoPanel() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lbl_jobName = new JLabel("Job Name");
		add(lbl_jobName, "2, 2, right, default");
		
		txtField_jobName = new JTextField();
		add(txtField_jobName, "4, 2, fill, top");
		txtField_jobName.setColumns(10);
		
		JLabel lbl_jobId = new JLabel("Job Id");
		add(lbl_jobId, "2, 4, right, default");
		
		txtField_jobId = new JTextField();
		add(txtField_jobId, "4, 4, fill, default");
		txtField_jobId.setColumns(10);
		
		JLabel lbl_description = new JLabel("description");
		add(lbl_description, "2, 6, left, default");
		
		JLabel lbl_reward = new JLabel("Reward");
		add(lbl_reward, "2, 8");

	}

}
