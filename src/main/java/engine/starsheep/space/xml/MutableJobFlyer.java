package engine.starsheep.space.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import engine.starsheep.space.job.JobFlyer;

/**
 * A subclass of the JobFlyer class to allow for setters. Only to be used when
 * marshalling.
 * 
 * @author peakyDicers
 *
 * @see MutableMission
 */
@XmlRootElement(name = "job")
public class MutableJobFlyer extends JobFlyer {

	@XmlElement(name = "id")
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	@XmlElement(name = "name")
	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "description")
	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement(name = "stamina-cost")
	public void setStaminaCost(Integer staminaCost) {
		this.staminaCost = staminaCost;
	}
}