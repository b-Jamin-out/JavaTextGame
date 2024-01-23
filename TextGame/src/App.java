import java.util.*;

public class App {
    // Funcs and Methods
    public static Scanner keys = new Scanner(System.in);

    public static Random rnd = new Random();
    public static int x;

    // Krymn message
    public static void krymnLocationMessage() {
        System.out.println("You find yourself in Krymn. " + // +
                "\n To the North is the town of Novender, where you can find a bustling economy with merchants all through the \n streets."
                + //
                "\n In the East is the forest, where goblins and wolves lurk. Who knows what could happen there." + //
                "\n Down South is the Drylands, with high heat and not much food or animals, survival there is tough." + //
                "\n And finally to the West are the Heralds Hills, A place where many priests of this world undergo a testament of strength and \nwillpower. Only those who are qualified and strong enough are able to adventure there.\n"
                + // +
                "Where will you travel to?\n");
    }// End of krymnLocationMessage

    // places to travel to from Krymn
    public static void travelFromKrymn(String input, User user1, boolean hasMetGuards) {

        if (input.toLowerCase().contains("north")) {
            user1.setLocationY(user1.getLocationY() + 1);
            if (hasMetGuards == false) {
                System.out.println(
                        "\nYou travel up North towards Novender. After about two hours you arrive at the city gates. The guards stop you \non your way in.");
            } else {
                System.out.println(
                        "\nYou travel to Novender, the path now familiar to you. As you come to the \ntown gates, you greet the guards and they welcome you in without conversation.");
            }
        } else if (input.toLowerCase().contains("east")) {
            user1.setLocationX(user1.getLocationX() + 1);
            System.out.println(
                    "\nYou head into the forest, weary of the dangers. Armed with a small wooden sword, you go into the forest.");
        } else if (input.toLowerCase().contains("south")) {
            user1.setLocationY(user1.getLocationY() - 1);
            System.out.println("\nFinding the heat of the Drylands unbearable, you cannot travel through there now.\n");
            user1.setLocationY(user1.getLocationY() + 1);
        } else if (input.toLowerCase().contains("west")) {
            user1.setLocationX(user1.getLocationX() - 1);
            System.out.println(
                    "\nYou travel West, towrads the prooving grounds for priests-to-be. Upon your arrival to the top of the hill a \nguard stops you.");
            if (user1.getStrength() < 20) {
                System.out.println(
                        "\nGuard: Halt! You are not ready yet to try the Testament of Strength. Come back later, once you're stronger."
                                + // +
                                "\n\n You are forced to go back to Krymn.\n");
                user1.setLocationX(user1.getLocationX() + 1);
            }
        } else {
            System.out.println("\nPlease input a proper direction(North, South, East, West)\n");
        }
    }// End of travelFromKrymn

    // Battle func
    public static void battleEnemy(String input, User user1, Enemy enemy1) {

        while (user1.getHealth() >= 0 || enemy1.getHealth() >= 0) {
            System.out.println("You are fighting a \n" + enemy1.toString() + "\n\n" + user1.toString()
                    + "\n Your options are: Attack or Flee\n");
            input = keys.nextLine();
            // Determines what user's action
            // Attack
            if (input.toLowerCase().contains("attack")) {
                System.out.println("\nYou attack the " + enemy1.getName() + "!");
                enemy1.setHealth(enemy1.getHealth() - user1.getStrength());
            }
            // Flee
            else {
                boolean escape = canUserEscape(user1, enemy1, input);
                if (escape = true) {
                    System.out.println("\nYou escaped from the " + enemy1.getName()
                            + "! You find yourself running back to where you came from.");
                    user1.setLocationX(user1.getLocationX() - 1);
                    enemy1.setHealth(-500);
                } else {
                    System.out.println("The " + enemy1.getName() + " won't let you escape!");
                }

            }
            // Determines what enemy will do
            x = rnd.nextInt(2) + 1;
            // Attacks
            if (x == 1) {
                System.out.println("\nThe " + enemy1.getName() + " swipes at you with it's claws\n");
                user1.setHealth(user1.getHealth() - enemy1.getStrength());
            }
            // Nothing
            else if (x == 2) {
                System.out.println("\nThe " + enemy1.getName() + " does nothing\n");
            }

            // deafeated enemy
            if (enemy1.getHealth() <= 0 && enemy1.getHealth() > -499) {
                System.out
                        .println("You defeated the " + enemy1.getName() + " and got " + enemy1.getXpValue() + "XP!\n");
                user1.setXp(user1.getXp() + enemy1.getXpValue());
                break;
            }
            // Got defeated
            else if (user1.getHealth() <= 0) {
                System.out.println("The " + enemy1.getName() + " killed you! Your adventure ends here.");
                break;
            }
            //Fled
            else if (enemy1.getHealth() < -499){
                
                System.out.println(user1.getLocationX());
                break;
            }
        } // End of while
    }// End of battleEnemy

