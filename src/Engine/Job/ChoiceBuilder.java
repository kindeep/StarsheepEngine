package Engine.Job;

import java.util.ArrayList;

public class ChoiceBuilder {
	
	
	private ArrayList<Choice> choices = null;
	private ArrayList<Integer> choicesIds = null;
	private ArrayList<TraitDependency> traitDependencies = null;
	private Double staminaCost = null;
	private String description = null;
	private int choiceId;
	
	public ChoiceBuilder() {
		choices = new ArrayList<Choice>();
		choicesIds = new ArrayList<Integer>();
		traitDependencies = new ArrayList<TraitDependency>();
	}
	
	public Choice build() {
		return new Choice(this);
	}
	
	//helpers
	public void addChildChoiceID(Integer id) {
		choicesIds.add(id);
	}
	
	public void addTraitDependency(TraitDependency td) {
		this.traitDependencies.add(td);
	}
	
	//getters
	public ArrayList<Choice> getChoices(){
		return this.choices;
	}
	
	public ArrayList<TraitDependency> getTraitDependencies(){
		return this.traitDependencies;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public Double getStaminaCost() {
		return this.staminaCost;
	}
	
	public int getChoiceId() {
		return this.choiceId;
	}
	
	//setters
	public void setChoices(ArrayList<Choice> choices) {
		this.choices = choices;
	}
	
	public void setTraitDependencies(ArrayList<TraitDependency> traitDependencies) {
		this.traitDependencies = traitDependencies;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setStaminaCost(Double staminaCost) {
		this.staminaCost = staminaCost;
	}
	
	public void setChoiceId(int id) {
		this.choiceId = id;
	}
}
