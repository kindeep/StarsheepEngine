package engine.starsheep.space.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import engine.starsheep.space.trait.Trait;

/**
 * An extension of the Trait class to allow for setters.
 * Only to be used for unmarshalling traits.xml.
 * 
 * @author peakyDicers
 *
 * @see TraitsModel
 */

@XmlRootElement(name = "trait")
public class MutableTrait extends Trait{
    
    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }
    
    @XmlElement(name = "id")
    public void setId(String id) {
        this.id = id;
    }
    
    //TODO: is this a thing?
    public void setBaseLevel(int baseLevel) {
        this.baseLevel = baseLevel;
    }
}
