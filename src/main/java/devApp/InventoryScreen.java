package devApp;

import javax.swing.JPanel;

import com.jgoodies.common.collect.ArrayListModel;

import engine.starsheep.space.controller.ItemsController;
import engine.starsheep.space.item.Item;
import engine.starsheep.space.trait.Trait;

import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InventoryScreen extends JPanel {

    private JList<Item> jList_inventory;
    private JList<Item> jList_equipped;
    private JList<Trait> jList_traits;
    private Item selectedItem;
    private Item unEquipSelectedItem;
    private JTextField txtField_money;

    public InventoryScreen() {
        init();
        refreshView();
    }

    public void refreshView() {
        ItemsController itemsController = Application.getGameInstance().getItemsController();

        // display inventory
        List<Item> inventory = itemsController.getInventory();
        ArrayListModel<Item> inventoryModel = new ArrayListModel<Item>(inventory);
        jList_inventory.setModel(inventoryModel);

        // display equipped inventory.
        inventory = itemsController.getEquippedItems();
        inventoryModel = new ArrayListModel<Item>(inventory);
        jList_equipped.setModel(inventoryModel);

        // display traits.
        List<Trait> traitList = new ArrayList<Trait>();
        for (Trait trait : itemsController.getTraits().values()) {
            traitList.add(trait);
        }

        ArrayListModel<Trait> traitListModel = new ArrayListModel<Trait>(traitList);
        jList_traits.setModel(traitListModel);

        // display money
        txtField_money.setText(String.valueOf(itemsController.getBalance()));

        revalidate();
        repaint();
    }

    public void init() {
        setLayout(new BorderLayout(0, 0));

        JPanel inventoryPanel = new JPanel();
        add(inventoryPanel, BorderLayout.WEST);
        inventoryPanel.setLayout(new BorderLayout(0, 0));

        jList_inventory = new JList();

        inventoryPanel.add(jList_inventory);

        JPanel panel_invBtns = new JPanel();
        inventoryPanel.add(panel_invBtns, BorderLayout.SOUTH);

        JButton btn_equip = new JButton("Equip");
        panel_invBtns.add(btn_equip);

        JButton btn_sell = new JButton("Sell Item");
        panel_invBtns.add(btn_sell);

        JPanel equippedPanel = new JPanel();
        add(equippedPanel, BorderLayout.EAST);
        equippedPanel.setLayout(new BorderLayout(0, 0));

        jList_equipped = new JList();

        equippedPanel.add(jList_equipped);

        JButton btn_unequip = new JButton("unEquip");
        equippedPanel.add(btn_unequip, BorderLayout.SOUTH);

        JPanel panl_money = new JPanel();
        add(panl_money, BorderLayout.NORTH);

        JLabel lbl_money = new JLabel("Money: ");
        panl_money.add(lbl_money);

        txtField_money = new JTextField();
        txtField_money.setEditable(false);
        panl_money.add(txtField_money);
        txtField_money.setColumns(10);

        JPanel panel_traits = new JPanel();
        add(panel_traits, BorderLayout.CENTER);

        jList_traits = new JList();
        panel_traits.add(jList_traits);

        // clicked on inventory list.
        jList_inventory.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedItem = jList_inventory.getSelectedValue();
            }
        });

        // clicked in equipped list.
        jList_equipped.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                unEquipSelectedItem = jList_equipped.getSelectedValue();
            }
        });

        // clicked on sell btn.
        btn_sell.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Application.getGameInstance().getItemsController().sellItem(selectedItem);
                refreshView();
            }
        });

        // clicked on equip btn
        btn_equip.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Application.getGameInstance().getItemsController().equipItem(selectedItem);
                refreshView();
            }
        });

        // clicked on unequip btn
        btn_unequip.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Application.getGameInstance().getItemsController().unequipItem(unEquipSelectedItem);
                refreshView();
            }
        });
    }

}
