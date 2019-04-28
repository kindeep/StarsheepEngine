package devTool.models;

public class GameModel {
	private String title;
	private String description;
	private String creator;
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
