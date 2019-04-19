package engine.starsheep.space.xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import engine.starsheep.space.trait.Trait;


/**
 * This is to be used for unmarshalling of the traits xml file.
 * 
 * @author peakyDicers
 *
 */
@XmlRootElement(name = "traits")
public class TraitsModel {
    private HashMap<String, Trait> traits = new HashMap<>();
    private List<MutableTrait> mutableTraits = new ArrayList<>();
    
    public HashMap<String, Trait> getTraits(){
        HashMap<String, Trait> result = new HashMap<>();
        for (MutableTrait trait : mutableTraits) {
            traits.put(trait.getId(), trait);
        }
        return result;
    }
    
    @XmlElement(name = "trait")
    public List<MutableTrait> getEditableTraits(){
        return this.mutableTraits;
    }
}
