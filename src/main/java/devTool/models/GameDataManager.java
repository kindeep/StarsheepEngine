package devTool.models;

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

}
