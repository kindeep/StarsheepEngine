package devTool.XMLBuilder;

import java.util.LinkedList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "job")
public class JobModel {
	private String title;
	private String id;
	private String description;
	private LinkedList<ChoiceModel> choices;

	public JobModel() {
		this.choices = new LinkedList<ChoiceModel>();
	}
	
	//setters and getters.
	@XmlElement(name = "title")
	public String getTitle() {
		return title;
	}

	@XmlElement(name = "id")
	public String getId() {
		return id;
	}
	
	@XmlElement(name = "description")
	public String getDescription() {
		return description;
	}
	
	@XmlElement(name = "choices")
	public LinkedList<ChoiceModel> getChoices() {
		return choices;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public void setChoices(LinkedList<ChoiceModel> choices) {
		this.choices = choices;
	}
}
