package engine.starsheep.space.Job;

import engine.starsheep.space.Choice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @see JobBuilder
 */

@XmlRootElement(name = "mission")
public class Job {
	protected Choice head;
	protected HashMap<Integer, Choice> choices;
	protected String name;
	protected String description;
	protected String imageID;
	protected String id;
	
	//no-arg constructor required for XML marshalling.
	public Job() {}
	
	public Job(JobBuilder jb) {
		this.head = jb.getHead();
		this.name = jb.getName();
		this.description = jb.getDescription();
		this.imageID = jb.getImageID();
		this.id = jb.getId();
		this.choices = jb.getChoices();
	}
	
	public Choice getHead() {
		return head;
	}

	@XmlElement(name = "title")
	public String getName() {
		return name;
	}

	@XmlElement(name = "description")
	public String getDescription() {
		return description;
	}
	
	@XmlElement(name = "choices")
	public Map<Integer, Choice> getChoices() {
		return Collections.unmodifiableMap(choices);
	}

	@XmlElement(name = "image_id")
	public String getImageID() {
		return imageID;
	}

	@XmlElement(name = "id")
	public String getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
