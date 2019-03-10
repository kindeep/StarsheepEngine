package Engine;

import java.util.List;

public class Game {

	MissionsManager missionsManager;

	/**
	 * Need some way to read the game state from XML files. Possibly another class
	 * to read data from save files, which would be xml files.
	 *
	 * @param display a display for the game, should implement View. swap it out for
	 *                different enviornments.
	 *
	 */
	public Game(View display, Player player) {
		missionsManager = MissionsManager.getInstance();
	}

	public static void main(String[] args) {
		StarTest test = new StarTest(); //use StarTest to test anything.
		test.testReadingMissions();
	}
}
