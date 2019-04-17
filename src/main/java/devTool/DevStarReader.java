package devTool;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.jgoodies.common.collect.ArrayListModel;

import devTool.models.MissionsModel;
import devTool.models.TraitsModel;
import devTool.models.EditableChoice;
import devTool.models.EditableJob;
import devTool.models.EditableJobFlyer;
import devTool.models.EditableMission;
import devTool.models.EditableTraitDependency;
import engine.starsheep.space.xml.MutableJobFlyer;
import engine.starsheep.space.xml.StarReader;

public class DevStarReader extends StarReader {

	/**
	 * Reads the traits.xml file and returns a Traitsmodel.
	 * 
	 * @return The unmarshalled traits model.
	 */
	public static TraitsModel readEditableTraits() {
		try {
			if (fileManager == null)
				throw new Exception("Star file manager cannot be null in StarReader.");

			String path = fileManager.getBaseDirectory().toString() + "/traits.xml";
			File file = new File(path);

			JAXBContext jContext = JAXBContext.newInstance(TraitsModel.class);
			Unmarshaller unmarshallerObj = jContext.createUnmarshaller();

			TraitsModel traitsModel = (TraitsModel) unmarshallerObj.unmarshal(file);

			return traitsModel;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Reads the missions.xml file and returns a MissionsModel.
	 * 
	 * @return The unmarshalled mission model.
	 */
	public static MissionsModel readEditableMissions() {
		try {
			if (fileManager == null)
				throw new Exception("Star file manager cannot be null in StarReader.");

			String path = fileManager.getBaseDirectory().toString() + "/missions.xml";
			File file = new File(path);

			JAXBContext jContext = JAXBContext.newInstance(MissionsModel.class);
			Unmarshaller unmarshallerObj = jContext.createUnmarshaller();

			MissionsModel mm = (MissionsModel) unmarshallerObj.unmarshal(file);
			
			return mm;

		} catch (Exception e) {

			e.printStackTrace();

		}
		return null;
	}

	/**
	 * Reads the job_<jobid>.xml file and returns an EditableJob.
	 * 
	 * @param jobId
	 * @return
	 */
	public static EditableJob readJob(String jobId) {
		try {
			if (fileManager == null)
				throw new Exception("Star file manager cannot be null in StarReader.");

			String path = fileManager.getBaseDirectory().toString() + "/jobs/j_" + jobId + ".xml";
			File file = new File(path);

			JAXBContext jContext = JAXBContext.newInstance(EditableJob.class);
			Unmarshaller unmarshallerObj = jContext.createUnmarshaller();

			EditableJob job = (EditableJob) unmarshallerObj.unmarshal(file);

			System.out.println(job.toString());
			return job;

		} catch (Exception e) {

			e.printStackTrace();

		}
		return null;
	}
}
