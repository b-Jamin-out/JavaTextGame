public class User {
    //Variables

    private String name;
    private int strength;
    private int locationX;
    private int locationY;
    private int health;
    private int totHealth;
    private double xp;
    private double xpGoal;
    

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

    public int getTotHealth() {
        return totHealth;
    }

    public double getXp() {
        return xp;
    }

    public double getXpGoal() {
        return xpGoal;
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

    public void setTotHealth(int totHealth) {
        this.totHealth = totHealth;
    }

    public void setXp(double xp) {
        this.xp = xp;
    }

    public void setXpGoal(double xpGoal) {
        this.xpGoal = xpGoal;
    }

    //Constructors
    public User(String name, int strength, int locationX, int locationY, int health, double xp, double xpGoal, int totHealth) {
        this.name = name;
        this.strength = strength;
        this.locationX = locationX;
        this.locationY = locationY;
        this.health = health;
        this.xp = xp;
        this.xpGoal = xpGoal;
        this.totHealth = totHealth;
    }

    public User() {
    }

    //toString
    @Override
    public String toString() {
        return name + // + 
        "\n" + strength + "STR" + // +
        "\n" + health + "HP" + // +
        "\n" + xp + "XP";
    }
    
}
