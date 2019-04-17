package engine.starsheep.space;

import engine.starsheep.space.job.JobFlyer;
import engine.starsheep.space.xml.MutableMission;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * A Mission holds all data contained within a single mission.
 * 
 * @see MutableMission
 * @see JobFlyer
 */

// @XmlSeeAlso({EditableMission.class})

public class Mission {
	protected String name;
	protected String description;
	protected String id;
	protected int staminaCost;
	protected List<JobFlyer> jobFlyers;

	// no-arg constructor required for XML marshalling.
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
