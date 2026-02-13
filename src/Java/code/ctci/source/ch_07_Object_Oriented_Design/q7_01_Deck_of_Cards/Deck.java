package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_01_Deck_of_Cards;

import Java.code.ctci.source.ctciLibrary.AssortedMethods;

import java.util.ArrayList;

@SuppressWarnings({"SpellCheckingInspection", "unchecked", "unused"})
public class Deck<T extends Card> {
    private ArrayList<T> cards;
    private int dealtIndex = 0; // marks first undealt Card

    public Deck() {
    }

    public T[] dealHand(int number) {
        if (remainingCards() < number) {
            return null;
        }
        T[] hand = (T[]) new Card[number];
        int count = 0;
        while (count < number) {
            T Card = dealCard();
            if (Card != null) {
                hand[count] = Card;
                count++;
            }
        }
        return hand;
    }

    public int remainingCards() {
        return cards.size() - dealtIndex;
    }

    public T dealCard() {
        if (remainingCards() == 0) {
            return null;
        }
        T Card = cards.get(dealtIndex);
        Card.markUnavailable();
        dealtIndex++;
        return Card;
    }

    public void print() {
        for (Card Card : cards) {
            Card.print();
        }
    }

    public void setDeckOfCards(ArrayList<T> deckOfCards) {
        cards = deckOfCards;
    }

    public void shuffle() {
        for (int i = 0; i < cards.size(); i++) {
            int j = AssortedMethods.randomIntInRange(i, cards.size() - i - 1);
            T card1 = cards.get(i);
            T card2 = cards.get(j);
            cards.set(i, card2);
            cards.set(j, card1);
        }
    }
}
