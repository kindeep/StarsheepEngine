package devTool.XMLBuilder;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "gameModel")
public class GameModel {
	
	@XmlElement(name = "title")
	private String title;
	
	@XmlElement(name = "description")
	private String description;
	
	@XmlElement(name = "creator")
	private String creator;
	
	@XmlElement(name = "currency")
	private String currency;
	
	public GameModel() {
		
	}
	
	public GameModel setTitle(String title) {
		this.title = title;
		return this;
	}
	
	public GameModel setDescription(String description) {
		this.description = description;
		return this;
	}
	
	public GameModel setCreator(String creator) {
		this.creator = creator;
		return this;
	}
	
	public GameModel setCurrency(String currency) {
		this.currency = currency;
		return this;
	}
}
