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
    @SerializedName("traits")
    private List<Trait> traitsList;
    
    public Map<String, Trait> getTraits(){
        Map<String, Trait> result = new HashMap<>();
        
        for (Trait trait: traitsList) {
            result.put(trait.getId(), trait);
        }
        return result;
    }
}
