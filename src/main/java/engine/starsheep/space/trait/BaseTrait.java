package engine.starsheep.space.trait;
/**
 *
 * @see Trait
 * @see DefensiveTrait
 */
interface BaseTrait {
	
	public String getName();
	
	public String getId();
	
	public int getLevel();
	
	public void addLevels(int levels);
}
