package developerTool;

<<<<<<< HEAD:src/main/java/developerTool/DeveloperView.java
=======
import engine.starsheep.space.StarGameView;
>>>>>>> Created main Developer window, GeneralPanel and MissionsPanel:src/developerTool/DeveloperView.java
import engine.starsheep.space.Controller;
import engine.starsheep.space.Mission;
import engine.starsheep.space.StarGameView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This is an implementation of a View as defined by the Starsheep Engine View.
 *
 */
public class DeveloperView extends JFrame implements StarGameView {
	private static final long serialVersionUID = 1L;
	Controller controller;

	public DeveloperView(Controller c) {
		controller = c;
	}

	@Override
	public void log(Object toPrint) {
	}
}
