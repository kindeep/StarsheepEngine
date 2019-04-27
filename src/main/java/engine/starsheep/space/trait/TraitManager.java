package engine.starsheep.space.trait;

import java.util.Map;

import engine.starsheep.space.json.StarReader;

/**
 * Manages all data pertaining to Traits.
 *
 */
public class TraitManager {
	private Map<String, Trait> allTraits;
	private static TraitManager instance = null;

	private TraitManager() {
	    allTraits = StarReader.readTraits();
	}

	static public TraitManager getInstance() {
		if (instance == null)
			instance = new TraitManager();
		return instance;
	}
	
	public Map<String,Trait> getAllTraits(){
	    return this.allTraits;
	}
	
	public void alterTraitLevel(String traitId, int val) {
	    allTraits.get(traitId).addLevels(val);
	}
}
