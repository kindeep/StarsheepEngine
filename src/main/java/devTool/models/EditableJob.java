package devTool.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.jgoodies.common.collect.ArrayListModel;

@XmlRootElement(name = "job")
public class EditableJob {
	
	@XmlElement(name = "title")
	public String name;
	
	@XmlElement(name = "description")
	public String description;
	
	@XmlElement(name = "id")
	public String id;
	
	@XmlElement(name = "image-id")
	public String imageID;
	
	@XmlElement(name = "head-choice")
	public EditableChoice head;
	
	@XmlElementWrapper(name = "choices")
	@XmlElement(name = "choice")
	public ArrayListModel<EditableChoice> choices;
	
	public EditableJob() {
		choices = new ArrayListModel<EditableChoice>();
	}
	
	public void addChoice(EditableChoice choice) {
		this.choices.add(choice);
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
