package Java.test.ctci.old.ch_07_Object_Oriented_Design;

import Java.code.ctci.old.ch_07_Object_Oriented_Design.Card;
import Java.code.ctci.old.ch_07_Object_Oriented_Design.Card.Suit;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CardTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void Card() {
        printTestHeader(name.getMethodName());
        Suit Suit = Suit.Club;
        int value = 11;
        Card Card = new Card(Suit, value);
        assertNotNull(Card);
    }

    @Test
    public void getSuit() {
        printTestHeader(name.getMethodName());
        Suit Suit = Suit.Club;
        int value = 11;
        Card Card = new Card(Suit, value);
        Suit result = Card.Suit();
        assertEquals(Suit, result);
        System.out.format("\tgetSuit %s\n", result);
    }

    @Test
    public void getValue() {
        printTestHeader(name.getMethodName());
        Suit Suit = Suit.Club;
        int value = 11;
        Card Card = new Card(Suit, value);
        int result = Card.value();
        assertEquals(value, result);
        System.out.format("\tgetValue %d\n", result);
    }
}
