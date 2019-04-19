package engine.starsheep.space.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import engine.starsheep.space.Choice;

/**
 * An extension of the Choice class to allow for setters. 
 * Only to be used for unmarshalling xml.
 * 
 * @author peakyDicers
 *
 */
@XmlRootElement(name = "choice")
public class MutableChoice extends Choice {

    // List to be used when unmarshalling.
    private ArrayList<MutableTraitDependency> mutableTraits;

    public MutableChoice() {
        mutableTraits = new ArrayList<MutableTraitDependency>();
    }
    /**
     * This is to be done before upcasting a MutableChoice to a Choice.
     * 
     * Note: Remember to do this, or else you will not have access to any
     * TraitDependencies after you upcast.
     */
    public void upCastTraitDependencies() {
        for (MutableTraitDependency trait : this.mutableTraits) {
            this.traitDependencies.add(trait);
        }
    }

    @XmlElement(name = "id")
    public void setId(String id) {
        this.id = id;
    }
    
    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "description")
    public void setDescription(String description) {
        this.description = description;
    }
    
    @XmlElement(name = "stamina-cost")
    public void setStaminaCost(Double staminaCost) {
        this.staminaCost = staminaCost;
    }

    @XmlElementWrapper(name = "children")
    @XmlElement(name = "child")
    public List<String> getChildren() {
        return this.children;
    }

    @XmlElementWrapper(name = "trait-dependencies")
    @XmlElement(name = "trait")
    public List<MutableTraitDependency> getMutableTraitDependencies() {
        return this.mutableTraits;
    }
}
