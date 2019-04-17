package engine.starsheep.space.job;

import engine.starsheep.space.xml.MutableJobFlyer;

/**
 * This class contains all metadata for a single job. 
 * KEY NOTE: This class differs from the Job class in that this 
 * class does not contain the Choices for the specified Job.
 * 
 * Use a JobFlyer to display Job information to the user (to list the jobs).
 * 
 * @see MutableJobFlyer
 */

public class JobFlyer {
	protected String jobId;
	protected String name;
	protected String description;
	protected Integer staminaCost;
	
	//no-arg constructor required for XML marshalling.
	public JobFlyer() {}
	
	public JobFlyer(MutableJobFlyer builder) {
		this.jobId = builder.getJobId();
		this.name = builder.getName();
		this.description = builder.getDescription();
		this.staminaCost = builder.getStaminaCost();
	}
	
	public String getJobId() {
		return jobId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	public Integer getStaminaCost() {
		return staminaCost;
	}
	
	@Override 
	public String toString(){
		return this.name;
	}
}
