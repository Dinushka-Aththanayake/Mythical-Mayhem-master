import java.io.Serial;
import java.io.Serializable;

public class Trop implements Serializable{
    @Serial
    private static final long serialVersionUID = 6375919583411830285L;
    String name;
    double price;
    int attack;
    int defence;
    double health;
    int speed;
    String armour;
    String artefact;
}
