package Java.test.ctci.old.ch_08_Recursion_and_Dynamic_Programming.q8_02_Robot_in_a_Grid;

import Java.code.ctci.source.ch_08_Recursion_and_Dynamic_Programming.q8_02_Robot_in_a_Grid.Point;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PointTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void column() {
        printTestHeader(name.getMethodName());
        int row = 5;
        int column = 10;
        Point point = new Point(row, column);
        assertNotNull(point);
        assertEquals(column, point.column());
        System.out.format("\tPoint column - %d\n", point.column());
    }

    @Test
    public void row() {
        printTestHeader(name.getMethodName());
        int row = 5;
        int column = 10;
        Point point = new Point(row, column);
        assertNotNull(point);
        assertEquals(row, point.row());
        System.out.format("\tPoint row - %d\n", point.row());
    }
}
