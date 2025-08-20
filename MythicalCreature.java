import java.util.Scanner;
import java.io.Serializable;
public class MythicalCreature extends Trop implements Market ,Serializable{
    private static final long serialVersionUID = 6375919583411830285L;
    public void buy(Player player) {
        System.out.println("<>-----------------------------------------------------------------------------<>");
        System.out.println("                            -----< MythicalCreatures >-----");
        System.out.println("+---------------+---------------+---------------+---------------+---------------+");
        System.out.println("|    Dragon     |   Basilisk    |     Hydra     |    Phoenix    |    Pegasus    |");
        System.out.println("| Price: 120 gc | Price: 165 gc | Price: 205 gc | Price: 275 gc | Price: 340 gc |");
        System.out.println("| Attack:    12 | Attack:    15 | Attack:    12 | Attack:    17 | Attack:    14 |");
        System.out.println("| Defence:   14 | Defence:   11 | Defence:   16 | Defence:   13 | Defence:   18 |");
        System.out.println("| Health:    15 | Health:    10 | Health:    15 | Health:    17 | Health:    20 |");
        System.out.println("| Speed:      8 | Speed:     12 | Speed:     11 | Speed:     19 | Speed:     20 |");
        System.out.println("<>-----< 1 >----------< 2 >-----------< 3 >-----------< 4 >----------< 5 >-----<>");
        Scanner x = new Scanner(System.in);
        System.out.printf(">>> ");
        int input_num = x.nextInt();
        String[] mcArr = { "dragon", "basilisk", "hydra", "phoenix", "pegasus" };
        double currentGc = player.getGc();
        if (player.getMythicalCreature() == null) {

            if (input_num == 1 && currentGc - 120 >= 0) {
                player.setGc(currentGc - 120);
                player.setMythicalCreature(mcArr[input_num - 1]);
                System.out.println("Your new MythicalCreature is ready now...!");
            } else if (input_num == 2 && currentGc - 165 >= 0) {
                player.setGc(currentGc - 165);
                player.setMythicalCreature(mcArr[input_num - 1]);
                System.out.println("Your new MythicalCreature is ready now...!");
            } else if (input_num == 3 && currentGc - 205 >= 0) {
                player.setGc(currentGc - 205);
                player.setMythicalCreature(mcArr[input_num - 1]);
                System.out.println("Your new MythicalCreature is ready now...!");
            } else if (input_num == 4 && currentGc - 275 >= 0) {
                player.setGc(currentGc - 275);
                player.setMythicalCreature(mcArr[input_num - 1]);
                System.out.println("Your new MythicalCreature is ready now...!");
            } else if (input_num == 5 && currentGc - 340 >= 0) {
                player.setGc(currentGc - 340);
                player.setMythicalCreature(mcArr[input_num - 1]);
                System.out.println("Your new MythicalCreature is ready now...!");
            } else if (input_num == 1 || input_num == 2 || input_num == 3 || input_num == 4 || input_num == 5) {
                System.out.println("You don't have enough gold coins to buy this mythical creature.");
            }
        } else {
            System.out.println("MythicalCreature is already exists.");
        }
    }

    public void sell(Player player) {
        double currentGc = player.getGc();
        MythicalCreature currentCharacter = player.getMythicalCreature();
        if (currentCharacter.name == "dragon" && player.getGc() +  120 * 0.9 >= 120) {
            player.setGc(currentGc + 120 * 0.9);
        } else if (currentCharacter.name == "basilisk" && player.getGc() +  165 * 0.9 >= 120) {
            player.setGc(currentGc + 165 * 0.9);
        } else if (currentCharacter.name == "hydra" && player.getGc() +  205 * 0.9 >= 120) {
            player.setGc(currentGc + 205 * 0.9);
        } else if (currentCharacter.name == "phoenix" && player.getGc() +  275 * 0.9 >= 120) {
            player.setGc(currentGc + 275 * 0.9);
        } else if (currentCharacter.name == "pegasus" && player.getGc() +  340 * 0.9 >= 120) {
            player.setGc(currentGc + 340 * 0.9);
        }
        player.setMythicalCreature(null);
        System.out.println(
                String.format(
                        "Your MythicalCreature sold sucessfully.\nYour current gold coin amount = %.1f \n Now you want to buy a new MythicalCreature",
                        player.getGc()));
        MythicalCreature x = new MythicalCreature();
        x.buy(player);
    }
}

class Dragon extends MythicalCreature {
    Dragon() {
        super.name = "dragon";
        super.price = 120;
        super.attack = 12;
        super.defence = 14;
        super.health = 15;
        super.speed = 8;
    }
}

class Basilisk extends MythicalCreature {
    Basilisk() {
        super.name = "basilisk";
        super.price = 165;
        super.attack = 15;
        super.defence = 11;
        super.health = 10;
        super.speed = 12;
    }
}

class Hydra extends MythicalCreature {
    Hydra() {
        super.name = "hydra";
        super.price = 205;
        super.attack = 12;
        super.defence = 16;
        super.health = 15;
        super.speed = 11;
    }
}

class Phoenix extends MythicalCreature {
    Phoenix() {
        super.name = "phoenix";
        super.price = 275;
        super.attack = 17;
        super.defence = 13;
        super.health = 17;
        super.speed = 19;
    }
}

class Pegasus extends MythicalCreature {
    Pegasus() {
        super.name = "pegasus";
        super.price = 340;
        super.attack = 14;
        super.defence = 18;
        super.health = 20;
        super.speed= 20;
    }
}