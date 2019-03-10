package Engine.Trait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Manages all data pertaining to Traits.
 *
 */
public class TraitManager {
	private HashMap<Integer, BaseTrait> allTraits;
	private List<DefensiveTrait> defensiveTraits;
	private static TraitManager instance = null;

	private TraitManager() {
		/*
		 * todo: read from Traits.xml and player save data.
		 */
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
