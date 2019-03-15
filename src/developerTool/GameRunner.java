package developerTool;

import cmdTest.SampleFilesManager;
import engine.starsheep.space.StarGame;

/**
 * 
 * This starts the developer tool.
 *
 */
public class GameRunner{

	public static void main(String args[]) {
		StarGame game = new StarGame(null, null, new SampleFilesManager());
		DeveloperView devView = new DeveloperView(game.getController());
	}
}