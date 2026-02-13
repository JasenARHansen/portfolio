package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_01_Deck_of_Cards;

import java.util.ArrayList;

public class Hand<T extends Card> {
    protected final ArrayList<T> cards = new ArrayList<>();

    public void addCard(T Card) {
        cards.add(Card);
    }

    public void print() {
        for (Card Card : cards) {
            Card.print();
        }
    }

    public int points() {
        int points = 0;
        for (T Card : cards) {
            points += Card.value();
        }
        return points;
    }
}
