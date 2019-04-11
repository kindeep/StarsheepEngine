package devTool.models;

import engine.starsheep.space.Job.JobFlyer;
import engine.starsheep.space.Job.JobFlyerBuilder;

public class EditableJobFlyer extends JobFlyer {

	public EditableJobFlyer() {
		super();
	}

	//setters
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setStaminaCost(Integer staminaCost) {
		this.staminaCost = staminaCost;
	}
}
