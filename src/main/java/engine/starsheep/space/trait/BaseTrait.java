package engine.starsheep.space.trait;
/**
 *
 * @see Trait
 * @see DefensiveTrait
 */
interface BaseTrait {
	
	public String getName();
	
	public int getId();
	
	public int getLevel();
	
	public void addLevels(int levels);
}
