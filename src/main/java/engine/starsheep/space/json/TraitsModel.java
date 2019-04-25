package engine.starsheep.space.json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

import engine.starsheep.space.trait.Trait;


/**
 * This is to be used for unmarshalling of the traits json file.
 * 
 * @author peakyDicers
 *
 */
public class TraitsModel {
    private Map<String, Trait> traitsMap = new HashMap<>();
    
    @SerializedName("traits")
    private List<Trait> traitsList;
    
    @SerializedName("name")
    public Map<String, Trait> getTraits(){
        return this.traitsMap;
    }
}
