package engine.starsheep.space.xml;

import engine.starsheep.space.Mission;
import engine.starsheep.space.StarFileManager;
import engine.starsheep.space.job.Job;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import java.io.File;
import java.util.List;

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
	 * Reads the Missions.xml file and returns a list of Mission objects.
	 */
	public static List<Mission> readMissions() {
		try {
			if (fileManager == null)
				throw new Exception("Star file manager cannot be null in StarReader.");

			String path = fileManager.getBaseDirectory().toString() + "/missions.xml";
			File file = new File(path);

			JAXBContext jContext = JAXBContext.newInstance(MissionsModel.class);
			Unmarshaller unmarshallerObj = jContext.createUnmarshaller();

			MissionsModel mm = (MissionsModel) unmarshallerObj.unmarshal(file);
			
			return mm.getImmutableMissions();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return null;
	}

	/**
	 * Reads the Job.xml file for a specific job and return the job object.
	 */
	public static Job readJob(String jobId) { // this method needs to be worked on.
	    try {
            if (fileManager == null)
                throw new Exception("Star file manager cannot be null in StarReader.");

            String path = fileManager.getBaseDirectory().toString() + "/jobs/j_" + jobId + ".xml";
            File file = new File(path);

            JAXBContext jContext = JAXBContext.newInstance(MutableJob.class);
            Unmarshaller unmarshallerObj = jContext.createUnmarshaller();

            MutableJob mutableJob = (MutableJob) unmarshallerObj.unmarshal(file);
            mutableJob.upcastChoices();
            
            return mutableJob;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}
}
