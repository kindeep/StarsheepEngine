package developerTool.XMLBuilder;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "choice")
public class ChoiceModel {

	@XmlElement(name = "title")
	private String title;
	
	@XmlElement(name = "description")
	private String description;
	
	@XmlAttribute(name = "id")
	private String id;
	
	@XmlElement(name = "imageId")
	private String imageId;
	
	@XmlElement(name = "children")
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
	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getId() {
		return id;
	}

	public String getImageId() {
		return imageId;
	}

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
