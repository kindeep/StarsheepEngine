package engine.starsheep.space;

import engine.starsheep.space.Job.ChoiceBuilder;
import engine.starsheep.space.Job.TraitDependency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Choice {

	private ArrayList<Choice> choices;
	private ArrayList<TraitDependency> traitDependencies;
	private Double staminaCost = 0.0;
	private Integer id;
	private String description = "fake description here";

	public Choice(ChoiceBuilder cb) {
		this.choices = cb.getChoices();
		this.traitDependencies = cb.getTraitDependencies();
		this.staminaCost = cb.getStaminaCost();
		this.id = cb.getChoiceId();
	}

	@Override
	public String toString() {
		return "Choice - id: " + this.id + " staminaCost: " + this.staminaCost + "description: " + this.description;
	}

	public int getID() {
		return this.id;
	}

	/**
	 * Returns an unmodifiable list of the trait dependencies.
	 * 
	 * @return an unmodifiable list of trait dependencies.
	 */
	public List<TraitDependency> getTraitDependencies() {
		return Collections.unmodifiableList(this.traitDependencies) ;
	}

	/**
	 * Returns a list with all children of the current choice
	 *
	 * @return a list of all children choices
	 */
	public List<Choice> getChildrenChoices() {
		return this.choices;
	}

	/**
	 * Getter method for stamina
	 *
	 * @return Double stamina
	 */
	public double getStaminaCost() {
		return this.staminaCost;
	}

	/**
	 * Uses trait weights and information from the stamina
	 *
	 * @return if the choice can be made
	 */
	boolean canMakeChoice(StarPlayer player) {
		return false;
	}
}
