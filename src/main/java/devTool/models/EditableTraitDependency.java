package devTool.models;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.SerializedName;

public class EditableTraitDependency {
	
    @SerializedName("id")
	public String id;

    @SerializedName("weight")
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
