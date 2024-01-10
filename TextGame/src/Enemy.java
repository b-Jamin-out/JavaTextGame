public class Enemy {
    //Variables
    private int health;
    private int strength;
    private String name;

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

    public Enemy(int health, int strength, String name) {
        this.health = health;
        this.strength = strength;
        this.name = name;
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
