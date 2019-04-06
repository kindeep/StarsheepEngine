package devTool.XMLBuilder;

import java.io.File;
import java.util.LinkedList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import devTool.DevStarReader;
import devTool.DevFileManager;
import devTool.models.EditableMission;
import engine.starsheep.space.StarSaveFilesReader;

@XmlRootElement(name = "missions")
public class MissionsModel {
	private LinkedList<EditableMission> missions;

	public MissionsModel() {
		missions = new LinkedList<EditableMission>();
	}

	// helper
	public void addMission(EditableMission m) {
		missions.add(m);
	}

	public void removeMission(EditableMission m) {
		missions.remove(m);
	}

	public String getNextMissionId() {
		return String.valueOf(missions.size());
	}

	// getter
	@XmlElement(name = "mission")
	public LinkedList<EditableMission> getMissions() {
		return this.missions;
	}
	
	public void loadMissionsFile(File gameDir) {
		StarSaveFilesReader wtf = new DevFileManager(gameDir);
		DevStarReader.setFileManager(wtf);
		this.missions = DevStarReader.readEditableMissions();
	}
}