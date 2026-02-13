package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_01_Deck_of_Cards;

public class BlackJackCard extends Card {
    public BlackJackCard(int c, Suit s) {
        super(c, s);
    }

    public int maxValue() {
        if (isAce()) { // Ace
            return 11;
        } else {
            return value();
        }
    }

    public boolean isAce() {
        return faceValue == 1;
    }

    public int value() {
        if (isAce()) { // Ace
            return 1;
        } else if (isFaceCard()) { // Face Card
            return 10;
        } else { // Number Card
            return faceValue;
        }
    }

    public boolean isFaceCard() {
        return faceValue >= 11 && faceValue <= 13;
    }

    public int minValue() {
        if (isAce()) { // Ace
            return 1;
        } else {
            return value();
        }
    }
}
