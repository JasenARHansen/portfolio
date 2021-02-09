package Test.HackerRank.WarmUpChallenges;

import Code.HackerRank.WarmUpChallenges.JumpingOnTheClouds;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JumpingOnTheClouds_tests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void jumpClouds_1() {
        int expected = 3;
        int[] clouds = {0, 1, 0, 0, 0, 1, 0};
        int result = JumpingOnTheClouds.jumpClouds(clouds);
        System.out.format(
                "%s: The shortest path through the clouds '%s' is %d jumps.\n",
                name.getMethodName(), Arrays.toString(clouds), result);
        assertEquals(expected, result);
    }

    @Test
    public void jumpClouds_2() {
        int expected = 4;
        int[] clouds = {0, 0, 1, 0, 0, 1, 0};
        int result = JumpingOnTheClouds.jumpClouds(clouds);
        System.out.format(
                "%s: The shortest path through the clouds '%s' is %d jumps.\n",
                name.getMethodName(), Arrays.toString(clouds), result);
        assertEquals(expected, result);
    }

    @Test
    public void jumpClouds_3() {
        int expected = 3;
        int[] clouds = {0, 0, 0, 0, 1, 0};
        int result = JumpingOnTheClouds.jumpClouds(clouds);
        System.out.format(
                "%s: The shortest path through the clouds '%s' is %d jumps.\n",
                name.getMethodName(), Arrays.toString(clouds), result);
        assertEquals(expected, result);
    }

    @Test
    public void jumpClouds_4() {
        int expected = 3;
        int[] clouds = {0, 0, 0, 1, 0, 0};
        int result = JumpingOnTheClouds.jumpClouds(clouds);
        System.out.format(
                "%s: The shortest path through the clouds '%s' is %d jumps.\n",
                name.getMethodName(), Arrays.toString(clouds), result);
        assertEquals(expected, result);
    }

    @Test
    public void jumpClouds_5() {
        int expected = 4;
        int[] clouds = {0, 0, 1, 0, 0, 1, 0};
        int result = JumpingOnTheClouds.jumpClouds(clouds);
        System.out.format(
                "%s: The shortest path through the clouds '%s' is %d jumps.\n",
                name.getMethodName(), Arrays.toString(clouds), result);
        assertEquals(expected, result);
    }

    @Test
    public void jumpClouds_6() {
        int expected = 1;
        int[] clouds = {0, 0};
        int result = JumpingOnTheClouds.jumpClouds(clouds);
        System.out.format(
                "%s: The shortest path through the clouds '%s' is %d jumps.\n",
                name.getMethodName(), Arrays.toString(clouds), result);
        assertEquals(expected, result);
    }

    @Test
    public void jumpClouds_7() {
        int expected = 1;
        int[] clouds = {0, 0, 0};
        int result = JumpingOnTheClouds.jumpClouds(clouds);
        System.out.format(
                "%s: The shortest path through the clouds '%s' is %d jumps.\n",
                name.getMethodName(), Arrays.toString(clouds), result);
        assertEquals(expected, result);
    }
}
