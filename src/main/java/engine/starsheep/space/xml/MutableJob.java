package engine.starsheep.space.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import engine.starsheep.space.job.Job;

/**
 * An extension of the Job class to allow for setters. 
 * Only to be used for unmarshalling XML. 
 * 
 * @author peakyDicers
 *
 */
@XmlRootElement(name = "job")
public class MutableJob extends Job {
    
    //This list is to only be used for unmarshalling.
    private ArrayList<MutableChoice> mutableChoices;
    
    public MutableJob() {
        mutableChoices = new ArrayList<MutableChoice>();
    }
    
    /**
     * Converts the List of MutableChoices into a Hashmap of Choices.
     * 
     * Note: Make sure to call this before upcasting this object to a Job, or 
     * else you will not have access to any of the Choices.
     */
    public void upcastChoices() {
        for (MutableChoice choice : this.mutableChoices) {
            choice.upCastTraitDependencies();
            this.choices.put(choice.getID(), choice);
        }
    }

    @XmlElement(name = "id")
    public void setId(String id) {
        this.id = id;
    }
    
    @XmlElement(name = "title")
    public void setName(String name) {
        this.name = name;
    }
    
    @XmlElement(name = "description")
    public void setDescription(String description) {
        this.description = description;
    }
    
    @XmlElement(name = "image-id")
    public void setImageID(String imageID) {
        this.imageID = imageID;
    }
    
    //setters.
    @XmlElement(name = "head-choice")
    public void setHead(String headId) {
        this.headId = headId;
    }
    
    @XmlElementWrapper(name = "choices")
    @XmlElement(name = "choice")
    public List<MutableChoice> getMutableChoices() {
        return this.mutableChoices;
    }
    
}
