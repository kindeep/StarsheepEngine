package devTool.models;

import java.util.HashMap;
import java.util.LinkedList;

import engine.starsheep.space.Choice;
import engine.starsheep.space.Job.JobBuilder;

public class EditableJobBuilder extends JobBuilder {

	public EditableJobBuilder() {
		super();
	}
	
	@Override
	public EditableJob build() {
		return new EditableJob(this);
	}
	
	/**
	 * This converts a linked list of choices (as used to display jobs in
	 * the developer tool) to the hashmap standard as seen in Job.
	 * 
	 * @param choices A linkedlist of Editable choices.
	 * @see Job
	 */
	public void setChoices(LinkedList<EditableChoice> choices) {
		HashMap<Integer, Choice> map = new HashMap<Integer, Choice>();
		for (int i = 0; i < choices.size(); i++) {
			map.put(i, choices.get(i));
		}
		this.choices = map;
	}
}
