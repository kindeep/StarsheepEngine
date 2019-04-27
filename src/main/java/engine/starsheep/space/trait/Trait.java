package engine.starsheep.space.trait;

import com.google.gson.annotations.SerializedName;

/**
 * Holds data for a single trait.
 *
 */
public class Trait {
    
    @SerializedName("name")
	private String name;
    
    @SerializedName("id")
	private String id;
    
	private int level;

	public String getName() {
		return this.name;
	}

	public String getId() {
		return this.id;
	}

	public int getLevel() {
		return this.level;
	}

	public void addLevels(int levels) {
		this.level += levels;
	}
	
	@Override
	public String toString() {
	    return this.name + " Level: " + this.level;
	}
}
