package devApp;

import javax.swing.JPanel;

import com.jgoodies.common.collect.ArrayListModel;

import engine.starsheep.space.item.Item;

import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShopScreen extends JPanel {

    private Item selectedItem;
    private JList<Item> jList_shopItems;
    private InventoryScreen invScreen;

    public ShopScreen(InventoryScreen invScreen) {
        this.invScreen = invScreen;

        //display shop items.
        List<Item> itemsList = new ArrayList<Item>();
        Map<String, Item> mapItems = Application.getGameInstance().getItemsController().getAllItems();
        for (Item item : mapItems.values()) {
            itemsList.add(item);
        }
        ArrayListModel<Item> shopItemsModel = new ArrayListModel<>(itemsList);
        init();
        jList_shopItems.setModel(shopItemsModel);
    }

    private void init() {
        setLayout(new BorderLayout(0, 0));

        jList_shopItems = new JList();
       
        add(jList_shopItems);

        JPanel panel = new JPanel();
        add(panel, BorderLayout.EAST);

        JButton btn_buyItem = new JButton("Buy Item");
       
        panel.add(btn_buyItem);
        
        //click on shop inventory list.
        jList_shopItems.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedItem = jList_shopItems.getSelectedValue();
            }
        });
        
        //clicked on buy item btn.
        btn_buyItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Application.getGameInstance().getItemsController().buyItem(selectedItem);
                invScreen.refreshView();
            }
        });
    }
}
