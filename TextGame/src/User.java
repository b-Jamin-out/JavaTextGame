public class User {
    //Variables

    //Name
    private String name;

    //Stats
    private int strength;
    private int health;
    private double xp;
    private int level;
    private int agility;
    private int gold;

    

    

    //Dev stats
    private int locationX;
    private int locationY;
    private int totHealth;
    private double xpGoal;
    
    //Getters

    //Name getter
    public String getName() {
        return name;
    }

    //Stats getters
    public int getHealth() {
        return health;
    }

    public int getStrength(){
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public double getXp() {
        return xp;
    }

    public int getLevel() {
        return level;
    }

    public int getGold() {
        return gold;
    }

    //Dev stats getters
    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public int getTotHealth() {
        return totHealth;
    }

    public double getXpGoal() {
        return xpGoal;
    }

    //Setters

    //Name setter
    public void setName(String name) {
        this.name = name;
    }

    //Stats setters
    public void setStrength(int strength){
        this.strength = strength;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setXp(double xp) {
        this.xp = xp;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    //Dev stats getters
    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public void setTotHealth(int totHealth) {
        this.totHealth = totHealth;
    }

    public void setXpGoal(double xpGoal) {
        this.xpGoal = xpGoal;
    }

    //Constructors
    public User(String name, int strength, int locationX, int locationY, int health, double xp, double xpGoal, int totHealth, int level, int agility, int gold) {
        this.name = name;
        this.strength = strength;
        this.locationX = locationX;
        this.locationY = locationY;
        this.health = health;
        this.xp = xp;
        this.xpGoal = xpGoal;
        this.totHealth = totHealth;
        this.level = level;
        this.agility = agility;
        this.gold = gold;
    }

    public User() {
    }

    //toString
    @Override
    public String toString() {
        return name + // + 
        "\n" + level + "LVL" + // +
        "\n" + xp + "XP" + // +
        "\n" + health + "HP" + // +
        "\n" + strength + "STR" + // +
        "\n" + agility + "AGI" + // +
        "\n" + gold + "Gold";
    }
    
}
