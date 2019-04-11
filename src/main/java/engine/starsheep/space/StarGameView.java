package engine.starsheep.space;

/**
 * Defies the StarGameView in MVC
 */
public abstract class StarGameView {

    private StarTab currStarTab = StarTab.HOME;

    /**
     * Similar to working of System.out.println, log implementations can differ.
     *
     * uses toString on object
     */
    public abstract void log(Object toPrint);


    public void changeToTab(StarTab starTab) {
        currStarTab = starTab;
    }

    public StarTab getCurrentTab(){
        return this.currStarTab;
    }

}
