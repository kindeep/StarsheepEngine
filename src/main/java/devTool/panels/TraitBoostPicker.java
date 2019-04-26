package devTool.panels;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import devTool.models.EditableTrait;
import devTool.models.GameDataManager;
import devTool.models.item.EditableItem;
import devTool.models.item.EditableTraitBoost;

import javax.swing.JList;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TraitBoostPicker extends JFrame {

    private JPanel contentPane;
    private EditableItem currItem;
    private JTextField txtField_traitName;
    private JTextField txtField_traitId;
    private JTextField txtField_effect;
    private JList<EditableTrait> jList_traits;
    private EditableTrait selectedTrait;

    /**
     * Create the frame.
     */
    public TraitBoostPicker(EditableItem currItem) {
        initialize();
        this.currItem = currItem;
        jList_traits.setModel(GameDataManager.getInstance().getTraitsModel().traits);
    }

    public void initialize() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel_list = new JPanel();
        contentPane.add(panel_list, BorderLayout.WEST);

        jList_traits = new JList();
        panel_list.add(jList_traits);

        JPanel panel_info = new JPanel();
        contentPane.add(panel_info, BorderLayout.CENTER);
        panel_info.setLayout(new FormLayout(
                new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
                        FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"), },
                new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
                        FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, }));

        JLabel lbl_traitName = new JLabel("Trait Name");
        panel_info.add(lbl_traitName, "2, 2, left, default");

        txtField_traitName = new JTextField();
        txtField_traitName.setEditable(false);
        panel_info.add(txtField_traitName, "4, 2, fill, default");
        txtField_traitName.setColumns(10);

        JLabel lbl_traitId = new JLabel("Trait id");
        panel_info.add(lbl_traitId, "2, 4, left, default");

        txtField_traitId = new JTextField();
        txtField_traitId.setEditable(false);
        panel_info.add(txtField_traitId, "4, 4, fill, default");
        txtField_traitId.setColumns(10);

        JLabel lbl_effect = new JLabel("Effect (Integer): ");
        panel_info.add(lbl_effect, "2, 6, right, default");

        txtField_effect = new JTextField();
        panel_info.add(txtField_effect, "4, 6, fill, default");
        txtField_effect.setColumns(10);

        JPanel panel_saveBtn = new JPanel();
        contentPane.add(panel_saveBtn, BorderLayout.SOUTH);

        JButton btn_save = new JButton("Save Trait Boost");
        
        // listeners ---------
        jList_traits.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                selectedTrait = jList_traits.getSelectedValue();

                // update all txt fields.
                txtField_traitName.setText(selectedTrait.name);
                txtField_traitId.setText(selectedTrait.id);
                txtField_effect.setText("");
            }
        });
        
        btn_save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                EditableTraitBoost boost = new EditableTraitBoost();
                boost.traitId = txtField_traitId.getText();
                boost.effect = Integer.valueOf(txtField_effect.getText());
                currItem.traitBoosts.add(boost);
            }
        });
        panel_saveBtn.add(btn_save);
    }
}
