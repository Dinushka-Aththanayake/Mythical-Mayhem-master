import java.io.Serializable;
import java.util.Scanner;

public class MarketPlace implements Serializable {
    private static final long serialVersionUID = 6375919583411830285L;
    void buyArcher(Player player) {
        Archer x = new Archer();
        x.buy(player);
    }

    void sellArcher(Player player) {
        Archer x = new Archer();
        x.sell(player);
    }

    void buyKnight(Player player) {
        Knight x = new Knight();
        x.buy(player);
    }

    void sellKnight(Player player) {
        Knight x = new Knight();
        x.sell(player);
    }

    void buyMage(Player player) {
        Mage x = new Mage();
        x.buy(player);
    }

    void sellMage(Player player) {
        Mage x = new Mage();
        x.sell(player);
    }

    void buyHealer(Player player) {
        Healer x = new Healer();
        x.buy(player);
    }

    void sellHealer(Player player) {
        Healer x = new Healer();
        x.sell(player);
    }

    void buyMythicalCreature(Player player) {
        MythicalCreature x = new MythicalCreature();
        x.buy(player);
    }

    void sellMythicalCreature(Player player) {
        MythicalCreature x = new MythicalCreature();
        x.sell(player);
    }

    private Trop removeTool(Trop updateChar, String toolType) {
        if (toolType == "armour")
            updateChar.armour = null;
        else if (toolType == "artefact")
            updateChar.artefact = null;
        // ---------------Archer---------------------
        if (updateChar.name == "shooter") {
            updateChar.attack = 11;
            updateChar.defence = 4;
            updateChar.health = 6;
            updateChar.speed = 9;

        } else if (updateChar.name == "ranger") {
            updateChar.attack = 14;
            updateChar.defence = 5;
            updateChar.health = 8;
            updateChar.speed = 10;
        } else if (updateChar.name == "sunfire") {
            updateChar.attack = 15;
            updateChar.defence = 5;
            updateChar.health = 7;
            updateChar.speed = 14;
        } else if (updateChar.name == "zing") {
            updateChar.attack = 16;
            updateChar.defence = 9;
            updateChar.health = 11;
            updateChar.speed = 14;
        } else if (updateChar.name == "saggitarius") {
            updateChar.attack = 18;
            updateChar.defence = 7;
            updateChar.health = 12;
            updateChar.speed = 17;
        }
        // ----------Knight--------------
        else if (updateChar.name == "squire") {
            updateChar.attack = 8;
            updateChar.defence = 9;
            updateChar.health = 7;
            updateChar.speed = 8;
        } else if (updateChar.name == "cavalier") {
            updateChar.attack = 10;
            updateChar.defence = 12;
            updateChar.health = 7;
            updateChar.speed = 10;
        } else if (updateChar.name == "templar") {
            updateChar.attack = 14;
            updateChar.defence = 16;
            updateChar.health = 12;
            updateChar.speed = 12;
        } else if (updateChar.name == "zoro") {
            updateChar.attack = 17;
            updateChar.defence = 16;
            updateChar.health = 13;
            updateChar.speed = 14;
        } else if (updateChar.name == "swiftblade") {
            updateChar.attack = 18;
            updateChar.defence = 20;
            updateChar.health = 17;
            updateChar.speed = 13;
        }
        // ----------Mage---------------------
        else if (updateChar.name == "warlock") {
            updateChar.attack = 12;
            updateChar.defence = 7;
            updateChar.health = 10;
            updateChar.speed = 12;
        } else if (updateChar.name == "iIIusionist") {
            updateChar.attack = 13;
            updateChar.defence = 8;
            updateChar.health = 12;
            updateChar.speed = 14;
        } else if (updateChar.name == "enchanter") {
            updateChar.attack = 16;
            updateChar.defence = 10;
            updateChar.health = 13;
            updateChar.speed = 16;
        } else if (updateChar.name == "conjurer") {
            updateChar.attack = 18;
            updateChar.defence = 15;
            updateChar.health = 14;
            updateChar.speed = 12;
        } else if (updateChar.name == "eldritch") {
            updateChar.attack = 19;
            updateChar.defence = 17;
            updateChar.health = 18;
            updateChar.speed = 14;
        }
        // ------------Healer---------------------
        else if (updateChar.name == "soother") {
            updateChar.attack = 10;
            updateChar.defence = 8;
            updateChar.health = 9;
            updateChar.speed = 6;
        } else if (updateChar.name == "medic") {
            updateChar.attack = 12;
            updateChar.defence = 9;
            updateChar.health = 10;
            updateChar.speed = 7;
        } else if (updateChar.name == "alchemist") {
            updateChar.attack = 13;
            updateChar.defence = 13;
            updateChar.health = 13;
            updateChar.speed = 13;
        } else if (updateChar.name == "saint") {
            updateChar.attack = 16;
            updateChar.defence = 14;
            updateChar.health = 17;
            updateChar.speed = 9;
        } else if (updateChar.name == "lightbringer") {
            updateChar.attack = 17;
            updateChar.defence = 15;
            updateChar.health = 19;
            updateChar.speed = 12;
        }
        // ------------Mythical Creature-------------
        else if (updateChar.name == "dragon") {
            updateChar.attack = 12;
            updateChar.defence = 14;
            updateChar.health = 15;
            updateChar.speed = 8;
        } else if (updateChar.name == "basilisk") {
            updateChar.attack = 15;
            updateChar.defence = 11;
            updateChar.health = 10;
            updateChar.speed = 12;
        } else if (updateChar.name == "hydra") {
            updateChar.attack = 12;
            updateChar.defence = 16;
            updateChar.health = 15;
            updateChar.speed = 11;
        } else if (updateChar.name == "phoenix") {
            updateChar.attack = 17;
            updateChar.defence = 13;
            updateChar.health = 17;
            updateChar.speed = 19;
        } else if (updateChar.name == "pegasus") {
            updateChar.attack = 14;
            updateChar.defence = 18;
            updateChar.health = 20;
            updateChar.speed = 20;
        }
        return updateChar;
    }

