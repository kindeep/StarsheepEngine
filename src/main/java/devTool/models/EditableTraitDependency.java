package devTool.models;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "trait-dependency")
public class EditableTraitDependency {
	
	@XmlElement(name = "id")
	public String id;

	@XmlElement(name = "weight")
	public String weight;
	
	
	public EditableTraitDependency() {
		
	}

	@Override
	public String toString() {
	    ArrayList<EditableTrait> traits = GameDataManager.getInstance().getTraitsModel().traits;
	    for (EditableTrait trait: traits) {
	        if (trait.id.compareTo(this.id) == 0 ) {
	            return trait.name;
	        }
	    }
	    return "ERROR: Trait " + this.id + " not found.";
	}
}
