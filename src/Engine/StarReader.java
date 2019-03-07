package Engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;

import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;

public class StarReader {
	final static File configFile = new File("game_files/Job.xml");
	
	//read an entire job listing given a missionId.
	public static ArrayList<JobListing> readJobListing(int missionId) {
		return null;
	}

	//reads a single job xml file.
	public static Job readJob(int jobId) {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		InputStream in;
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
					
					if (elementName.equals("Job")) { //start of new job element.
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
					} else if (elementName.equals("Choices")) { //start of new choices element.
						
					} else if (elementName.equals("Choice")) { //start of choice element.
						choiceBuilder = new ChoiceBuilder();
						//read choice attributes.
						Attribute choiceId = startElement.getAttributeByName(new QName("id"));
						choiceBuilder.setChoiceId(Integer.valueOf(choiceId.getValue()));
					} else if (elementName.equals("Children")){
						
					} else if (elementName.equals("Child")){
						Attribute choiceId = startElement.getAttributeByName(new QName("id"));
						choiceBuilder.addChildChoiceID(Integer.valueOf(choiceId.getValue()));
					} else if (elementName.equals("Description")){
						//choiceBuilder.setDescription(event.asCharacters().getData());
					} else if (elementName.equals("TraitDependencies")){
						
					} else if (elementName.equals("Trait")) {
						Attribute name = startElement.getAttributeByName(new QName("name"));
						Attribute weight = startElement.getAttributeByName(new QName("weight"));
						TraitDependency td = new TraitDependency(name.getValue(), Integer.valueOf(weight.getValue()));
						choiceBuilder.addTraitDependency(td);
					}
				} else if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();
					String elementName = endElement.getName().getLocalPart();
					if (elementName.equals("Choice")){
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
