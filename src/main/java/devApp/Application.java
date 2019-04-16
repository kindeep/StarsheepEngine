package devApp;

import java.io.File;
import java.util.List;

import engine.starsheep.space.Mission;
import engine.starsheep.space.StarGame;
import engine.starsheep.space.StarGameView;
import engine.starsheep.space.Job.JobFlyer;

/**
 * Application for testing purposes.
 * 
 * @author peakyDicers
 *
 */
public class Application {

	public Application() {
		StarGameView view = new AppView();
		AppFileManager.getInstance().setBaseDirectory(new File("./sample_game"));
		
		StarGame game = new StarGame(view, null, AppFileManager.getInstance(), null);
		List<Mission> missions = game.getMissions();
		
		//print missions.
		for (Mission m: missions) {
			System.out.println(m);
			
			for (JobFlyer job: m.getJobFlyers()) {
				System.out.println(job.getName());
			}
			System.out.println("-------------------");
		}
		
	}

	public static void main(String args[]) {
		new Application();
	}
}
