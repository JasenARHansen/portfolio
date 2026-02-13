package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_01_Deck_of_Cards;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class BlackJackGameAutomator {
    private static final int HIT_UNTIL = 16;
    private final BlackJackHand[] hands;
    private Deck<BlackJackCard> deck;

    public BlackJackGameAutomator(int numPlayers) {
        hands = new BlackJackHand[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            hands[i] = new BlackJackHand();
        }
    }

    public boolean dealInitial() {
        for (BlackJackHand hand : hands) {
            BlackJackCard card1 = deck.dealCard();
            BlackJackCard card2 = deck.dealCard();
            if (card1 == null || card2 == null) {
                return false;
            }
            hand.addCard(card1);
            hand.addCard(card2);
        }
        return true;
    }

    public ArrayList<Integer> getBlackJacks() {
        ArrayList<Integer> winners = new ArrayList<>();
        for (int i = 0; i < hands.length; i++) {
            if (hands[i].isBlackJack()) {
                winners.add(i);
            }
        }
        return winners;
    }

    public ArrayList<Integer> getWinners() {
        ArrayList<Integer> winners = new ArrayList<>();
        int winningScore = 0;
        for (int i = 0; i < hands.length; i++) {
            BlackJackHand hand = hands[i];
            if (!hand.busted()) {
                if (hand.points() > winningScore) {
                    winningScore = hand.points();
                    winners.clear();
                    winners.add(i);
                } else if (hand.points() == winningScore) {
                    winners.add(i);
                }
            }
        }
        return winners;
    }

    public void initializeDeck() {
        ArrayList<BlackJackCard> cards = new ArrayList<>();
        for (int i = 1; i <= 13; i++) {
            for (int j = 0; j <= 3; j++) {
                Suit Suit = Suit.getSuitFromValue(j);
                BlackJackCard Card = new BlackJackCard(i, Suit);
                cards.add(Card);
            }
        }
        deck = new Deck<>();
        deck.setDeckOfCards(cards);
        deck.shuffle();
    }

    public boolean playAllHands() {
        for (BlackJackHand hand : hands) {
            if (!playHand(hand)) {
                return false;
            }
        }
        return true;
    }

    public boolean playHand(BlackJackHand hand) {
        while (hand.points() < HIT_UNTIL) {
            BlackJackCard Card = deck.dealCard();
            if (Card == null) {
                return false;
            }
            hand.addCard(Card);
        }
        return true;
    }

    public boolean playHand(int i) {
        BlackJackHand hand = hands[i];
        return playHand(hand);
    }

    public void printHandsAndScore() {
        for (int i = 0; i < hands.length; i++) {
            System.out.print("Hand " + i + " (" + hands[i].points() + "): ");
            hands[i].print();
            System.out.println();
        }
    }
}
