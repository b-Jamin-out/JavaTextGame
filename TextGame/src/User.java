public class User {
    //Variables

    private String name;
    private int strength;
    private int locationX;
    private int locationY;
    private int health;

    //Getters
    public String getName() {
        return name;
    }

    public int getStrength(){
        return strength;
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public int getHealth() {
        return health;
    }
    
    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setStrength(int strength){
        this.strength = strength;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    //Constructors
    public User(String name, int strength, int locationX, int locationY, int health) {
        this.name = name;
        this.strength = strength;
        this.locationX = locationX;
        this.locationY = locationY;
        this.health = health;
    }

    public User() {
    }

    //toString
    @Override
    public String toString() {
        return name + // + 
        "\n" + strength + "STR" + // +
        "\n" + health + "HP";
    }
    
}
