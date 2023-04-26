package Test.Java.Interview.Facebook.Practice;

import Java.Code.Interview.Facebook.Practice.ReverseOperations;
import Java.Code.Interview.Facebook.Practice.ReverseOperations.Node;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReverseOperationsTests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void ReverseOperations() {
        System.out.format("%s: ", name.getMethodName());
        ReverseOperations.getDescription();
    }

    @Test
    public void reverse_1() {
        int[] expected = {1, 8, 2, 9, 16, 12};
        int[] array = {1, 2, 8, 9, 12, 16};
        Node head = ReverseOperations.createLinkedList(array);
        Node output = ReverseOperations.reverse(head);
        Object[] result = ReverseOperations.createArray(output);
        System.out.format("%s: Reversing '%s' had a result of '%s'\n", name.getMethodName(), Arrays.toString(array), Arrays.toString(result));
        assertEquals(Arrays.toString(expected), Arrays.toString(result));
    }

    @Test
    public void reverse_2() {
        int[] expected = {24, 18, 2, 3, 5, 7, 9, 12, 6};
        int[] array = {2, 18, 24, 3, 5, 7, 9, 6, 12};
        Node head = ReverseOperations.createLinkedList(array);
        Node output = ReverseOperations.reverse(head);
        Object[] result = ReverseOperations.createArray(output);
        System.out.format("%s: Reversing '%s' had a result of '%s'\n", name.getMethodName(), Arrays.toString(array), Arrays.toString(result));
        assertEquals(Arrays.toString(expected), Arrays.toString(result));
    }
}
