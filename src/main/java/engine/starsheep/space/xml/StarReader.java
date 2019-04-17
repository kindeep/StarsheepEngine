package engine.starsheep.space.xml;

import engine.starsheep.space.Mission;
import engine.starsheep.space.StarFileManager;
import engine.starsheep.space.job.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import java.io.File;
import java.util.List;

/**
 * This class reads StarSheep XML files.
 * <p>
 * possibly pass in File instead. We can't assume where the files are located.
 */

// TODO: StarReader should probably be a singlton, and thus so should
// DevStarReader.
public class StarReader {
	protected static StarFileManager fileManager;

	public static void setFileManager(StarFileManager manager) {
		StarReader.fileManager = manager;
	}

	/**
	 * Reads the Missions.xml file and returns a list of Mission objects.
	 *
	 * @return A list of all missions in the game.
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
	 *
	 * @param jobId
	 *            - The job id.
	 * @return job object.
	 */
	//TODO: this jobid parameter should be a String.
	public static Job readJob(int jobId) { // this method needs to be worked on.
		return null;
	}
}
