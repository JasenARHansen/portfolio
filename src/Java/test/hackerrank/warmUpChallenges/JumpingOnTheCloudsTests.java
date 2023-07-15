package Java.test.hackerrank.warmUpChallenges;

import Java.code.hackerrank.warmUpChallenges.JumpingOnTheClouds;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("DuplicatedCode")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JumpingOnTheCloudsTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void jumpClouds_1() {
        int expected = 3;
        printTestHeader(name.getMethodName());
        int[] clouds = {0, 1, 0, 0, 0, 1, 0};
        int result = JumpingOnTheClouds.jumpClouds(clouds);
        assertEquals(expected, result);
        System.out.format(
                "\tThe shortest path through the clouds '%s' is %d jumps.\n",
                Arrays.toString(clouds), result);
    }

    @Test
    public void jumpClouds_2() {
        int expected = 4;
        printTestHeader(name.getMethodName());
        int[] clouds = {0, 0, 1, 0, 0, 1, 0};
        int result = JumpingOnTheClouds.jumpClouds(clouds);
        assertEquals(expected, result);
        System.out.format(
                "\tThe shortest path through the clouds '%s' is %d jumps.\n",
                Arrays.toString(clouds), result);
    }

    @Test
    public void jumpClouds_3() {
        int expected = 3;
        printTestHeader(name.getMethodName());
        int[] clouds = {0, 0, 0, 0, 1, 0};
        int result = JumpingOnTheClouds.jumpClouds(clouds);
        assertEquals(expected, result);
        System.out.format(
                "\tThe shortest path through the clouds '%s' is %d jumps.\n",
                Arrays.toString(clouds), result);
    }

    @Test
    public void jumpClouds_4() {
        int expected = 3;
        printTestHeader(name.getMethodName());
        int[] clouds = {0, 0, 0, 1, 0, 0};
        int result = JumpingOnTheClouds.jumpClouds(clouds);
        assertEquals(expected, result);
        System.out.format(
                "\tThe shortest path through the clouds '%s' is %d jumps.\n",
                Arrays.toString(clouds), result);
    }

    @Test
    public void jumpClouds_5() {
        int expected = 4;
        printTestHeader(name.getMethodName());
        int[] clouds = {0, 0, 1, 0, 0, 1, 0};
        int result = JumpingOnTheClouds.jumpClouds(clouds);
        assertEquals(expected, result);
        System.out.format(
                "\tThe shortest path through the clouds '%s' is %d jumps.\n",
                Arrays.toString(clouds), result);
    }

    @Test
    public void jumpClouds_6() {
        int expected = 1;
        printTestHeader(name.getMethodName());
        int[] clouds = {0, 0};
        int result = JumpingOnTheClouds.jumpClouds(clouds);
        assertEquals(expected, result);
        System.out.format(
                "\tThe shortest path through the clouds '%s' is %d jumps.\n",
                Arrays.toString(clouds), result);
    }

    @Test
    public void jumpClouds_7() {
        int expected = 1;
        printTestHeader(name.getMethodName());
        int[] clouds = {0, 0, 0};
        int result = JumpingOnTheClouds.jumpClouds(clouds);
        assertEquals(expected, result);
        System.out.format(
                "\tThe shortest path through the clouds '%s' is %d jumps.\n",
                Arrays.toString(clouds), result);
    }
}
