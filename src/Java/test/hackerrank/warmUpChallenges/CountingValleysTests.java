package Java.test.hackerrank.warmUpChallenges;
import static org.junit.Assert.assertEquals;

import Java.code.hackerrank.warmUpChallenges.CountingValleys;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings("SpellCheckingInspection")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CountingValleysTests {
    @Rule
    public final TestName name = new TestName();
    @Test
    public void valleysTraversed_1() {
        int expected = 1;
        int steps = 8;
        String path = "DDUUUUDD";
        int result = CountingValleys.valleysTraversed(steps, path);
        System.out.format(
                "%s: Taking %d steps on the path '%s' has %d valleys.\n",
                name.getMethodName(), steps, path, result);
        assertEquals(expected, result);
    }
    @Test
    public void valleysTraversed_2() {
        int expected = 1;
        int steps = 8;
        String path = "UDDDUDUU";
        int result = CountingValleys.valleysTraversed(steps, path);
        System.out.format(
                "%s: Taking %d steps on the path '%s' has %d valleys.\n",
                name.getMethodName(), steps, path, result);
        assertEquals(expected, result);
    }
    @Test
    public void valleysTraversed_3() {
        int expected = 1;
        int steps = 8;
        String path = "uddduduu";
        int result = CountingValleys.valleysTraversed(steps, path);
        System.out.format(
                "%s: Taking %d steps on the path '%s' has %d valleys.\n",
                name.getMethodName(), steps, path, result);
        assertEquals(expected, result);
    }
    @Test
    public void valleysTraversed_5() {
        int expected = 4;
        int steps = 11;
        String path = "DUDU   DUDU";
        int result = CountingValleys.valleysTraversed(steps, path);
        System.out.format(
                "%s: Taking %d steps on the path '%s' has %d valleys.\n",
                name.getMethodName(), steps, path, result);
        assertEquals(expected, result);
    }
    @Test
    public void valleysTraversed_6() {
        int expected = 2;
        int steps = 4;
        String path = "DUDU   DUDU";
        int result = CountingValleys.valleysTraversed(steps, path);
        System.out.format(
                "%s: Taking %d steps on the path '%s' has %d valleys.\n",
                name.getMethodName(), steps, path, result);
        assertEquals(expected, result);
    }
    @Test
    public void valleysTraversed_7() {
        int expected = 2;
        int steps = 12;
        String path = "DDUUDDUDUUUD";
        int result = CountingValleys.valleysTraversed(steps, path);
        System.out.format(
                "%s: Taking %d steps on the path '%s' has %d valleys.\n",
                name.getMethodName(), steps, path, result);
        assertEquals(expected, result);
    }
}
