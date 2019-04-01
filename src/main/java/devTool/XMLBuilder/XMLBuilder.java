package devTool.XMLBuilder;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class XMLBuilder {

	public static void buildGameModelData(GameModel gm) {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(GameModel.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(gm, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public static void buildJobFile(JobModel jm) {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(JobModel.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			String fileName = "j_" + jm.getId() + ".xml";
			marshaller.marshal(jm, new File(fileName));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public static void buildMissionsFile(MissionsModel mm) {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(MissionsModel.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(mm, new File("Missions"));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
