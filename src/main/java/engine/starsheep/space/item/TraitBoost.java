package engine.starsheep.space.item;

import com.google.gson.annotations.SerializedName;

/**
 * 
 * Holds info on the trait boosts for items.
 */
public class TraitBoost {
    
    @SerializedName("trait-id")
	private String traitId;
    
    @SerializedName("effect")
	private int effect;

    public String getTraitId() {
        return traitId;
    }

    public int getEffect() {
        return effect;
    }
}
