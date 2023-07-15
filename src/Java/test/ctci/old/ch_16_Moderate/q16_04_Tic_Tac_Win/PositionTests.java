package Java.test.ctci.old.ch_16_Moderate.q16_04_Tic_Tac_Win;

import Java.code.ctci.source.ch_16_Moderate.q16_04_Tic_Tac_Win.Position;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PositionTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void Position() {
        printTestHeader(name.getMethodName());
        int row = 5;
        int column = 5;
        Position position = new Position(row, column);
        assertNotNull(position);
    }

    @Test
    public void column() {
        printTestHeader(name.getMethodName());
        int row = 5;
        int column = 5;
        Position position = new Position(row, column);
        int result = position.column();
        assertEquals(column, result);
        System.out.format("\tPair first - %d\n", result);
    }

    @Test
    public void row() {
        printTestHeader(name.getMethodName());
        int row = 5;
        int column = 5;
        Position position = new Position(row, column);
        int result = position.row();
        assertEquals(row, result);
        System.out.format("\tPair first - %d\n", result);
    }
}
