package Java.test.ctci.old.ch_07_Object_Oriented_Design.q7_01_Deck_of_Cards;

import Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_01_Deck_of_Cards.BlackJackHand;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertNotNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BlackJackHandTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void BlackJackHand() {
        printTestHeader(name.getMethodName());
        BlackJackHand blackJackHand = new BlackJackHand();
        assertNotNull(blackJackHand);
    }
}
