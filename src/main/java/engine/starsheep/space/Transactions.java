package engine.starsheep.space;

import engine.starsheep.space.item.Item;

public class Transactions {
    
    // buy item from store.
    public static boolean buyItem(Item item) {
        Player player = Player.getInstance();
        if (item.getPrice() > player.getCash()) return false;
        
        ItemsManager.getInstance().addToInventory(item);
        player.removeCash(item.getPrice());
        return true;
    }
    
    //sell item to store from inventory.
    public static boolean sellItem(Item item) {
        if (ItemsManager.getInstance().getInventory().remove(item)) {
            Player.getInstance().addCash(item.getRefundPrice());
            return true;
        }
        return false;
    }
}
