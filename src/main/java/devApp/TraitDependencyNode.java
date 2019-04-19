package devApp;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TraitDependencyNode extends JPanel {
    private JTextField txtField_traitName;
    private JTextField txtField_weight;
   
    public TraitDependencyNode(String name, String weight) {
        initalize();
        txtField_traitName.setText(name);
        txtField_weight.setText(weight);
    }
    
    public void initalize() {
        setSize(300, 70);
        setVisible(true);
        setLayout(new FormLayout(new ColumnSpec[] {
                FormSpecs.RELATED_GAP_COLSPEC,
                FormSpecs.DEFAULT_COLSPEC,
                FormSpecs.RELATED_GAP_COLSPEC,
                ColumnSpec.decode("default:grow"),},
            new RowSpec[] {
                FormSpecs.RELATED_GAP_ROWSPEC,
                FormSpecs.DEFAULT_ROWSPEC,
                FormSpecs.RELATED_GAP_ROWSPEC,
                FormSpecs.DEFAULT_ROWSPEC,}));
        
        JLabel lblTraitName = new JLabel("Trait Name:");
        add(lblTraitName, "2, 2, right, default");
        
        txtField_traitName = new JTextField();
        txtField_traitName.setEditable(false);
        add(txtField_traitName, "4, 2, fill, default");
        txtField_traitName.setColumns(10);
        
        JLabel lbl_weight = new JLabel("Weight");
        add(lbl_weight, "2, 4, left, default");
        
        txtField_weight = new JTextField();
        txtField_weight.setEditable(false);
        add(txtField_weight, "4, 4, fill, default");
        txtField_weight.setColumns(10);
    }
}
