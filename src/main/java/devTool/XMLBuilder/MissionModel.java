package devTool.XMLBuilder;

import java.util.LinkedList;
import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "mission")
/*
 * TODO: remove LinkedList<Integer> jobIds;
 */
public class MissionModel {
	private String id;
	private String title;
	private String description;
	private String creator;
	private String currency;
	private Integer staminaCost;
	private LinkedList<JobFlyerModel> jobFlyers;
	private LinkedList<Integer> jobIds;
	public MissionModel() {
		jobIds = new LinkedList<Integer>();
		jobFlyers = new LinkedList<JobFlyerModel>();
		
		this.id = UUID.randomUUID().toString();
		System.out.println(this.id);
		
	}

	//helpers
	public void addJobId(int id) {
		jobIds.add(id);
	}
	
	public void removeJobId(int id) {
		Integer obj = new Integer(id);
		jobIds.remove(obj);
	}
	
	//setters and getters.
	
	@XmlElement(name = "id")
	public String getId() {
		return this.id;
	}
	
	@XmlElement(name = "title")
	public String getTitle() {
		return title;
	}

	@XmlElement(name = "description")
	public String getDescription() {
		return description;
	}

	@XmlElement(name = "creator")
	public String getCreator() {
		return creator;
	}

	@XmlElement(name = "currency")
	public String getCurrency() {
		return currency;
	}

	public LinkedList<Integer> getJobIds() {
		return jobIds;
	}

	@XmlElement(name = "staminaCost")
	public Integer getStaminaCost() {
		return this.staminaCost;
	}
	
	@XmlElement(name = "jobs")
	public LinkedList<JobFlyerModel> getJobFlyers(){
		return this.jobFlyers;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setJobIds(LinkedList<Integer> jobIds) {
		this.jobIds = jobIds;
	}
	
	public void getJobFlyers(LinkedList<JobFlyerModel> jobFlyers){
		this.jobFlyers = jobFlyers;
	}
	
	public void setStaminaCost(int staminaCost) {
		this.staminaCost = staminaCost;
	}
	
	public void addJobFlyer(JobFlyerModel jobFlyer) {
		this.jobFlyers.add(jobFlyer);
	}
	
	@Override
	public String toString() {
		return this.title;
	}
}
