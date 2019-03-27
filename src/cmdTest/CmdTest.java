package cmdTest;

import engine.starsheep.space.*;

import java.io.File;

public class CmdTest {

    /**
     * Testing needs to be isolated from the paakge.
     * <p>
     * Unit testing is whatever tho.
     *
     * @param args
     */
    public static void main(String[] args) {
//        File job = new File("sample_config/Job.xml");
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
        System.out.println("what");
        StarGameView view = new SampleCmdView();
        StarPlayer player = new StarPlayer();
        SampleFilesManager filesManager = new SampleFilesManager();
        view.log("Sample out");
        StarGame game = new StarGame(view, player, filesManager);
    }
}
