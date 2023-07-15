package Java.test.ctci.old.ch_16_Moderate.q16_24_Pairs_With_Sum;

import Java.code.ctci.source.ch_16_Moderate.q16_24_Pairs_With_Sum.Pair;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PairTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void first() {
        printTestHeader(name.getMethodName());
        int first = 5;
        int second = 10;
        Pair pair = new Pair(first, second);
        assertNotNull(pair);
        assertEquals(first, pair.first());
        System.out.format("\tPair first - %d\n", pair.first());
    }

    @Test
    public void second() {
        printTestHeader(name.getMethodName());
        int first = 5;
        int second = 10;
        Pair pair = new Pair(first, second);
        assertNotNull(pair);
        assertEquals(second, pair.second());
        System.out.format("\tPair second - %d\n", pair.second());
    }
}