    void buyArmour(Player player) {
        Trop[] characterArr = { player.getArcher(), player.getKnight(), player.getMage(), player.getHealer(),
                player.getMythicalCreature() };
        System.out.println("Choose a character to equip the armour,");
        int i = 1;
        for (Trop obj : characterArr) {
            if (obj != null)
                System.out.println(obj.name + "--< " + i++ + " >");
        }
        Scanner x = new Scanner(System.in);
        System.out.println("Which character do you want...?");
        System.out.printf(">>> ");
        int characterNum = x.nextInt();
        System.out.println("<>-----------------------------------------------------------------------------<>");
        System.out.println("                               -----< Armours >-----");
        System.out.println("|-------------------------+---------------------------+-------------------------|");
        System.out.println("|        Chainmail        |          Regalia          |          Fleece         |");
        System.out.println("| Price:            70gc  | Price:             105gc  | Price:           150 gc |");
        System.out.println("| Attack:      No change  | Attack:        No change  | Attack:       No change |");
        System.out.println("| Defence:            +1  | Defence:              +1  | Defence:             +2 |");
        System.out.println("| Health:      No change  | Health:         No change | Health:              +1 |");
        System.out.println("| Speed:              -1  | Speed:          No change | Speed:               -1 |");
        System.out.println("<>--------< 1 >-----------------------< 2 >---------------------< 3 >----------<>\n");
        System.out.println("Which Armour do you want...?");
        System.out.printf(">>> ");
        int armour_num = x.nextInt();
        double currentGc = player.getGc();
        Trop updateChar = characterArr[characterNum - 1];
        if (updateChar.armour == null) {
            if (armour_num == 1 && currentGc - 70 >= 0) {
                updateChar.armour = "chainmail";
                updateChar.attack += 1;
                updateChar.speed -= 1;
                player.setGc(currentGc - 70);
                updateChar.price += 0.2 * 70;
                System.out.println("Your "+ updateChar.name + " is updated by Chainmail.");
            } else if (armour_num == 2 && currentGc - 105 >= 0) {
                updateChar.armour = "regalia";
                updateChar.attack += 1;
                player.setGc(currentGc - 105);
                updateChar.price += 0.2 * 105;
                System.out.println("Your "+ updateChar.name + " is updated by Regalia.");
            } else if (armour_num == 3 && currentGc - 150 >= 0) {
                updateChar.armour = "fleece";
                updateChar.defence += 2;
                updateChar.health += 1;
                updateChar.speed -= 1;
                player.setGc(currentGc - 150);
                updateChar.price += 0.2 * 150;
                System.out.println("Your "+ updateChar.name + " is updated by Fleece.");
            }
        } else {
            removeTool(updateChar, "armour");
            buyArmour(player);
        }
    }

