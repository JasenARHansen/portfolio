package Java.code.ctci.old.ch_07_Object_Oriented_Design;

public class Card {
  final Suit suit;
  final int value;

  public Card(Suit suit, int value) {
    this.suit = suit;
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }

  public Suit getSuit() {
    return this.suit;
  }

  public enum Suit {
    Heart,
    Diamond,
    Spade,
    Club
  }
}
