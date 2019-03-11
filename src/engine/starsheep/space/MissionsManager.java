package engine.starsheep.space;

import java.io.File;
import java.util.List;

/**
 * 
 * This is a singleton class that holds all data regarding all missions.
 * Use to get any any data on any mission.
 * 
 * @see Mission
 */
public class MissionsManager {
	private static MissionsManager instance;
	private List<Mission> missions; //a list of all missions.
	private StarFileManager fileManager;
	private MissionsManager(StarFileManager fileManager) {
		missions = StarReader.readMissions(fileManager.getMissionsFile()); //read the missions xml.
	}
	
	public static MissionsManager getInstance(StarFileManager fileManager) {
		if (instance == null) {
            instance = new MissionsManager(fileManager);
        }
		return instance;
	}
	
	public List<Mission> getMissions(){
		return this.missions;
	}
}
