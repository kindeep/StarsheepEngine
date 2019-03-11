import engine.starsheep.space.*;

public class CmdTest {

    /**
     * Testing needs to be isolated from the paakge.
     *
     * Unit testing is whatever tho.
     *
     * @param args
     */
    public static void main(String[] args) {
        StarGameView view = new SampleCmdView();

        StarPlayer player = new StarPlayer();

        StarGame game = new StarGame(view, player);
    }
}
