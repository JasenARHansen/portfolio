package Test.Java.unsorted;

import Java.Code.unsorted.classes.CodeChallenge;
import Java.Code.unsorted.classes.classesInstance.Rectangle;
import Java.Code.unsorted.classes.classesInstance.Tuple;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CodeChallengeTests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void _description() {
        CodeChallenge.description();
    }

    @Test
    public void detectCycle_Small_Cycle() {
        boolean test = CodeChallenge.detectCycle(1, 2, 1, 3, 4, 8);
        assertTrue("Cycle", test);
    }

    @Test
    public void detectCycle_Small_No_Cycle() {
        boolean test = CodeChallenge.detectCycle(2);
        assertFalse("No cycle", test);
    }

    @Test
    public void findCommonComplex_1() {
        System.out.format("Test: %s\n", name.getMethodName());
        int[] array1 = {1, 2, 3, 4, 5, 6};
        int[] array2 = {3, 6, 9};

        List<Integer> value = CodeChallenge.findCommonComplex(array1, array2);
        System.out.println(value);
    }

    @Test
    public void findCommonComplex_2() {
        System.out.format("Test: %s\n", name.getMethodName());
        int[] array1 = {1, 2, 3, 3, 3, 3, 4, 5, 6};
        int[] array2 = {3, 3, 3, 6, 9};

        List<Integer> value = CodeChallenge.findCommonComplex(array1, array2);
        System.out.println(value);
    }

    @Test
    public void findCommonComplex_3() {
        System.out.format("Test: %s\n", name.getMethodName());
        int[] array1 = {1, 2, 3, 3, 3, 3, 4, 5, 6};
        int[] array2 = {3, 3, 3, 6, 9};
        int[] array3 = {3, 6};
        int[] array4 = {1, 2, 3, 4, 6, 11};
        int[] array5 = {2, 3, 4, 4, 5, 6, 9};

        List<Integer> value = CodeChallenge.findCommonComplex(array1, array2, array3, array4, array5);
        System.out.println(value);
    }

    @Test
    public void findCommonComplex_4() {
        System.out.format("Test: %s\n", name.getMethodName());
        int[] array1 = {2, 6, 9, 11, 13, 17};
        int[] array2 = {3, 6, 7, 10, 13, 18};
        int[] array3 = {4, 5, 6, 9, 11, 13};

        List<Integer> value = CodeChallenge.findCommonComplex(array1, array2, array3);
        System.out.println(value);
    }

    @Test
    public void findCommonComplex_5() {
        System.out.format("Test: %s\n", name.getMethodName());
        int[] array1 = {1, 2, 3, 4, 5, 6};

        List<Integer> value = CodeChallenge.findCommonComplex(array1);
        System.out.println(value);
    }

    @Test
    public void findSubsets() {
        System.out.format("Test: %s\n", name.getMethodName());
        ArrayList<ArrayList<Integer>> test = CodeChallenge.findSubsets(1, 2);
        CodeChallenge.printSubsets(test);
        assertEquals("4 subsets", test.size(), 4);
    }

    @Test
    public void firstPairSortedList_Failure() {
        List<Integer> test = CodeChallenge.firstPairSortedList(4, 2, 3, 4, 5, 6);
        assertNull("Test first Pair empty List", test);
    }

    @Test
    public void firstPairSortedList_Success() {
        List<Integer> test = CodeChallenge.firstPairSortedList(4, 1, 2, 3, 4, 5, 6);
        assertNotNull("Test first Pair empty List", test);
    }

    @Test
    public void firstPairSortedTuple_Failure() {
        Tuple<Integer, Integer> test = CodeChallenge.firstPairSortedTuple(4, 2, 3, 4, 5, 6);
        assertNull("Test first Pair null Tuple", test);
    }

    @Test
    public void firstPairSortedTuple_Success() {
        Tuple<Integer, Integer> test = CodeChallenge.firstPairSortedTuple(4, 1, 2, 3, 4, 5, 6);
        assertNotNull("Test first Pair valid List", test);
    }

    @Test
    public void firstPairUnortedList_Failure() {
        List<Integer> test = CodeChallenge.firstPairUnortedList(4, 5, 3, 2, 4, 6);
        assertNull("Test first Pair null Tuple", test);
    }

    @Test
    public void firstPairUnortedList_Success() {
        List<Integer> test = CodeChallenge.firstPairUnortedList(4, -1, 3, 18, 1, 8, 4);
        assertNotNull("Test first Pair valid List", test);
    }

    @Test
    public void firstPairUnortedTuple_Failure() {
        Tuple<Integer, Integer> test = CodeChallenge.firstPairUnortedTuple(4, 5, 3, 2, 4, 6);
        assertNull("Test first Pair null Tuple", test);
    }

    @Test
    public void firstPairUnortedTuple_Success() {
        Tuple<Integer, Integer> test = CodeChallenge.firstPairUnortedTuple(4, -1, 3, 18, 1, 8, 4);
        assertNotNull("Test first Pair valid List", test);
    }

    @Test
    public void incrementArrayValue() {
        int[] test = CodeChallenge.incrementArrayValue();
        assertEquals("Empty Array", test.length, 1);
        test = CodeChallenge.incrementArrayValue(1);
        assertEquals("1 digit no carry", test.length, 1);
        test = CodeChallenge.incrementArrayValue(9);
        assertEquals("1 digit carry", test.length, 2);
        test = CodeChallenge.incrementArrayValue(9, 5, 9);
        assertEquals("3 digits carry", test.length, 3);
        test = CodeChallenge.incrementArrayValue(9, 9, 9);
        assertEquals("3 digits carry", test.length, 4);
    }

    @Test
    public void pairExistsSorted_False() {
        Boolean test = CodeChallenge.pairExistsSorted(4, 2, 3, 4, 5, 6);
        assertFalse("Test Pair Exists False", test);
    }

    @Test
    public void pairExistsSorted_True() {
        Boolean test = CodeChallenge.pairExistsSorted(4, 1, 2, 3, 4, 5, 6);
        assertTrue("Test Pair Exists False", test);
    }

    @Test
    public void pairExistsUnorted_False() {
        Boolean test = CodeChallenge.pairExistsUnorted(4, 5, 3, 2, 4, 6);
        assertFalse("Test Pair Exists False", test);
    }

    @Test
    public void pairExistsUnorted_True() {
        Boolean test = CodeChallenge.pairExistsUnorted(4, -1, 3, 18, 1, 8, 4);
        assertTrue("Test Pair Exists False", test);
    }

    @Test
    public void placeNQueens_2() {
        System.out.format("Test: %s\n", name.getMethodName());
        List<Tuple<Integer, Integer>> test = CodeChallenge.placeNQueens(2);
        CodeChallenge.printQueens(test);
        assertEquals("Queen Count", test.size(), 0);
    }

    @Test
    public void placeNQueens_8() {
        System.out.format("Test: %s\n", name.getMethodName());
        List<Tuple<Integer, Integer>> test = CodeChallenge.placeNQueens(8);
        CodeChallenge.printQueens(test);
        assertEquals("Queen Count", test.size(), 8);
    }

    @Test
    public void rectangleOverlap_1() {
        Rectangle rectangle1 = new Rectangle(2, 1, 5, 5);
        Rectangle rectangle2 = new Rectangle(3, 2, 5, 7);

        int test = CodeChallenge.rectangleOverlap(rectangle1, rectangle2);
        assertEquals("Rectangle overlap", test, 6);
    }

    @Test
    public void rectangleOverlap_2() {
        Rectangle rectangle1 = new Rectangle(5, 5, 2, 1);
        Rectangle rectangle2 = new Rectangle(5, 7, 3, 2);

        int test = CodeChallenge.rectangleOverlap(rectangle1, rectangle2);
        assertEquals("Rectangle overlap", test, 0);
    }

    @Test
    public void rectangleOverlap_3() {
        Rectangle rectangle1 = new Rectangle(0, 0, 5, 5);
        Rectangle rectangle2 = new Rectangle(1, 1, 2, 2);

        int test = CodeChallenge.rectangleOverlap(rectangle1, rectangle2);
        assertEquals("Rectangle overlap", test, 1);
    }

    @Test
    public void rectangleOverlap_4() {
        Rectangle rectangle1 = new Rectangle(5, 5, 0, 0);
        Rectangle rectangle2 = new Rectangle(2, 2, 1, 1);

        int test = CodeChallenge.rectangleOverlap(rectangle1, rectangle2);
        assertEquals("Rectangle overlap", test, 0);
    }

    @Test
    public void searchComplex_1() {
        System.out.format("Test: %s\n", name.getMethodName());
        int[] array1 = {1, 2, 3, 4, 5, 6};
        int[] array2 = {7, 8, 9, 10, 11, 12, 13};
        int[] array3 = {3, 6, 9};
        int[] answer = CodeChallenge.mergeAndSort(array1, array2, array3);
        for (int i = 1; i <= answer.length; i++) {
            int value = CodeChallenge.searchComplex(i, array1, array2, array3);
            System.out.println("\tThe answer is: " + value + " and the expected is: " + answer[i - 1] + ".  This is "
                    + (value == answer[i - 1]));
        }
    }

    @Test
    public void searchComplex_2() {
        System.out.format("Test: %s\n", name.getMethodName());
        int[] array1 = {5, 3, 1, 2, 4, 6};
        int[] array2 = {11, 12, 7, 9, 8, 10, 13};
        int[] array3 = {6, 3, 9};
        int[] answer = CodeChallenge.mergeAndSort(array1, array2, array3);
        for (int i = 1; i <= answer.length; i++) {
            int value = CodeChallenge.searchComplex(i, array1, array2, array3);
            System.out.println("\tThe answer is: " + value + " and the expected is: " + answer[i - 1] + ".  This is "
                    + (value == answer[i - 1]));
        }
    }

    @Test
    public void sortTupleList() {
        System.out.format("Test: %s\n", name.getMethodName());
        List<Tuple<String, Integer>> values = new ArrayList<>();
        values.add(new Tuple<>("Jasen", 42));
        values.add(new Tuple<>("Evelyn", 62));
        values.add(new Tuple<>("Kelly", 23));
        values.add(new Tuple<>("William", 26));
        values.add(new Tuple<>("Christal", 33));

        System.out.println("Unsorted:");
        for (Tuple<String, Integer> value : values) {
            System.out.format("\t%s, %s\n", value.getLeftData(), value.getRightData());
        }
        System.out.println("Sorted Left:");
        CodeChallenge.sortTupelLeft(values);
        for (Tuple<String, Integer> value : values) {
            System.out.format("\t%s, %s\n", value.getLeftData(), value.getRightData());
        }
        System.out.println("Sorted Right:");
        CodeChallenge.sortTupelRight(values);
        for (Tuple<String, Integer> value : values) {
            System.out.format("\t%s, %s\n", value.getLeftData(), value.getRightData());
        }
    }

}
