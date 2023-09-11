package Java.test.ctci.old.ch_02_Linked_Lists.old;

import Java.code.ctci.old.ch_02_Linked_Lists.LinkedList;
import Java.code.unsorted.classes.CustomLinkedList;
import Java.code.unsorted.classes.NodeList;
import Java.code.unsorted.classes.classesInstance.CircularLinkedList;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.lang.reflect.Field;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.*;

@SuppressWarnings({"DuplicatedCode", "ConstantValue"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LinkedListTest {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void detectCycle_1() {
        printTestHeader(name.getMethodName());
        CircularLinkedList<String> stringList = new CircularLinkedList<>();
        stringList.insert("a");
        stringList.insert("b");
        stringList.insert("c");
        stringList.insert("d");
        stringList.insert("e");
        stringList.insert("f");
        System.out.format("\tSource: %s", stringList.list());
        NodeList<String> result = LinkedList.detectCycle(stringList);
        assertNull(result);
        System.out.format("\tCycle Node: %s\n", result);
    }

    @Test
    public void detectCycle_2() throws IllegalAccessException {
        printTestHeader(name.getMethodName());
        CircularLinkedList<String> stringList = new CircularLinkedList<>();
        stringList.insert("a");
        stringList.insert("b");
        stringList.insert("c");
        stringList.insert("d");
        stringList.insert("e");
        stringList.insert("f");
        // Corrupting the list to make a cycle
        NodeList<String> cyclePoint = stringList.getIndex(3);
        NodeList<String> cyclePointStart = stringList.getLast();
        Field declaredField;
        try {
            declaredField = NodeList.class.getDeclaredField("next");
            declaredField.setAccessible(true);
            declaredField.set(cyclePointStart, cyclePoint);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException e) {
            e.printStackTrace();
        }
        System.out.format("\tSource: %s", stringList.list());
        NodeList<String> result = LinkedList.detectCycle(stringList);
        assertNotNull(result);
        System.out.format("\tCycle Node: %s\n", result);
    }

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        LinkedList.getDescription();
    }

    @Test
    public void intersects_1() {
        printTestHeader(name.getMethodName());
        CustomLinkedList<String> stringList = new CustomLinkedList<>();
        stringList.insert("a");
        stringList.insert("b");
        stringList.insert("c");
        stringList.insert("d");
        stringList.insert("e");
        stringList.insert("f");
        System.out.format("\tSource: %s\n", stringList);
        CustomLinkedList<String> subList = stringList.sublist(stringList, 3);
        System.out.format("\tSublist: %s\n", subList);
        NodeList<String> result = LinkedList.intersects(stringList, subList);
        assertNotNull(result);
        System.out.format("\tIntersects at: %s\n", result);
    }

    @Test
    public void intersects_2() {
        printTestHeader(name.getMethodName());
        CustomLinkedList<String> stringList = new CustomLinkedList<>();
        stringList.insert("a");
        stringList.insert("a");
        stringList.insert("a");
        stringList.insert("a");
        stringList.insert("a");
        CustomLinkedList<String> subList = new CustomLinkedList<>();
        subList.insert("a");
        subList.insert("a");
        subList.insert("a");
        subList.insert("a");
        System.out.format("\tSource: %s\n", stringList);
        System.out.format("\tSublist: %s\n", subList);
        NodeList<String> result = LinkedList.intersects(stringList, subList);
        assertNull(result);
        System.out.format("\tIntersects at: %s\n", result);
    }

    @Test
    public void isPalindrome_1() {
        printTestHeader(name.getMethodName());
        CustomLinkedList<String> stringList = new CustomLinkedList<>();
        stringList.insert("a");
        stringList.insert("b");
        stringList.insert("b");
        stringList.insert("a");
        System.out.format("\tSource: %s\n", stringList);
        boolean result = LinkedList.isPalindrome(stringList);
        assertTrue(result);
        System.out.format("\tPalindrome: %s\n", result);
    }

    @Test
    public void isPalindrome_2() {
        printTestHeader(name.getMethodName());
        CustomLinkedList<String> stringList = new CustomLinkedList<>();
        stringList.insert("a");
        stringList.insert("b");
        stringList.insert("a");
        System.out.format("\tSource: %s\n", stringList);
        boolean result = LinkedList.isPalindrome(stringList);
        assertTrue(result);
        System.out.format("\tPalindrome: %s\n", result);
    }

    @Test
    public void isPalindrome_3() {
        printTestHeader(name.getMethodName());
        CustomLinkedList<String> stringList = new CustomLinkedList<>();
        stringList.insert("a");
        stringList.insert("b");
        stringList.insert("c");
        System.out.format("\tSource: %s\n", stringList);
        boolean result = LinkedList.isPalindromeInRange(stringList);
        assertFalse(result);
        System.out.format("\tPalindrome: %s\n", result);
    }

    @Test
    public void partition_1() {
        int expected = 10;
        printTestHeader(name.getMethodName());
        int partition = 5;
        CustomLinkedList<Integer> toSimplify = new CustomLinkedList<>();
        toSimplify.insert(0);
        toSimplify.insert(1);
        toSimplify.insert(6);
        toSimplify.insert(9);
        toSimplify.insert(4);
        toSimplify.insert(0);
        toSimplify.insert(6);
        toSimplify.insert(9);
        toSimplify.insert(6);
        toSimplify.insert(6);
        System.out.format("\tSource: %s\n", toSimplify);
        LinkedList.partition(toSimplify, partition);
        int result = toSimplify.getSize();
        assertEquals(expected, result);
        System.out.format("\tPartition %d Result: %s\n", partition, toSimplify);
    }

    @Test
    public void partition_2() {
        int expected = 10;
        printTestHeader(name.getMethodName());
        int partition = 7;
        CustomLinkedList<Integer> toSimplify = new CustomLinkedList<>();
        toSimplify.insert(0);
        toSimplify.insert(1);
        toSimplify.insert(6);
        toSimplify.insert(9);
        toSimplify.insert(4);
        toSimplify.insert(0);
        toSimplify.insert(6);
        toSimplify.insert(9);
        toSimplify.insert(6);
        toSimplify.insert(6);
        System.out.format("\tSource: %s\n", toSimplify);
        LinkedList.partition(toSimplify, partition);
        int result = toSimplify.getSize();
        assertEquals(expected, result);
        System.out.format("\tPartition %d Result: %s\n", partition, toSimplify);
    }

    @Test
    public void removeDuplicate_1() {
        int expected = 5;
        printTestHeader(name.getMethodName());
        CustomLinkedList<Integer> toSimplify = new CustomLinkedList<>();
        toSimplify.insert(0);
        toSimplify.insert(1);
        toSimplify.insert(6);
        toSimplify.insert(9);
        toSimplify.insert(4);
        toSimplify.insert(0);
        toSimplify.insert(6);
        toSimplify.insert(9);
        toSimplify.insert(6);
        toSimplify.insert(6);
        System.out.format("\tSource: %s\n", toSimplify);
        LinkedList.removeDuplicate(toSimplify);
        int result = toSimplify.getSize();
        assertEquals(expected, result);
        System.out.format("\tResult: %s\n", toSimplify);
    }

    @Test
    public void removeDuplicate_2() {
        int expected = 6;
        printTestHeader(name.getMethodName());
        CustomLinkedList<Integer> toSimplify = new CustomLinkedList<>();
        toSimplify.insert(0);
        toSimplify.insert(1);
        toSimplify.insert(6);
        toSimplify.insert(9);
        toSimplify.insert(4);
        toSimplify.insert(0);
        toSimplify.insert(5);
        toSimplify.insert(9);
        toSimplify.insert(6);
        toSimplify.insert(6);
        System.out.format("\tSource: %s\n", toSimplify);
        LinkedList.removeDuplicate(toSimplify);
        int result = toSimplify.getSize();
        assertEquals(expected, result);
        System.out.format("\tResult: %s\n", toSimplify);
    }

    @Test
    public void removeDuplicate_3() {
        int expected = 4;
        printTestHeader(name.getMethodName());
        CustomLinkedList<Integer> toSimplify = new CustomLinkedList<>();
        toSimplify.insert(0);
        toSimplify.insert(9);
        toSimplify.insert(6);
        toSimplify.insert(0);
        toSimplify.insert(4);
        toSimplify.insert(0);
        toSimplify.insert(6);
        toSimplify.insert(9);
        toSimplify.insert(0);
        toSimplify.insert(6);
        System.out.format("\tSource: %s\n", toSimplify);
        LinkedList.removeDuplicate(toSimplify);
        int result = toSimplify.getSize();
        assertEquals(expected, result);
        System.out.format("\tResult: %s\n", toSimplify);
    }

    @Test
    public void removeKthFromLast_1() {
        int expected = 5;
        printTestHeader(name.getMethodName());
        int k = 5;
        CustomLinkedList<Integer> toSimplify = new CustomLinkedList<>();
        toSimplify.insert(0);
        toSimplify.insert(1);
        toSimplify.insert(9);
        toSimplify.insert(9);
        toSimplify.insert(6);
        toSimplify.insert(6);
        System.out.format("\tK = %d Test 2 source: %s\n", k, toSimplify);
        LinkedList.removeKthFromLast(3, toSimplify);
        int result = toSimplify.getSize();
        assertEquals(expected, result);
        System.out.format("\tResult: %s\n", toSimplify);
    }

    @Test
    public void removeKthFromLast_2() {
        int expected = 5;
        printTestHeader(name.getMethodName());
        int k = 3;
        CustomLinkedList<Integer> toSimplify = new CustomLinkedList<>();
        toSimplify.insert(0);
        toSimplify.insert(1);
        toSimplify.insert(9);
        toSimplify.insert(9);
        toSimplify.insert(6);
        toSimplify.insert(6);
        System.out.format("\tK = %d Test 2 source: %s\n", k, toSimplify);
        LinkedList.removeKthFromLast(3, toSimplify);
        int result = toSimplify.getSize();
        assertEquals(expected, result);
        System.out.format("\tResult: %s\n", toSimplify);
    }

    @Test
    public void removeKthFromLast_3() {
        int expected = 5;
        printTestHeader(name.getMethodName());
        int k = 1;
        CustomLinkedList<Integer> toSimplify = new CustomLinkedList<>();
        toSimplify.insert(0);
        toSimplify.insert(1);
        toSimplify.insert(9);
        toSimplify.insert(9);
        toSimplify.insert(6);
        toSimplify.insert(6);
        System.out.format("\tK = %d Test 2 source: %s\n", k, toSimplify);
        LinkedList.removeKthFromLast(3, toSimplify);
        int result = toSimplify.getSize();
        assertEquals(expected, result);
        System.out.format("\tResult: %s\n", toSimplify);
    }

    @Test
    public void removeMiddleNode() throws IllegalAccessException {
        int expected = 2;
        printTestHeader(name.getMethodName());
        int node = 1;
        CustomLinkedList<Integer> toSimplify = new CustomLinkedList<>();
        toSimplify.insert(0);
        toSimplify.insert(1);
        toSimplify.insert(6);
        System.out.format("\tSource: %s\n", toSimplify);
        LinkedList.removeMiddleNode(toSimplify.getIndex(node), toSimplify);
        int result = toSimplify.getSize();
        assertEquals(expected, result);
        System.out.format("\tResult: %s\n", toSimplify);
    }

    @Test
    public void sumList_1() {
        int expected = 4;
        printTestHeader(name.getMethodName());
        CustomLinkedList<Integer> intValue1 = new CustomLinkedList<>();
        intValue1.insert(7);
        intValue1.insert(1);
        intValue1.insert(6);
        CustomLinkedList<Integer> intValue2 = new CustomLinkedList<>();
        intValue2.insert(5);
        intValue2.insert(9);
        intValue2.insert(2);
        System.out.println("\tSource:");
        System.out.format("\t\t%s\n", intValue1);
        System.out.format("\t\t%s\n", intValue2);
        CustomLinkedList<Integer> result = LinkedList.sumList(intValue1, intValue2);
        assertEquals(expected, result.getSize());
        System.out.format("\tResult: %s\n", result);
    }

    @Test
    public void sumList_2() {
        int expected = 3;
        printTestHeader(name.getMethodName());
        CustomLinkedList<Integer> intValue1 = new CustomLinkedList<>();
        intValue1.insert(6);
        intValue1.insert(1);
        intValue1.insert(7);
        CustomLinkedList<Integer> intValue2 = new CustomLinkedList<>();
        intValue2.insert(2);
        intValue2.insert(9);
        intValue2.insert(5);
        System.out.println("\tSource:");
        System.out.format("\t\t%s\n", intValue1);
        System.out.format("\t\t%s\n", intValue2);
        CustomLinkedList<Integer> result = LinkedList.sumList(intValue1, intValue2);
        assertEquals(expected, result.getSize());
        System.out.format("\tResult: %s\n", result);
    }
}
