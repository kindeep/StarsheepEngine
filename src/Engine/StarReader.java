package Engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;

import javax.xml.stream.events.XMLEvent;

import Engine.Job.Choice;
import Engine.Job.ChoiceBuilder;
import Engine.Job.Job;
import Engine.Job.JobBuilder;
import Engine.Job.JobFlyerBuilder;
import Engine.Job.TraitDependency;

import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;

/**
 * This class reads StarSheep XML files.
 */
public class StarReader {

	/**
	 * Reads the Missions.xml file and returns a list of Mission objects.
	 * 
	 * @return A list of all missions in the game. 
	 */
	public static List<Mission> readMissions() {
		
		/* todo: 
		 * 
		 * read id, name and imageID for every mission.
		 * 
		 */
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		InputStream in;
		File configFile = new File("game_files/Missions.xml");
		
		ArrayList<Mission> missions = new ArrayList<Mission>();
		MissionBuilder missionBuilder = null;
		JobFlyerBuilder jobFlyerBuilder = null;

		try {
			in = new FileInputStream(configFile);
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					event = eventReader.nextEvent();
					String elementName = startElement.getName().getLocalPart();
					if (elementName.equals("Mission")) { // create a new missionBuilder.
						missionBuilder = new MissionBuilder();

					} else if (elementName.equals("Job")) {
						jobFlyerBuilder = new JobFlyerBuilder(); //create a new jobBuilder.
						
					} else if (elementName.equals("id")) { //add job id to job flyer.
						jobFlyerBuilder.setJobId(Integer.valueOf(event.asCharacters().getData()));

					} else if (elementName.equals("name")) { //add job name to job flyer.
						jobFlyerBuilder.setName(event.asCharacters().getData());

					} else if (elementName.equals("description")) { // add description to job flyer.
						jobFlyerBuilder.setDescription(event.asCharacters().getData());

					}
				} else if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();
					String elementName = endElement.getName().getLocalPart();
					if (elementName.equals("Job")) {
						missionBuilder.addFlyer(jobFlyerBuilder.build()); // add flyer to mission.
						
					} else if (elementName.equals("Mission")) {
						missions.add(missionBuilder.build()); //add mission to list of missions.
						
					} else if (elementName.equals("Missions")) {
						return Collections.unmodifiableList(missions); //return missions
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Reads the Job.xml file for a specific job and return the job object.
	 * 
	 * @param jobId - The job id.
	 * @return job object.
	 */
	public static Job readJob(int jobId) { //this method needs to be worked on.
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		InputStream in;
		File configFile = new File("game_files/Job.xml");
		try {
			in = new FileInputStream(configFile);
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			JobBuilder jobBuilder = null;
			ChoiceBuilder choiceBuilder = null;
			ArrayList<Integer> childrenIds = null;

			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();

				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					String elementName = startElement.getName().getLocalPart();

					if (elementName.equals("Job")) { // start of new job element.
						jobBuilder = new JobBuilder();
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
								jobBuilder.setId(Integer.valueOf(attr.getValue()));
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

	public StarReader() {
	}
}
