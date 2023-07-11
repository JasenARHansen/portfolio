package Java.test.ctci.old.ch_16_Moderate.q16_24_Pairs_With_Sum;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import Java.code.ctci.source.ch_16_Moderate.q16_24_Pairs_With_Sum.Pair;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PairTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void first() {
    int first = 5;
    int second = 10;
    Pair pair = new Pair(first, second);
    assertNotNull(pair);
    assertEquals(first, pair.first());
    System.out.format("%s: Pair first - %d\n", name.getMethodName(), pair.first());
  }

  @Test
  public void second() {
    int first = 5;
    int second = 10;
    Pair pair = new Pair(first, second);
    assertNotNull(pair);
    assertEquals(second, pair.second());
    System.out.format("%s: Pair second - %d\n", name.getMethodName(), pair.second());
  }
}