    void buyArtefact(Player player) {
        Trop[] characterArr = { player.getArcher(), player.getKnight(), player.getMage(), player.getHealer(),
                player.getMythicalCreature() };
        System.out.println("Choose a character to equie the artefacts,");
        int i = 1;
        for (Trop obj : characterArr) {
            System.out.println(obj.name + "--< " + i++ + " >");
        }
        Scanner x = new Scanner(System.in);
        System.out.println("Which character do you want...?");
        System.out.printf(">>> ");
        int characterNum = x.nextInt();
        System.out.println("<>-----------------------------------------------------------------------------<>");
        System.out.println("                               -----< Armours >-----");
        System.out.println("|-------------------------+---------------------------+-------------------------|");
        System.out.println("|         Excalibur       |          Amulet           |          Crystal        |");
        System.out.println("| Price:            150gc | Price:              200gc | Price:            210gc |");
        System.out.println("| Attack:             +2  | Attack:                +1 | Attack:              +2 |");
        System.out.println("| Defence:     No change  | Defence:               -1 | Defence:             +1 |");
        System.out.println("| Health:      No change  | Health:                +1 | Health:              -1 |");
        System.out.println("| Speed:       No change  | Speed:                 +1 | Speed:               -1 |");
        System.out.println("<>--------< 1 >-----------------------< 2 >---------------------< 3 >----------<>\n");
        System.out.println("Which Artefacts do you want...?");
        System.out.printf(">>> ");
        int artefact_num = x.nextInt();
        double currentGc = player.getGc();
        Trop updateChar = characterArr[characterNum - 1];
        if (updateChar.artefact == null) {
            if (artefact_num == 1 && currentGc - 150 >= 0) {
                updateChar.artefact = "excalibur";
                updateChar.attack += 2;
                player.setGc(currentGc - 150);
                updateChar.price += 0.2 * 150;
                System.out.println("Your "+ updateChar.name + " is updated by Excalibur.");
            } else if (artefact_num == 2 && currentGc - 200 >= 0) {
                updateChar.armour = "amulet";
                updateChar.attack += 1;
                updateChar.defence -= 1;
                updateChar.health += 1;
                updateChar.speed += 1;
                player.setGc(currentGc - 200);
                updateChar.price += 0.2 * 200;
                System.out.println("Your "+ updateChar.name + " is updated by Amulet.");
            } else if (artefact_num == 3 && currentGc - 210 >= 0) {
                updateChar.armour = "crystal";
                updateChar.attack += 2;
                updateChar.defence += 1;
                updateChar.health -= 1;
                updateChar.speed -= 1;
                player.setGc(currentGc - 210);
                updateChar.price += 0.2 * 210;
                System.out.println("Your "+ updateChar.name + " is updated by Crystal.");
            }
        } else {
            // ---------Archer------------------
            removeTool(updateChar, "artefact");
            buyArtefact(player);
        }
    }
}