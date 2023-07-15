package Java.test.ctci.old.ch_03_Stacks_and_Queues;

import Java.code.ctci.old.ch_03_Stacks_and_Queues.SortableStack;
import Java.code.ctci.old.ch_03_Stacks_and_Queues.SortableStack2;
import Java.code.ctci.source.ctciLibrary.AssortedMethods;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Stack;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@SuppressWarnings({"NewClassNamingConvention", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q3_05_Sort_Stack_Test {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void SortableStack() {
        String expected = "[123, 55, 23, 5, 1, 0]";
        printTestHeader(name.getMethodName());
        SortableStack<Integer> sortableStack = new SortableStack<>();
        int[] array = new int[]{55, 1, 23, 0, 123, 5};
        for (int data : array) {
            sortableStack.push(data);
            System.out.format("\tPush '%s' on Stack '%s'\n", data, sortableStack);
        }
        sortableStack.sort();
        String result = sortableStack.toString();
        assertEquals(expected, result);
        System.out.format("\tSorted Queue '%s'\n", sortableStack);
        for (int i = 0; i < array.length; i++) {
            System.out.format("\tPop '%s' on Stack '%s'\n", sortableStack.pop(), sortableStack);
        }
    }

    @Test
    public void sort_stack_solution_1() {
        printTestHeader(name.getMethodName());
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < 10; i++) {
            int r = AssortedMethods.randomIntInRange(0, 1000);
            s.push(r);
        }
        String notExpected = s.toString();
        SortableStack2.sort(s);
        String result = s.toString();
        assertNotEquals(notExpected, result);
        while (!s.isEmpty()) {
            System.out.format("\t%s\n", s.pop());
        }
    }

    @Test
    public void sort_stack_solution_2() {
        printTestHeader(name.getMethodName());
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < 10; i++) {
            int r = AssortedMethods.randomIntInRange(0, 1000);
            s.push(r);
        }
        String notExpected = s.toString();
        SortableStack2.mergesort(s);
        String result = s.toString();
        assertNotEquals(notExpected, result);
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
