package engine.starsheep.space.json;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

import engine.starsheep.space.item.Item;

public class ItemsModel {
    
	@SerializedName("max-equipped")
    private int maxEquipped;
	
    @SerializedName("items")
    private List<Item> items;
    
    //converts list of items into hashmap and returns the map.
    public Map<String, Item> getItems() {
        Map<String, Item> result = new HashMap<>();
        for (Item item: items) {
        	result.put(item.getId(), item);
        }
        
        return Collections.unmodifiableMap(result);
    }
    
    public int getMaxEquipped() {
        return this.maxEquipped;
    }
}
