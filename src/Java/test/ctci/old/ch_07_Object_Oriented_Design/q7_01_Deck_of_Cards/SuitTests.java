package Java.test.ctci.old.ch_07_Object_Oriented_Design.q7_01_Deck_of_Cards;

import static org.junit.Assert.assertEquals;

import Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_01_Deck_of_Cards.Suit;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SuitTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void BlackJackHand() {
    Suit suit = Suit.Club;
    int result = suit.getValue();
    assertEquals(0, result);
    System.out.format("%s: Suit %s has value %d\n", name.getMethodName(), suit, result);
  }
}
