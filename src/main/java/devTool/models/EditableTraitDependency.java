package devTool.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "trait-dependency")
public class EditableTraitDependency {
	
	@XmlAttribute(name = "name")
	public String name;
	
	@XmlAttribute(name = "weight")
	public int weight;

	public EditableTraitDependency() {}
	
	@Override
	public String toString() {
		return this.name;
	}
}
