package engine.starsheep.space.trait;

/**
 * 
 * Holds data for a single trait.
 *
 */
public class Trait implements BaseTrait{
	private String name;
	private int id;
	private int baseLevel;
	
	public Trait(String name, int id, int baseLevel) {
		this.name = name;
		this.id = id;
		this.baseLevel = baseLevel;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public int getLevel() {
		return this.baseLevel;
	}

	@Override
	public void addLevels(int levels) {
		this.baseLevel += levels;
	}
}
