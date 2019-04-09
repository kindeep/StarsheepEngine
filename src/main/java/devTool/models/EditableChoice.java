package devTool.models;

import java.util.ArrayList;
import java.util.List;

import engine.starsheep.space.Choice;
import engine.starsheep.space.Job.TraitDependency;

public class EditableChoice extends Choice {

	public EditableChoice() {
		super();
	}
	//helpers
	public void addTraitDependency(EditableTraitDependency td) {
		traitDependencies.add(td);
	}
	
	//setters
	public void setChoices(ArrayList<String> choices) {
		this.choices = choices;
	}
	
	public void setStaminaCost(Double staminaCost) {
		this.staminaCost = staminaCost;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setChoiceId(Integer id) {
		this.id = id;
	}
}
