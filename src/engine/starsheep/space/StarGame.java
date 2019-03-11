package engine.starsheep.space;

import java.util.List;

import engine.starsheep.space.Job.Job;
import engine.starsheep.space.Job.JobFlyer;
import engine.starsheep.space.Job.TraitDependency;
import engine.starsheep.space.Trait.TraitManager;

public class StarGame {

    private MissionsManager missionsManager;
    private TraitManager traitManager;
    private Mission currentMission;
    private Choice currentChoice;

    private StarGameView display;
    private StarPlayer player;
    private StarFileManager fileManager;

    /**
     * Need some way to read the game state from XML files. Possibly another class
     * to read data from save files, which would be xml files.
     * <p>
     * represents model in MVC
     *
     * @param display a display for the game, should implement StarGameView. swap it out for
     *                different enviornments.
     */
    public StarGame(StarGameView display, StarPlayer player, StarFileManager filesMangaer) {
//        missionsManager = MissionsManager.getInstance(filesMangaer);
        this.traitManager = TraitManager.getInstance();
        this.currentMission = null;
        this.currentChoice = null;
        this.display = display;
        this.player = player;
        this.fileManager = filesMangaer;
        this.missionsManager = MissionsManager.getInstance(fileManager);

        Job j = StarReader.readJob(filesMangaer.getJobFile(), 999);
        System.out.println(j.toString());
        List<Mission> missions = missionsManager.getMissions();
        missions.forEach(m -> {
            List<JobFlyer> flyers = m.getJobFlyers();
            flyers.forEach(flyer -> {
                display.log(flyer.getName());
                display.log(flyer.getDescription());
                display.log(flyer.getJobId());
                display.log(flyer.getStaminaCost());
            });
        });
    }

    public void setMission(Mission m) {
        currentMission = m;
    }

    public void setChoice(Choice c) {
        currentChoice = c;
    }

    public boolean calculateSuccess(List<TraitDependency> traitDependencies) {

        /*
         * todo: computer calculations.
         */
        for (int i = 0; i < traitDependencies.size(); i++) {
            TraitDependency td = traitDependencies.get(i);
            int weight = td.getWeight();


        }
        return true;
    }

//    public static void main(String[] args) {
////		StarTest test = new StarTest(); //use StarTest to test anything.
////		test.testReadingMissions();
//
//    }
}