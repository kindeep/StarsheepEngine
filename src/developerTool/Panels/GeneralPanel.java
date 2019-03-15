package developerTool.Panels;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;

public class GeneralPanel extends JPanel {
	private static final long serialVersionUID = -4856608278305715159L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public GeneralPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel info = new JPanel();
		add(info, BorderLayout.WEST);
		info.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(47dlu;default)"),
				ColumnSpec.decode("max(86dlu;default):grow"),},
			new RowSpec[] {
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("Title");
		info.add(lblNewLabel, "1, 1");
		
		textField = new JTextField();
		info.add(textField, "2, 1, fill, default");
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("SubTitle");
		info.add(lblNewLabel_1, "1, 3");
		
		textField_1 = new JTextField();
		info.add(textField_1, "2, 3, fill, default");
		textField_1.setColumns(10);
		
		JLabel lblCreator = new JLabel("Creator");
		info.add(lblCreator, "1, 5");
		
		textField_2 = new JTextField();
		info.add(textField_2, "2, 5, fill, default");
		textField_2.setColumns(10);
		
		JLabel lblCurrency = new JLabel("Currency");
		info.add(lblCurrency, "1, 7");
		
		textField_3 = new JTextField();
		info.add(textField_3, "2, 7, fill, default");
		textField_3.setColumns(10);
		
		JLabel lblStamina = new JLabel("Stamina");
		info.add(lblStamina, "1, 9");
		
		textField_4 = new JTextField();
		info.add(textField_4, "2, 9, fill, default");
		textField_4.setColumns(10);
	}
}