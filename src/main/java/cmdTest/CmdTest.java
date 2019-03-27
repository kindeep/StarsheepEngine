package cmdTest;

import engine.starsheep.space.*;

public class CmdTest {

    /**
     * Testing needs to be isolated from the paakge.
     * <p>
     * Unit testing is whatever tho.
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
        StarGameView view = new SampleCmdView();
        StarPlayer player = new StarPlayer();
        FileManager saveFilesReader = new FileManager();
        view.log("Sample out");
        StarGame game = new StarGame(view, player, saveFilesReader);
    }
}
