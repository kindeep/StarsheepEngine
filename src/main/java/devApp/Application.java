package devApp;

import java.awt.EventQueue;
import java.io.File;
import java.util.List;

import javax.swing.JFrame;

import engine.starsheep.space.Mission;
import engine.starsheep.space.StarGame;
import engine.starsheep.space.StarGameView;
import javax.swing.JTabbedPane;
import java.awt.CardLayout;

public class Application {

    private JFrame frame;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Application window = new Application();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    static private StarGame game;
    
    static StarGame getGameInstance() {
        return game;
    }

    /**
     * Create the application.
     */
    public Application() {
        StarGameView view = new AppView();
        AppFileManager.getInstance().setBaseDirectory(new File("./src/main/resources/sample_game"));
        
        game = new StarGame(view, null, AppFileManager.getInstance(), null);
        List<Mission> missions = game.getMissionsController().getMissions();
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 324, 505);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new CardLayout(0, 0));
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        frame.getContentPane().add(tabbedPane, "name_433018553683185");
        
        MissionsScreen missionsScreen = new MissionsScreen();
        tabbedPane.addTab("Missions", null, missionsScreen, null);
        
    }
}
