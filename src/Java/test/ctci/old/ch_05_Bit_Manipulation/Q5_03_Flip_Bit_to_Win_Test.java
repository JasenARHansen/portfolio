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
public class Q5_03_Flip_Bit_to_Win_Test {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void longestSequence() {
        int[] expected = {5, 7, 8, 5, 8};
        printTestHeader(name.getMethodName());
        int[] values = {15, 3003, 9694, 9945, 1775};
        for (int i = 0; i < values.length; i++) {
            int result = BitShift.longestSequence(values[i]);
            assertEquals(expected[i], result);
            System.out.format(
                    "\tThe largest bit sequence in %s allowing a single bit skip %d\n",
                    Integer.toBinaryString(values[i]), result);
        }
    }
}
