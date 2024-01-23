public class Enemy {
    //Variables
    private int health;
    private int strength;
    private String name;
    private double xpValue;
    private int agi;
    private int gold;

    //Getters
    public int getHealth() {
        return health;
    }
    
    public int getStrength() {
        return strength;
    }

    public int getAgi() {
        return agi;
    }

    public String getName() {
        return name;
    }

    public double getXpValue() {
        return xpValue;
    }

    public int getGold() {
        return gold;
    }

    //Setters
    public void setHealth(int health) {
        this.health = health;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setAgi(int agi) {
        this.agi = agi;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setXpValue(int xpValue) {
        this.xpValue = xpValue;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
    
    //Constructors
    public Enemy(int health, int strength, String name, double xpValue, int agi, int gold) {
        this.health = health;
        this.strength = strength;
        this.name = name;
        this.xpValue = xpValue;
        this.agi = agi;
        this.gold = gold;
    }
    
    public Enemy() {
    }

    @Override
    public String toString() {
        return name + // + 
        "\n" + strength + "STR" + // +
        "\n" + agi + "AGI" + // +
        "\n" + health + "HP";
    }
    
}
