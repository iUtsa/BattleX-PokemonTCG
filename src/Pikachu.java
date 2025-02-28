import javax.swing.*;

public class Pikachu extends PokemonCard {
    private Attack thunderShock;
    private Attack thunderBall;

    public Pikachu() {
        super("Pikachu", 60, "Electric", 20, "pikachu.png");
        this.thunderShock = new Attack("Thunder Shock", 25);
        this.thunderBall = new Attack("Thunder Balls", 30);

    }

    public void useAttack(PokemonCard opponent) {
        if (getEnergy() >= 1) {
            thunderShock.performAttack(this, opponent);

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
            thunderBall.performAttack(this, opponent);

            // 10% chance to Paralyze the opponent
            if (Math.random() < 0.1) {
                opponent.setStatusEffect("Paralyze");
                System.out.println(opponent.getName() + " is now Paralyzed!");
            }

            this.minusEnergy(2);
        }
    }
}
