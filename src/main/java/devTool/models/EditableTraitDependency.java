package devTool.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "trait-dependency")
public class EditableTraitDependency {

	@XmlElement(name = "name")
	public String name;
	
	@XmlElement(name = "id")
	public String id;

	@XmlElement(name = "weight")
	public String weight;
	
	
	public EditableTraitDependency() {
		
	}

	@Override
	public String toString() {
		return this.name;
	}
}
