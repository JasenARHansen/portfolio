package Java.test.ctci.old.ch_03_Stacks_and_Queues;

import Java.code.ctci.old.ch_03_Stacks_and_Queues.MultiStackArrayList;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.*;

@SuppressWarnings({"ConstantValue", "DuplicatedCode", "DataFlowIssue"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MultiStackArrayListTest {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void MultiStackArrayList() {
        int expected = 3;
        printTestHeader(name.getMethodName());
        MultiStackArrayList stacksArray = new MultiStackArrayList();
        int result = stacksArray.getStackCount();
        assertEquals(expected, result);
    }

    @Test
    public void MultiStackArrayList_size() {
        int expected = 5;
        printTestHeader(name.getMethodName());
        MultiStackArrayList stacksArray = new MultiStackArrayList(expected);
        int result = stacksArray.getStackCount();
        assertEquals(expected, result);
        printTestHeader(name.getMethodName());
    }

    @Test
    public void getSize_1() {
        int expected = 2;
        printTestHeader(name.getMethodName());
        MultiStackArrayList stacksArray = new MultiStackArrayList();
        int stack = 0;
        int data = 10;
        stacksArray.push(stack, data);
        stacksArray.push(stack, data);
        System.out.format("\tStack:\n%s", stacksArray);
        int result = stacksArray.getSize(stack);
        assertEquals(expected, result);
        System.out.format("\tStack %d size %d\n", stack, result);
    }

    @Test
    public void getSize_2() {
        int expected = 0;
        printTestHeader(name.getMethodName());
        MultiStackArrayList stacksArray = new MultiStackArrayList();
        int stack = 0;
        int data = 10;
        stacksArray.push(stack, data);
        stacksArray.push(stack, data);
        int index = 1;
        System.out.format("\tStack:\n%s", stacksArray);
        int result = stacksArray.getSize(index);
        assertEquals(expected, result);
        System.out.format("\tStack %d size %d\n", index, result);
    }

    @Test
    public void getStackCount() {
        int expected = 6;
        printTestHeader(name.getMethodName());
        MultiStackArrayList stacksArray = new MultiStackArrayList(expected);
        System.out.format("\tStack:\n%s", stacksArray);
        int result = stacksArray.getStackCount();
        assertEquals(expected, result);
        System.out.format("\tCount %s\n", result);
    }

    @Test
    public void isEmpty_1() {
        printTestHeader(name.getMethodName());
        MultiStackArrayList stacksArray = new MultiStackArrayList();
        System.out.format("\tStack:\n%s", stacksArray);
        int stack = 1;
        int data = 10;
        stacksArray.push(stack, data);
        int index = 0;
        boolean result = stacksArray.isEmpty(index);
        assertTrue(result);
        System.out.format("\tStack %d Empty: %b\n", stack, result);
    }

    @Test
    public void isEmpty_2() {
        printTestHeader(name.getMethodName());
        MultiStackArrayList stacksArray = new MultiStackArrayList();
        int stack = 1;
        int data = 10;
        stacksArray.push(stack, data);
        System.out.format("\tStack:\n%s", stacksArray);
        boolean result = stacksArray.isEmpty(stack);
        assertFalse(result);
        System.out.format("\tStack %d Empty: %b\n", stack, result);
    }

    @Test
    public void isEmpty_3() {
        printTestHeader(name.getMethodName());
        MultiStackArrayList stacksArray = new MultiStackArrayList();
        int stack = 1;
        int data = 10;
        stacksArray.push(stack, data);
        System.out.format("\tStack:\n%s", stacksArray);
        boolean result = stacksArray.isEmpty();
        assertFalse(result);
        System.out.format("\tAll Empty: %b\n", result);
    }

    @Test
    public void isEmpty_4() {
        printTestHeader(name.getMethodName());
        MultiStackArrayList stacksArray = new MultiStackArrayList();
        System.out.format("\tStack:\n%s", stacksArray);
        boolean result = stacksArray.isEmpty();
        assertTrue(result);
        System.out.format("\tAll Empty: %b\n", result);
    }

    @Test
    public void peek_1() {
        int expected = 10;
        printTestHeader(name.getMethodName());
        MultiStackArrayList stacksArray = new MultiStackArrayList();
        int stack = 0;
        stacksArray.push(stack, expected);
        System.out.format("\tStack:\n%s", stacksArray);
        int result = stacksArray.peek(stack);
        assertEquals(expected, result);
        System.out.format("\tStack %d peek %d\n", stack, result);
    }

    @Test(expected = Exception.class)
    public void peek_2() {
        printTestHeader(name.getMethodName());
        MultiStackArrayList stacksArray = new MultiStackArrayList();
        int stack = 0;
        int data = 10;
        stacksArray.push(stack, data);
        System.out.format("\tStack:\n%s", stacksArray);
        int index = 1;
        System.out.format("\tStack %d peek Empty Stack Exception\n", index);
        stacksArray.peek(index);
    }

    @Test
    public void print() {
        int expected_1 = 13;
        int expected_2 = 22;
        int expected_3 = 32;
        printTestHeader(name.getMethodName());
        MultiStackArrayList stacksArray = new MultiStackArrayList();
        int stack = 0;
        int data = 10;
        stacksArray.push(stack, data);
        stack = 1;
        data = 20;
        stacksArray.push(stack, data);
        stack = 2;
        data = 30;
        stacksArray.push(stack, data);
        stack = 1;
        data = 21;
        stacksArray.push(stack, data);
        stack = 0;
        data = 11;
        stacksArray.push(stack, data);
        stack = 0;
        data = 12;
        stacksArray.push(stack, data);
        stack = 0;
        data = 13;
        stacksArray.push(stack, data);
        stack = 1;
        data = 22;
        stacksArray.push(stack, data);
        stack = 2;
        data = 32;
        stacksArray.push(stack, data);
        System.out.format("\tStack:\n%s", stacksArray);
        int first = 0;
        int second = 1;
        int third = 2;
        int first_size = stacksArray.peek(first);
        int second_size = stacksArray.peek(second);
        int third_size = stacksArray.peek(third);
        assertEquals(expected_1, first_size);
        assertEquals(expected_2, second_size);
        assertEquals(expected_3, third_size);
        System.out.format("\tStack %d peek %d\n", first, first_size);
        System.out.format("\tStack %d peek %d\n", second, second_size);
        System.out.format("\tStack %d peek %d\n", third, third_size);
    }

    @Test
    public void push() {
        int expected = 10;
        printTestHeader(name.getMethodName());
        MultiStackArrayList stacksArray = new MultiStackArrayList();
        int stack = 2;
        System.out.format("\tStack:\n%s", stacksArray);
        stacksArray.push(stack, expected);
        System.out.format("\tStack %d Push %d\n", stack, expected);
        int result = stacksArray.peek(stack);
        assertEquals(expected, result);
        System.out.format("\tStack:\n%s", stacksArray);
    }
}
