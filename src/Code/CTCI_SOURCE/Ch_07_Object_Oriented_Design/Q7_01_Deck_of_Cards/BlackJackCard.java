package Code.CTCI_SOURCE.Ch_07_Object_Oriented_Design.Q7_01_Deck_of_Cards;

public class BlackJackCard extends Card {
    public BlackJackCard(int c, Suit s) {
        super(c, s);
    }

    public int minValue() {
        if (isAce()) { // Ace
            return 1;
        } else {
            return value();
        }
    }

    public int value() {
        if (isAce()) { // Ace
            return 1;
        } else if (isFaceCard()) { // Face card
            return 10;
        } else { // Number card
            return faceValue;
        }
    }

    public boolean isFaceCard() {
        return faceValue >= 11 && faceValue <= 13;
    }

    public boolean isAce() {
        return faceValue == 1;
    }

    public int maxValue() {
        if (isAce()) { // Ace
            return 11;
        } else {
            return value();
        }
    }
}
