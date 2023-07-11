package Java.test.ctci.old.ch_08_Recursion_and_Dynamic_Programming.q8_02_Robot_in_a_Grid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import Java.code.ctci.source.ch_08_Recursion_and_Dynamic_Programming.q8_02_Robot_in_a_Grid.Point;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PointTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void row() {
    int row = 5;
    int column = 10;
    Point point = new Point(row, column);
    assertNotNull(point);
    assertEquals(row, point.row());
    System.out.format("%s: Point row - %d\n", name.getMethodName(), point.row());
  }

  @Test
  public void column() {
    int row = 5;
    int column = 10;
    Point point = new Point(row, column);
    assertNotNull(point);
    assertEquals(column, point.column());
    System.out.format("%s: Point column - %d\n", name.getMethodName(), point.column());
  }
}
