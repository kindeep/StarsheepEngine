package engine.starsheep.space.trait;

public class DefensiveTrait implements BaseTrait {
	private String name;
	private String id;
	private int baseLevel;

	public DefensiveTrait(String name, String id, int baseLevel) {
		this.name = name;
		this.id = id;
		this.baseLevel = baseLevel;
	}

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
