package Engine;

import java.util.Collections;
import java.util.List;

/**
 * 
 * A Mission holds all data contained within a single mission.
 * 
 * @see MisionBuilder
 * @see JobFlyer
 */
public class Mission {
	private List<JobFlyer> jobFlyers;
	private String name;
	private String description;
	private Integer id;
	
	public Mission(MissionBuilder builder) {
		jobFlyers = builder.getjobFlyerList();
	}
	
	public List<JobFlyer> getJobFlyers(){
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
