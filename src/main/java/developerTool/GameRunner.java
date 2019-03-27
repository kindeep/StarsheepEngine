package developerTool;

import cmdTest.FileManager;
import cmdTest.SampleSoundManager;
import engine.starsheep.space.StarGame;

import java.awt.*;

/**
 * 
 * This starts the developer tool.
 *
 */
public class GameRunner {
	
	public static void main(String args[]) {
		EventQueue.invokeLater(() -> {
			StarGame game = new StarGame(null, null, new FileManager(), new SampleSoundManager());
			DeveloperView devView = new DeveloperView(game.getController());
			devView.setVisible(true);
		});
	}
}
