package devTool.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.jgoodies.common.collect.ArrayListModel;

@XmlRootElement(name = "missions")
public class MissionsModel {
	private ArrayListModel<EditableMission> missions;

	public MissionsModel() {
		missions = new ArrayListModel<EditableMission>();
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
	public ArrayListModel<EditableMission> getMissions() {
		return this.missions;
	}
}