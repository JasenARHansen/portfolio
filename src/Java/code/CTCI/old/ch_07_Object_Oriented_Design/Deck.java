package Java.code.ctci.old.ch_07_Object_Oriented_Design;

import Java.code.ctci.old.ch_07_Object_Oriented_Design.Card.Suit;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Deck {
  final List<Card> deck;

  public Deck() {
    this.deck = new ArrayList<>();
    for (int value = 0; value < 11; value++) {
      for (Suit suit : Suit.values()) {
        deck.add(new Card(suit, value));
      }
    }
  }
}
