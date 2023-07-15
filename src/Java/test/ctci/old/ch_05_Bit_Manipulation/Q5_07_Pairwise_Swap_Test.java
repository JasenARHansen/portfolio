package Java.test.ctci.old.ch_05_Bit_Manipulation;

import Java.code.ctci.old.ch_05_Bit_Manipulation.BitShift;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@SuppressWarnings({"NewClassNamingConvention", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q5_07_Pairwise_Swap_Test {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void swapOddEvenBits() {
        int[] expected = {15, 1911, 6893, 6630, 2527, 778312, -42828};
        printTestHeader(name.getMethodName());
        int[] values = {15, 3003, 9694, 9945, 1775, 512132, -23432};
        for (int i = 0; i < values.length; i++) {
            int result = BitShift.swapOddEvenBits(values[i]);
            assertEquals(expected[i], result);
            System.out.format(
                    "\t%d (%s) converts to %d (%s)\n",
                    values[i], Integer.toBinaryString(values[i]), result, Integer.toBinaryString(result));
        }
    }
}
