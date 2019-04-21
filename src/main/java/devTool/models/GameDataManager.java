package devTool.models;

import devTool.models.item.ItemsModel;

/**
 * 
 * @author peakyDicers
 *
 */
public class GameDataManager {
	private static GameDataManager instance;
	
	private GameDataManager() {}
	
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
		this.gameModel = gameModel;
	}

	public void setMissionsModel(MissionsModel missionsModel) {
		this.missionsModel = missionsModel;
	}

	public void setTraitsModel(TraitsModel traitsModel) {
		this.traitsModel = traitsModel;
	}
	
	public void setItemsModel(ItemsModel itemsModel) {
	    this.itemsModel = itemsModel;
	}
}
