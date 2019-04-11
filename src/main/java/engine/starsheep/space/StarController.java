package engine.starsheep.space;

import javafx.scene.control.Tab;

import java.util.List;


public class StarController {

    private static StarController instance;
    private static StarGame game;

    private StarController() {

    }

    static StarController getInstance() {
        if (instance == null)
            instance = new StarController();
        return instance;
    }

    static void setGame(StarGame g) {
        game = g;
    }

    //controller methods.
    public List<Mission> getMissions() {
        return game.getMissions();
    }

    public void changeToTab(StarTab t) {
        game.getView().changeToTab(t);
    }
}