    // Detects for cardinal direction
    public static void detectCardinalDirection(String input) {
        if (input.toLowerCase().contains("north") != true || input.toLowerCase().contains("east") != true
                || input.toLowerCase().contains("south") != true || input.toLowerCase().contains("west") != true) {
            System.out.println("\nPlease input a cardinal direction(North, South, East, West): \n");
            input = keys.nextLine();
        } else {

        }
    }// End of detectCardinalDirection

    // Novender Town Message
    public static void novenderTownMessage(String input, User user1, boolean hasMetGuards) {
        while (hasMetGuards == false) {
            System.out.println(
                    "\nGuard: Halt! What is your reason for entering Novender? Are you an adventurer, merchant, or scholar?\n");

            input = keys.nextLine();
            // Detects user input
            // Adventurer
            if (input.toLowerCase().contains("adventurer")) {
                user1.setLocationY(user1.getLocationY() + 1);
                System.out.println(
                        "\nGuard: Ah an adventurer. I used to do that, then I took an arrow to the knee. Well, seeing as you have no \nillegal items, you may enter.");
            }
            // Merchant
            else if (input.toLowerCase().contains("merchant")) {
                user1.setLocationY(user1.getLocationY() + 1);
                System.out.println(
                        "\nGuard: Oh another merchant. Just what we need. Do you have any illegal items? Are you selling or buying in \ntown? You know what, whatever. The town's riddled with crime anyway. Go in.");
            }
            // Scholar
            else if (input.toLowerCase().contains("scholar")) {
                user1.setLocationY(user1.getLocationY() + 1);
                System.out.println(
                        "\nGuard: Ah a scholar. Well, we don't have many libraries, but feel free to study what you can.");
            }
            // Random nonsense
            else {
                System.out.println(
                        "\nGuard: What? Are you speaking some ancient language or something? Say something normal.");
            }
            hasMetGuards = true;
        }

        while (user1.getLocationY() == 2) {

            // Novender navigation
            System.out.println(
                    "\nYou walk through the gates and start walking the streets. You notice an abundance of shops and restaurants \nthroughout the streets and you think you must be in the market distrct. Look closer at a shop, continue \nonward or leave Novender and return to Krymn?\n");
            input = keys.nextLine();

            // Shop
            if (input.toLowerCase().contains("shop")) {
                user1.setLocationY(user1.getLocationY() + 1);
                System.out.println("You look closer at a shop and begin talking with the merchant\n");
                System.out.println("\nMerchant: AHH! Interested in my wares are you?! Well, I'll tell you what I got and I'll tell it to ya straight. I got a healing potion. 5 points of health. What does that mean? I don't know, you look like you know though. \n3 gold! What else do I have, let's see here, I got this nifty glowstick. It's like a torch but better! It never burns out! Uhh 10 gold for that. I have a sack of 10 apples picked just this morning from the local orchird. 2 gold for each apple.\n\nYou hear the merchant ramble off a few more items but none of them seem of real importance.\n\nMerchant: So, what are ya buying? Or are you buying everything?! Oh that'd be great! Please buy everything. I want it all gone!\n");
                input = keys.nextLine();

                //Nothing
                if (input.toLowerCase().contains("nothing")){
                    System.out.println("\nMerchant: Aww. I just want to sell my junk...\n\nYou continue onward through the streets of Novender ane make your way to the town square. Here you see a large \nchurch which seems to be a main stopping point for most people. You also see several roads continuing the path \nthrough the town");
                }
                else if (input.toLowerCase().contains("health potion")){
                    System.out.println("\nMerchant: OOH! A good choice my fine sir. Here you go!");
                }
            }
            // Continue
            else if (input.toLowerCase().contains("continue")) {
                user1.setLocationY(user1.getLocationY() + 1);
                System.out.println(
                        "You continue onward through the town, making your way through the Market District. After some time of shoving \nyour way through the crowded streets, you find yourself in the town square. You see a large church that many \npeople are stopping at even for a spare moment, and several different roads jutting outward through the town.");
            }
            // Leave
            else if (input.toLowerCase().contains("leave")) {
                user1.setLocationY(user1.getLocationY() - 2);
                System.out.println("You leave the town and return to Krymn");
            }

        } // End of switch (input) for Novender
    }// End of novenderTownsMessage

