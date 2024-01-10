import java.util.*;
public class App {
    //Funcs and Methods
    public static Scanner keys = new Scanner(System.in);

    public static Random rnd = new Random();
    public static int x;
    
    //Krymn message
    public static void krymnLocationMessage(){
        System.out.println("You find yourself in Krymn. " + // + 
                "\nTo the North is the town of Novender, where you can find a bustling economy with merchants all through the streets." + //
                "\nIn the East is the forest, where goblins and wolves lurk." + //
                "\nDown South is the Drylands, with high heat and not much food or animals survival there is tough." + //
                "\nAnd finally to the West are the Heralds Hills, A place where many priests of this world undergo a testament of strength and \nwillpower. Only those who are qualified and strong enough are able to adventure there.\n");
    }

    //places to travel to from Krymn
    public static void travelFromKrymn(String input, User user1){
        
        if (input.toLowerCase().contains("north")){
            user1.setLocationY(user1.getLocationY() + 1);
            System.out.println("\nYou travel up North towards Novender. After about two hours you arrive at the city gates. The guards stop you on your way in.");
        }
        else if (input.toLowerCase().contains("east")){
            user1.setLocationX(user1.getLocationX() + 1);
            System.out.println("\nYou head into the forest, weary of the dangers. Armed with a small wooden sword, you go into the forest.");
        }
        else if (input.toLowerCase().contains("south")){
            user1.setLocationY(user1.getLocationY() - 1);
            System.out.println("\nFinding the heat of the Drylands unbearable, you cannot travel through there now.\n");
            user1.setLocationY(user1.getLocationY() + 1);
        }
        else if (input.toLowerCase().contains("west")){
            user1.setLocationX(user1.getLocationX() - 1);
            System.out.println("\nYou travel West, towrads the prooving grounds for priests-to-be. Upon your arrival to the top of the hill a guard stops you.");
            if (user1.getStrength() < 20){
                System.out.println(
            "\nGuard: Halt! You are not ready yet to try the Testament of Strength. Come back later, once you're stronger." + // + 
            "\n You are forced to go back to Krymn.\n");
            user1.setLocationX(user1.getLocationX() + 1);
            }
        }
    }//End of travelFromKrymn

    //Battle func
    public static void battleEnemy(String input, User user1, Enemy enemy1){
        while (user1.getHealth() >= 0 || enemy1.getHealth() >= 0){
            System.out.println("You are fighting a \n" + enemy1.toString() + "\n\n" + user1.toString() + "\n Your options are: Attack or Flee");
            input = keys.nextLine();
            if (input.toLowerCase().contains("attack")){
                System.out.println("\nYou attack the " + enemy1.getName() + "!");
                enemy1.setHealth(enemy1.getHealth() - user1.getStrength());
            } else {
                System.out.println("\nThe " + enemy1.getName() + " won't let you do that!\n");
            }
            x = rnd.nextInt(2) + 1;
            if (x == 1){
                System.out.println("\nThe " + enemy1.getName() + " swipes at you with it's claws\n");
                user1.setHealth(user1.getHealth() - enemy1.getStrength());
            } else if (x == 2){
                System.out.println("\nThe " + enemy1.getName() + " does nothing\n");
            }
            //System.out.println(x);
            if (enemy1.getHealth() <= 0){
                System.out.println("You defeated the " + enemy1.getName() + "!\n");
                break;
            } else if (user1.getHealth() <= 0){
                System.out.println("The " + enemy1.getName() + " killed you! Your adventure ends here.");
                break;
            }
        }
    }//End of battleEnemy
    public static void main(String[] args) throws Exception {
        //Variables

        String input = "";

        //Class variables

        Scanner keyboard = new Scanner(System.in);

        //User
        User user1 = new User();
        user1.setStrength(1);
        user1.setHealth(10);

        //Enemy
        Enemy enemy1 = new Enemy();

        //Inputs

        //Welcome Message // setting name
        System.out.println("Welcome! This is a text based adventure game that will take place in a medival fantasy world of spells and swords! Enter a name for your character and we will start on your journey!\n");
        input = keyboard.nextLine();
        user1.setName(input);

        //Writes out locations from Krymn
        System.out.println("\nYour character " + user1.getName() + ", and your story, starts in a small village called Krymn." + // + 
        "\n To the North is the town of Novender, where you can find a bustling economy with merchants all through the streets." + // + 
        "\n In the East is the forest, where goblins and wolves lurk." + // + 
        "\n Down South is the Drylands, with high heat and not much food or animals survival there is tough." + // + 
        "\n And finally to the West are the Heralds Hills, A place where many priests of this world undergo a testament of strength and \n willpower. Only those who are qualified and strong enough are able to adventure there.\n");
        input = keyboard.nextLine();

        //Takes player from Krymn
        travelFromKrymn(input, user1);
        while (user1.getLocationX() == 0 && user1.getLocationY() == 0){
            krymnLocationMessage();
            input = keyboard.nextLine();
            travelFromKrymn(input, user1);
        }

        if (user1.getLocationX() == 1 && user1.getLocationY() == 0){
            System.out.println("\nAfter about 20 minutes of walking through the forest you encounter a goblin. He looks vicious and hungry. You must fight him to escape!");
            enemy1.setName("Hungry Goblin");
            enemy1.setHealth(5);
            enemy1.setStrength(1);
            battleEnemy(input, user1, enemy1);
        }

        //Func and Method calls



        //Processes



        //Output

        
        keyboard.close();
    }//End of Main
}//End of Class
