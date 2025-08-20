import java.io.Serial;
import java.io.Serializable;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Player implements Serializable {
    static int initialid = 220000;
    @Serial
    private static final long serialVersionUID = 6375919583411830285L;
    private int userId;
    private String name;
    private String username;
    private int xp;
    private double gc;
    private String homeground;
    private Archer archer;
    private Knight knight;
    private Mage mage;
    private Healer healer;
    private MythicalCreature mythicalCreature;
    private boolean called = false;

    // Constructor for new player (auto id, default xp/gc)
    public Player(String name, String username) {
        Read_Write db = new Read_Write();
        Player[] arr = db.readplayerarr();
        int array_lenth = arr.length;
        int initial_id = arr[0].getUserId();
        for (int k = 1; k < array_lenth; k++) {
            if (initial_id < arr[k].getUserId()) {
                initial_id = arr[k].getUserId();
            }
        }
        this.userId = initial_id + 1;
        this.name = name;
        this.username = username;
        this.xp = 0;
        this.gc = 500;
    }

    // Constructor for loading/saving with all fields (used in createProfile)
    public Player(String name, String username, int xp, double gc, String homeground) {
        // Assign a unique userId (could be improved if needed)
        Read_Write db = new Read_Write();
        Player[] arr = db.readplayerarr();
        int array_lenth = arr.length;
        int initial_id = arr[0].getUserId();
        for (int k = 1; k < array_lenth; k++) {
            if (initial_id < arr[k].getUserId()) {
                initial_id = arr[k].getUserId();
            }
        }
        this.userId = initial_id + 1;
        this.name = name;
        this.username = username;
        this.xp = xp;
        this.gc = gc;
        this.homeground = homeground;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public int getXp() {
        return xp;
    }

    protected void setxp() {
        this.xp = xp + 1;
    }

    public double getGc() {
        return gc;
    }

    protected void setGc(double newGc) {
        this.gc = newGc;
    }

    public String getHomeground() {
        return homeground;
    }

    public Archer getArcher() {
        return archer;
    }

    public void setArcher(String archerType) {
        switch (archerType) {
            case "shooter":
                this.archer = new Shooter();
                break;
            case "ranger":
                this.archer = new Ranger();
                break;
            case "sunfire":
                this.archer = new Sunfire();
                break;

            case "zing":
                this.archer = new Zing();
                break;
            case "saggitarius":
                this.archer = new Saggitarius();
                break;
            case "null":
                this.archer = null;
                break;
        }
    }

    public Knight getKnight() {
        return knight;
    }

    public void setKnight(String knightType) {
        switch (knightType) {
            case "squire":
                this.knight = new Squire();
                break;
            case "cavalier":
                this.knight = new Cavalier();
                break;
            case "templar":
                this.knight = new Templar();
                break;
            case "zoro":
                this.knight = new Zoro();
                break;
            case "swiftblade":
                this.knight = new Swiftblade();
                break;
            case "null":
                this.knight = null;
                break;
        }
    }

    public Mage getMage() {
        return mage;
    }

    public void setMage(String mageType) {
        switch (mageType) {
            case "warlock":
                this.mage = new Warlock();
                break;
            case "illusionist":
                this.mage = new IIIusionist();
                break;
            case "enchanter":
                this.mage = new Enchanter();
                break;

            case "conjurer":
                this.mage = new Conjurer();
                break;
            case "eldritch":
                this.mage = new Eldritch();
                break;
            case "null":
                this.mage = null;
                break;
        }
    }

    public Healer getHealer() {
        return healer;
    }

    public void setHealer(String healerType) {
        switch (healerType) {
            case "soother":
                this.healer = new Soother();
                break;
            case "medic":
                this.healer = new Medic();
                break;
            case "alchemist":
                this.healer = new Alchemist();
                break;

            case "saint":
                this.healer = new Saint();
                break;
            case "lightbringer":
                this.healer = new Lightbringer();
                break;
            case "null":
                this.healer = null;
                break;
        }
    }

    public MythicalCreature getMythicalCreature() {
        return mythicalCreature;
    }

    public void setMythicalCreature(String mythicalCreaturesType) {
        switch (mythicalCreaturesType) {
            case "dragon":
                this.mythicalCreature = new Dragon();
                break;
            case "basilisk":
                this.mythicalCreature = new Basilisk();
                break;

            case "hydra":
                this.mythicalCreature = new Hydra();
                break;
            case "phoenix":
                this.mythicalCreature = new Phoenix();
                break;
            case "pegasus":
                this.mythicalCreature = new Pegasus();
                break;
            case "null":
                this.mythicalCreature = null;
                break;
        }
    }

    public void setHomeGround() {
        if (!called) {
            Scanner x = new Scanner(System.in);
            this.homeground = x.nextLine();
            called = true;
        } else {
            System.out.println("Alredy set the homeground");
        }
    }

    public Player change(Player Profile, String place) {
        if (place == "Hillcreast") {
            if (Profile.getArcher().name == "shooter" || Profile.getArcher().name == "ranger") {
                Profile.getArcher().attack++;
                Profile.getArcher().defence++;
            }
            if (Profile.getArcher().name == "sunfire" || Profile.getArcher().name == "zing") {
                Profile.getArcher().speed--;
            }
            if (Profile.getKnight().name == "cavalier" || Profile.getKnight().name == "zoro") {
                Profile.getKnight().attack++;
                Profile.getKnight().defence++;
            }
            if (Profile.getKnight().name == "squire" || Profile.getKnight().name == "swiftblade"
                    || Profile.getKnight().name == "templar") {
                Profile.getKnight().speed--;
            }
            if (Profile.getMage().name == "enchanter" || Profile.getMage().name == "conjurer") {
                Profile.getMage().attack++;
                Profile.getMage().defence++;
            }
            if (Profile.getMage().name == "warlock") {
                Profile.getMage().speed--;
            }
            if (Profile.getHealer().name == "medic") {
                Profile.getHealer().attack++;
                Profile.getHealer().defence++;
            }
            if (Profile.getHealer().name == "soother" || Profile.getHealer().name == "lightbringer") {
                Profile.getHealer().speed--;
            }
        } else if (place == "Marshland") {
            if (Profile.getKnight().name == "squire" || Profile.getKnight().name == "swiftblade") {
                Profile.getKnight().defence += 2;
            }
            if (Profile.getArcher().name == "sunfire" || Profile.getArcher().name == "zing"
                    || Profile.getArcher().name == "saggitarius") {
                Profile.getArcher().speed--;
            }
            if (Profile.getMage().name == "warlock") {
                Profile.getMage().attack += 2;
            }
            if (Profile.getMage().name == "illusionist" || Profile.getMage().name == "eldritch") {
                Profile.getMage().speed--;
            }
            if (Profile.getHealer().name == "alchemist") {
                Profile.getHealer().attack += 2;
            }
            if (Profile.getHealer().name == "soother" || Profile.getHealer().name == "lightbringer"
                    || Profile.getHealer().name == "saint") {
                Profile.getHealer().speed--;
            }
            if (Profile.getMythicalCreature().name == "basilisk" || Profile.getMythicalCreature().name == "hydra") {
                Profile.getMythicalCreature().attack += 2;
            }
            if (Profile.getMythicalCreature().name == "dragon" || Profile.getMythicalCreature().name == "phoenix"
                    || Profile.getMythicalCreature().name == "pegasus") {
                Profile.getMythicalCreature().speed--;
            }

        } else if (place == "Desert") {
            if (Profile.getArcher().name == "sunfire" || Profile.getArcher().name == "zing") {
                Profile.getArcher().attack++;
            }
            if (Profile.getKnight().name == "templar") {
                Profile.getArcher().attack++;
            }
            if (Profile.getKnight().name == "squire" || Profile.getKnight().name == "swiftblade") {
                Profile.getKnight().health--;
            }
            if (Profile.getHealer().name == "soother" || Profile.getHealer().name == "lightbringer") {
                Profile.getHealer().attack++;
            }
            if (Profile.getHealer().name == "alchemist") {
                Profile.getHealer().health--;
            }
            if (Profile.getMythicalCreature().name == "dragon" || Profile.getMythicalCreature().name == "phoenix") {
                Profile.getMythicalCreature().attack++;
            }
            if (Profile.getMythicalCreature().name == "basilisk" || Profile.getMythicalCreature().name == "hydra") {
                Profile.getMythicalCreature().health--;
            }

        } else if (place == "Arcane") {
            if (Profile.getArcher().name == "saggitarius") {
                Profile.getArcher().attack += 2;
            }
            if (Profile.getArcher().name == "shooter" || Profile.getArcher().name == "ranger") {
                Profile.getArcher().speed--;
                Profile.getArcher().defence--;
            }
            if (Profile.getKnight().name != "templar") {
                Profile.getKnight().speed--;
                Profile.getKnight().defence--;
            }
            if (Profile.getMage().name == "illusionist" || Profile.getMage().name == "eldritch") {
                Profile.getMage().attack += 2;
            }
            if (Profile.getMage().name == "warlock" || Profile.getMage().name == "enchanter"
                    || Profile.getMage().name == "conjurer") {
                Profile.getMage().speed--;
                Profile.getMage().defence--;
            }
            if (Profile.getHealer().name == "saint") {
                Profile.getHealer().attack += 2;
            }
            if (Profile.getHealer().name == "medic" || Profile.getHealer().name == "alchemist") {
                Profile.getHealer().speed--;
                Profile.getHealer().defence--;
            }
            if (Profile.getMythicalCreature().name == "pegasus") {
                Profile.getMythicalCreature().attack += 2;
            }
            if (Profile.getMythicalCreature().name == "basilisk" || Profile.getMythicalCreature().name == "hydra") {
                Profile.getMythicalCreature().speed--;
                Profile.getMythicalCreature().defence--;
            }

        }
        return Profile;
    }

    public Trop[] Setarmy(Player Profile) {
        // System.out.println(Profile.getName());
        HashMap<Trop, Integer> mapName = new HashMap<>();
        mapName.put(Profile.getArcher(), 1);
        mapName.put(Profile.getKnight(), 2);
        mapName.put(Profile.getMythicalCreature(), 3);
        mapName.put(Profile.getMage(), 4);
        mapName.put(Profile.getHealer(), 5);
        Trop[] player_army = { Profile.getArcher(), Profile.getKnight(), Profile.getMage(), Profile.getHealer(),
                Profile.getMythicalCreature() };
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                if (player_army[j].speed < player_army[j + 1].speed) {
                    Trop temp = player_army[j];
                    player_army[j] = player_army[j + 1];
                    player_army[j + 1] = temp;
                } else if (player_army[j].speed == player_army[j + 1].speed) {
                    if (mapName.get(player_army[j]) > mapName.get(player_army[j + 1])) {
                        Trop temp = player_army[j];
                        player_army[j] = player_army[j + 1];
                        player_army[j + 1] = temp;
                    }
                }
            }
        }
        return player_army; // For example, returning the same array for demonstration
    }

    public Trop[] setdef(Player Profile) {
        HashMap<Trop, Integer> mapName = new HashMap<>();
        mapName.put(Profile.getArcher(), 3);
        mapName.put(Profile.getKnight(), 4);
        mapName.put(Profile.getMythicalCreature(), 2);
        mapName.put(Profile.getMage(), 5);
        mapName.put(Profile.getHealer(), 1);
        Trop[] player_def = { Profile.getArcher(), Profile.getKnight(), Profile.getMage(), Profile.getHealer(),
                Profile.getMythicalCreature() };
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                if (player_def[j].defence > player_def[j + 1].defence) {
                    Trop temp = player_def[j];
                    player_def[j] = player_def[j + 1];
                    player_def[j + 1] = temp;
                } else if (player_def[j].defence == player_def[j + 1].defence) {
                    if (mapName.get(player_def[j]) > mapName.get(player_def[j + 1])) {
                        Trop temp = player_def[j];
                        player_def[j] = player_def[j + 1];
                        player_def[j + 1] = temp;
                    }
                }
            }
        }
        return player_def;
    }

    public void goBattale(Player Profile_1, Player Profile_2, String place, ArrayList<Player> profilelist) {

        Profile_1 = change(Profile_1, place);
        Profile_2 = change(Profile_2, place);
        //
        Trop[] Profile_1_army = Setarmy(Profile_1);
        Trop[] Profile_2_army = Setarmy(Profile_2);
        Trop[] Profile_1_def = setdef(Profile_1);
        Trop[] Profile_2_def = setdef(Profile_2);
        double[] life_1 = new double[5];
        double[] life_2 = new double[5];
        for (int i = 0; i < 5; i++) {
            life_1[i] = Profile_1_army[i].health;
            life_2[i] = Profile_2_army[i].health;
        }
        int Player_1_attack_turn = 0;
        int Player_1_def_turn = 0;
        int Player_2_attack_turn = 0;
        int Player_2_def_turn = 0;
        Trop current_Attacker = Profile_1_army[Player_1_attack_turn];
        Trop current_def = Profile_2_def[Player_2_def_turn];
        Player chance = Profile_1;
        int turn = 0;
        System.out.println("--------Battle is Begining--------");
        if (place == "Hillcrest") {
            while (true) {
                if (turn > 20) {
                    break;
                } else if (Player_1_attack_turn > 4 || Player_2_attack_turn > 4 || Player_1_def_turn > 4
                        || Player_2_def_turn > 4) {
                    break;
                } else if (current_Attacker.health == 0) {
                    if (chance == Profile_1) {
                        current_Attacker = Profile_1_army[Player_1_attack_turn++];
                    } else {
                        current_Attacker = Profile_2_army[Player_2_attack_turn++];
                    }
                } else {
                    System.out.println(" ");
                    turn++;
                    if (current_Attacker.name == "medic") {
                        if (chance == Profile_1) {
                            Trop needheal = Profile_1_army[0];
                            for (int i = 1; i < 5; i++) {
                                if (needheal.health > Profile_1_army[i].health && Profile_1_army[i].health > 0) {
                                    needheal = Profile_1_army[i];
                                }
                            }
                            needheal.health = needheal.health + current_Attacker.attack * 0.12;
                            System.out.println(
                                    chance.getName() + "  " + current_Attacker.name + " Heal " + needheal.name);
                            // System.out.println(" ");
                            current_Attacker = Profile_2_army[Player_2_attack_turn];
                            current_def = Profile_1_def[Player_1_def_turn];
                            chance = Profile_2;
                        } else {
                            Trop needheal = Profile_2_army[0];
                            for (int i = 1; i < 5; i++) {
                                if (needheal.health > Profile_2_army[i].health && Profile_2_army[i].health > 0) {
                                    needheal = Profile_2_army[i];
                                }
                            }
                            needheal.health = needheal.health + current_Attacker.attack * 0.12;
                            System.out.println(
                                    chance.getName() + "  " + current_Attacker.name + " Heal " + needheal.name);
                            // System.out.println(" ");
                            current_Attacker = Profile_1_army[Player_1_attack_turn];
                            current_def = Profile_2_def[Player_2_def_turn];
                            chance = Profile_2;
                        }

                    } else if (current_Attacker.name == "alchemist" || current_Attacker.name == "soother"
                            || current_Attacker.name == "lightbringer" || current_Attacker.name == "saint") {
                        if (chance == Profile_1) {
                            Trop needheal = Profile_1_army[0];
                            for (int i = 1; i < 5; i++) {
                                if (Profile_1_army[0].health > Profile_1_army[i].health
                                        && Profile_1_army[i].health > 0) {
                                    needheal = Profile_1_army[i];
                                }
                            }
                            needheal.health = needheal.health + 0.1 * current_Attacker.attack;
                            System.out
                                    .println(chance.getName() + " " + current_Attacker.name + " Heal " + needheal.name);
                            // System.out.println(" ");
                            current_Attacker = Profile_2_army[Player_2_attack_turn];
                            current_def = Profile_1_def[Player_1_def_turn];
                            chance = Profile_2;
                        } else {
                            Trop needheal = Profile_2_army[0];
                            for (int i = 1; i < 5; i++) {
                                if (Profile_2_army[0].health > Profile_2_army[i].health
                                        && Profile_2_army[i].health > 0) {
                                    needheal = Profile_2_army[i];
                                }
                            }
                            needheal.health = needheal.health + 0.1 * current_Attacker.attack;
                            System.out.println(
                                    chance.getName() + "  " + current_Attacker.name + " Heal " + needheal.name);
                            // System.out.println(" ");
                            current_Attacker = Profile_1_army[Player_1_attack_turn];
                            current_def = Profile_2_def[Player_2_def_turn];
                            chance = Profile_1;
                        }
                    } else if (current_Attacker.name == "shooter" || current_Attacker.name == "ranger"
                            || current_Attacker.name == "cavalier" || current_Attacker.name == "zoro"
                            || current_Attacker.name == "enchanter" || current_Attacker.name == "conjurer") {
                        current_def.health = current_def.health
                                - ((0.6 * current_Attacker.attack) - (0.1 * current_def.defence));
                        System.out.println(
                                chance.getName() + "  " + current_Attacker.name + " -----> " + current_def.name);
                        // System.out.println(" ");
                        if (current_def.health <= 0) {
                            current_def.health = 0;
                            // System.out.println(chance.name + " : "+current_def.name+" is Dead");
                            System.out.println(" ");
                        }
                        if (chance == Profile_1) {
                            if (current_def.health == 0) {
                                System.out.println(Profile_2.getName() + "  " + current_def.name + " is Dead");
                                // System.out.println(" ");
                                Player_2_def_turn++;
                                for (int i = 0; i < 5; i++) {
                                    if (current_def.name == Profile_2_army[i].name) {
                                        Profile_2_army[i].health = 0;
                                    }
                                }
                            }
                            current_Attacker = Profile_2_army[Player_2_attack_turn];
                            current_def = Profile_1_def[Player_1_def_turn];
                            chance = Profile_2;
                        } else {
                            if (current_def.health == 0) {
                                System.out.println(Profile_1.getName() + "  " + current_def.name + " is Dead");
                                // System.out.println(" ");
                                Player_1_def_turn++;
                                for (int i = 0; i < 5; i++) {
                                    if (current_def.name == Profile_1_army[i].name) {
                                        Profile_1_army[i].health = 0;
                                    }
                                }
                            }
                            current_Attacker = Profile_1_army[Player_1_attack_turn];
                            current_def = Profile_2_def[Player_2_def_turn];
                            chance = Profile_1;
                        }

                    } else {
                        current_def.health = current_def.health
                                - ((0.5 * current_Attacker.attack) - (0.1 * current_def.defence));
                        System.out.println(
                                chance.getName() + "  " + current_Attacker.name + " -----> " + current_def.name);
                        // System.out.println(" ");
                        if (current_def.health <= 0) {
                            current_def.health = 0;
                            // System.out.println(chance.name + " : "+current_def.name+" is Dead");
                            System.out.println(" ");
                        }
                        if (chance == Profile_1) {
                            if (current_def.health == 0) {
                                System.out.println(Profile_2.getName() + "  " + current_def.name + " is Dead");
                                // System.out.println(" ");
                                Player_2_def_turn++;
                                for (int i = 0; i < 5; i++) {
                                    if (current_def.name == Profile_2_army[i].name) {
                                        Profile_2_army[i].health = 0;
                                    }
                                }
                            }
                            current_Attacker = Profile_2_army[Player_2_attack_turn];
                            current_def = Profile_1_def[Player_1_def_turn];
                            chance = Profile_2;
                        } else {
                            if (current_def.health == 0) {
                                System.out.println(Profile_1.getName() + "  " + current_def.name + " is Dead");
                                // System.out.println(" ");
                                Player_1_def_turn++;
                                for (int i = 0; i < 5; i++) {
                                    if (current_def.name == Profile_1_army[i].name) {
                                        Profile_1_army[i].health = 0;
                                    }
                                }
                            }
                            current_Attacker = Profile_1_army[Player_1_attack_turn];
                            current_def = Profile_2_def[Player_2_def_turn];
                            chance = Profile_1;
                        }
                    }
                }

            }
        } else if (place == "Arcane") {
            while (true) {
                if (turn > 20) {
                    break;
                } else if (Player_1_attack_turn > 4 || Player_2_attack_turn > 4 || Player_1_def_turn > 4
                        || Player_2_def_turn > 4) {
                    break;
                } else if (current_Attacker.health == 0) {
                    if (chance == Profile_1) {
                        current_Attacker = Profile_1_army[Player_1_attack_turn++];
                        turn--;
                    } else {
                        current_Attacker = Profile_2_army[Player_2_attack_turn++];
                        turn--;
                    }
                } else {
                    System.out.println(" ");
                    turn++;
                    if (current_Attacker.name == "medic") {
                        if (chance == Profile_1) {
                            Trop needheal = Profile_1_army[0];
                            for (int i = 1; i < 5; i++) {
                                if (needheal.health > Profile_1_army[i].health && Profile_1_army[i].health > 0) {
                                    needheal = Profile_1_army[i];
                                }
                            }
                            needheal.health = needheal.health + current_Attacker.attack * 0.12;
                            System.out.println(
                                    chance.getName() + "  " + current_Attacker.name + " Heal " + needheal.name);
                            current_Attacker = Profile_2_army[Player_2_attack_turn];
                            current_def = Profile_1_def[Player_1_def_turn];
                            chance = Profile_2;
                        } else {
                            Trop needheal = Profile_2_army[0];
                            for (int i = 1; i < 5; i++) {
                                if (needheal.health > Profile_2_army[i].health && Profile_2_army[i].health > 0) {
                                    needheal = Profile_2_army[i];
                                }
                            }
                            needheal.health = needheal.health + current_Attacker.attack * 0.12;
                            System.out.println(
                                    chance.getName() + "  " + current_Attacker.name + " Heal " + needheal.name);
                            current_Attacker = Profile_1_army[Player_1_attack_turn];
                            current_def = Profile_2_def[Player_2_def_turn];
                            chance = Profile_2;
                        }

                    } else if (current_Attacker.name == "alchemist" || current_Attacker.name == "soother"
                            || current_Attacker.name == "lightbringer" || current_Attacker.name == "saint") {
                        if (chance == Profile_1) {
                            Trop needheal = Profile_1_army[0];
                            for (int i = 1; i < 5; i++) {
                                if (Profile_1_army[0].health > Profile_1_army[i].health
                                        && Profile_1_army[i].health > 0) {
                                    needheal = Profile_1_army[i];
                                }
                            }
                            needheal.health = needheal.health + 0.1 * current_Attacker.attack;
                            System.out
                                    .println(chance.getName() + " " + current_Attacker.name + " Heal " + needheal.name);
                            current_Attacker = Profile_2_army[Player_2_attack_turn];
                            current_def = Profile_1_def[Player_1_def_turn];
                            chance = Profile_2;
                        } else {
                            Trop needheal = Profile_2_army[0];
                            for (int i = 1; i < 5; i++) {
                                if (Profile_2_army[0].health > Profile_2_army[i].health
                                        && Profile_2_army[i].health > 0) {
                                    needheal = Profile_2_army[i];
                                }
                            }
                            needheal.health = needheal.health + 0.1 * current_Attacker.attack;
                            System.out.println(
                                    chance.getName() + "  " + current_Attacker.name + " Heal " + needheal.name);
                            current_Attacker = Profile_1_army[Player_1_attack_turn];
                            current_def = Profile_2_def[Player_2_def_turn];
                            chance = Profile_1;
                        }
                    } else if (current_Attacker.name == "shooter" || current_Attacker.name == "ranger"
                            || current_Attacker.name == "cavalier" || current_Attacker.name == "zoro"
                            || current_Attacker.name == "enchanter" || current_Attacker.name == "conjurer") {
                        current_def.health = current_def.health
                                - ((0.6 * current_Attacker.attack) - (0.1 * current_def.defence));
                        System.out.println(
                                chance.getName() + "  " + current_Attacker.name + " -----> " + current_def.name);
                        // System.out.println("");
                        if (current_def.health <= 0) {
                            current_def.health = 0;
                            System.out.println(" ");
                        }
                        if (chance == Profile_1) {
                            if (current_def.health == 0) {
                                System.out.println(Profile_2.getName() + "  " + current_def.name + " is Dead");
                                Player_2_def_turn++;
                                for (int i = 0; i < 5; i++) {
                                    if (current_def.name == Profile_2_army[i].name) {
                                        Profile_2_army[i].health = 0;
                                    }
                                }
                            }
                            current_Attacker = Profile_2_army[Player_2_attack_turn];
                            current_def = Profile_1_def[Player_1_def_turn];
                            chance = Profile_2;
                        } else {
                            if (current_def.health == 0) {
                                System.out.println(Profile_1.getName() + "  " + current_def.name + " is Dead");
                                Player_1_def_turn++;
                                for (int i = 0; i < 5; i++) {
                                    if (current_def.name == Profile_1_army[i].name) {
                                        Profile_1_army[i].health = 0;
                                    }
                                }
                            }
                            current_Attacker = Profile_1_army[Player_1_attack_turn];
                            current_def = Profile_2_def[Player_2_def_turn];
                            chance = Profile_1;
                        }

                    } else {
                        current_def.health = current_def.health
                                - ((0.5 * current_Attacker.attack) - (0.1 * current_def.defence));
                        System.out.println(
                                chance.getName() + "  " + current_Attacker.name + " -----> " + current_def.name);
                        if (current_def.health <= 0) {
                            current_def.health = 0;
                            System.out.println(" ");
                        }
                        if (chance == Profile_1) {
                            if (current_def.health == 0) {
                                System.out.println(Profile_2.getName() + "  " + current_def.name + " is Dead");
                                Player_2_def_turn++;
                                for (int i = 0; i < 5; i++) {
                                    if (current_def.name == Profile_2_army[i].name) {
                                        Profile_2_army[i].health = 0;
                                    }
                                }
                            }
                            current_Attacker = Profile_2_army[Player_2_attack_turn];
                            current_def = Profile_1_def[Player_1_def_turn];
                            chance = Profile_2;
                        } else {
                            if (current_def.health == 0) {
                                System.out.println(Profile_1.getName() + "  " + current_def.name + " is Dead");
                                Player_1_def_turn++;
                                for (int i = 0; i < 5; i++) {
                                    if (current_def.name == Profile_1_army[i].name) {
                                        Profile_1_army[i].health = 0;
                                    }
                                }
                            }
                            current_Attacker = Profile_1_army[Player_1_attack_turn];
                            current_def = Profile_2_def[Player_2_def_turn];
                            chance = Profile_1;
                        }
                    }
                }

            }
        } else {
            while (true) {
                if (turn > 20) {
                    break;
                } else if (Player_1_attack_turn > 4 || Player_2_attack_turn > 4 || Player_1_def_turn > 4
                        || Player_2_def_turn > 4) {
                    break;
                } else if (current_Attacker.health == 0) {
                    if (chance == Profile_1) {
                        current_Attacker = Profile_1_army[Player_1_attack_turn++];
                        turn--;
                    } else {
                        current_Attacker = Profile_2_army[Player_2_attack_turn++];
                        turn--;
                    }
                } else {
                    System.out.println(" ");
                    turn++;
                    if (current_Attacker.name == "medic" || current_Attacker.name == "alchemist"
                            || current_Attacker.name == "soother" || current_Attacker.name == "lightbringer"
                            || current_Attacker.name == "saint") {
                        if (chance == Profile_1) {
                            Trop needheal = Profile_1_army[0];
                            for (int i = 1; i < 5; i++) {
                                if (Profile_1_army[0].health > Profile_1_army[i].health
                                        && Profile_1_army[i].health > 0) {
                                    needheal = Profile_1_army[i];
                                }
                            }
                            needheal.health = needheal.health + 0.1 * current_Attacker.attack;
                            System.out.println(
                                    Profile_1.getName() + "  " + current_Attacker.name + " Heal " + needheal.name);
                            current_Attacker = Profile_2_army[Player_2_attack_turn];
                            current_def = Profile_1_def[Player_1_def_turn];
                            chance = Profile_2;
                        } else {
                            Trop needheal = Profile_2_army[0];
                            for (int i = 1; i < 5; i++) {
                                if (Profile_2_army[0].health > Profile_2_army[i].health
                                        && Profile_2_army[i].health > 0) {
                                    needheal = Profile_2_army[i];
                                }
                            }
                            needheal.health = needheal.health + 0.1 * current_Attacker.attack;
                            System.out.println(
                                    Profile_1.getName() + "  " + current_Attacker.name + " Heal " + needheal.name);
                            current_Attacker = Profile_1_army[Player_1_attack_turn];
                            current_def = Profile_2_def[Player_2_def_turn];
                            chance = Profile_1;
                        }
                    } else {
                        current_def.health = current_def.health
                                - ((0.5 * current_Attacker.attack) - (0.1 * current_def.defence));
                        System.out.println(
                                chance.getName() + "  " + current_Attacker.name + " -----> " + current_def.name);
                        if (current_def.health <= 0) {
                            System.out.println(" ");
                            current_def.health = 0;
                        }
                        if (chance == Profile_1) {
                            if (current_def.health == 0) {
                                System.out.println(Profile_2.getName() + "  " + current_def.name + " is Dead");
                                Player_2_def_turn++;
                                for (int i = 0; i < 5; i++) {
                                    if (current_def.name == Profile_2_army[i].name) {
                                        Profile_2_army[i].health = 0;
                                    }
                                }
                            }
                            current_Attacker = Profile_2_army[Player_2_attack_turn];
                            current_def = Profile_1_def[Player_1_def_turn];
                            chance = Profile_2;
                        } else {
                            if (current_def.health == 0) {
                                System.out.println(Profile_1.getName() + "  " + current_def.name + " is Dead");
                                Player_1_def_turn++;
                                for (int i = 0; i < 5; i++) {
                                    if (current_def.name == Profile_1_army[i].name) {
                                        Profile_1_army[i].health = 0;
                                    }
                                }
                            }
                            current_Attacker = Profile_1_army[Player_1_attack_turn];
                            current_def = Profile_2_def[Player_2_def_turn];
                            chance = Profile_1;
                        }
                    }
                }

            }
        }

        System.out.println("<>------- End of the Battle ------<>");
        double a = 0;
        for (Trop i : Profile_1_army) {
            if (i.health > 0) {
                a = a + i.health;
            }
        }
        double b = 0;
        for (Trop j : Profile_2_army) {
            if (j.health > 0) {
                b = b + j.health;
            }
        }
        if (a != 0 && b != 0) {
            System.out.println("<>---------- Draw ----------<>");
            for (int j = 0; j < 5; j++) {
                Profile_1_army[j].health = life_1[j];
                Profile_2_army[j].health = life_2[j];
            }
        } else if (a > 0 && b == 0) {
            System.out.println("<>---------- Victory!!! ----------<>");
            Profile_1.setxp();
            double temp = Profile_2.getGc();
            double loot = Profile_1.getGc() + temp * 0.1;
            Profile_1.setGc(loot);
            double loss_loot = temp * 0.9;
            Profile_2.setGc(loss_loot);
            for (int j = 0; j < 5; j++) {
                Profile_1_army[j].health = life_1[j];
                Profile_2_army[j].health = life_2[j];
            }
        } else if (a == 0 && b > 0) {
            System.out.println("<>---------- Defeat!!! ----------<>");
            Profile_2.setxp();
            double temp = Profile_1.getGc();
            double loot = Profile_2.getGc() + temp * 0.1;
            Profile_2.setGc(loot);
            double loss_loot = temp * 0.9;
            Profile_1.setGc(loss_loot);
            for (int j = 0; j < 5; j++) {
                Profile_1_army[j].health = life_1[j];
                Profile_2_army[j].health = life_2[j];
            }
        }

        profilelist.add(Profile_1);
        profilelist.add(Profile_2);

        Read_Write final_save = new Read_Write();
        int n = profilelist.size();
        ArrayList<Player> array_prof = new ArrayList<>();
        // Player[] array_prof = new Player[n];
        for (int z = 0; z < n; z++) {
            array_prof.add(profilelist.get(z));
        }
        final_save.writeplayer(array_prof);

    }

    public void readyAttack(Player currentplayer, Player[] profilearr) {
        ArrayList<Player> profileList = new ArrayList<>();
        Collections.addAll(profileList, profilearr);
        int length = profileList.size();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select home ground for battle,");
        System.out.println("   *- Hillcrest ---< 1 >");
        System.out.println("   *- Marshland ---< 2 >");
        System.out.println("   *- Desert ------< 3 >");
        System.out.println("   *- Arcane ------< 4 >");
        int homenum = scanner.nextInt();
        String place = "";
        switch (homenum) {
            case 1:
                place = "Hillcrest";
                break;
            case 2:
                place = "Marshland";
                break;
            case 3:
                place = "Desert";
                break;
            case 4:
                place = "Arcane";
                break;
        }

        for (int i = 0; i < length; i++) {
            Player player_1 = profileList.get(i);
            if (player_1.getUsername().equals(currentplayer.getUsername())) {
                profileList.remove(i);
                continue;
            }
            System.out.println("select your opponent to press 1 otherwise skip");
            System.out.println("Player name: " + player_1.getName());
            System.out.println("Player xp: " + player_1.getXp());
            int num = scanner.nextInt();
            if (num == 1) {
                profileList.remove(i);
                goBattale(currentplayer, player_1, place, profileList);

                break; // Exit the loop if attack is initiated
            }
        }
        scanner.close(); // Closing the scanner to prevent resource leak
    }
}