    // Sets parameters of enemy1
    public static void setEnemyDeets(Enemy enemy1, String name, int health, int strength, int xpValue, int agi, int gold) {
        enemy1.setName(name);
        enemy1.setHealth(health);
        enemy1.setStrength(strength);
        enemy1.setXpValue(xpValue);
        enemy1.setAgi(agi);
        enemy1.setGold(gold);
    }// End of setEnemyDeets

    // Level up func
    public static void levelUp(User user1, String input) {
        while (user1.getXp() >= user1.getXpGoal()) {
            System.out.println("\nYou leveled up! Would you like to increase strength, agility or health?\n");
            input = keys.nextLine();

            // Upgrades strength
            if (input.toLowerCase().contains("strength")) {
                user1.setStrength(user1.getStrength() + 1);
            }
            // Upgrades health
            else if (input.toLowerCase().contains("health")) {
                user1.setTotHealth(user1.getTotHealth() + 2);
            }
            // Upgrades agility
            else if (input.toLowerCase().contains("agility")) {
                user1.setAgility(user1.getAgility() + 2);
            } else {
                System.out.println("\nPlease enter a valid response: strength or health\n");
                input = keys.nextLine();
            }
            user1.setXp(user1.getXp() - user1.getXpGoal());
            ;
            user1.setXpGoal(user1.getXpGoal() * 1.5);
            user1.setHealth(user1.getTotHealth());
            user1.setLevel(user1.getLevel() + 1);
        }
    }// End of levelUp

    // Writes if statement for travel
    public static void travelFunc(User user1, String input, String x, String y) {
        if (input.toLowerCase().contains(x)) {
            System.out.println(y);
        }
    }// End of travelFunc

