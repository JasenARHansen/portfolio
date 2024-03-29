package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_01_Deck_of_Cards;

@SuppressWarnings("unused")
public abstract class Card {
    /* Number or face that's on card - a number 2 through 10, or 11 for Jack, 12 for Queen, 13 for King, or 1 for Ace. */
    protected final int faceValue;

    protected final Suit suit;
    private boolean available = true;

    public Card(int c, Suit s) {
        faceValue = c;
        suit = s;
    }

    public boolean isAvailable() {
        /* returns whether-or-not the card is available to be given out to someone. */
        return available;
    }

    public void markAvailable() {
        available = true;
    }

    public void markUnavailable() {
        available = false;
    }

    public void print() {
        String[] faceValues = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        System.out.print(faceValues[faceValue - 1]);
        switch (suit) {
            case Club -> System.out.print("c");
            case Heart -> System.out.print("h");
            case Diamond -> System.out.print("d");
            case Spade -> System.out.print("s");
        }
        System.out.print(" ");
    }

    public Suit suit() {
        return suit;
    }

    public abstract int value();
}
