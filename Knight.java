import java.util.Scanner;
import java.io.Serializable;
public class Knight extends Trop implements Market , Serializable {
    private static final long serialVersionUID = 6375919583411830285L;
    public void buy(Player player) {
        System.out.println("<>-----------------------------------------------------------------------------<>");
        System.out.println("                               -----< Knights >-----");
        System.out.println("+---------------+---------------+---------------+---------------+---------------+");
        System.out.println("|    Squire     |    Cavalier   |    Templar    |     Zoro      |   Swiftblade  |");
        System.out.println("| Price:  85 gc | Price: 110 gc | Price: 155 gc | Price: 180 gc | Price: 250 gc |");
        System.out.println("| Attack:     8 | Attack:    10 | Attack:    14 | Attack:    17 | Attack:    18 |");
        System.out.println("| Defence:    9 | Defence:   12 | Defence:   16 | Defence:   16 | Defence:   20 |");
        System.out.println("| Health:     7 | Health:     7 | Health:    12 | Health:    13 | Health:    17 |");
        System.out.println("| Speed:      8 | Speed:     10 | Speed:     12 | Speed:     14 | Speed:     13 |");
        System.out.println("<>-----< 1 >----------< 2 >-----------< 3 >-----------< 4 >----------< 5 >-----<>");
        Scanner x = new Scanner(System.in);
        System.out.printf(">>> ");
        int input_num = x.nextInt();
        String[] knightArr = { "squire", "cavalier", "templar", "zoro", "swiftblade" };
        double currentGc = player.getGc();
        if (player.getKnight() == null) {

            if (input_num == 1 && currentGc - 85 >= 0) {
                player.setGc(currentGc - 85);
                player.setKnight(knightArr[input_num - 1]);
                System.out.println("Your new Knight is ready now...!");
            } else if (input_num == 2 && currentGc - 110 >= 0) {
                player.setGc(currentGc - 110);
                player.setKnight(knightArr[input_num - 1]);
                System.out.println("Your new Knight is ready now...!");
            } else if (input_num == 3 && currentGc - 155 >= 0) {
                player.setGc(currentGc - 155);
                player.setKnight(knightArr[input_num - 1]);
                System.out.println("Your new Knight is ready now...!");
            } else if (input_num == 4 && currentGc - 280 >= 0) {
                player.setGc(currentGc - 280);
                player.setKnight(knightArr[input_num - 1]);
                System.out.println("Your new Knight is ready now...!");
            } else if (input_num == 5 && currentGc - 250 >= 0) {
                player.setGc(currentGc - 250);
                player.setKnight(knightArr[input_num - 1]);
                System.out.println("Your new Knight is ready now...!");
            } else if (input_num == 1 || input_num == 2 || input_num == 3 || input_num == 4 || input_num == 5) {
                System.out.println("You don't have enough gold coins to buy this knight.");
            }
        } else {
            System.out.println("Knight is already exists.");
        }
    }

    public void sell(Player player) {
        double currentGc = player.getGc();
        Knight currentCharacter = player.getKnight();
        if (currentCharacter.name == "squire" && player.getGc() +  85 * 0.9 >= 85) {
            player.setGc(currentGc + 85 * 0.9);
        } else if (currentCharacter.name == "cavalier" && player.getGc() +  110 * 0.9 >= 85) {
            player.setGc(currentGc + 110 * 0.9);
        } else if (currentCharacter.name == "templar" && player.getGc() +  155 * 0.9 >= 85) {
            player.setGc(currentGc + 155 * 0.9);
        } else if (currentCharacter.name == "zoro" && player.getGc() +  180 * 0.9 >= 85) {
            player.setGc(currentGc + 180 * 0.9);
        } else if (currentCharacter.name == "swiftblade" && player.getGc() +  250 * 0.9 >= 85) {
            player.setGc(currentGc + 250 * 0.9);
        }
        player.setKnight("null");
        System.out.println(
                String.format(
                        "Your Knight sold sucessfully.\nYour current gold coin amount = %.1f \n Now you want to buy a new Knight",
                        player.getGc()));
        Knight x = new Knight();
        x.buy(player);
    }
}

class Squire extends Knight {
    Squire() {
        super.name = "squire";
        super.price = 85;
        super.attack = 8;
        super.defence = 9;
        super.health = 7;
        super.speed = 8;
    }
}

class Cavalier extends Knight {
    Cavalier() {
        super.name = "cavalier";
        super.price = 110;
        super.attack = 10;
        super.defence = 12;
        super.health = 7;
        super.speed = 10;
    }
}

class Templar extends Knight {
    Templar() {
        super.name = "templar";
        super.price = 155;
        super.attack = 14;
        super.defence = 16;
        super.health = 12;
        super.speed = 12;
    }
}

class Zoro extends Knight {
    Zoro() {
        super.name = "zoro";
        super.price = 180;
        super.attack = 17;
        super.defence = 16;
        super.health = 13;
        super.speed = 14;
    }
}

class Swiftblade extends Knight {
    Swiftblade() {
        super.name = "swiftblade";
        super.price = 250;
        super.attack = 18;
        super.defence = 20;
        super.health = 17;
        super.speed = 13;
    }
}