package engine.starsheep.space.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import engine.starsheep.space.Mission;
import engine.starsheep.space.MutableMission;

/**
 * Mission model is the class that the missions.xml file is unmarshalled to.
 * 
 * @author peakyDicers
 *
 */
@XmlRootElement(name = "missions")
public class MissionsModel {
	
	
	private ArrayList<MutableMission> missions;

	public MissionsModel() {
		missions = new ArrayList<MutableMission>();
	}

	/**
	 * This is ONLY to be used for unmarshalling from the missions.xml file.
	 * 
	 * @return An ArrayList of mutable missions.
	 */
	@XmlElement(name = "mission")
	public ArrayList<MutableMission> getMissions() {
		return this.missions;
	}
	
	/**
	 * Reading in the missions.xml, the data is unmarshalled into objects with setters.
	 * In order to remove the setters, these objects are 
	 * upcasted.
	 * 
	 * This is the list to be used within the Engine.
	 * 
	 * 
	 * @return An Unmodifiable list of all Missions and JobFlyers.
	 */
	public List<Mission> getImmutableMissions(){
		ArrayList<Mission> result = new ArrayList<Mission>();
		
		for (MutableMission mutableMission: missions) {
			mutableMission.buildImmutableJobFlyers();
			result.add(mutableMission);
		}
		
		return Collections.unmodifiableList(result);
	}
}
