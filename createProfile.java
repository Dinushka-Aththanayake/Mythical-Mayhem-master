import java.util.ArrayList;
import java.io.*;

public class createProfile implements Serializable {
    public static void main(String[] args) {
        // ArrayList<Player> playerArr = new ArrayList<>();
        Player[] arr = new Player[8];
        Player a = new Player("Dinushka", "Dinuuu", 1, 1000, "Desert");
        MarketPlace a_base = new MarketPlace();
        a_base.buyArcher(a);
        a_base.buyKnight(a);
        a_base.buyMage(a);
        a_base.buyHealer(a);
        a_base.buyMythicalCreature(a);
        arr[0] = a;
        // ----------
        Player b = new Player("Kasun", "Kasuuu", 2, 2000, "Arcane");
        MarketPlace b_base = new MarketPlace();
        b_base.buyArcher(b);
        b_base.buyKnight(b);
        b_base.buyMage(b);
        b_base.buyHealer(b);
        b_base.buyMythicalCreature(b);
        arr[1] = b;
        // ---------
        Player c = new Player("Eshin", "Eshinnn", 3, 2500, "Hillcrest");
        MarketPlace c_base = new MarketPlace();
        c_base.buyArcher(c);
        c_base.buyKnight(c);
        c_base.buyMage(c);
        c_base.buyHealer(c);
        c_base.buyMythicalCreature(c);
        arr[2] = c;
        // -----------

        /*
         * Player d = new Player("bhanuka", "bhanuuu", 4, 3000, "Marshland");
         * MarketPlace d_base = new MarketPlace();
         * d_base.buyArcher(d);
         * d_base.buyKnight(d);
         * d_base.buyMage(d);
         * d_base.buyHealer(d);
         * d_base.buyMythicalCreature(d);
         * playerArr.add(d);
         * // -------------
         * Player e = new Player("vibhu", "bossss", 5, 3500, "Desert");
         * MarketPlace e_base = new MarketPlace();
         * e_base.buyArcher(e);
         * e_base.buyKnight(e);
         * e_base.buyMage(e);
         * e_base.buyHealer(e);
         * e_base.buyMythicalCreature(e);
         * e_base.buyArmour(e);
         * playerArr.add(e);
         * // -------------
         * Player f = new Player("hiruni", "hiruuu", 6, 4000, "Arcane");
         * MarketPlace f_base = new MarketPlace();
         * f_base.buyArcher(f);
         * f_base.buyKnight(f);
         * f_base.buyMage(f);
         * f_base.buyHealer(f);
         * f_base.buyMythicalCreature(f);
         * f_base.buyArmour(f);
         * f_base.buyArmour(f);
         * playerArr.add(f);
         * // -------------
         * Player g = new Player("amanethmi", "amaaa", 6, 4500, "Hillcrest");
         * MarketPlace g_base = new MarketPlace();
         * g_base.buyArcher(g);
         * g_base.buyKnight(g);
         * g_base.buyMage(g);
         * g_base.buyHealer(g);
         * g_base.buyMythicalCreature(g);
         * g_base.buyArmour(g);
         * g_base.buyArmour(g);
         * g_base.buyArmour(g);
         * playerArr.add(g);
         * // -------------
         * Player h = new Player("himasara", "himaaaaa", 7, 5000, "Marshland");
         * MarketPlace h_base = new MarketPlace();
         * h_base.buyArcher(h);
         * h_base.buyKnight(h);
         * h_base.buyMage(h);
         * h_base.buyHealer(h);
         * h_base.buyMythicalCreature(h);
         * h_base.buyArmour(h);
         * h_base.buyArmour(h);
         * h_base.buyArmour(h);
         * h_base.buyArmour(h);
         * playerArr.add(h);
         */
        Read_Write savefilee = new Read_Write();
        savefilee.writePlayers(arr);
    }

}