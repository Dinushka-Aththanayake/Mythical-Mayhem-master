import java.util.Scanner;
import java.io.Serializable;
public class Mage extends Trop implements Market,Serializable {
    private static final long serialVersionUID = 6375919583411830285L;
    public void buy(Player player) {
        System.out.println("<>-----------------------------------------------------------------------------<>");
        System.out.println("                               -----< Mages >-----");
        System.out.println("+---------------+---------------+---------------+---------------+---------------+");
        System.out.println("|    Warlock    |  Illusionist  |   Enchanter   |   Conjurer    |    Eldritch   |");
        System.out.println("| Price: 100 gc | Price: 120 gc | Price: 160 gc | Price: 200 gc | Price: 230 gc |");
        System.out.println("| Attack:    12 | Attack:    13 | Attack:    15 | Attack:    16 | Attack:    18 |");
        System.out.println("| Defence:    7 | Defence:    8 | Defence:    5 | Defence:    9 | Defence:    7 |");
        System.out.println("| Health:    10 | Health:    12 | Health:     7 | Health:    11 | Health:    12 |");
        System.out.println("| Speed:     12 | Speed:     14 | Speed:     14 | Speed:     14 | Speed:     17 |");
        System.out.println("<>-----< 1 >----------< 2 >-----------< 3 >-----------< 4 >----------< 5 >-----<>");
        Scanner x = new Scanner(System.in);
        System.out.printf(">>> ");
        int input_num = x.nextInt();

        String[] mageArr = { "warlock", "illusionist", "enchanter", "conjurer", "eldritch" };
        double currentGc = player.getGc();
        if (player.getMage() == null) {

            if (input_num == 1 && currentGc - 100 >= 0) {
                player.setGc(currentGc - 100);
                player.setMage(mageArr[input_num - 1]);
                System.out.println("Your new Mage is ready now...!");
            } else if (input_num == 2 && currentGc - 120 >= 0) {
                player.setGc(currentGc - 120);
                player.setMage(mageArr[input_num - 1]);
                System.out.println("Your new Mage is ready now...!");
            } else if (input_num == 3 && currentGc - 160 >= 0) {
                player.setGc(currentGc - 160);
                player.setMage(mageArr[input_num - 1]);
                System.out.println("Your new Mage is ready now...!");
            } else if (input_num == 4 && currentGc - 195 >= 0) {
                player.setGc(currentGc - 195);
                player.setMage(mageArr[input_num - 1]);
                System.out.println("Your new Mage is ready now...!");
            } else if (input_num == 5 && currentGc - 270 >= 0) {
                player.setGc(currentGc - 270);
                player.setMage(mageArr[input_num - 1]);
                System.out.println("Your new Mage is ready now...!");
            } else if (input_num == 1 || input_num == 2 || input_num == 3 || input_num == 4 || input_num == 5) {
                System.out.println("You don't have enough gold coins to buy this knight.");
            }
        } else {
            System.out.println("Mage is already exists.");
        }
    }

    public void sell(Player player) {
        double currentGc = player.getGc();
        Mage currentCharacter = player.getMage();
        if (currentCharacter.name == "warlock" && player.getGc() +  100 * 0.9 >= 100) {
            player.setGc(currentGc + 100 * 0.9);
        } else if (currentCharacter.name == "illusionist" && player.getGc() +  120 * 0.9 >= 100) {
            player.setGc(currentGc + 120 * 0.9);
        } else if (currentCharacter.name == "enchanter" && player.getGc() +  160 * 0.9 >= 100) {
            player.setGc(currentGc + 160 * 0.9);
        } else if (currentCharacter.name == "conjurer" && player.getGc() +  195 * 0.9 >= 100) {
            player.setGc(currentGc + 195 * 0.9);
        } else if (currentCharacter.name == "eldritch" && player.getGc() +  270 * 0.9 >= 100) {
            player.setGc(currentGc + 270 * 0.9);
        }
        player.setMage(null);
        System.out.println(
                String.format(
                        "Your Mage sold sucessfully.\nYour current gold coin amount = %.1f \n Now you want to buy a new Mage",
                        player.getGc()));
        Mage x = new Mage();
        x.buy(player);
    }
}

class Warlock extends Mage {
    Warlock() {
        super.name = "warlock";
        super.price = 100;
        super.attack = 12;
        super.defence = 7;
        super.health = 10;
        super.speed = 12;
    }

    String getName() {
        return this.name;
    }

}

class IIIusionist extends Mage {
    IIIusionist() {
        super.name = "iIIusionist";
        super.price = 120;
        super.attack = 13;
        super.defence = 8;
        super.health = 12;
        super.speed = 14;
    }

    String getName() {
        return this.name;
    }
}

class Enchanter extends Mage {
    Enchanter() {
        super.name = "enchanter";
        super.price = 160;
        super.attack = 16;
        super.defence = 10;
        super.health = 13;
        super.speed = 16;
    }

    String getName() {
        return this.name;
    }
}

class Conjurer extends Mage {
    Conjurer() {
        super.name = "conjurer";
        super.price = 195;
        super.attack = 18;
        super.defence = 15;
        super.health = 14;
        super.speed = 12;
    }

    String getName() {
        return this.name;

    }
}

class Eldritch extends Mage {
    Eldritch() {
        super.name = "eldritch";
        super.price = 270;
        super.attack = 19;
        super.defence = 17;
        super.health = 18;
        super.speed = 14;
    }

    String getName() {
        return this.name;

    }
}