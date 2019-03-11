package engine.starsheep.space.Trait;

public class DefensiveTrait implements BaseTrait {
	private String name;
	private int id;
	private int baseLevel;

	public DefensiveTrait(String name, int id, int baseLevel) {
		this.name = name;
		this.id = id;
		this.baseLevel = baseLevel;
	}

	public String getName() {
		return this.name;
	}

	public int getId() {
		return this.id;
	}

	public int getLevel() {
		return this.baseLevel;
	}

	public void addLevels(int levels) {
		this.baseLevel += levels;
	}
}
