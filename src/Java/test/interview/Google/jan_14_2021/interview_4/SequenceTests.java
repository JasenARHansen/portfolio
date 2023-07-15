package Java.test.interview.Google.jan_14_2021.interview_4;

import Java.code.interview.Google.jan_14_2021.interview_4.Sequence;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ConstantValue")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SequenceTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void XofAKind_1() {
        printTestHeader(name.getMethodName());
        ArrayList<Integer> inputs = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 6, 6, 6, 6));
        boolean result = Sequence.XofAKind(inputs);
        assertFalse(result);
        System.out.format(
                "\tlist %s can be broken up to entirely X of a kind sequences: %b\n",
                inputs, result);
    }

    @Test
    public void XofAKind_2() {
        printTestHeader(name.getMethodName());
        ArrayList<Integer> inputs = new ArrayList<>(List.of(6, 6, 6, 6, 6));
        boolean result = Sequence.XofAKind(inputs);
        assertTrue(result);
        System.out.format(
                "\tlist %s can be broken up to entirely X of a kind sequences: %b\n",
                inputs, result);
    }

    @Test
    public void XofAKind_3() {
        printTestHeader(name.getMethodName());
        ArrayList<Integer> inputs = new ArrayList<>(List.of(6, 5, 6, 5, 6, 6, 6));
        boolean result = Sequence.XofAKind(inputs);
        assertTrue(result);
        System.out.format(
                "\tlist %s can be broken up to entirely X of a kind sequences: %b\n",
                inputs, result);
    }

    @Test
    public void XofAKind_4() {
        printTestHeader(name.getMethodName());
        ArrayList<Integer> inputs = new ArrayList<>(List.of());
        boolean result = Sequence.XofAKind(inputs);
        assertTrue(result);
        System.out.format(
                "\tlist %s can be broken up to entirely X of a kind sequences: %b\n",
                inputs, result);
    }

    @Test
    public void XofAKind_5() {
        printTestHeader(name.getMethodName());
        ArrayList<Integer> inputs = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        boolean result = Sequence.XofAKind(inputs);
        assertFalse(result);
        System.out.format(
                "\tlist %s can be broken up to entirely X of a kind sequences: %b\n",
                inputs, result);
    }

    @Test
    public void XofAKind_6() {
        printTestHeader(name.getMethodName());
        boolean result = Sequence.XofAKind(null);
        assertFalse(result);
        System.out.format(
                "\tlist null can be broken up to entirely of straights of 5 cards: %b\n",
                result);
    }

    @Test
    public void straights_1() {
        printTestHeader(name.getMethodName());
        ArrayList<Integer> inputs = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        boolean result = Sequence.straights(inputs);
        assertFalse(result);
        System.out.format(
                "\tlist %s can be broken up to entirely of straights of 5 cards: %b\n",
                inputs, result);
    }

    @Test
    public void straights_2() {
        printTestHeader(name.getMethodName());
        ArrayList<Integer> inputs = new ArrayList<>(List.of(1, 2, 3, 4, 5, 2, 3, 4, 5, 6));
        boolean result = Sequence.straights(inputs);
        assertTrue(result);
        System.out.format(
                "\tlist %s can be broken up to entirely of straights of 5 cards: %b\n",
                inputs, result);
    }

    @Test
    public void straights_3() {
        printTestHeader(name.getMethodName());
        ArrayList<Integer> inputs = new ArrayList<>(List.of(1, 2, 3, 4, 5, 2, 3, 4, 5, 7));
        boolean result = Sequence.straights(inputs);
        assertFalse(result);
        System.out.format(
                "\tlist %s can be broken up to entirely of straights of 5 cards: %b\n",
                inputs, result);
    }

    @Test
    public void straights_4() {
        printTestHeader(name.getMethodName());
        ArrayList<Integer> inputs = new ArrayList<>(List.of(6, 2, 4, 1, 3, 5, 4, 5, 2, 3));
        boolean result = Sequence.straights(inputs);
        assertTrue(result);
        System.out.format(
                "\tlist %s can be broken up to entirely of straights of 5 cards: %b\n",
                inputs, result);
    }

    @Test
    public void straights_5() {
        printTestHeader(name.getMethodName());
        ArrayList<Integer> inputs = new ArrayList<>(List.of(2, 4, 1, 3, 5, 4, 5, 2, 3, 3));
        boolean result = Sequence.straights(inputs);
        assertFalse(result);
        System.out.format(
                "\tlist %s can be broken up to entirely of straights of 5 cards: %b\n",
                inputs, result);
    }

    @Test
    public void straights_6() {
        printTestHeader(name.getMethodName());
        Sequence.straights(null);
        boolean result = Sequence.straights(null);
        assertFalse(result);
        System.out.format(
                "\tlist null can be broken up to entirely of straights of 5 cards: %b\n",
                result);
    }
}
