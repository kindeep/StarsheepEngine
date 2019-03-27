package engine.starsheep.space;

import java.util.List;

public class Controller {
	
	private static Controller instance;
	private static StarGame game;
	
	private Controller() {
		
	}
	
	public static Controller getInstance() {
		if (instance == null)
			instance = new Controller();
		return instance;
	}
	
	public static void setGame(StarGame g) {
		game = g;
	}
	
	//controller methods.
	public List<Mission> getMissions(){
		return game.getMissions();
	}

}
