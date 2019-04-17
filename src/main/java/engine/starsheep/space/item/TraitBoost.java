package engine.starsheep.space.item;

/**
 * 
 * Holds info on the trait boosts for items.
 */
public class TraitBoost {
	private String traitName;
	private int boost;
	
	public TraitBoost(String traitName, int boost) {
		this.traitName = traitName;
		this.boost = boost;
	}
	
	public String getName() {
		return this.traitName;
	}
	
	public int getBoost() {
		return this.boost;
	}
}
