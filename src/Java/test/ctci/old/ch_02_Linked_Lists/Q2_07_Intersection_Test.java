package Java.test.ctci.old.ch_02_Linked_Lists;

import Java.code.ctci.old.ch_02_Linked_Lists.LinkedList;
import Java.code.ctci.old.ch_02_Linked_Lists.Q2_07_Intersection;
import Java.code.ctci.source.ctciLibrary.AssortedMethods;
import Java.code.ctci.source.ctciLibrary.LinkedListNode;
import Java.code.unsorted.classes.CustomLinkedList;
import Java.code.unsorted.classes.NodeList;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@SuppressWarnings({"NewClassNamingConvention", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q2_07_Intersection_Test {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void findIntersection_solution_1() {
        printTestHeader(name.getMethodName());
        /* Create linked list. */
        int[] vales = {-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8};
        LinkedListNode list1 = AssortedMethods.createLinkedListFromArray(vales);
        int[] vales2 = {12, 14, 15};
        LinkedListNode list2 = AssortedMethods.createLinkedListFromArray(vales2);
        list2.next.next = list1.next.next.next.next;
        System.out.format("\tList 1: %s\n", list1.printForward());
        System.out.format("\tList 2: %s\n", list2.printForward());
        LinkedListNode result = Q2_07_Intersection.findIntersection_solution_1(list1, list2);
        assertNotNull(result);
        System.out.format("\tList intersection: %s\n", result.printForward());
    }

    @Test
    public void intersects_1() {
        printTestHeader(name.getMethodName());
        CustomLinkedList<String> stringValue1 = new CustomLinkedList<>();
        stringValue1.insert("a");
        stringValue1.insert("b");
        stringValue1.insert("c");
        stringValue1.insert("d");
        stringValue1.insert("e");
        stringValue1.insert("f");
        System.out.format("\tList 1: %s\n", stringValue1);
        CustomLinkedList<String> stringValue2 = stringValue1.sublist(stringValue1, 3);
        System.out.format("\tList 2: %s\n", stringValue2);
        NodeList<String> result = LinkedList.intersects(stringValue1, stringValue2);
        assertNotNull(result);
        System.out.format("\tList intersects at: %s\n", result);
    }

    @Test
    public void intersects_2() {
        printTestHeader(name.getMethodName());
        CustomLinkedList<String> stringValue1 = new CustomLinkedList<>();
        stringValue1.insert("a");
        stringValue1.insert("b");
        stringValue1.insert("c");
        stringValue1.insert("d");
        stringValue1.insert("e");
        stringValue1.insert("f");
        System.out.format("\tList 1: %s\n", stringValue1);
        CustomLinkedList<String> stringValue2 = new CustomLinkedList<>();
        stringValue2.insert("a");
        stringValue2.insert("d");
        stringValue2.insert("f");
        stringValue2.insert("b");
        stringValue2.insert("e");
        stringValue2.insert("c");
        System.out.format("\tList 2: %s\n", stringValue2);
        NodeList<String> result = LinkedList.intersects(stringValue1, stringValue2);
        assertNull(result);
        System.out.format("\tList intersects at: null\n");
    }
}
