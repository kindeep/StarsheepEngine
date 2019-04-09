package devTool.models;

import java.util.List;

import engine.starsheep.space.Mission;
import engine.starsheep.space.Job.JobFlyer;

/**
 * An EditableMission is an extension of Mission that allows for the ability to
 * change Mission variables.
 * 
 * @author peakyDicers
 *
 */

public class EditableMission extends Mission {

	public EditableMission() {
		super();
	}
	
	/**
	 * Returns a list of EditableJobFlyers. JobFlyers are guaranteed 
	 * to be EditableJobFlyer since only EditableJobFlyers can be added.
	 */
	@Override
	public List<JobFlyer> getJobFlyers() {
		return this.jobFlyers;
	}
	
	public void addJobFlyer(EditableJobFlyer flyer) {
		this.jobFlyers.add(flyer);
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getStaminaCost() {
		return 999;
	}

	@Override
	public String toString() {
		return this.title;
	}
}
