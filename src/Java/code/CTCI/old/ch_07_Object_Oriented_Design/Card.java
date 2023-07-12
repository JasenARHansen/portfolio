package Java.code.ctci.old.ch_07_Object_Oriented_Design;

public record Card(Suit suit, int value) {

  public Suit suit() {
    return this.suit;
  }

  public int value() {
    return this.value;
  }

  public enum Suit {
    Heart,
    Diamond,
    Spade,
    Club
  }
}
