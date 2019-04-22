package engine.starsheep.space.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import engine.starsheep.space.job.TraitDependency;

/**
 * An extension of TraitDependency to allow for setters.
 * Only to be used for unmarshalling xml.
 * 
 * @author peakyDicers
 * 
 * @see MutableChoice
 */
@XmlRootElement(name = "trait")
public class MutableTraitDependency extends TraitDependency {

    @XmlElement(name = "id")
    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name = "weight")
    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
