package devTool.models;

import engine.starsheep.space.Job.TraitDependency;

public class EditableTraitDependency extends TraitDependency{

	public EditableTraitDependency() {
		super(null, 0);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
}
