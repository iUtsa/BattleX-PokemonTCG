import java.util.*;
import javax.swing.*;

public class Charmander extends PokemonCard {
    private Attack flamethrower;
    private Attack fireBlast;

    public Charmander() {
        super("Charmander", 60, "Fire", 12, "charmander.png");
        this.flamethrower = new Attack("Flamethrower", 30);
        this.fireBlast = new Attack("Fire Blast", 35);
    }

    public void useFlamethrower(PokemonCard opponent) {
        if (getEnergy() >= 1) {
            int damageDealt = flamethrower.getDamage(); // ✅ Get correct damage
            flamethrower.performAttack(this, opponent);
            opponent.takeDamage(damageDealt); // ✅ Ensure HP is reduced properly

            this.minusEnergy(1); // ✅ Reduce energy only if attack is performed
        } else {
            JOptionPane.showMessageDialog(null, this.getName() + " does not have enough Energy to use Flamethrower!",
                    "Energy Required", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void useFireBlast(PokemonCard opponent) {
        if (getEnergy() >= 2) {
            int damageDealt = fireBlast.getDamage(); // ✅ Get correct damage
            fireBlast.performAttack(this, opponent);
            opponent.takeDamage(damageDealt); // ✅ Ensure HP is reduced properly

            this.minusEnergy(2); // ✅ Reduce energy only if attack is performed
        } else {
            JOptionPane.showMessageDialog(null, this.getName() + " does not have enough Energy to use Fire Blast!",
                    "Energy Required", JOptionPane.WARNING_MESSAGE);
        }
    }

}
