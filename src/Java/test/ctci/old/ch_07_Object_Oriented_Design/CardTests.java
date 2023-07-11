package Java.test.ctci.old.ch_07_Object_Oriented_Design;

import static org.junit.Assert.*;

import Java.code.ctci.old.ch_07_Object_Oriented_Design.Card;
import Java.code.ctci.old.ch_07_Object_Oriented_Design.Card.Suit;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CardTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void Card() {
    Suit suit = Suit.Club;
    int value = 11;
    Card card = new Card(suit, value);
    assertNotNull(card);
    System.out.format("%s:\n", name.getMethodName());
  }

  @Test
  public void getSuit() {
    Suit suit = Suit.Club;
    int value = 11;
    Card card = new Card(suit, value);
    Suit result = card.suit();
    assertEquals(suit, result);
    System.out.format("%s: getSuit %s\n", name.getMethodName(), result);
  }

  @Test
  public void getValue() {
    Suit suit = Suit.Club;
    int value = 11;
    Card card = new Card(suit, value);
    int result = card.value();
    assertEquals(value, result);
    System.out.format("%s: getValue %d\n", name.getMethodName(), result);
  }
}
