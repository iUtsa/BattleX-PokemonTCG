import javax.swing.*;
import java.util.*;

public class PokemonCard extends Card {
    private int hp,energy;

    private String type;
    private int attackDamage;
    private String imagePath;
    private String statusEffect; // Added this missing attribute

    public PokemonCard(String name, int hp, String type, int attackDamage, String imagePath) {
        super(name);
        this.hp = hp;
        this.energy = 0;
        this.type = type;
        this.attackDamage = attackDamage; //Remove this later on
        this.imagePath = imagePath;
        this.statusEffect = "None"; //  Default status effect
    }

    public void takeDamage(int damage) {
        System.out.println(name + " was hit for " + damage + " damage!");

        this.hp -= damage; // ✅ Ensure HP decreases instead of increasing

        if (this.hp < 0) {
            this.hp = 0; // Prevent negative HP
        }

        System.out.println(name + " now has " + this.hp + " HP left.");
    }








    public int getHp() {
        return hp;
    }
    public int getEnergy(){return energy; }

    public void minusEnergy(int n) {
        this.energy -= n;
        if (this.energy < 0) {
            this.energy = 0;  // ✅ Ensure Energy never goes negative
        }
    }


    public void heal(int num){hp += num;}

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setStatusEffect(String effect) {
        this.statusEffect = effect;
        System.out.println(name + " is now " + effect + "!");
    }

    public void applyStatusEffect() {
        if (statusEffect.equals("Paralyze")) {
            System.out.println(name + " is paralyzed and cannot attack this turn!");
        } else if (statusEffect.equals("Burn")) {
            hp -= 10;
            System.out.println(name + " is burned and takes 10 damage!");
        } else if (statusEffect.equals("Sleep")) {
            if (new Random().nextBoolean()) {
                System.out.println(name + " woke up!");
                statusEffect = "None";
            } else {
                System.out.println(name + " is still asleep and cannot attack.");
            }
        }
    }

    public void addEnergy(EnergyCard energy) {
        this.energy += energy.getEnergyBoost();  // Increase Energy
        this.hp += energy.getHpBoost();  // Increase HP (if applicable)

        // Ensure HP does not exceed max HP
        if (this.hp > 100) {
            this.hp = 100;
        }

        System.out.println(name + " received " + energy.getName() + "! Energy: " + this.energy + ", HP: " + this.hp);
    }




    public void attack(PokemonCard opponent) {
        if (statusEffect.equals("Paralyze") || statusEffect.equals("Sleep")) {
            System.out.println(name + " cannot attack due to status effect!");
            return;
        }

        int finalDamage = this.attackDamage;  // Get the attack damage amount

        System.out.println(name + " is attacking " + opponent.getName() + " with " + finalDamage + " damage!");

        opponent.takeDamage(finalDamage);  // ✅ Apply the correct damage

        System.out.println(opponent.getName() + " now has " + opponent.getHp() + " HP left.");
    }




    public ImageIcon getImageIcon() {
        return new ImageIcon(getClass().getResource("/assets/" + imagePath));
    }
}
