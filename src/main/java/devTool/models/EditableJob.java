package devTool.models;

import com.google.gson.annotations.SerializedName;

import com.jgoodies.common.collect.LinkedListModel;

public class EditableJob {

    @SerializedName("name")
	public String name;

    @SerializedName("description")
	public String description;

    @SerializedName("id")
	public String id;

    @SerializedName("image-id")
	public String imageId;

    @SerializedName("head-choice-id")
	public String headChoice;
    
    @SerializedName("level")
	public String level;
	
    @SerializedName("choices")
	public LinkedListModel<EditableChoice> choices = null;

	public EditableJob() {
		choices = new LinkedListModel<EditableChoice>();
	}

	public void addChoice(EditableChoice choice) {
		this.choices.add(choice);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
