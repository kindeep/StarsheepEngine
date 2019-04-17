package devTool.panels;

import java.awt.BorderLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class GeneralPanel extends JPanel {
	private static final long serialVersionUID = -4856608278305715159L;
	private JTextField titleTxtField;
	private JTextField creatorTxtField;
	private JTextField currencyTxtField;
	private JTextField staminaTxtField;

	/**
	 * Create the panel.
	 */
	public GeneralPanel(devTool.models.GameModel gameModel) {
		setLayout(new BorderLayout(0, 0));

		JPanel info = new JPanel();
		add(info, BorderLayout.WEST);
		info.setLayout(new FormLayout(
				new ColumnSpec[] { ColumnSpec.decode("max(47dlu;default)"),
						ColumnSpec.decode("max(86dlu;default):grow"), },
				new RowSpec[] { FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, }));

		JLabel lblNewLabel = new JLabel("Title");
		info.add(lblNewLabel, "1, 1");

		titleTxtField = new JTextField();
		titleTxtField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				gameModel.setTitle(titleTxtField.getText());
			}
		});
		info.add(titleTxtField, "2, 1, fill, default");
		titleTxtField.setColumns(10);

		JLabel lblCreator = new JLabel("Creator");
		info.add(lblCreator, "1, 3");

		creatorTxtField = new JTextField();
		creatorTxtField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				gameModel.setCreator(creatorTxtField.getText());
			}
		});
		info.add(creatorTxtField, "2, 3, fill, default");
		creatorTxtField.setColumns(10);

		JLabel lblCurrency = new JLabel("Currency");
		info.add(lblCurrency, "1, 5");

		currencyTxtField = new JTextField();
		currencyTxtField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				gameModel.setCurrency(currencyTxtField.getText());
			}
		});
		info.add(currencyTxtField, "2, 5, fill, default");
		currencyTxtField.setColumns(10);

		JLabel lblStamina = new JLabel("Stamina");
		info.add(lblStamina, "1, 7");

		staminaTxtField = new JTextField();
		staminaTxtField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				gameModel.setCurrency(staminaTxtField.getText());
			}
		});
		info.add(staminaTxtField, "2, 7, fill, default");
		staminaTxtField.setColumns(10);
	}
}