package engine.starsheep.space.controller;

import java.util.List;

import engine.starsheep.space.Choice;
import engine.starsheep.space.Mission;
import engine.starsheep.space.Player;
import engine.starsheep.space.job.Job;
import engine.starsheep.space.job.TraitDependency;
import engine.starsheep.space.json.StarReader;
import engine.starsheep.space.trait.Trait;
import engine.starsheep.space.trait.TraitManager;

/**
 * Controls all data around the current Mission, Job and Choice. 
 * 
 * @author peakyDicers
 *
 */
public class MissionsController {
    
    private static MissionsController instance;
    private List<Mission> missions;
    private Mission currMission;
    private Job currJob;
    private Choice currChoice;

    private MissionsController() {
        missions = StarReader.readMissions();
    }
    
    public static MissionsController getInstance() {
        if (instance == null)
            instance = new MissionsController();
        return instance;
    }

    public List<Mission> getMissions(){
        return this.missions;
    }
    
    public Mission getCurrentMission() {
        return currMission;
    }
    
    public void setCurrentMission(Mission mission) {
        this.currMission = mission;
    }
    
    public void setCurrentChoice(Choice c) {
        this.currChoice = c;
    }
    
    public Choice getCurrentChoice() {
        return this.currChoice;
    }

    public Job getCurrentJob() {
        return this.currJob;
    }
    
    public void setCurrentJob(String jobId) {
        
        //read job.xml file and set the current choice to head.
        this.currJob = StarReader.readJob(jobId);
        this.currChoice = currJob.getChoices().get(currJob.getHeadId());
    }
    
    public int getPlayerStamina() {
    	return Player.getInstance().getStamina();
    }
    
    public boolean makeChoice(Choice choice) {
    	Player.getInstance().reduceStamina(choice.getStaminaCost()); //reduce stamina.
    	
    	List<TraitDependency> traitDeps = choice.getTraitDependencies();
    	
    	//calculate weight sum.
    	double weightSum = traitDeps.stream().mapToInt(dep -> dep.getWeight()).sum();
	
    	//calculate weighted sum.
		TraitManager traitManager = TraitManager.getInstance();
		double weightedSum = traitDeps.stream().mapToDouble(dep -> {
			Trait trait = traitManager.getTrait(dep.getId());
			return trait.getLevel()*dep.getWeight()/weightSum;
		}).sum();
		
		//compute probability
		double probability = logistic(weightedSum);
		double random = Math.random();
		
		if (random < probability) {
			this.setCurrentChoice(choice);
			return true;
		}
        return false;
    }
    
    private double logistic(double x) {
    	double jobLevel = currJob.getLevel();
		x -= 2.8;
		double y = 0.0f;
		double k = 0.1f;
		double midpoint = jobLevel/2.0;
		
		y = 1/(1 + Math.exp(-k*(x - midpoint)));
		return y;
	}
}
