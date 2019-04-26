package devTool.models.item;

import com.google.gson.annotations.SerializedName;
import com.jgoodies.common.collect.ArrayListModel;

public class EditableItem {
    @SerializedName("name")
    public String name;
    
    @SerializedName("description")
    public String description;
    
    @SerializedName("id")
    public String id;
    
    @SerializedName("price")
    public int price;
    
    @SerializedName("image-id")
    public String imageId;
    
    @SerializedName("trait-boosts")
    public ArrayListModel<EditableTraitBoost> traitBoosts;
    
 public EditableItem() {
        traitBoosts = new ArrayListModel<>();
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}
