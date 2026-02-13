package Java.code.ctci.old.ch_07_Object_Oriented_Design;

public record Card(Suit Suit, int value) {

    public Suit Suit() {
        return this.Suit;
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
