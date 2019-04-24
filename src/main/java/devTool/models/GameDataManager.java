package devTool.models;

import devTool.models.item.ItemsModel;

/**
 * 
 * @author peakyDicers
 *
 */
public class GameDataManager {
	private static GameDataManager instance;
	
	private GameDataManager() {
	    this.gameModel = new GameModel();
	    this.missionsModel = new MissionsModel();
	    this.traitsModel = new TraitsModel();
	    this.itemsModel = new ItemsModel();
	}
	
	public static GameDataManager getInstance() {
		if (instance == null)
			instance = new GameDataManager();
		return instance;
	}

	private GameModel gameModel;
	private MissionsModel missionsModel;
	private TraitsModel traitsModel;
	private ItemsModel itemsModel;

	// getters
	public GameModel getGameModel() {
		return gameModel;
	}

	public MissionsModel getMissionsModel() {
		return missionsModel;
	}

	public TraitsModel getTraitsModel() {
		return traitsModel;
	}
	
	public ItemsModel getItemsModel() {
	    return itemsModel;
	}

	// setters
	public void setGameModel(GameModel gameModel) {
	    if (gameModel != null)
	        this.gameModel = gameModel;
	}

	public void setMissionsModel(MissionsModel missionsModel) {
	    if (missionsModel != null)
	        this.missionsModel = missionsModel;
	}

	public void setTraitsModel(TraitsModel traitsModel) {
	    if (traitsModel != null)
	        this.traitsModel = traitsModel;
	}
	
	public void setItemsModel(ItemsModel itemsModel) {
	    if (itemsModel != null)
	        this.itemsModel = itemsModel;
	}
}
