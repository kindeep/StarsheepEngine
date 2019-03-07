package Engine;


/**
 * This class contains all metadata for a single job. 
 * Display this to the user, and only load corresponding Job when user selects this job.
 *
 */
public class JobListing {
	private Integer jobId;
	private String name;
	private String description;
	private Integer staminaCost;
	
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getStaminaCost() {
		return staminaCost;
	}
	public void setStaminaCost(Integer staminaCost) {
		this.staminaCost = staminaCost;
	}
}
