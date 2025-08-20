import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main_1 {
    static int check = 0;

    public static String printTool(String tool) {
        if (tool != null) {
            return " + " + tool;
        } else {
            return "";
        }
    }

    public static void profile_list(Player currentPlayer, Player[] playerarr, Scanner y) {
        System.out.println("________________________________________________________________________________________");
        System.out.println("<>-----<>-----<>-----<>                 Main Menu               <>-----<>------<>-----<>");
        System.out
                .println("_______||________||________||_____________________________||________||_______||_________\n");
        System.out.println("                               *-  Battle -------< 1 >");
        System.out.println("                               *-  BuyArmy ------< 2 >");
        System.out.println("                               *-  BuyEquipment --< 3 >");
        System.out.println("                               *-  Sell Army ----< 4 >");
        System.out.println("                               *-  Profile ------< 5 >");
        System.out.println("                               *-  save ---------< 6 >");
        System.out.println("                               *-  Exit ---------< 7 >");
        System.out.printf(">>> ");
        // Scanner y = new Scanner(System.in);
        if (y.hasNextInt()) {
            int optionInput = y.nextInt();
            if (optionInput == 1) {
                currentPlayer.readyAttack(currentPlayer, playerarr);
            } else if (optionInput == 2) {
                MarketPlace buyarmy = new MarketPlace();
                System.out.println("Which  category of character do you want to buy...? \n");
                System.out.println(
                        "*- Archer ------------< 1 >\n*- Knight ------------< 2 >\n*- Mage --------------< 3 >\n*- Healer ------------< 4 >\n*- MythicalCreature --< 5 >");
                System.out.printf(">>> ");
                int buyarmynum = y.nextInt();
                MarketPlace sellArmy = new MarketPlace();
                if (buyarmynum == 1) {
                    buyarmy.buyArcher(currentPlayer);
                } else if (buyarmynum == 2) {
                    buyarmy.buyKnight(currentPlayer);
                } else if (buyarmynum == 3) {
                    buyarmy.buyMage(currentPlayer);
                } else if (buyarmynum == 4) {
                    buyarmy.buyHealer(currentPlayer);
                } else if (buyarmynum == 5) {
                    buyarmy.buyMythicalCreature(currentPlayer);
                }
            } else if (optionInput == 3) {
                MarketPlace buyEquiment = new MarketPlace();
                System.out.println("Which equipment type do you want...?\n");
                System.out.println("*- Armour -----------< 1 >\n*- Artefact ---------< 2 >");
                System.out.printf(">>> ");
                int buyequipmentnum = y.nextInt();
                if (buyequipmentnum == 1) {
                    buyEquiment.buyArmour(currentPlayer);

                } else if (buyequipmentnum == 2) {
                    buyEquiment.buyArtefact(currentPlayer);
                }
            } else if (optionInput == 4) {
                MarketPlace sellarmy = new MarketPlace();
                System.out.println("Which  category of character do you want to sell...?");
                System.out.println(
                        "*- Archer ------------< 1 >\n*- Knight ------------< 2 >\n*- Mage --------------< 3 >\n*- Healer ------------< 4 >\n*- MythicalCreature --< 5 >");
                System.out.printf(">>> ");
                int sellarmynum = y.nextInt();
                MarketPlace sellArmy = new MarketPlace();
                if (sellarmynum == 1) {
                    sellArmy.sellArcher(currentPlayer);
                } else if (sellarmynum == 2) {
                    sellArmy.sellKnight(currentPlayer);
                } else if (sellarmynum == 3) {
                    sellArmy.sellMage(currentPlayer);
                } else if (sellarmynum == 4) {
                    sellArmy.sellHealer(currentPlayer);
                } else if (sellarmynum == 5) {
                    sellArmy.sellMythicalCreature(currentPlayer);
                }
            } else if (optionInput == 5) {
                System.out.println(
                        "________________________________________________________________________________________");
                System.out.println(
                        "<>-----<>-----<>-----<>-----<>          Profile          <>-----<>-----<>------<>-----<>");
                System.out.println(
                        "_______||________||________||_____________________________||________||_______||_________\n");
                System.out.println("                           *- UserId :" + currentPlayer.getUserId());
                System.out.println("                           *- Name:" + currentPlayer.getName());
                System.out.println("                           *- UserName: " + currentPlayer.getUsername());
                System.out.println("                           *- Xp: " + currentPlayer.getXp());
                System.out.println("                           *- GoldCoin: " + currentPlayer.getGc());
                System.out.println("                           *- Archer: " + currentPlayer.getArcher().name
                        + printTool(currentPlayer.getArcher().armour) + printTool(currentPlayer.getArcher().artefact));

                System.out.println("                           *- Knight: " + currentPlayer.getKnight().name
                        + printTool(currentPlayer.getKnight().armour) + printTool(currentPlayer.getKnight().artefact));

                System.out.println("                           *- Mage: " + currentPlayer.getMage().name +
                        printTool(currentPlayer.getMage().armour) + printTool(currentPlayer.getMage().artefact));
                System.out.println("                           *- Healer: " + currentPlayer.getHealer().name
                        + printTool(currentPlayer.getHealer().armour) + printTool(currentPlayer.getHealer().artefact));
                System.out.println(
                        "                           *- MythicalCreature: " + currentPlayer.getMythicalCreature().name +
                                printTool(currentPlayer.getMythicalCreature().armour)
                                + printTool(currentPlayer.getMythicalCreature().artefact));
                System.out.println("Enter any number to go back Main menu.");
                System.out.printf(">>> ");
                int nothing = y.nextInt();
            } else if (optionInput == 6) {
                playerarr[playerarr.length - 1] = currentPlayer;
                Read_Write obj3 = new Read_Write();
                int n = playerarr.length;
                ArrayList<Player> array_prof1 = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    array_prof1.add(playerarr[i]);
                }
                obj3.writeplayer(array_prof1);
                System.out.println("Save Done");

            } else if (optionInput == 7) {
                check = 1;
                System.exit(0);
            }
        } else {
            System.out.println("Invalid Input");
            check = 1;
        }
    }

    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.println("________________________________________________________________________________________");
        System.out.println("<>-----<>-----<>-----<>      Welcome to The Mystic Mayhem       <>-----<>------<>-----<>");
        System.out.println("_______||________||________||_____________________________||________||_______||_________");
        System.out
                .println("You are entering now to battlefield.Are you ready? Yes--< 1 > / No--< 0 > ");

        System.out.println(">>> ");
        int choice = x.nextInt();

        Read_Write db = new Read_Write();
        Player[] arr = db.readplayerarr();

        int count = 0;
        Player currentPlayer = new Player(null, null);
        if (choice == 1) {
            System.out.println("Create a new kingdom --< 1 > or Already I have a kingdom --< 2 >");
            System.out.printf(">>> ");
            int signupNumber = x.nextInt();
            if (signupNumber == 1) {
                System.out.println("Enter your Name ");
                System.out.printf(">>> ");
                x.nextLine();
                String name = x.nextLine();
                System.out.println(
                        "Set a UserName, your can't change after creating it.");
                ArrayList<Player> usernamelist = new ArrayList<>();
                Collections.addAll(usernamelist, arr);

                int chance = 0;
                String username = "";
                while (chance == 0) {
                    System.out.print(">>> ");
                    username = x.nextLine();

                    boolean exists = false;
                    for (Player user : usernamelist) {
                        if (username.equals(user.getUsername())) {
                            System.out.println("Username that you're entered already exists!");
                            exists = true;
                            break;
                        }
                    }

                    if (!exists) {

                        chance = 1;
                        System.out.println("Your Kingdom is created successfully...!\nKingdom's treasure is 500gc\n");
                    }
                }
                Player currentPlayer1 = new Player(name, username);
                currentPlayer = currentPlayer1;

                System.out.println("Let's build an Army...!\n");
                System.out.println("According to your kingdom's treasure we can buy only one of below two armys.\n");
                System.out.println("<>-----------------------------------------------------------------------------<>");
                System.out.println("                               -----< Army 1 >-----< 1 >");
                System.out.println("+---------------+---------------+---------------+---------------+---------------+");
                System.out.println("|    Shooter    |     Squire   |    Warlock    |     Soother  |     Dragon    |");
                System.out.println("| Price:  80 gc | Price: 85 gc | Price: 100 gc | Price: 95 gc | Price: 120 gc |");
                System.out.println("| Attack:    11 | Attack:    8 | Attack:    12 | Attack:   10 | Attack:    12 |");
                System.out.println("| Defence:    4 | Defence:   9 | Defence:    7 | Defence:   8 | Defence:   14 |");
                System.out.println("| Health:     6 | Health:    7 | Health:    10 | Health:    9 | Health:    15 |");
                System.out.println("| Speed:      9 | Speed:     8 | Speed:     12 | Speed:     6 | Speed:      8 |\n");

                System.out.println("<>-----------------------------------------------------------------------------<>");
                System.out.println("                               -----< Army 2 >-----< 2 >");
                System.out.println("+---------------+---------------+---------------+---------------+---------------+");
                System.out.println("|    Shooter    |     Squire   |  Illusionist   |     Soother  |     Dragon    |");
                System.out.println("| Price:  80 gc | Price: 85 gc | Price: 120 gc | Price: 95 gc | Price: 120 gc |");
                System.out.println("| Attack:    11 | Attack:    8 | Attack:    13 | Attack:   10 | Attack:    12 |");
                System.out.println("| Defence:    4 | Defence:   9 | Defence:    8 | Defence:   8 | Defence:   14 |");
                System.out.println("| Health:     6 | Health:    7 | Health:    12 | Health:    9 | Health:    15 |");
                System.out.println("| Speed:      9 | Speed:     8 | Speed:     14 | Speed:     6 | Speed:      8 |\n");
                System.out.println("What is your Idea...?");
                System.out.printf(">>> ");
                int armynum = x.nextInt();
                if (armynum == 1) {
                    currentPlayer.setArcher("shooter");
                    currentPlayer.setKnight("squire");
                    currentPlayer.setMage("warlock");
                    currentPlayer.setHealer("soother");
                    currentPlayer.setMythicalCreature("dragon");

                } else if (armynum == 2) {
                    currentPlayer.setArcher("shooter");
                    currentPlayer.setKnight("squire");
                    currentPlayer.setMage("illusionist");
                    currentPlayer.setHealer("soother");
                    currentPlayer.setMythicalCreature("dragon");

                }

            } else if (signupNumber == 2) {

                for (Player player : arr) {

                    count++;
                    System.out.println("Profile " + count + " <-> " + player.getName() + " --< " + count + " >");
                }
                System.out.println("Select a profile");
                System.out.printf(">>> ");
                int pro = x.nextInt();
                currentPlayer = arr[pro - 1];
            }
            // profile_list(currentPlayer,arr);

            while (true) {
                if (check == 0) {
                    profile_list(currentPlayer, arr, x);
                } else {
                    break;
                }
            }
        } else if (choice == 0) {
            System.out.println("Thank you for join this game. See you again");
        } else {

            System.out.println("Give correct choise yes or no");
        }

    }
}
