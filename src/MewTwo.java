import java.util.*;
import javax.swing.*;
public class MewTwo extends PokemonCard {
    private Attack ancientPower;
    private Attack psycStrike;

    public MewTwo() {
        super("MewTwo", 100, "Psychic", 35, "mewtwo.png");
        this.ancientPower = new Attack("Ancient Power", 50);
        this.psycStrike = new Attack("Psycstrike", 45);

    }

    public void useAttack(PokemonCard opponent) {
        if (getEnergy() >= 1) {
            ancientPower.performAttack(this, opponent);

            //  10% chance to Paralyze the opponent
            if (Math.random() < 0.1) {
                opponent.setStatusEffect("Paralyze");
                System.out.println(opponent.getName() + " is now Paralyzed!");
            }
            this.minusEnergy(1);
        }
    }

    public void useAttack2(PokemonCard opponent) {
        if (getEnergy() >= 2) {
            psycStrike.performAttack(this, opponent);

            //  10% chance to Paralyze the opponent
            if (Math.random() < 0.1) {
                opponent.setStatusEffect("Paralyze");
                System.out.println(opponent.getName() + " is now Paralyzed!");
            }

            this.minusEnergy(2);
        }
    }
}
