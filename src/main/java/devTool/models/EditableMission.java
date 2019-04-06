package devTool.models;

import java.util.LinkedList;
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

	public EditableMission(EditableMissionBuilder builder) {
		super(builder);
	}
	
	/**
	 * Gives devtool access to an editable linkedlist of jobflyers. 
	 */
	@Override
	public LinkedList<JobFlyer> getJobFlyers() {
		return new LinkedList<JobFlyer>(this.jobFlyers);
	}

	public void setJobFlyers(List<JobFlyer> jobFlyers) {
		this.jobFlyers = jobFlyers;
	}

	public void setName(String name) {
		this.title = name;
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
