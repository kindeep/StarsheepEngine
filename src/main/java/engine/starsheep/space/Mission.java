package engine.starsheep.space;

import engine.starsheep.space.Job.JobFlyer;

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
 * @see MissionBuilder
 * @see JobFlyer
 */

// @XmlSeeAlso({EditableMission.class})
@XmlRootElement(name = "mission")
@XmlType(propOrder = { "title", "description", "id", "staminaCost", "jobFlyers" })
public class Mission {
	protected String title;
	protected String description;
	protected String id;
	protected List<JobFlyer> jobFlyers;

	// no-arg constructor required for XML marshalling.
	public Mission() {
		jobFlyers = new ArrayList<JobFlyer>();
	}

	public Mission(MissionBuilder builder) {
		jobFlyers = builder.getJobFlyerList();
		this.id = builder.getId();
		this.title = builder.getName();
		this.description = builder.getDescription();
	}

	@XmlElementWrapper(name = "jobs")
	@XmlElement(name = "job")
	public List<JobFlyer> getJobFlyers() {
		return Collections.unmodifiableList(this.jobFlyers);
	}

	@XmlElement(name = "id")
	public String getId() {
		return this.id;
	}

	@XmlElement(name = "title")
	public String getTitle() {
		return this.title;
	}

	@XmlElement(name = "description")
	public String getDescription() {
		return this.description;
	}

	@XmlElement(name = "staminaCost")
	public Integer getStaminaCost() {
		return 999;
	}
}
