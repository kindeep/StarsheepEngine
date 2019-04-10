package devTool.XMLBuilder;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.jgoodies.common.collect.LinkedListModel;

import devTool.DevStarReader;
import devTool.DevFileManager;
import devTool.models.EditableMission;
import engine.starsheep.space.StarFileManager;

@XmlRootElement(name = "missions")
public class MissionsModel {
	private LinkedListModel<EditableMission> missions;

	public MissionsModel() {
		missions = new LinkedListModel<EditableMission>();
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
	public LinkedListModel<EditableMission> getMissions() {
		return this.missions;
	}
	
	public void loadMissionsFile(File gameDir) {
		StarFileManager wtf = new DevFileManager(gameDir);
		DevStarReader.setFileManager(wtf);
		this.missions = DevStarReader.readEditableMissions();
	}
}