package engine.starsheep.space.Job;

import engine.starsheep.space.Choice;

import java.util.HashMap;

/**
 * @see Job
 */
public class JobBuilder {
	protected Choice head = null;
	protected String name = null;
	protected String description = null;
	protected String imageId = null;
	protected String id = null;
	protected HashMap<Integer, Choice> choices= new HashMap<Integer, Choice>();
	
	//build job.
	public Job build() {
		return new Job(this);
	}
	
	//helper
	public void addChoice(Choice c) {
		choices.put(c.getID(), c);
	}
	
	//getters
	public HashMap<Integer, Choice> getChoices() {
		return this.choices;
	}
	public Choice getHead() {
		return this.head;
	}
	public String getName() {
		return this.name;
	}
	public String getDescription() {
		return this.description;
	}
	public String getImageID() {
		return this.imageId;
	}
	public String getId() {
		return this.id;
	}
	
	//setters
	public void setHead(Choice head) {
		this.head = head;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	
	public void setId(String id) {
		this.id = id;
	}
}
