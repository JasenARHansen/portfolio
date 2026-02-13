package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_01_Deck_of_Cards;

import java.util.ArrayList;

public class BlackJackHand extends Hand<BlackJackCard> {
    public BlackJackHand() {
    }

    public boolean busted() {
        return points() > 21;
    }

    public int points() {
        ArrayList<Integer> scores = possibleScores();
        int maxUnder = Integer.MIN_VALUE;
        int minOver = Integer.MAX_VALUE;
        for (int points : scores) {
            if (points > 21 && points < minOver) {
                minOver = points;
            } else if (points <= 21 && points > maxUnder) {
                maxUnder = points;
            }
        }
        return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
    }

    private ArrayList<Integer> possibleScores() {
        ArrayList<Integer> scores = new ArrayList<>();
        if (cards.size() == 0) {
            return scores;
        }
        for (BlackJackCard Card : cards) {
            addCardToScoreList(Card, scores);
        }
        return scores;
    }

    private void addCardToScoreList(BlackJackCard Card, ArrayList<Integer> scores) {
        if (scores.size() == 0) {
            scores.add(0);
        }
        int length = scores.size();
        for (int i = 0; i < length; i++) {
            int points = scores.get(i);
            scores.set(i, points + Card.minValue());
            if (Card.minValue() != Card.maxValue()) {
                scores.add(points + Card.maxValue());
            }
        }
    }

    public boolean is21() {
        return points() == 21;
    }

    public boolean isBlackJack() {
        if (cards.size() != 2) {
            return false;
        }
        BlackJackCard first = cards.get(0);
        BlackJackCard second = cards.get(1);
        return (first.isAce() && second.isFaceCard()) || (second.isAce() && first.isFaceCard());
    }
}
