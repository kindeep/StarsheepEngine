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
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		InputStream in;
		try {
			if (fileManager == null)
				throw new Exception("Star file manager cannot be null in StarReader.");

			in = fileManager.getJobStream(String.valueOf(jobId));
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			MutableJob jobBuilder = null;
			ChoiceBuilder choiceBuilder = null;
			ArrayList<Integer> childrenIds = null;

			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();

				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					String elementName = startElement.getName().getLocalPart();

					if (elementName.equals("Job")) { // start of new job element.
						jobBuilder = new MutableJob();
						// read job attributes.
						Iterator<Attribute> attributes = startElement.getAttributes();
						while (attributes.hasNext()) {
							Attribute attr = attributes.next();
							String attrName = attr.getName().toString();
							switch (attrName) {
							case "name":
								jobBuilder.setName(attr.getValue());
								break;
							case "id":
								jobBuilder.setId(attr.getValue());
								break;
							}
						}
					} else if (elementName.equals("Choices")) { // start of new choices element.

					} else if (elementName.equals("Choice")) { // start of choice element.
						choiceBuilder = new ChoiceBuilder();
						// read choice attributes.
						Attribute choiceId = startElement.getAttributeByName(new QName("id"));
						choiceBuilder.setChoiceId(Integer.valueOf(choiceId.getValue()));
					} else if (elementName.equals("Children")) {

					} else if (elementName.equals("Child")) {
						Attribute choiceId = startElement.getAttributeByName(new QName("id"));
						choiceBuilder.addChildChoiceID(Integer.valueOf(choiceId.getValue()));
					} else if (elementName.equals("Description")) {
						// choiceBuilder.setDescription(event.asCharacters().getData());
					} else if (elementName.equals("TraitDependencies")) {

					} else if (elementName.equals("Trait")) {
						Attribute name = startElement.getAttributeByName(new QName("name"));
						Attribute weight = startElement.getAttributeByName(new QName("weight"));
						TraitDependency td = new TraitDependency(name.getValue(), Integer.valueOf(weight.getValue()));
						choiceBuilder.addTraitDependency(td);
					}
				} else if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();
					String elementName = endElement.getName().getLocalPart();
					if (elementName.equals("Choice")) {
						Choice c = choiceBuilder.build();
						jobBuilder.addChoice(c);
					} else if (elementName.equals("Choices")) {

					} else if (elementName.equals("Job")) {
						return jobBuilder.build();
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
