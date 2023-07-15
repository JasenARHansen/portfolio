package Java.test.educative;

import Java.code.educative.DynamicProgrammingCountAllPossiblePaths;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DynamicProgrammingCountAllPossiblePathsTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        DynamicProgrammingCountAllPossiblePaths.getDescription();
    }

    @Test
    public void uniquePaths_1() {
        int expected = 28;
        printTestHeader(name.getMethodName());
        int m = 3;
        int n = 7;
        int result = DynamicProgrammingCountAllPossiblePaths.uniquePaths(m, n);
        System.out.format(
                "\tGiven the prices %d by %d matrix, there are %d unique paths.\n", m, n, result);
        assertEquals(expected, result);
    }

    @Test
    public void uniquePaths_2() {
        int expected = 3;
        printTestHeader(name.getMethodName());
        int m = 3;
        int n = 2;
        int result = DynamicProgrammingCountAllPossiblePaths.uniquePaths(m, n);
        System.out.format(
                "\tGiven the prices %d by %d matrix, there are %d unique paths.\n", m, n, result);
        assertEquals(expected, result);
    }

    @Test
    public void uniquePaths_3() {
        int expected = 6;
        printTestHeader(name.getMethodName());
        int m = 3;
        int n = 3;
        int result = DynamicProgrammingCountAllPossiblePaths.uniquePaths(m, n);
        System.out.format(
                "\tGiven the prices %d by %d matrix, there are %d unique paths.\n", m, n, result);
        assertEquals(expected, result);
    }
}
