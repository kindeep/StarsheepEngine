package engine.starsheep.space;

import engine.starsheep.space.Job.*;
import engine.starsheep.space.models.MissionsModel;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
