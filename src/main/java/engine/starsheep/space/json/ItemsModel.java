package engine.starsheep.space.json;

import java.util.Collections;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import engine.starsheep.space.item.Item;

public class ItemsModel {
    
    @SerializedName("items")
    private List<Item> items;
    
    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }
}
