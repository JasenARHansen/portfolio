package Java.Code.CTCI.Ch_07_Object_Oriented_Design2;

import Java.Code.CTCI.Ch_07_Object_Oriented_Design2.Card.Suit;
import java.util.ArrayList;
import java.util.List;

public class Deck {
  List<Card> deck;

  public Deck() {
    this.deck = new ArrayList<>();
    for (int value = 0; value < 11; value++) {
      for (Suit suit : Suit.values()) {
        deck.add(new Card(suit, value));
      }
    }
  }
}
