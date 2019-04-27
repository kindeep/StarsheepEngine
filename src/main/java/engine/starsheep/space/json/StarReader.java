package engine.starsheep.space.json;

import engine.starsheep.space.Mission;
import engine.starsheep.space.StarFileManager;
import engine.starsheep.space.item.Item;
import engine.starsheep.space.job.Job;
import engine.starsheep.space.trait.Trait;

import com.google.gson.Gson;

import java.io.FileReader;
import java.util.List;
import java.util.Map;

/**
 * Used to read StarSheep JSON files.
 * 
 * @author peakyDicers
 *
 */
public class StarReader {
    
	protected static StarFileManager fileManager;

	public static void setFileManager(StarFileManager manager) {
		StarReader.fileManager = manager;
	}
	
	/**
	 * Reads the traits.json file and returns a HashMap of Trait objects.
	 */
	public static Map<String, Trait> readTraits(){
	    try {
            if (fileManager == null)
                throw new Exception("Star file manager cannot be null in StarReader.");

            String path = fileManager.getBaseDirectory().toString() + "/traits.json";
            FileReader reader = new FileReader(path);
            Gson gson = new Gson();
            
            return gson.fromJson(reader, TraitsModel.class).getTraits();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}
	
	/**
     * Reads the Items.json file and returns a list of Items.
     */
	public static ItemsModel readItems(){
	    try {
            if (fileManager == null)
                throw new Exception("Star file manager cannot be null in StarReader.");

            String path = fileManager.getBaseDirectory().toString() + "/items.json";
            FileReader reader = new FileReader(path);
            Gson gson = new Gson();
            
            return gson.fromJson(reader, ItemsModel.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}
	
	/**
	 * Reads the Mission.json and returns a list of missions.
	 */
	public static List<Mission> readMissions() {
		try {
			if (fileManager == null)
				throw new Exception("Star file manager cannot be null in StarReader.");

			String path = fileManager.getBaseDirectory().toString() + "/missions.json";
			FileReader reader = new FileReader(path);
			Gson gson = new Gson();
			
			MissionsModel mm = gson.fromJson(reader, MissionsModel.class);
			return mm.getMissions();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Reads the Job.json file for a specific job and return the Job object.
	 */
	public static Job readJob(String jobId) { // this method needs to be worked on.
	    try {
            if (fileManager == null)
                throw new Exception("Star file manager cannot be null in StarReader.");

            String path = fileManager.getBaseDirectory().toString() + "/jobs/j_" + jobId + ".json";
            FileReader reader = new FileReader(path);

            Gson gson = new Gson();
            Job job = gson.fromJson(reader, Job.class);
            job.finalize();
            
            return job;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}
}
