import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
        shuffle();
    }

    private void initializeDeck() {
        // Pokémon Cards

        for (int i = 0; i < 3; i++) {
            PokemonCard pikachu = new PokemonCard("Pikachu", 60, "Electric", 20, "pikachu.png");
            PokemonCard charmander = new Charmander();
            PokemonCard mewtwo = new Charmander();
            PokemonCard golem = new Charmander();

            cards.add(charmander);
            cards.add(charmander);
            cards.add(charmander);

//            cards.add(charmander);
//            cards.add(mewtwo);
//            cards.add(golem);

            // Trainer Cards
            cards.add(new TrainerCard("Potion"));
            cards.add(new TrainerCard("Professor Oak"));
            cards.add(new TrainerCard("Full Heal"));


            // Energy Cards (Each Type Has Unique Effects)
            cards.add(new EnergyCard("Fire Energy", "Fire", 2, 0));  // Boosts Energy by 2
            cards.add(new EnergyCard("Electric Energy", "Electric", 1, 0));  // Boosts Energy by 1, HP by 10
            cards.add(new EnergyCard("Psychic Energy", "Psychic", 3, 0));  // Boosts Energy by 3
        }
    }


    public void shuffle() {
        Collections.shuffle(cards);
        initializeDeck();
    }

    public Card drawCard() {
        return cards.isEmpty() ? null : cards.remove(0);
    }

    public int getDeckSize() {
        return cards.size();
    }
}
