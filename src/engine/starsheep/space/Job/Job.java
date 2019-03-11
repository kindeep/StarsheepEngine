package engine.starsheep.space.Job;

import java.util.HashMap;

/**
 * @see JobBuilder
 */
public class Job {
	private Choice head;
	private String name;
	private String description;
	private HashMap<Integer, Choice> choices;
	private Integer imageID;
	private Integer id;
	
	public Job(JobBuilder jb) {
		this.head = jb.getHead();
		this.name = jb.getName();
		this.description = jb.getDescription();
		this.imageID = jb.getImageID();
		this.id = jb.getId();
		this.choices = jb.getChoices();
	}
	
	@Override
	public String toString() {
		return choices.get(3).toString();
	}
	
}
