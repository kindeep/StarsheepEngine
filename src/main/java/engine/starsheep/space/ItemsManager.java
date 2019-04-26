package engine.starsheep.space;

import java.util.List;
import java.util.Map;

import engine.starsheep.space.item.Item;
import engine.starsheep.space.json.StarReader;

public class ItemsManager {
    private static ItemsManager instance;
    
    private ItemsManager() {
        List<Item> items = StarReader.readItems();
    }
    
    public static ItemsManager getInstance() {
        if (instance == null)
            instance = new ItemsManager();
        return instance;
    }

    //id -> item.
    Map<String, Item> items;
    
    // stores item ids. 
    List<Item> equippedItems;
    
    List<Item> availableItems;
    
    public void equipItem(Item item) {
       if (!isEquipped(item))
           equippedItems.add(item);
    }
    
    public void removeItem(Item item) {
        equippedItems.remove(item);
    }
    
    private boolean isEquipped(Item i) {
        for (Item item: equippedItems) { 
            if (item.getId().compareTo(i.getId()) == 0)
                return true;
        }
        return false;
    }
}
