package devTool.models;

import engine.starsheep.space.Job.Job;

public class EditableJob extends Job {

	public EditableJob() {
		super();
	}
	
	//helper
	public void setChoice(int index, EditableChoice choice) {
		this.choices.put(index, choice);
	}
	
	/**
	 *  Only EditableChoices can be added into the map, and so 
	 *  casting a choice from the map back into an EditableChoice will always work.
	 *  
	 * @param id The id of the choice.
	 * @return The EditableChoice that matches the id.
	 */
	public EditableChoice getChoice(int id) {
		return (EditableChoice) this.choices.get(id);
	}
	
	public void removeChoice(int index) {
		this.choices.remove(index);
	}
	
	//setters
	public void setHead(EditableChoice head) {
		this.head = head;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setImageID(String imageID) {
		this.imageID = imageID;
	}
	public void setId(String id) {
		this.id = id;
	}
}
