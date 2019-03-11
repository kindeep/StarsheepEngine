package developerTool;

import engine.starsheep.space.StarGame;
import java.awt.EventQueue;

/**
 * 
 * This starts the developer tool.
 *
 */
public class GameRunner {
	
	public static void main(String args[]) {
		EventQueue.invokeLater(() -> {
			StarGame game = new StarGame(null, null);
			DeveloperView devView = new DeveloperView(game.getController());
			devView.setVisible(true);
		});
	}
}
