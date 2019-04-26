package devTool.models.item;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

import devTool.models.EditableTrait;
import devTool.models.GameDataManager;

public class EditableTraitBoost {
    
    @SerializedName("trait-id")
    public String traitId; 
    
    @SerializedName("effect")
    public Integer effect;
    
    @Override
    public String toString() {
        ArrayList<EditableTrait> list = GameDataManager.getInstance().getTraitsModel().traits;
        for (EditableTrait trait: list) {
            if (trait.id.compareTo(this.traitId) == 0)
                return trait.name + " Effect: " + this.effect;
        }
        return "INVALID: Trait does not exist.";
    }
}
