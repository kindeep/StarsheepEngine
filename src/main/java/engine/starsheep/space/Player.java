package engine.starsheep.space;

public class Player {
    private static Player instance;
    private int cash;
    private int stamina;
    
    private Player() {
        cash = 100;
        stamina = 100;
    }

    public static Player getInstance() {
        if (instance == null)
            instance = new Player();
        return instance;
    }
    
    public int getBalance() {
        return cash;
    }
    
    public void addCash(int amount) {
        if (amount < 0)
            return;
        this.cash += amount;
    }
    
    public boolean removeCash(int amount) {
        if (this.cash - amount < 0 || amount < 0)
            return false;
        
        this.cash -= amount;
        return true;
    }
    
    public int getStamina() {
    	return this.stamina;
    }
    
    public void reduceStamina(int change) {
    	stamina -= change;
    	if (stamina < 0) stamina = 0;
    }
}
