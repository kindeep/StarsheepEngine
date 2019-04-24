package devTool.models;

import com.google.gson.annotations.SerializedName;

public class EditableJobFlyer {

    @SerializedName("id")
	public String id;

	@SerializedName("name")
	public String name;

	@SerializedName("description")
	public String description;

	@SerializedName("stamina-cost")
	public Integer staminaCost;

	@Override
	public String toString() {
		return this.name;
	}
}
