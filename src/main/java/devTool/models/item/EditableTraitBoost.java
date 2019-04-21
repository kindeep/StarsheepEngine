package devTool.models.item;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import devTool.models.EditableTrait;
import devTool.models.GameDataManager;

@XmlRootElement(name = "trait")
public class EditableTraitBoost {
    
    @XmlElement(name = "id")
    public String traitId; 
    
    @XmlElement(name = "effect")
    public Integer effect;
    
    @Override
    public String toString() {
        System.out.print(this.traitId);
        System.out.print(this.effect);
        ArrayList<EditableTrait> list = GameDataManager.getInstance().getTraitsModel().traits;
        for (EditableTrait trait: list) {
            if (trait.id.compareTo(this.traitId) == 0)
                return trait.name;
        }
        
        return "INVALID";
    }
}
