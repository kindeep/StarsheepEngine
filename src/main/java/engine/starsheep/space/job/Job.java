package engine.starsheep.space.job;

import engine.starsheep.space.Choice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @see JobBuilder
 */

@XmlRootElement(name = "job")
public class Job {
	protected Choice head;
	protected HashMap<Integer, Choice> choices;
	protected String name;
	protected String description;
	protected String imageID;
	protected String id;
	
	//no-arg constructor required for XML marshalling.
	public Job() {
		choices = new HashMap<Integer, Choice>();
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
	
	@XmlElementWrapper(name = "choices")
	@XmlElement(name = "choice")
	public List<Choice> getChoicesForXML(){
		return new ArrayList<Choice>(this.choices.values());
	}
	
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
