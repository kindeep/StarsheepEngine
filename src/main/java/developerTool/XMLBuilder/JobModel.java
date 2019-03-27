package developerTool.XMLBuilder;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "job")
public class JobModel {
	
	@XmlElement(name = "title")
	private String title;
	
	@XmlElement(name = "id")
	private String id;
	
	@XmlElement(name = "choices")
	private ArrayList<ChoiceModel> choices;

	public JobModel() {
		this.choices = new ArrayList<ChoiceModel>();
	}
	
	//setters and getters.
	public String getTitle() {
		return title;
	}

	public String getId() {
		return id;
	}

	public ArrayList<ChoiceModel> getChoices() {
		return choices;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setChoices(ArrayList<ChoiceModel> choices) {
		this.choices = choices;
	}

}
