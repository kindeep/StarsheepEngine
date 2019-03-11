package engine.starsheep.space;

import java.util.List;

import engine.starsheep.space.Job.Job;
import engine.starsheep.space.Job.JobFlyer;

/**
 * Use this file to run your tests.
 */
public class StarTest {
	
	public void testFileReading() {
		Job j = StarReader.readJob(999);
		System.out.println(j.toString());
	}
	
	public void testReadingMissions() {
		MissionsManager missionsManager = MissionsManager.getInstance();
		List<Mission> missions = missionsManager.getMissions();
		for (int i = 0; i < missions.size(); i++) {
			Mission m = missions.get(i);
			List<JobFlyer> flyers = m.getJobFlyers();
			for (int j = 0; j < flyers.size(); j++) {
				JobFlyer flyer = flyers.get(j);
				System.out.println(flyer.getName());
				System.out.println(flyer.getDescription());
				System.out.println(flyer.getJobId());
				System.out.println(flyer.getStaminaCost());
			}
		}
	}
}
