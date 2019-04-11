package cmdTest;

import engine.starsheep.space.*;

import java.util.Scanner;

/**
 * @author Kindeep Singh Kargil
 */
public class CmdTest {
    /**
     * Testing needs to be isolated from the paakge.
     * <p>
     * Unit testing is whatever tho.
     *
     * @param args
     */
    public static void main(String[] args) {
//        System.out.println("Working Directory = " +
//                System.getProperty("user.dir"));
        SampleCmdView view = new SampleCmdView();
        StarPlayer player = new StarPlayer();
        FileManager saveFilesReader = new FileManager();
        SampleSoundManager soundManager = new SampleSoundManager();
        StarGame game = new StarGame(view, player, saveFilesReader, soundManager);
        Scanner in = new Scanner(System.in);
        StarController controller = game.getController();
        Thread viewThread = new Thread(view);
        view.log("StarSheep");
        view.display();
        for (; ; ) {
            String currLine = in.nextLine();
            if (currLine.equals("exit")) break;
            switch (currLine.trim()) {
                case "home":
                    controller.changeToTab(StarTab.HOME);
                    break;
                case "inventory":
                    controller.changeToTab(StarTab.INVENTORY);
                    break;
                case "shop":
                    controller.changeToTab(StarTab.SHOP);
                    break;
            }
            view.display();
        }
    }


}
