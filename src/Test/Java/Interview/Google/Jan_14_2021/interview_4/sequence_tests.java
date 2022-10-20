package Test.Java.Interview.Google.Jan_14_2021.interview_4;

import Code.Java.Interview.Google.Jan_14_2021.interview_4.Sequence;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class sequence_tests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void XofAKind_1() throws Exception {
        ArrayList<Integer> inputs = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 6, 6, 6, 6));
        boolean result = Code.Java.Interview.Google.Jan_14_2021.interview_4.Sequence.XofAKind(inputs);
        System.out.format(
                "%s: list %s can be broken up to entirely X of a kind sequences: %b\n",
                name.getMethodName(), inputs, result);
        assertFalse(result);
    }

    @Test
    public void XofAKind_2() throws Exception {
        ArrayList<Integer> inputs = new ArrayList<>(List.of(6, 6, 6, 6, 6));
        boolean result = Code.Java.Interview.Google.Jan_14_2021.interview_4.Sequence.XofAKind(inputs);
        System.out.format(
                "%s: list %s can be broken up to entirely X of a kind sequences: %b\n",
                name.getMethodName(), inputs, result);
        assertTrue(result);
    }

    @Test
    public void XofAKind_3() throws Exception {
        ArrayList<Integer> inputs = new ArrayList<>(List.of(6, 5, 6, 5, 6, 6, 6));
        boolean result = Code.Java.Interview.Google.Jan_14_2021.interview_4.Sequence.XofAKind(inputs);
        System.out.format(
                "%s: list %s can be broken up to entirely X of a kind sequences: %b\n",
                name.getMethodName(), inputs, result);
        assertTrue(result);
    }

    @Test
    public void XofAKind_4() throws Exception {
        ArrayList<Integer> inputs = new ArrayList<>(List.of());
        boolean result = Code.Java.Interview.Google.Jan_14_2021.interview_4.Sequence.XofAKind(inputs);
        System.out.format(
                "%s: list %s can be broken up to entirely X of a kind sequences: %b\n",
                name.getMethodName(), inputs, result);
        assertTrue(result);
    }

    @Test
    public void XofAKind_5() throws Exception {
        ArrayList<Integer> inputs = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        boolean result = Code.Java.Interview.Google.Jan_14_2021.interview_4.Sequence.XofAKind(inputs);
        System.out.format(
                "%s: list %s can be broken up to entirely X of a kind sequences: %b\n",
                name.getMethodName(), inputs, result);
        assertFalse(result);
    }

    @Test(expected = Exception.class)
    public void XofAKind_6() throws Exception {
        Code.Java.Interview.Google.Jan_14_2021.interview_4.Sequence.XofAKind(null);
    }

    @Test
    public void straights_1() throws Exception {
        ArrayList<Integer> inputs = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        boolean result = Code.Java.Interview.Google.Jan_14_2021.interview_4.Sequence.straights(inputs);
        System.out.format(
                "%s: list %s can be broken up to entirely of straights of 5 cards: %b\n",
                name.getMethodName(), inputs, result);
        assertFalse(result);
    }

    @Test
    public void straights_2() throws Exception {
        ArrayList<Integer> inputs = new ArrayList<>(List.of(1, 2, 3, 4, 5, 2, 3, 4, 5, 6));
        boolean result = Code.Java.Interview.Google.Jan_14_2021.interview_4.Sequence.straights(inputs);
        System.out.format(
                "%s: list %s can be broken up to entirely of straights of 5 cards: %b\n",
                name.getMethodName(), inputs, result);
        assertTrue(result);
    }

    @Test
    public void straights_3() throws Exception {
        ArrayList<Integer> inputs = new ArrayList<>(List.of(1, 2, 3, 4, 5, 2, 3, 4, 5, 7));
        boolean result = Code.Java.Interview.Google.Jan_14_2021.interview_4.Sequence.straights(inputs);
        System.out.format(
                "%s: list %s can be broken up to entirely of straights of 5 cards: %b\n",
                name.getMethodName(), inputs, result);
        assertFalse(result);
    }

    @Test
    public void straights_4() throws Exception {
        ArrayList<Integer> inputs = new ArrayList<>(List.of(6, 2, 4, 1, 3, 5, 4, 5, 2, 3));
        boolean result = Code.Java.Interview.Google.Jan_14_2021.interview_4.Sequence.straights(inputs);
        System.out.format(
                "%s: list %s can be broken up to entirely of straights of 5 cards: %b\n",
                name.getMethodName(), inputs, result);
        assertTrue(result);
    }

    @Test
    public void straights_5() throws Exception {
        ArrayList<Integer> inputs = new ArrayList<>(List.of(2, 4, 1, 3, 5, 4, 5, 2, 3, 3));
        boolean result = Code.Java.Interview.Google.Jan_14_2021.interview_4.Sequence.straights(inputs);
        System.out.format(
                "%s: list %s can be broken up to entirely of straights of 5 cards: %b\n",
                name.getMethodName(), inputs, result);
        assertFalse(result);
    }

    @Test(expected = Exception.class)
    public void straights_7() throws Exception {
        Sequence.straights(null);
    }
}
