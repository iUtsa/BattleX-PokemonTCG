import java.util.*;
import javax.swing.*;

public class Golem extends PokemonCard {
    private Attack earthQuake;
    private Attack stoneEdge;

    public Golem() {
        super("Golem", 88, "Rock", 30, "rock.png");
        this.earthQuake = new Attack("Earthquake", 20);
        this.stoneEdge = new Attack("Stone Edge", 30);
    }

    public void useEarthquake(PokemonCard opponent) {
        if (getEnergy() >= 1) {
            int damageDealt = earthQuake.getDamage(); // ✅ Get correct damage
            earthQuake.performAttack(this, opponent);
            opponent.takeDamage(damageDealt); // ✅ Ensure HP is reduced

            JOptionPane.showMessageDialog(null, opponent.getName() + " took " + damageDealt + " damage from Earthquake!",
                    "Earthquake Attack", JOptionPane.INFORMATION_MESSAGE);

            this.minusEnergy(1); // ✅ Reduce energy only if attack is performed
        } else {
            JOptionPane.showMessageDialog(null, this.getName() + " does not have enough Energy to use Earthquake!",
                    "Energy Required", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void useStoneEdge(PokemonCard opponent) {
        if (getEnergy() >= 2) {
            int damageDealt = stoneEdge.getDamage(); // ✅ Get correct damage
            stoneEdge.performAttack(this, opponent);
            opponent.takeDamage(damageDealt); // ✅ Ensure HP is reduced

            // ✅ 10% chance to cause **Paralyze**
            if (Math.random() < 0.1) {
                opponent.setStatusEffect("Paralyze");
                JOptionPane.showMessageDialog(null, opponent.getName() + " is now Paralyzed!",
                        "Paralyze Effect", JOptionPane.INFORMATION_MESSAGE);
            }

            JOptionPane.showMessageDialog(null, opponent.getName() + " took " + damageDealt + " damage from Stone Edge!",
                    "Stone Edge Attack", JOptionPane.INFORMATION_MESSAGE);

            this.minusEnergy(2); // ✅ Reduce energy only if attack is performed
        } else {
            JOptionPane.showMessageDialog(null, this.getName() + " does not have enough Energy to use Stone Edge!",
                    "Energy Required", JOptionPane.WARNING_MESSAGE);
        }
    }
}
