package Java.test.ctci.old.ch_07_Object_Oriented_Design.q7_01_Deck_of_Cards;

import Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_01_Deck_of_Cards.Suit;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SuitTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void BlackJackHand() {
        printTestHeader(name.getMethodName());
        Suit Suit = Suit.Club;
        int result = Suit.getValue();
        assertEquals(0, result);
        System.out.format("\tSuit %s has value %d\n", Suit, result);
    }
}
