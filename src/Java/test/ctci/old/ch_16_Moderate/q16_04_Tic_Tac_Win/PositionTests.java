package Java.test.ctci.old.ch_16_Moderate.q16_04_Tic_Tac_Win;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import Java.code.ctci.source.ch_16_Moderate.q16_04_Tic_Tac_Win.Position;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PositionTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void Position() {
    int row = 5;
    int column = 5;
    Position position = new Position(row, column);
    assertNotNull(position);
    System.out.format("%s:\n", name.getMethodName());
  }

  @Test
  public void row() {
    int row = 5;
    int column = 5;
    Position position = new Position(row, column);
    int result = position.row();
    assertEquals(row, result);
    System.out.format("%s: Pair first - %d\n", name.getMethodName(), result);
  }

  @Test
  public void column() {
    int row = 5;
    int column = 5;
    Position position = new Position(row, column);
    int result = position.column();
    assertEquals(column, result);
    System.out.format("%s: Pair first - %d\n", name.getMethodName(), result);
  }
}
