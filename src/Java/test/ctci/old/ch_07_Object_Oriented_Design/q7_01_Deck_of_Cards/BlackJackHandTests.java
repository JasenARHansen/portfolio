package Java.test.ctci.old.ch_07_Object_Oriented_Design.q7_01_Deck_of_Cards;

import static org.junit.Assert.assertNotNull;

import Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_01_Deck_of_Cards.BlackJackHand;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BlackJackHandTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void BlackJackHand() {
    BlackJackHand blackJackHand = new BlackJackHand();
    assertNotNull(blackJackHand);
    System.out.format("%s:\n", name.getMethodName());
  }
}
