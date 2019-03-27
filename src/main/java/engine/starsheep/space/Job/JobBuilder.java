package engine.starsheep.space.Job;

import engine.starsheep.space.Choice;

import java.util.HashMap;

/**
 * @see Job
 */
public class JobBuilder {
	Choice head = null;
	String name = null;
	String description = null;
	Integer imageId = null;
	Integer id = null;
	HashMap<Integer, Choice> choices= new HashMap<Integer, Choice>();
	
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
	public Integer getImageID() {
		return this.imageId;
	}
	public Integer getId() {
		return this.id;
	}
	
	//setters
	public void setHead(Choice head) {
		this.head = head;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setHead(String description) {
		this.description = description;
	}
	
	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
}
