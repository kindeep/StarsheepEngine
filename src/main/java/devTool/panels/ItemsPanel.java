package devTool.panels;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.common.collect.ArrayListModel;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import devTool.models.EditableTrait;
import devTool.models.GameDataManager;
import devTool.models.item.EditableItem;
import devTool.models.item.ItemsModel;
import engine.starsheep.space.item.Item;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.UUID;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ItemsPanel extends JPanel {
    private JTextField txtField_itemName;
    private JTextField txtField_price;
    private JTextField image_id;
    private JList<EditableItem> jList_items;
    private JList<EditableTrait> jList_traits;
    private EditableItem selectedItem;

    /**
     * Create the panel.
     */
    public ItemsPanel() {
        ArrayListModel<EditableTrait> traitModel = new ArrayListModel<>();
        ArrayListModel<EditableItem> itemModel = new ArrayListModel<>();
        initalize();
        jList_items.setModel(itemModel);
        jList_traits.setModel(traitModel);
    }

    public void updateItems() {
        ItemsModel itemsModel = GameDataManager.getInstance().getItemsModel();
        jList_items.setModel(itemsModel.items);
    }

    public void initalize() {
        setLayout(new BorderLayout(0, 0));

        JPanel panel_itemList = new JPanel();
        add(panel_itemList, BorderLayout.WEST);
        panel_itemList.setLayout(new BorderLayout(0, 0));

        jList_items = new JList();
        panel_itemList.add(jList_items);

        JPanel panel_btns = new JPanel();
        panel_itemList.add(panel_btns, BorderLayout.SOUTH);
        panel_btns.setLayout(new BoxLayout(panel_btns, BoxLayout.X_AXIS));

        JButton btn_newItem = new JButton("New Item");
        btn_newItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EditableItem item = new EditableItem();
                item.name = "unnamed item";
                item.id = UUID.randomUUID().toString();
                GameDataManager.getInstance().getItemsModel().items.add(item);
            }
        });
        panel_btns.add(btn_newItem);

        JButton btn_removeItem = new JButton("Remove Item");
        btn_removeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameDataManager.getInstance().getItemsModel().items.remove(selectedItem);
                txtField_itemName.setText(null);
                txtField_price.setText(null);
                image_id.setText(null);
                jList_traits.setModel(null);
            }
        });
        panel_btns.add(btn_removeItem);

        JPanel panel = new JPanel();
        add(panel, BorderLayout.CENTER);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel panel_form = new JPanel();
        panel.add(panel_form);
        panel_form.setLayout(new FormLayout(
                new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
                        FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
                        ColumnSpec.decode("default:grow"), },
                new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
                        FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
                        FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
                        FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, }));

        JLabel lbl_itemName = new JLabel("Item name");
        panel_form.add(lbl_itemName, "2, 2, left, default");

        txtField_itemName = new JTextField();
        panel_form.add(txtField_itemName, "6, 2, fill, default");
        txtField_itemName.setColumns(10);

        JLabel lbl_description = new JLabel("Description");
        panel_form.add(lbl_description, "2, 4, left, default");

        JButton btn_selectImage = new JButton("Select Image");
        panel_form.add(btn_selectImage, "2, 6");

        image_id = new JTextField();
        panel_form.add(image_id, "6, 6, fill, default");
        image_id.setColumns(10);

        JLabel lbl_price = new JLabel("Price");
        panel_form.add(lbl_price, "2, 8, left, default");

        txtField_price = new JTextField();
        panel_form.add(txtField_price, "6, 8, fill, default");
        txtField_price.setColumns(10);

        JPanel panel_traitList = new JPanel();
        panel.add(panel_traitList);
        panel_traitList.setLayout(new BorderLayout(0, 0));

        jList_traits = new JList();
        panel_traitList.add(jList_traits);

        JPanel panel_traitBtns = new JPanel();
        panel_traitList.add(panel_traitBtns, BorderLayout.SOUTH);

        JButton btn_addTrait = new JButton("New Trait");
        panel_traitBtns.add(btn_addTrait);

        JButton btn_removeTrait = new JButton("Remove Trait");
        panel_traitBtns.add(btn_removeTrait);

        // ------------------------ listeners

        jList_items.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedItem = jList_items.getSelectedValue();
                txtField_itemName.setText(selectedItem.name);
                txtField_price.setText(String.valueOf(selectedItem.price));
                jList_traits.setModel(selectedItem.traitBoosts);
            }
        });
    }

}
