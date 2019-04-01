package devTool.XMLBuilder;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "choice")
public class ChoiceModel {
	private String title;
	private String description;
	private String id;
	private String imageId;
	private ArrayList<Integer> children;
	
	@XmlElement(name = "traitDependency")
	private ArrayList<TraitDependencyModel> traitDependencies;
	
	public ChoiceModel() {
		children = new ArrayList<Integer>();
		traitDependencies = new ArrayList<TraitDependencyModel>();
	}
	
	//helpers
	public void addTraitDependency(TraitDependencyModel td) {
		this.traitDependencies.add(td);
	}
	
	public void removeTraitDependency(TraitDependencyModel td) {
		this.traitDependencies.remove(td); 
	}
	
	public void addChild(Integer id) {
		children.add(id);
	}
	
	public void removeChild(Integer id) {
		children.remove(id);
	}
	
	//setters and getters.
	@XmlElement(name = "title")
	public String getTitle() {
		return title;
	}

	@XmlElement(name = "description")
	public String getDescription() {
		return description;
	}

	@XmlAttribute(name = "id")
	public String getId() {
		return id;
	}

	@XmlElement(name = "imageId")
	public String getImageId() {
		return imageId;
	}

	@XmlElement(name = "children")
	public ArrayList<Integer> getChildren() {
		return children;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public void setChildren(ArrayList<Integer> children) {
		this.children = children;
	}
}
