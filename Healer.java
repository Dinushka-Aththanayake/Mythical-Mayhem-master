import java.util.Scanner;
import java.io.Serializable;
public class Healer extends Trop implements Market,Serializable {
    private static final long serialVersionUID = 6375919583411830285L;
    public void buy(Player player) {
        System.out.println("<>-----------------------------------------------------------------------------<>");
        System.out.println("                               -----< Healers >-----");
        System.out.println("+---------------+---------------+---------------+---------------+---------------+");
        System.out.println("|    Soother    |     Medic     |   Alchemist   |     Saint     |    Pegasus    |");
        System.out.println("| Price:  95 gc | Price: 125 gc | Price: 150 gc | Price: 200 gc | Price: 260 gc |");
        System.out.println("| Attack:    10 | Attack:    12 | Attack:    13 | Attack:    16 | Attack:    17 |");
        System.out.println("| Defence:    8 | Defence:    9 | Defence:   13 | Defence:   14 | Defence:   15 |");
        System.out.println("| Health:     9 | Health:    10 | Health:    13 | Health:    17 | Health:    19 |");
        System.out.println("| Speed:      6 | Speed:      7 | Speed:     13 | Speed:      9 | Speed:     12 |");
        System.out.println("<>-----< 1 >----------< 2 >-----------< 3 >-----------< 4 >----------< 5 >-----<>");
        Scanner x = new Scanner(System.in);
        System.out.printf(">>> ");
        int input_num = x.nextInt();
        String[] healerArr = { "soother", "medic", "alchemist", "saint", "lightbringer" };
        double currentGc = player.getGc();
        if (player.getHealer() == null) {
            if (input_num == 1 && currentGc - 95 >= 0) {
                player.setGc(currentGc - 95);
                player.setHealer(healerArr[input_num - 1]);
                System.out.println("Your new Healer is ready now...!");
            } else if (input_num == 2 && currentGc - 125 >= 0) {
                player.setGc(currentGc - 125);
                player.setHealer(healerArr[input_num - 1]);
                System.out.println("Your new Healer is ready now...!");
            } else if (input_num == 3 && currentGc - 150 >= 0) {
                player.setGc(currentGc - 150);
                player.setHealer(healerArr[input_num - 1]);
                System.out.println("Your new Healer is ready now...!");
            } else if (input_num == 4 && currentGc - 200 >= 0) {
                player.setGc(currentGc - 200);
                player.setHealer(healerArr[input_num - 1]);
                System.out.println("Your new Healer is ready now...!");
            } else if (input_num == 5 && currentGc - 260 >= 0) {
                player.setGc(currentGc - 260);
                player.setHealer(healerArr[input_num - 1]);
                System.out.println("Your new Healer is ready now...!");
            } else if (input_num == 1 || input_num == 2 || input_num == 3 || input_num == 4 || input_num == 5) {
                System.out.println("You don't have enough gold coins to buy this knight.");
            }
        } else {
            System.out.println("Healer is already exists.");
        }
    }

    public void sell(Player player) {
        double currentGc = player.getGc();
        Healer currentCharacter = player.getHealer();
        if (currentCharacter.name == "soother" && player.getGc() + 95 * 0.9 >= 95) {
            player.setGc(currentGc + 95 * 0.9);
        } else if (currentCharacter.name == "medic" && player.getGc() +  125 * 0.9 >= 95) {
            player.setGc(currentGc + 125 * 0.9);
        } else if (currentCharacter.name == "alchemist" && player.getGc() +  150 * 0.9 >= 95) {
            player.setGc(currentGc + 150 * 0.9);
        } else if (currentCharacter.name == "saint" && player.getGc() +  200 * 0.9 >= 95) {
            player.setGc(currentGc + 200 * 0.9);
        } else if (currentCharacter.name == "lightbringer" && player.getGc() +  260 * 0.9 >= 95) {
            player.setGc(currentGc + 260 * 0.9);
        }
        player.setHealer("null");
        System.out.println(
                String.format(
                        "Your Healer sold sucessfully.\nYour current gold coin amount = %.1f \n Now you want to buy a new Healer",
                        player.getGc()));
        Healer x = new Healer();
        x.buy(player);
    }
}

class Soother extends Healer {
    Soother() {
        super.name = "soother";
        super.price = 95;
        super.attack = 10;
        super.defence = 8;
        super.health = 9;
        super.speed = 6;
    }

    String getname() {
        return this.name;
    }
}

class Medic extends Healer {
    Medic() {
        super.name = "medic";
        super.price = 125;
        super.attack = 12;
        super.defence = 9;
        super.health = 10;
        super.speed = 7;
    }

    String getname() {
        return this.name;
    }
}

class Alchemist extends Healer {
    Alchemist() {
        super.name = "alchemist";
        super.price = 150;
        super.attack = 13;
        super.defence = 13;
        super.health = 13;
        super.speed = 13;
    }

    String getname() {
        return this.name;
    }
}

class Saint extends Healer {
    Saint() {
        super.name = "saint";
        super.price = 200;
        super.attack = 16;
        super.defence = 14;
        super.health = 17;
        super.speed = 9;
    }

    String getname() {
        return this.name;
    }
}

class Lightbringer extends Healer {
    Lightbringer() {
        super.name = "lightbringer";
        super.price = 260;
        super.attack = 17;
        super.defence = 15;
        super.health = 19;
        super.speed = 12;
    }

    String getname() {
        return this.name;
    }
}