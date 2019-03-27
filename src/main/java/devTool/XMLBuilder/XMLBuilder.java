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
			marshaller.marshal(gm, new File("GameModel.xml"));
			marshaller.marshal(gm, System.out);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
