package engine.starsheep.space.trait;

/**
 * 
 * Holds data for a single trait.
 *
 */
public class Trait implements BaseTrait{
	protected String name;
	protected String id;
	protected int baseLevel;

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getId() {
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
