package CTCI_SOURCE.unprocessed_Ch_07_Object_Oriented_Design.Q7_01_Deck_of_Cards;

public enum Suit {
    Club(0),
    Diamond(1),
    Heart(2),
    Spade(3);

    private int value;

    Suit(int v) {
        value = v;
    }

    public static Suit getSuitFromValue(int value) {
        return switch (value) {
            case 0 -> Suit.Club;
            case 1 -> Suit.Diamond;
            case 2 -> Suit.Heart;
            case 3 -> Suit.Spade;
            default -> null;
        };
    }

    public int getValue() {
        return value;
    }
}
