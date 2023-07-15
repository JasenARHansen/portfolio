package Java.test.interview.Facebook.practice;

import Java.code.interview.Facebook.practice.ReverseOperations;
import Java.code.interview.Facebook.practice.ReverseOperations.Node;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertArrayEquals;

@SuppressWarnings("DuplicatedCode")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReverseOperationsTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        ReverseOperations.getDescription();
    }

    @Test
    public void reverse_1() {
        int[] expected = {1, 8, 2, 9, 16, 12};
        printTestHeader(name.getMethodName());
        int[] array = {1, 2, 8, 9, 12, 16};
        Node head = ReverseOperations.createLinkedList(array);
        Node output = ReverseOperations.reverse(head);
        int[] result = ReverseOperations.createArray(output);
        System.out.format(
                "\tReversing '%s' had a result of '%s'\n",
                Arrays.toString(array), Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void reverse_2() {
        int[] expected = {24, 18, 2, 3, 5, 7, 9, 12, 6};
        printTestHeader(name.getMethodName());
        int[] array = {2, 18, 24, 3, 5, 7, 9, 6, 12};
        Node head = ReverseOperations.createLinkedList(array);
        Node output = ReverseOperations.reverse(head);
        int[] result = ReverseOperations.createArray(output);
        System.out.format(
                "\tReversing '%s' had a result of '%s'\n",
                Arrays.toString(array), Arrays.toString(result));
        assertArrayEquals(expected, result);
    }
}
