package devApp;

import javax.swing.JPanel;

import com.jgoodies.common.collect.ArrayListModel;

import engine.starsheep.space.controller.ItemsController;
import engine.starsheep.space.item.Item;

import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InventoryScreen extends JPanel {
    
    private JList<Item> jList_inventory;
    private JList<Item> jList_equipped;
    private Item selectedItem;

    public InventoryScreen() {
        init();
        refreshView();
    }
    
    private void refreshView() {
        List<Item> inventory = Application.getGameInstance().getItemsController().getInventory();
        ArrayListModel<Item> inventoryModel = new ArrayListModel<Item>(inventory);
        jList_inventory.setModel(inventoryModel);
        
        inventory = Application.getGameInstance().getItemsController().getEquippedItems();
        inventoryModel = new ArrayListModel<Item>(inventory);
        jList_equipped.setModel(inventoryModel);
    }

    public void init() {
        setLayout(new BorderLayout(0, 0));

        JPanel inventoryPanel = new JPanel();
        add(inventoryPanel, BorderLayout.WEST);
        inventoryPanel.setLayout(new BorderLayout(0, 0));

        jList_inventory = new JList();
        
        inventoryPanel.add(jList_inventory);

        JButton btn_equip = new JButton("Equip");
        
        inventoryPanel.add(btn_equip, BorderLayout.SOUTH);

        JPanel equippedPanel = new JPanel();
        add(equippedPanel, BorderLayout.EAST);
        equippedPanel.setLayout(new BorderLayout(0, 0));

        jList_equipped = new JList();
        equippedPanel.add(jList_equipped);

        JButton btn_unequip = new JButton("unEquip");
        equippedPanel.add(btn_unequip, BorderLayout.SOUTH);
        
        jList_inventory.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedItem = jList_inventory.getSelectedValue();
            }
        });
        
        //clicked on equip btn
        btn_equip.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Application.getGameInstance().getItemsController().equipItem(selectedItem);
                refreshView();
            }
        });
        
        //clicked on unequip btn
        btn_unequip.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Application.getGameInstance().getItemsController().unequipItem(selectedItem);
                refreshView();
            }
        });
    }

}
