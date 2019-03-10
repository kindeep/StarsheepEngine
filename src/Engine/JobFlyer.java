package Engine;


/**
 * This class contains all metadata for a single job. 
 * KEY NOTE: This class differs from the Job class in that this 
 * class does not contain the Choices for the specified Job.
 * 
 * Use a JobFlyer to display Job information to the user (to list the jobs).
 */
public class JobFlyer {
	private Integer jobId;
	private String name;
	private String description;
	private Integer staminaCost;
	
	public JobFlyer(JobFlyerBuilder builder) {
		this.jobId = builder.getJobId();
		this.name = builder.getName();
		this.description = builder.getDescription();
		this.staminaCost = builder.getStaminaCost();
	}
	
	public Integer getJobId() {
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
}
