package engine.starsheep.space.job;

import com.google.gson.annotations.SerializedName;

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
    
    @SerializedName("id")
	private String jobId;
    
    @SerializedName("name")
	private String name;
    
    @SerializedName("description")
	private String description;
    
    @SerializedName("stamina-cost")
	private Integer staminaCost;
	
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
