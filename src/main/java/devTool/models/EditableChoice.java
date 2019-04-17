package devTool.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.jgoodies.common.collect.ArrayListModel;

@XmlRootElement(name = "choice")
public class EditableChoice {

	@XmlElement(name = "name")
	public String name;

	@XmlElement(name = "id")
	public String id;

	@XmlElement(name = "stamina-cost")
	public Integer staminaCost = 0;

	@XmlElement(name = "description")
	public String description = "choice description here.";

	@XmlElementWrapper(name = "trait-dependencies")
	@XmlElement(name = "trait")
	public ArrayListModel<EditableTraitDependency> traitDependencies = null;

	@XmlElementWrapper(name = "children")
	@XmlElement(name = "child")
	public ArrayListModel<String> children = null;

	public EditableChoice() {
		traitDependencies = new ArrayListModel<EditableTraitDependency>();
		children = new ArrayListModel<String>();
	}

	public void addChild(String child) {
		children.add(child);
	}

	public void addTraitDependency(EditableTraitDependency td) {
		this.traitDependencies.add(td);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
