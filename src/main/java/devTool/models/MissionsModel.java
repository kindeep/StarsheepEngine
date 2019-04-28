package devTool.models;

import com.jgoodies.common.collect.ArrayListModel;


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

	public ArrayListModel<EditableMission> getMissions() {
		return this.missions;
	}
}