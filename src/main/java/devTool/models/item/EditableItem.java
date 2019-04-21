package devTool.models.item;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.jgoodies.common.collect.ArrayListModel;

import engine.starsheep.space.item.TraitBoost;

@XmlRootElement(name = "item")
public class EditableItem {
    
    @XmlElement(name = "id")
    public String id;
    
    @XmlElement(name = "name")
    public String name;
    
    @XmlElement(name = "description")
    public String description;
    
    @XmlElement(name = "image-id")
    public String imageId;
    
    @XmlElement(name = "price")
    public int price;
    
    @XmlElementWrapper(name = "effects")
    @XmlElement(name = "trait")
    public ArrayListModel<EditableTraitBoost> traitBoosts;
    
    @Override
    public String toString() {
        return this.name;
    }
}