    // Determines if user can escape a battle
    public static boolean canUserEscape(User user1, Enemy enemy1, String input) {
        int x;
        x = rnd.nextInt(1, enemy1.getAgi());
        if (user1.getAgility() > x) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        // Variables

        String input = "";
        boolean hasMetGuards = false;

        // Class variables

        Scanner keyboard = new Scanner(System.in);

        // User
        User user1 = new User();
        user1.setStrength(1);
        user1.setHealth(10);
        user1.setXp(0.0);
        user1.setXpGoal(10.0);
        user1.setTotHealth(10);
        user1.setLevel(1);
        user1.setAgility(2);

        // Enemy
        Enemy enemy1 = new Enemy();

        // Inputs

        // Welcome Message // setting name
        System.out.println(
                "Welcome! This is a text based adventure game that will take place in a medival fantasy world of duels and \nswords! Enter a name for your character and we will start on your journey!\n");
        input = keyboard.nextLine();
        user1.setName(input);

        // Writes out locations from Krymn
        System.out.println(
                "\nYour character " + user1.getName() + ", and your story, starts in a small village called Krymn.");
        krymnLocationMessage();
        input = keyboard.nextLine();

        // Takes player from Krymn
        travelFromKrymn(input, user1, hasMetGuards);
        while (user1.getLocationX() == 0 && user1.getLocationY() == 0) {
            krymnLocationMessage();
            input = keyboard.nextLine();
            travelFromKrymn(input, user1, hasMetGuards);
        }
        if (user1.getName().toLowerCase().contains("xoc")) {
            user1.setXp(76.25);
        }

        // Forest Exploration
        while (user1.getLocationX() == 1 && user1.getLocationY() == 0) {

            // First forest location
            System.out.println(
                    "\nAfter about 20 minutes of walking through the forest you encounter a goblin. He looks vicious and hungry. You \nmust fight him to escape!");
            setEnemyDeets(enemy1, "Hungry Goblin", 5, 1, 5, 3, 2);
            battleEnemy(input, user1, enemy1);
            levelUp(user1, input);
            System.out.println(
                    "\nYou can return to Krymn and rest up, but you might allow new enemies to come back to the trails. Do you want to continue through the forest or leave?\n");
            input = keyboard.nextLine();

            // Second forest location
            if (input.toLowerCase().contains("continue")) {
                user1.setLocationX(user1.getLocationX() + 1);
                System.out.println(
                        "\nYou continue to walk throught the rough trails of the forest, looking for anything that seems interesting or \nout of place. after nearly an hour of walking the trails of the forest you come upon a little cottage. Will you knock on the door, snoop around, ignore it and continue walking the trails or walk back?\n");
                input = keyboard.nextLine();

                while (user1.getLocationX() == 2) {
                    // Knock
                    if (input.toLowerCase().contains("knock")) {
                        System.out.println(
                                "\nYou knock on the door and hear a clattering coming from inside the cottage.\n" + // +
                                        "\nUnknown: Ah! A visitor! We haven't had one of those for years haven't we Harper?\n"
                                        + // +
                                        "\nYou wait a few more moments and the door swings open to reveal a older man with a walking staff. Looking into \nthe cottage you see a large cauldron sitting on a fire.\n"
                                        + // +
                                        "\nMerlin: Welcome! My name is Merlin! Please come in!\n" + // +
                                        "\nWalk in or leave?\n");
                        input = keyboard.nextLine();
                    }
                    // Snoop
                    else if (input.toLowerCase().contains("snoop")) {
                        System.out.println(
                                "\nYou carefully walk around the cottage to a window. You find an older man inside with what seems to be a large \npot over a cooking fire. looking closer you see a small bird in a cage.\n"
                                        + // +
                                        "\nUnknown: Harper, fetch me the meddleroot please\n" + // +
                                        "\nYou see a bird fly off from it's cage deeper into the cottage.\nDo you want to knock on the front door, continue walking, or walk back?");
                        input = keyboard.nextLine();
                    }
                    // continue
                    else if (input.toLowerCase().contains("continue")) {
                        user1.setLocationX(user1.getLocationX() + 1);
                        System.out.println("\nYou ignore the cottage and continue onward through the forest.");
                    }
                    // back
                    else if (input.toLowerCase().contains("back")) {
                        user1.setLocationX(user1.getLocationX() - 1);
                        System.out.println(
                                "\nYou walk back to the spot where you fought the goblin. You don't see anything that's a threat nearby");
                    }
                    // invalid input
                    else {
                        System.out.println(
                                "\nPlease input a valid diction: knock on door, snoop around, continue onward, or walk back\n");
                        input = keyboard.nextLine();
                    }

                }
            }
            // Leave forest
            else if (input.toLowerCase().contains("leave")) {
                user1.setLocationX(user1.getLocationX() - 1);
                System.out.println(
                        "You retrace your steps through the forest and find yourself at the spot where you entered the forest from. You cotinue walking and make it back to Krymn and rest up.");
                user1.setHealth(user1.getTotHealth());
                krymnLocationMessage();
                input = keyboard.nextLine();
                travelFromKrymn(input, user1, hasMetGuards);
            }
            // Invalid response
            else {
                System.out.println("\nPlease enter a valid response: Continue the trails or leave the forest\n");
                input = keyboard.nextLine();
            }
        }

        // Novender Exploration
        while (user1.getLocationX() == 0 && user1.getLocationY() == 1) {
            novenderTownMessage(input, user1, hasMetGuards);
        }

        // Func and Method calls

        // Processes

        // Output

        keyboard.close();
    }// End of Main
}// End of Class
