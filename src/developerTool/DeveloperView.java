package developerTool;

import engine.starsheep.space.StarGameView;
import engine.starsheep.space.Controller;

/**
 * 
 * This is an implementation of a View as defined by the Starsheep Engine View.
 *
 */
public class DeveloperView implements StarGameView {
	Controller controller;

	public DeveloperView(Controller c) {
		controller = c;
	}

	@Override
	public void log(Object toPrint) {
	}
}
