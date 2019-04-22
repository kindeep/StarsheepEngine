package engine.starsheep.space.xml;

import engine.starsheep.space.Mission;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A subclass of the Mission class to allow for setters.
 * Only to be used when marshalling.
 * 
 * @author peakyDicers
 *
 * @see MissionsModel
 */
@XmlRootElement(name = "mission")
public class MutableMission extends Mission{
	private List<MutableJobFlyer> mutableJobFlyers = new ArrayList<MutableJobFlyer>();
	
	/**
	 * Upcasts the MutableJobFlyers to JobFlyers. The JobFlyers are then
	 * added to List<JobFlyer>.
	 * 
	 * Note: Remember to call this, before upcasting MutableMission to Mission, or else
	 * the List<JobFlyer> will not be available.
	 */
	public void buildImmutableJobFlyers() {
		for (MutableJobFlyer flyer: mutableJobFlyers) {
			jobFlyers.add(flyer);
		}
	}
	
	@XmlElement(name = "name")
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement(name = "description")
	public void setDescription(String description) {
		this.description = description;
	}
	
	@XmlElement(name = "id")
	public void setId(String id) {
		this.id = id;
	}
	
	@XmlElement(name = "stamina-cost")
	public void setStaminaCost(int staminaCost) {
		this.staminaCost = staminaCost;
	}
	
	@XmlElementWrapper(name = "jobs")
	@XmlElement(name = "job")
	public List<MutableJobFlyer> getJobFlyerList(){
		return this.mutableJobFlyers;
	}
}
