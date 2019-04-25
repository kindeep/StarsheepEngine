package engine.starsheep.space.trait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import engine.starsheep.space.json.StarReader;

/**
 * Manages all data pertaining to Traits.
 *
 */
public class TraitManager {
	private Map<String, Trait> allTraits;
	private List<DefensiveTrait> defensiveTraits;
	private static TraitManager instance = null;

	private TraitManager() {
	    allTraits = StarReader.readTraits();
	}

	static public TraitManager getInstance() {
		if (instance == null)
			instance = new TraitManager();
		return instance;
	}
	
	//returns an unmodifiable list of all traits.
	public List<BaseTrait> getAllTraits(){
		List<BaseTrait> list = new ArrayList<BaseTrait>(allTraits.values()); 
		return Collections.unmodifiableList(list);
	}
	
	//returns an unmodifiable list of all defensive traits.
	public List<DefensiveTrait> getAllDefensiveTraits(){
		return Collections.unmodifiableList(this.defensiveTraits);
	}
	
	//returns a single trait.
	public BaseTrait getTrait(Integer id) {
		return allTraits.get(id);
	}
}
