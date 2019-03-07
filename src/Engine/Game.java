package Engine;

public class Game {

    /**
     * Need some way to read the game state from XML files. Possibly another class to read data from save
     * files, which would be xml files.
     *
     * @param display a display for the game, should implement View. swap it out for different enviornments.
     *
     *
     */
    public Game(View display, Player player) {

    }

	public static void main(String[] args) {
		StarTest test = new StarTest();
		test.testFileReading();
	}
}
