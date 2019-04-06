package devTool;

import java.io.InputStream;
import java.util.LinkedList;

import devTool.models.EditableMission;
import devTool.models.EditableMissionBuilder;

import engine.starsheep.space.StarReader;
import engine.starsheep.space.Job.JobFlyerBuilder;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class DevStarReader extends StarReader {
	/**
	 * Reads the Missions.xml file and returns a List of EditableMissions.
	 * 
	 * @see EditableMission
	 * @return A List of editable missions.
	 */
	public static LinkedList<EditableMission> readEditableMissions() {

		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		InputStream in;

		LinkedList<EditableMission> editableMissions = new LinkedList<EditableMission>();
		EditableMissionBuilder missionBuilder = null;
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
					if (elementName.equals("Mission")) { // create a new missionBuilder.
						missionBuilder = new EditableMissionBuilder();

					} else if (elementName.equals("id")) {
						missionBuilder.setId(event.asCharacters().getData());

					} else if (elementName.equals("name")) {
						missionBuilder.setName(event.asCharacters().getData());

					} else if (elementName.equals("Job")) {
						jobFlyerBuilder = new JobFlyerBuilder();
						while (eventReader.hasNext()) { // INSIDE A JOB ELEMENT.
							event = eventReader.nextEvent();
							if (event.isStartElement()) {
								startElement = event.asStartElement();
								event = eventReader.nextEvent();
								elementName = startElement.getName().getLocalPart();
								if (elementName.equals("id")) { // add job id to job flyer.
									jobFlyerBuilder.setJobId(event.asCharacters().getData());
								} else if (elementName.equals("name")) { // add job name to job flyer.
									jobFlyerBuilder.setName(event.asCharacters().getData());
								} else if (elementName.equals("description")) { // add description to job flyer.
									jobFlyerBuilder.setDescription(event.asCharacters().getData());
								}
							} else if (event.isEndElement()) {
								EndElement endElement = event.asEndElement();
								elementName = endElement.getName().getLocalPart();
								if (elementName.equals("Job")) {
									missionBuilder.addFlyer(jobFlyerBuilder.build()); // add flyer to mission.
									break;
								}
							}
						}
					}
				} else if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();
					String elementName = endElement.getName().getLocalPart();
					if (elementName.equals("Mission")) {
						editableMissions.add(missionBuilder.build()); // add mission to list of missions.

					} else if (elementName.equals("Missions")) {
						return editableMissions; // return missions
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
