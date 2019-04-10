package devTool;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import devTool.models.EditableChoice;
import devTool.models.EditableJob;
import devTool.models.EditableJobFlyer;
import devTool.models.EditableMission;
import devTool.models.EditableTraitDependency;
import engine.starsheep.space.StarReader;
import engine.starsheep.space.Job.JobFlyerBuilder;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.jgoodies.common.collect.LinkedListModel;

public class DevStarReader extends StarReader {
	/**
	 * Reads the Missions.xml file and returns a List of EditableMissions.
	 * 
	 * @see EditableMission
	 * @return A List of editable missions.
	 */
	public static LinkedListModel<EditableMission> readEditableMissions() {

		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		InputStream in;

		LinkedListModel<EditableMission> editableMissions = new LinkedListModel<EditableMission>();
		EditableMission mission = null;
		JobFlyerBuilder jobFlyerBuilder = null;

		try {
			if (fileManager == null)
				throw new Exception("Star file manager cannot be null in StarReader.");

			in = fileManager.getDefaultMissionsStream();
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					event = eventReader.nextEvent();
					String elementName = startElement.getName().getLocalPart();
					if (elementName.equals("mission")) { // create a new missionBuilder.
						mission = new EditableMission();

					} else if (elementName.equals("id")) {
						mission.setId(event.asCharacters().getData());

					} else if (elementName.equals("title")) {
						mission.setTitle(event.asCharacters().getData());

					} else if (elementName.equals("job")) {
						EditableJobFlyer flyer = new EditableJobFlyer();
						while (eventReader.hasNext()) { // INSIDE A JOB ELEMENT.
							event = eventReader.nextEvent();
							if (event.isStartElement()) {
								startElement = event.asStartElement();
								event = eventReader.nextEvent();
								elementName = startElement.getName().getLocalPart();
								if (elementName.equals("id")) { // add job id to job flyer.
									flyer.setJobId(event.asCharacters().getData());
								} else if (elementName.equals("name")) { // add job name to job flyer.
									flyer.setName(event.asCharacters().getData());
								} else if (elementName.equals("description")) { // add description to job flyer.
									flyer.setDescription(event.asCharacters().getData());
								}
							} else if (event.isEndElement()) {
								EndElement endElement = event.asEndElement();
								elementName = endElement.getName().getLocalPart();
								if (elementName.equals("job")) {
									mission.addJobFlyer(flyer); // add flyer to mission.
									break;
								}
							}
						}
					}
				} else if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();
					String elementName = endElement.getName().getLocalPart();
					if (elementName.equals("mission")) {
						editableMissions.add(mission); // add mission to list of missions.

					} else if (elementName.equals("missions")) {
						return editableMissions; // return missions
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Reads the job_<jobid>.xml file and returns an EditableJob
	 * 
	 * @param jobId
	 * @return
	 */
	public static EditableJob readJob(String jobId) {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		InputStream in = null;
		try {
			if (fileManager == null)
				throw new Exception("Star file manager cannot be null in StarReader.");

			in = fileManager.getJobStream(jobId);
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			EditableJob job = null;
			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					String elementName = startElement.getName().getLocalPart();
					if (elementName.equals("job")) { // start of new job element.
						job = new EditableJob();
					} else if (elementName.equals("id")) {
						event = eventReader.nextEvent();
						job.setId(event.asCharacters().getData());
					} else if (elementName.equals("title")) {
						event = eventReader.nextEvent();
						job.setName(event.asCharacters().getData());
					} else if (elementName.equals("description")) {
						event = eventReader.nextEvent();
						job.setDescription(event.asCharacters().getData());
					} else if (elementName.equals("choice")) {
						EditableChoice choice = parseChoice(eventReader, event);
						job.setChoice(choice.getID(), choice);
					}
				} else if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();
					String elementName = endElement.getName().getLocalPart();

					if (elementName.equals("job")) {
						return job;
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static EditableChoice parseChoice(XMLEventReader eventReader, XMLEvent event) throws XMLStreamException {
		EditableChoice choice = new EditableChoice();
		List<String> children = null;

		StartElement startElement = event.asStartElement();

		// get choice attributes.
		Iterator<Attribute> attributes = startElement.getAttributes();
		while (attributes.hasNext()) {
			Attribute attr = attributes.next();
			String attrName = attr.getName().toString();
			if (attrName.compareTo("id") == 0) {
				choice.setChoiceId(Integer.valueOf(attr.getValue()));
			}
		}

		while (eventReader.hasNext()) {
			event = eventReader.nextEvent();
			if (event.isStartElement()) {
				startElement = event.asStartElement();
				String elementName = startElement.getName().getLocalPart();
				event = eventReader.nextEvent();

				if (elementName.compareTo("children") == 0) {
					children = new ArrayList<>();
				} else if (elementName.compareTo("child") == 0) {
					String id = startElement.getAttributeByName(new QName("id")).getValue();
					children.add(id);
				} else if (elementName.compareTo("description") == 0) {
					String data = event.asCharacters().getData();
					choice.setDescription(data);
				} else if (elementName.compareTo("trait-dependencies") == 0) {

				} else if (elementName.compareTo("trait") == 0) {
					EditableTraitDependency td = new EditableTraitDependency();
					String name = startElement.getAttributeByName(new QName("name")).getValue();
					String weight = startElement.getAttributeByName(new QName("weight")).getValue();
					td.setName(name);
					td.setWeight(Integer.parseInt(weight));
					choice.addTraitDependency(td);
				}
			} else if (event.isEndElement()) {
				EndElement endElement = event.asEndElement();
				String elementName = endElement.getName().getLocalPart();

				if (elementName.equals("choice")) {
					return choice;
				}
			}
		}
		return null;
	}
}
