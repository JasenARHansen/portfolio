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
public class Q5_06_Conversion_Test {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void bitSwapRequired() {
        int[] expected = {10, 15, 13, 14, 13, 0, 23};
        printTestHeader(name.getMethodName());
        int left = 512132;
        int[] data = {15, 3003, 9694, 9945, 1775, 512132, -23432};
        int index = 1;
        for (int i = 0; i < data.length; i++) {
            int result = BitShift.bitSwapRequired(left, data[i]);
            assertEquals(expected[i], result);
            System.out.format(
                    "\t%d: It takes %d bit flips to convert %d (%s) to %d (%s)\n",
                    index++,
                    result,
                    left,
                    Integer.toBinaryString(left),
                    data[i],
                    Integer.toBinaryString(data[i]));
        }
    }
}
