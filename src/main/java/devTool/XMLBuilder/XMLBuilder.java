package devTool.XMLBuilder;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import devTool.models.EditableJob;
import devTool.models.GameModel;
import devTool.models.MissionsModel;
import devTool.models.TraitsModel;

public class XMLBuilder {
	private static XMLBuilder instance;
	private String baseDir;

	private XMLBuilder() {
	}

	public static XMLBuilder getInstance() {
		if (instance == null)
			instance = new XMLBuilder();
		return instance;
	}

	public void setBaseDir(File f) {
		this.baseDir = f.getAbsolutePath() + "/";
	}

	public boolean deleteJobFile(String id) {
		File f = new File(baseDir + "jobs/j_" + id + ".xml");
		return f.delete();
	}

	public void buildGameModelData(GameModel gm) throws JAXBException {
		JAXBContext jaxbContext;
		jaxbContext = JAXBContext.newInstance(GameModel.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(gm, System.out);
	}

	public void buildJobFile(EditableJob job) {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(EditableJob.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			String fileName = "j_" + job.id + ".xml";
			marshaller.marshal(job, new File(this.baseDir + "/jobs/" + fileName));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public void buildMissionsFile(MissionsModel mm) throws JAXBException {
		JAXBContext jaxbContext;
		jaxbContext = JAXBContext.newInstance(MissionsModel.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(mm, new File(this.baseDir + "missions.xml"));
	}
	
	public void buildTraitsFile(TraitsModel traitsModel) throws JAXBException {
		JAXBContext jaxbContext;
		jaxbContext = JAXBContext.newInstance(TraitsModel.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(traitsModel, new File(this.baseDir + "traits.xml"));
	}
}
