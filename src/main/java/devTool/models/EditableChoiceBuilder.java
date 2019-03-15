package devTool.models;

import engine.starsheep.space.Job.ChoiceBuilder;

public class EditableChoiceBuilder extends ChoiceBuilder{

	public EditableChoiceBuilder() {
		super();
	}
	
	@Override
	public EditableChoice build() {
		return new EditableChoice(this);
	}
}
