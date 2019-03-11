package engine.starsheep.space;

import java.util.List;

import engine.starsheep.space.Job.TraitDependency;
import engine.starsheep.space.Trait.TraitManager;

public class StarGame {

	private MissionsManager missionsManager;
	private TraitManager traitManager;
	private Mission currentMission;
	private Choice currentChoice;

	/**
	 * Need some way to read the game state from XML files. Possibly another class
	 * to read data from save files, which would be xml files.
	 *
	 * represents model in MVC
	 *
	 * @param display a display for the game, should implement StarGameView. swap it out for
	 *                different enviornments.
	 *
	 */
	public StarGame(StarGameView display, StarPlayer player, StarFileMangaer filesMangaer) {
		missionsManager = MissionsManager.getInstance();
		traitManager = TraitManager.getInstance();
		currentMission = null;
		currentChoice = null;
	}
	
	public void setMission(Mission m) {
		currentMission = m;
	}
	
	public void setChoice(Choice c) {
		currentChoice = c;
	}
	
	public boolean calculateSuccess(List<TraitDependency> traitDependencies) {
		
		/*
		 * todo: computer calculations.
		 */
		for (int i = 0; i < traitDependencies.size(); i++) {
			TraitDependency td = traitDependencies.get(i);
			int weight = td.getWeight();
			
			
		}
		return true;
	}

	public static void main(String[] args) {
		StarTest test = new StarTest(); //use StarTest to test anything.
		test.testReadingMissions();
	}
}
