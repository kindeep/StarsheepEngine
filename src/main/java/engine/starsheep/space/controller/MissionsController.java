package engine.starsheep.space.controller;

import java.util.List;

import engine.starsheep.space.Choice;
import engine.starsheep.space.Mission;
import engine.starsheep.space.job.Job;
import engine.starsheep.space.json.StarReader;

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

}
