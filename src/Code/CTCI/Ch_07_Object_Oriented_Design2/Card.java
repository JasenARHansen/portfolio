package Code.CTCI.Ch_07_Object_Oriented_Design2;

public class Card {
    Suit suit;
    int value;

    public Card(Suit suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public enum Suit {
        Heart,
        Diamond,
        Spade,
        Club
    }
}
