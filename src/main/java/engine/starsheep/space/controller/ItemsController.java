package engine.starsheep.space.controller;

import java.util.Collections;
import java.util.List;

import engine.starsheep.space.ItemsManager;
import engine.starsheep.space.item.Item;

public class ItemsController {
    private static ItemsController instance;
    
    private ItemsController() {}
    
    public static ItemsController getInstance() {
        if (instance == null)
            instance = new ItemsController();
        return instance;
    }
    
    public void equipItem(Item item) {
        ItemsManager.getInstance().equipItem(item);
    }
    
    public void unequipItem(Item item) {
        ItemsManager.getInstance().unequipItem(item);
    }
    
    public List<Item> getInventory(){
        return Collections.unmodifiableList(ItemsManager.getInstance().getInventory());
    }
    
    public List<Item> getEquippedItems(){
        return Collections.unmodifiableList(ItemsManager.getInstance().getEquippedItems());
    }
}
