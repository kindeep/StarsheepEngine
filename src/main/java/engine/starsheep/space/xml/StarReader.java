package engine.starsheep.space.xml;

import engine.starsheep.space.Mission;
import engine.starsheep.space.StarFileManager;
import engine.starsheep.space.job.Job;
import engine.starsheep.space.trait.Trait;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

/**
 * Used to read StarSheep XML files.
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
	 * Reads the traits.xml file and returns a HashMap of Trait objects.
	 */
	public static Map<String, Trait> readTraits(){
	    try {
//            if (fileManager == null)
//                throw new Exception("Star file manager cannot be null in StarReader.");
//
//            String path = fileManager.getBaseDirectory().toString() + "/traits.xml";
//            File file = new File(path);
//
//            JAXBContext jContext = JAXBContext.newInstance(TraitsModel.class);
//            Unmarshaller unmarshallerObj = jContext.createUnmarshaller();
//
//            TraitsModel traitsModel = (TraitsModel) unmarshallerObj.unmarshal(file);
	        return null;
            //return traitsModel.getTraits();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}
	
	/**
	 * Reads the Missions.xml file and returns a list of Mission objects.
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
	 * Reads the Job.xml file for a specific job and return the Job object.
	 */
	public static Job readJob(String jobId) { // this method needs to be worked on.
	    try {
            if (fileManager == null)
                throw new Exception("Star file manager cannot be null in StarReader.");

            String path = fileManager.getBaseDirectory().toString() + "/jobs/j_" + jobId + ".json";
            FileReader reader = new FileReader(path);

            Gson gson = new Gson();
            Job job = gson.fromJson(reader, Job.class);
            
            return job;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}
}
