package Java.test.ctci.old.ch_05_Bit_Manipulation;

import Java.code.ctci.old.ch_05_Bit_Manipulation.BitShift;
import Java.code.ctci.old.ch_05_Bit_Manipulation.BitShift2;
import Java.code.ctci.source.ctciLibrary.AssortedMethods;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@SuppressWarnings({"NewClassNamingConvention", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q5_01_Insertion_Test {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void updateBits_1() {
        int expected = -1073765248;
        printTestHeader(name.getMethodName());
        int base = ~23423;
        int insert = 5;
        int indexStart = 29;
        int indexStop = 31;
        System.out.format("\tBase:\t%s\n", AssortedMethods.toFullBinaryString(base));
        System.out.format("\tInsert:\t%s\n", AssortedMethods.toFullBinaryString(insert));
        int result = BitShift.updateBits(base, insert, indexStart, indexStop);
        assertEquals(expected, result);
        System.out.format("\tResult:\t%s\n", AssortedMethods.toFullBinaryString(result));
    }

    @Test
    public void updateBits_2() {
        int expected = -536894336;
        printTestHeader(name.getMethodName());
        int base = ~23423;
        int insert = 5;
        int indexStart = 28;
        int indexStop = 30;
        System.out.format("\tBase:\t%s\n", AssortedMethods.toFullBinaryString(base));
        System.out.format("\tInsert:\t%s\n", AssortedMethods.toFullBinaryString(insert));
        int result = BitShift.updateBits(base, insert, indexStart, indexStop);
        assertEquals(expected, result);
        System.out.format("\tResult:\t%s\n", AssortedMethods.toFullBinaryString(result));
    }

    @Test
    public void updateBits_solution_1() {
        int expected = -1073765248;
        printTestHeader(name.getMethodName());
        int a = ~23423;
        System.out.format("\tValue 1 %d with bits %s\n", a, AssortedMethods.toFullBinaryString(a));
        int b = 5;
        System.out.format("\tValue 2 %d with bits %s\n", a, AssortedMethods.toFullBinaryString(b));
        int left = 29;
        int right = 31;
        int result = BitShift2.updateBits(a, b, left, right);
        assertEquals(expected, result);
        System.out.format(
                "\tUsing value 1 '%d' and Value 2 '%s' with masking between bits '%d' and"
                        + " '%d' result in '%d' with bits '%s'\n",
                a, b, left, right, result, AssortedMethods.toFullBinaryString(result));
    }

    @Test
    public void updateBits_solution_2() {
        int expected = -536894336;
        printTestHeader(name.getMethodName());
        int a = ~23423;
        System.out.format("\tValue 1 %d with bits %s\n", a, AssortedMethods.toFullBinaryString(a));
        int b = 5;
        System.out.format("\tValue 2 %d with bits %s\n", a, AssortedMethods.toFullBinaryString(b));
        int left = 28;
        int right = 30;
        int result = BitShift2.updateBits(a, b, left, right);
        assertEquals(expected, result);
        System.out.format(
                "\tUsing value 1 '%d' and Value 2 '%s' with masking between bits '%d' and"
                        + " '%d' result in '%d' with bits '%s'\n",
                a, b, left, right, result, AssortedMethods.toFullBinaryString(result));
    }
}
