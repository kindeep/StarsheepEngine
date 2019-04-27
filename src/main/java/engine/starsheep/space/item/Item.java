package engine.starsheep.space.item;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Item {
    
    @SerializedName("name")
    private String name;
    
    @SerializedName("id")
    private String id;
    
    @SerializedName("description")
    private String description;
    
    @SerializedName("price")
    private int price;
    
    @SerializedName("image-id")
    private String imageId;
    
    @SerializedName("trait-boosts")
    private List<TraitBoost> traitBoosts;

    
    //getters.
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String getImageId() {
        return imageId;
    }
    
    public int getRefundPrice() {
        return price/3;
    }

    public List<TraitBoost> getTraitBoosts() {
        return traitBoosts;
    }
    
}
