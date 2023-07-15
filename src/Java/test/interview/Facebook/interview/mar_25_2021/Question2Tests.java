package Java.test.interview.Facebook.interview.mar_25_2021;

import Java.code.interview.Facebook.interview.mar_25_2021.Question2;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Question2Tests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void NValues_1() {
        printTestHeader(name.getMethodName());
        int[][] points = {{50, 50}, {100, 50}, {50, 200}, {100, 200}};
        boolean result = Question2.rectangleFound(points);
        System.out.format("\tThe array contains prints that can form a rectangle: %s.\n", result);
        assertTrue(result);
    }

    @Test
    public void NValues_2() {
        printTestHeader(name.getMethodName());
        int[][] points = {{0, 0}, {50, 50}, {100, 50}, {50, 200}, {100, 200}, {120, 200}};
        boolean result = Question2.rectangleFound(points);
        System.out.format("\tThe array contains prints that can form a rectangle: %s.\n", result);
        assertTrue(result);
    }

    @Test
    public void NValues_3() {
        printTestHeader(name.getMethodName());
        int[][] points = {{0, 0}, {100, 50}, {50, 200}, {100, 200}, {120, 200}};
        boolean result = Question2.rectangleFound(points);
        System.out.format("\tThe array contains prints that can form a rectangle: %s.\n", result);
        assertFalse(result);
    }

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        Question2.getDescription();
    }
}
