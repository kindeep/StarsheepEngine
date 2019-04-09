package devTool.models;

import engine.starsheep.space.MissionBuilder;

public class EditableMissionBuilder extends MissionBuilder {
	
	@Override
	public EditableMission build() {
		return new EditableMission(this);
	}
}
