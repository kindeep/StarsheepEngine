package devTool.models;

import com.google.gson.annotations.SerializedName;
import com.jgoodies.common.collect.ArrayListModel;

/**
 * An EditableMission is an extension of Mission that allows for the ability to
 * change Mission variables.
 * 
 * @author peakyDicers
 *
 */
public class EditableMission {

    @SerializedName("name")
	public String title;

    @SerializedName("description")
	public String description;

    @SerializedName("id")
	public String id;

    @SerializedName("stamina-cost")
	public String staminaCost;

    @SerializedName("job")
	public ArrayListModel<EditableJobFlyer> jobFlyers = null;

	public EditableMission() {
		jobFlyers = new ArrayListModel<EditableJobFlyer>();
	}

	public void addJobFlyer(EditableJobFlyer flyer) {
		this.jobFlyers.add(flyer);
	}

	@Override
	public String toString() {
		return this.title;
	}
}
