package devTool.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "job")
public class EditableJobFlyer {

	@XmlElement(name = "id")
	public String id;

	@XmlElement(name = "name")
	public String name;

	@XmlElement(name = "description")
	public String description;

	@XmlElement(name = "stamina-cost")
	public Integer staminaCost;

	public EditableJobFlyer() {
	}

	@Override
	public String toString() {
		return this.name;
	}
}
