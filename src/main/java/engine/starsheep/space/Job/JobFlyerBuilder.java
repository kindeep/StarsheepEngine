package engine.starsheep.space.Job;

/**
 * @see JobFlyer
 */
public class JobFlyerBuilder {
	private String jobId = null;
	private String name = null;
	private String description = null;
	private Integer staminaCost = null;
	
	//build a JobFlyer.
	public JobFlyer build() {
		return new JobFlyer(this);
	}
	
	//getter
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
	
	//setter
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