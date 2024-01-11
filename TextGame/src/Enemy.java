public class Enemy {
    //Variables
    private int health;
    private int strength;
    private String name;
    private double xpValue;

    //Getters
    public int getHealth() {
        return health;
    }
    
    public int getStrength() {
        return strength;
    }

    public String getName() {
        return name;
    }

    public double getXpValue() {
        return xpValue;
    }

    //Setters
    public void setHealth(int health) {
        this.health = health;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setXpValue(int xpValue) {
        this.xpValue = xpValue;
    }
    
    //Constructors
    public Enemy(int health, int strength, String name, double xpValue) {
        this.health = health;
        this.strength = strength;
        this.name = name;
        this.xpValue = xpValue;
    }
    
    public Enemy() {
    }

    @Override
    public String toString() {
        return name + // + 
        "\n" + strength + "STR" + // +
        "\n" + health + "HP";
    }
    
}
