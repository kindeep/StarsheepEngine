package devTool.XMLBuilder;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "jobs")
public class JobFlyerModel {
	private String id;
	private String name;
	private String description;
	private String imageId;

	
	//setters and getters.
	@XmlElement(name = "id")
	public String getId() {
		return id;
	}

	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	@XmlElement(name = "description")
	public String getDescription() {
		return description;
	}

	@XmlElement(name = "imageId")
	public String getImageId() {
		return imageId;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
}
