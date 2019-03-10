package Engine.Job;

/**
 * @see JobFlyer
 */
public class JobFlyerBuilder {
	private Integer jobId = null;
	private String name = null;
	private String description = null;
	private Integer staminaCost = null;
	
	//build a JobFlyer.
	public JobFlyer build() {
		return new JobFlyer(this);
	}
	
	//getter
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
	
	//setter
	public void setJobId(Integer jobId) {
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