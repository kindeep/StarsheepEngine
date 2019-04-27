package engine.starsheep.space;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import engine.starsheep.space.item.Item;
import engine.starsheep.space.json.ItemsModel;
import engine.starsheep.space.json.StarReader;

public class ItemsManager {
    private static ItemsManager instance;
    private Map<String, Item> items;
    private List<Item> equippedItems;
    private List<Item> inventory; 
    private int maxEquipped;
    
    private ItemsManager() {
        ItemsModel itemsModel = StarReader.readItems();
        
        items = itemsModel.getItems();
        maxEquipped = itemsModel.getMaxEquipped();
        
        equippedItems = new ArrayList<>(10);
        inventory = new ArrayList<>();
    }
    
    public static ItemsManager getInstance() {
        if (instance == null)
            instance = new ItemsManager();
        return instance;
    }
    

    public List<Item> getAllItems(){
        return (List<Item>)items.values();
    }
    
    public List<Item> getInventory(){
        return Collections.unmodifiableList(this.inventory);
    }
    
    public List<Item> getEquippedItems(){
        return Collections.unmodifiableList(this.equippedItems);
    }
    
    public void equipItem(Item item) {
        if (equippedItems.size() >= maxEquipped) return;
        
        if (inventory.remove(item))
            equippedItems.add(item);
    }
    
    public void unequipItem(Item item) {
        equippedItems.remove(item);
    }
    
    public void addToInventory(Item item) {
        this.inventory.add(item);
    }
    
    private boolean isEquipped(Item i) {
        for (Item item: equippedItems) { 
            if (item.getId().compareTo(i.getId()) == 0)
                return true;
        }
        return false;
    }
}
