package engine.starsheep.space;

import engine.starsheep.space.Job.ChoiceBuilder;
import engine.starsheep.space.Job.TraitDependency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author peakyDicers
 * @see ChoiceBuilder
 */

@XmlRootElement(name = "choice")
public class Choice {
	protected ArrayList<String> choices;
	protected ArrayList<TraitDependency> traitDependencies;
	protected Double staminaCost = 0.0;
	protected Integer id;
	protected String description = "fake description here";
	
	//no-arg constructor required for XML marshalling.
	public Choice() {
		this.traitDependencies = new ArrayList<TraitDependency>();
	}

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

	@XmlAttribute(name = "id")
	public int getID() {
		return this.id;
	}

	/**
	 * Returns an unmodifiable list of the trait dependencies.
	 * 
	 * @return an unmodifiable list of trait dependencies.
	 */
	@XmlElementWrapper(name = "trait-dependencies")
	@XmlElement(name = "trait")
	public List<TraitDependency> getTraitDependencies() {
		return Collections.unmodifiableList(this.traitDependencies) ;
	}

	/**
	 * Returns a list with all children Choice Ids.
	 *
	 * @return a list of all children choice IDs.
	 */
	
	@XmlElementWrapper(name = "children")
	@XmlElement(name = "child")
	public List<String> getChildrenChoices() {
		return this.choices;
	}

	/**
	 * Getter method for stamina
	 *
	 * @return Double stamina
	 */
	@XmlElement(name = "stamina-cost")
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
