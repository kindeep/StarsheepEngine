package engine.starsheep.space.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import engine.starsheep.space.ItemsManager;
import engine.starsheep.space.Player;
import engine.starsheep.space.Transactions;
import engine.starsheep.space.item.Item;
import engine.starsheep.space.item.TraitBoost;
import engine.starsheep.space.trait.Trait;
import engine.starsheep.space.trait.TraitManager;

public class ItemsController {
    private static ItemsController instance;

    private ItemsController() {
    }

    public static ItemsController getInstance() {
        if (instance == null)
            instance = new ItemsController();
        return instance;
    }

    public int getBalance() {
        return Player.getInstance().getBalance();
    }

    public boolean sellItem(Item item) {
        return Transactions.sellItem(item);
    }

    public boolean buyItem(Item item) {
        return Transactions.buyItem(item);
    }

    public Map<String, Item> getAllItems() {
        return ItemsManager.getInstance().getAllItems();
    }

    /*
     * Equip the item, and then alter the trait levels based on the item's
     * TraitBoosts.
     */
    public boolean equipItem(Item item) {
        if (ItemsManager.getInstance().equipItem(item)) {
            TraitManager traitManager = TraitManager.getInstance();

            for (TraitBoost boost : item.getTraitBoosts()) {
                traitManager.alterTraitLevel(boost.getTraitId(), boost.getEffect());
            }
            return true;
        }
        return false;
    }

    /*
     * Unequip the item, and then alter the trait levels based on the item's
     * TraitBoosts.
     */
    public boolean unequipItem(Item item) {
        if (ItemsManager.getInstance().unequipItem(item)) {
            TraitManager traitManager = TraitManager.getInstance();

            item.getTraitBoosts().forEach(boost -> {
                traitManager.alterTraitLevel(boost.getTraitId(), -boost.getEffect());
            });
            return true;
        }
        return false;
    }

    public Map<String, Trait> getTraits() {
        return TraitManager.getInstance().getAllTraits();
    }

    public List<Item> getInventory() {
        return Collections.unmodifiableList(ItemsManager.getInstance().getInventory());
    }

    public List<Item> getEquippedItems() {
        return Collections.unmodifiableList(ItemsManager.getInstance().getEquippedItems());
    }
}
