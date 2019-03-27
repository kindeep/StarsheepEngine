package engine.starsheep.space;

import engine.starsheep.space.Job.JobFlyer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @see Mission
 * @see JobFlyer
 */
public class MissionBuilder {
	private List<JobFlyer> jobFlyers;
	private String name = null;
	private String description = null;
	private Integer id = null;
	
	public MissionBuilder() {
		jobFlyers = new ArrayList<JobFlyer>();
	}
	
	//build mission
	public Mission build() {
		return new Mission(this);
	}
	
	//helpers
	public void addFlyer(JobFlyer jobFlyer) {
		jobFlyers.add(jobFlyer);
	}
	
	//setters
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	//getters
	public List<JobFlyer> getjobFlyerList(){
		return Collections.unmodifiableList(this.jobFlyers);
	}
	public String getName() {
		return this.name;
	}
	public String getDescription() {
		return this.description;
	}
	public Integer getId() {
		return this.id;
	}
}
