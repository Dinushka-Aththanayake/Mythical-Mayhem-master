import java.util.Scanner;
import java.io.Serializable;

public class Archer extends Trop implements Market, Serializable {
    private static final long serialVersionUID = 6375919583411830285L;

    public void buy(Player player) {
        System.out.println("<>-----------------------------------------------------------------------------<>");
        System.out.println("                               -----< Archers >-----");
        System.out.println("+---------------+---------------+---------------+---------------+---------------+");
        System.out.println("|    Shooter    |     Ranger    |    Sunfire    |     Zing      |  Saggitarius  |");
        System.out.println("| Price:  80 gc | Price: 115 gc | Price: 160 gc | Price: 200 gc | Price: 230 gc |");
        System.out.println("| Attack:    11 | Attack:    14 | Attack:    15 | Attack:    16 | Attack:    18 |");
        System.out.println("| Defence:    4 | Defence:    5 | Defence:    5 | Defence:    9 | Defence:    7 |");
        System.out.println("| Health:     6 | Health:     8 | Health:     7 | Health:    11 | Health:    12 |");
        System.out.println("| Speed:      9 | Speed:     10 | Speed:     14 | Speed:     14 | Speed:     17 |");
        System.out.println("<>-----< 1 >----------< 2 >-----------< 3 >-----------< 4 >----------< 5 >-----<>");
        Scanner x = new Scanner(System.in);
        System.out.printf(">>> ");
        int input_num = x.nextInt();
        String[] archerArr = { "shooter", "ranger", "sunfire", "zing", "saggitarius" };
        double currentGc = player.getGc();
        if (player.getArcher() == null) {

            if (input_num == 1 && currentGc - 80 >= 0) {
                player.setGc(currentGc - 80);
                player.setArcher(archerArr[input_num - 1]);
                System.out.println("Your new Archer is ready now...!");
            } else if (input_num == 2 && currentGc - 115 >= 0) {
                player.setGc(currentGc - 115);
                player.setArcher(archerArr[input_num - 1]);
                System.out.println("Your new Archer is ready now...!");

            } else if (input_num == 3 && currentGc - 160 >= 0) {
                player.setGc(currentGc - 160);
                player.setArcher(archerArr[input_num - 1]);
                System.out.println("Your new Archer is ready now...!");

            } else if (input_num == 4 && currentGc - 200 >= 0) {
                player.setGc(currentGc - 200);
                player.setArcher(archerArr[input_num - 1]);
                System.out.println("Your new Archer is ready now...!");

            } else if (input_num == 5 && currentGc - 230 >= 0) {
                player.setGc(currentGc - 230);
                player.setArcher(archerArr[input_num - 1]);
                System.out.println("Your new Archer is ready now...!");

            } else if (input_num == 1 || input_num == 2 || input_num == 3 || input_num == 4 || input_num == 5) {
                System.out.println("You don't have enough gold coins to buy this archer.");
            }
        } else {
            System.out.println("Archer is already exists.");
        }
    }

    public void sell(Player player) {
        double currentGc = player.getGc();
        Archer currentCharacter = player.getArcher();
        if (currentCharacter.name == "shooter" && player.getGc() +  80 * 0.9 >= 80) {
            player.setGc(currentGc + 80 * 0.9);
        } else if (currentCharacter.name == "ranger" && player.getGc() +  115 * 0.9 >= 80) {
            player.setGc(currentGc + 115 * 0.9);
        } else if (currentCharacter.name == "sunfire" && player.getGc() +  160 * 0.9 >= 80) {
            player.setGc(currentGc + 160 * 0.9);
        } else if (currentCharacter.name == "zing" && player.getGc() +  200 * 0.9 >= 80) {
            player.setGc(currentGc + 200 * 0.9);
        } else if (currentCharacter.name == "saggitarius" && player.getGc() +  230 * 0.9 >= 80) {
            player.setGc(currentGc + 230 * 0.9);
        }
        player.setArcher("null");
        System.out.println(
                String.format(
                        "Your Archer sold sucessfully.\nYour current gold coin amount = %.1f \n Now you want to buy a new Archer",
                        player.getGc()));
        Archer x = new Archer();
        x.buy(player);
    }
}

class Shooter extends Archer {
    Shooter() {
        super.name = "shooter";
        super.price = 80;
        super.attack = 11;
        super.defence = 4;
        super.health = 6;
        super.speed = 9;
    }
}

class Ranger extends Archer {
    Ranger() {
        super.name = "ranger";
        super.price = 115;
        super.attack = 14;
        super.defence = 5;
        super.health = 8;
        super.speed = 10;
    }
}

class Sunfire extends Archer {
    Sunfire() {
        super.name = "sunfire";
        super.price = 160;
        super.attack = 15;
        super.defence = 5;
        super.health = 7;
        super.speed = 14;
    }
}

class Zing extends Archer {
    Zing() {
        super.name = "zing";
        super.price = 200;
        super.attack = 16;
        super.defence = 9;
        super.health = 11;
        super.speed = 14;
    }
}

class Saggitarius extends Archer {
    Saggitarius() {
        super.name = "saggitarius";
        super.price = 230;
        super.attack = 18;
        super.defence = 7;
        super.health = 12;
        super.speed = 17;
    }
}