package Java.test.ctci.old.ch_03_Stacks_and_Queues;

import Java.code.ctci.old.ch_03_Stacks_and_Queues.SortableStack;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.*;

@SuppressWarnings("ConstantValue")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SortableStackTest {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void SortableStack() {
        printTestHeader(name.getMethodName());
        SortableStack<Integer> result = new SortableStack<>();
        assertNotNull(result);
    }

    @Test
    public void getSize() {
        printTestHeader(name.getMethodName());
        SortableStack<Integer> sortableStack = new SortableStack<>();
        int data = 10;
        sortableStack.push(data);
        System.out.format("\tSource: %s\n", sortableStack);
        int result = sortableStack.getSize();
        assertEquals(1, result);
        System.out.format("\tSize: %d\n", result);
    }

    @Test
    public void isEmpty() {
        printTestHeader(name.getMethodName());
        SortableStack<Integer> sortableStack = new SortableStack<>();
        boolean result = sortableStack.isEmpty();
        assertTrue(result);
        int data = 10;
        sortableStack.push(data);
        System.out.format("\tSource: %s\n", sortableStack);
        result = sortableStack.isEmpty();
        assertFalse(result);
        System.out.format("\tEmpty: %b\n", result);
    }

    @Test
    public void peek() {
        printTestHeader(name.getMethodName());
        SortableStack<Integer> sortableStack = new SortableStack<>();
        int data = 10;
        sortableStack.push(data);
        System.out.format("\tSource: %s\n", sortableStack);
        int result = sortableStack.peek();
        assertEquals(data, result);
        assertFalse(sortableStack.isEmpty());
        System.out.format("\tPeek: %d\n", result);
    }

    @Test
    public void pop() {
        printTestHeader(name.getMethodName());
        SortableStack<Integer> sortableStack = new SortableStack<>();
        int data = 10;
        sortableStack.push(data);
        System.out.format("\tSource: %s\n", sortableStack);
        int result = sortableStack.pop();
        assertEquals(data, result);
        assertTrue(sortableStack.isEmpty());
        System.out.format("\tPop: %d\n", result);
    }

    @Test
    public void push() {
        printTestHeader(name.getMethodName());
        SortableStack<Integer> sortableStack = new SortableStack<>();
        int data = 10;
        boolean result = sortableStack.isEmpty();
        assertTrue(result);
        sortableStack.push(data);
        System.out.format("\tSource: %s\n", sortableStack);
        result = sortableStack.isEmpty();
        assertFalse(result);
        System.out.format("\tPush: %b\n", result);
    }

    @Test
    public void sort() {
        printTestHeader(name.getMethodName());
        SortableStack<Integer> sortableStack = new SortableStack<>();
        int data = 10;
        sortableStack.push(data++);
        sortableStack.push(data++);
        sortableStack.push(data);
        System.out.format("\tSource: %s\n", sortableStack);
        String result_1 = sortableStack.toString();
        sortableStack.sort();
        String result1_2 = sortableStack.toString();
        assertNotEquals(result_1, result1_2);
        System.out.format("\tSort: %s\n", result1_2);
    }
}
