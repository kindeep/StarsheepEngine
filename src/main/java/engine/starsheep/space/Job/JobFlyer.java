package engine.starsheep.space.Job;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class contains all metadata for a single job. 
 * KEY NOTE: This class differs from the Job class in that this 
 * class does not contain the Choices for the specified Job.
 * 
 * Use a JobFlyer to display Job information to the user (to list the jobs).
 * 
 * @see JobFlyerBuilder
 */

@XmlType(propOrder={"name", "description" , "jobId", "staminaCost" })
public class JobFlyer {
	protected String jobId;
	protected String name;
	protected String description;
	protected Integer staminaCost;
	
	//no-arg constructor required for XML marshalling.
	public JobFlyer() {}
	
	public JobFlyer(JobFlyerBuilder builder) {
		this.jobId = builder.getJobId();
		this.name = builder.getName();
		this.description = builder.getDescription();
		this.staminaCost = builder.getStaminaCost();
	}
	
	@XmlElement(name = "id")
	public String getJobId() {
		return jobId;
	}

	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	@XmlElement(name = "description")
	public String getDescription() {
		return description;
	}
	
	@XmlElement(name = "stamina_cost")
	public Integer getStaminaCost() {
		return staminaCost;
	}
	
	@Override 
	public String toString(){
		return this.name;
	}
}
