package devTool.models;

import com.google.gson.annotations.SerializedName;
import com.jgoodies.common.collect.ArrayListModel;

public class EditableChoice {

    @SerializedName("name")
	public String name;

    @SerializedName("id")
	public String id;

    @SerializedName("stamina-cost")
	public Integer staminaCost = 0;

    @SerializedName("description")
	public String description = "choice description here.";

    @SerializedName("trait")
	public ArrayListModel<EditableTraitDependency> traitDependencies = null;

    @SerializedName("child")
	public ArrayListModel<String> children = null;

	public EditableChoice() {
		traitDependencies = new ArrayListModel<EditableTraitDependency>();
		children = new ArrayListModel<String>();
	}

	public void addChild(String child) {
		children.add(child);
	}

	public void addTraitDependency(EditableTraitDependency td) {
		this.traitDependencies.add(td);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
