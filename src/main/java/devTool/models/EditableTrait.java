package devTool.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "trait")
public class EditableTrait {
	
	@XmlElement(name = "name")
	public String name;
	
	@XmlElement(name = "id")
	public String id;
	
	
	@Override
	public String toString() {
		return this.name;
	}
}
