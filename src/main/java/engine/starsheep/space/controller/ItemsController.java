package engine.starsheep.space.controller;

import engine.starsheep.space.ItemsManager;
import engine.starsheep.space.item.Item;

public class ItemsController {
    private static ItemsController instance;
    
    private ItemsController() {}
    
    public ItemsController getInstance() {
        if (instance == null)
            instance = new ItemsController();
        return this.getInstance();
    }
    
    public void equipItem(Item item) {
        ItemsManager.getInstance().equipItem(item);
    }
    
    public void removeItem(Item item) {
        ItemsManager.getInstance().removeItem(item);
    }
}
