package developerTool.XMLBuilder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "mission")
public class MissionModel {
	@XmlElement(name = "title")
	private String title;
	
	@XmlElement(name = "description")
	private String description;
	
	@XmlElement(name = "id")
	private String id;
	
	@XmlElement(name = "creator")
	private String creator;
	
	@XmlElement(name = "currency")
	private String currency;
	
	@XmlElement(name = "staminaCost")
	private Integer staminaCost;
	
	@XmlElement(name = "missions")
	private LinkedList<Integer> jobIds;
	
	public MissionModel() {
		jobIds = new LinkedList<Integer>();
		
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
	
	public String getId() {
		return this.id;
	}
	
	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getCreator() {
		return creator;
	}

	public String getCurrency() {
		return currency;
	}

	public LinkedList<Integer> getJobIds() {
		return jobIds;
	}
	
	public Integer getStaminaCost() {
		return this.staminaCost;
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
	
	public void setStaminaCost(int staminaCost) {
		this.staminaCost = staminaCost;
	}
	
	@Override
	public String toString() {
		return this.title;
	}
}
