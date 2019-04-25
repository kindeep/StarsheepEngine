package engine.starsheep.space;

import engine.starsheep.space.job.JobFlyer;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * 
 * A Mission holds all data contained within a single mission.
 * 
 * @see MutableMission
 * @see JobFlyer
 */

public class Mission {
    @SerializedName("name")
	private String name;
    
    @SerializedName("description")
	private String description;
    
    @SerializedName("id")
	private String id;
    
    @SerializedName("stamina-cost")
	private int staminaCost;
    
    @SerializedName("job")
	private List<JobFlyer> jobFlyers;

	public Mission() {
		jobFlyers = new ArrayList<JobFlyer>();
	}

	public List<JobFlyer> getJobFlyers() {
		return this.jobFlyers;
	}

	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public Integer getStaminaCost() {
		return this.staminaCost;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
