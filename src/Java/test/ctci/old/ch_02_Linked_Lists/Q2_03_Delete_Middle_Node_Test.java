package Java.test.ctci.old.ch_02_Linked_Lists;

import Java.code.ctci.old.ch_02_Linked_Lists.Q2_03_Delete_Middle_Node;
import Java.code.ctci.source.ctciLibrary.AssortedMethods;
import Java.code.ctci.source.ctciLibrary.LinkedListNode;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertNotEquals;

@SuppressWarnings("NewClassNamingConvention")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q2_03_Delete_Middle_Node_Test {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void removeMiddleNode() {
        printTestHeader(name.getMethodName());
        LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
        String notExpected = head.printForward();
        System.out.format("\tSource: %s\n", notExpected);
        LinkedListNode node_to_delete = head.next;
        System.out.format("\tRemove '%d' from head\n", 1);
        Q2_03_Delete_Middle_Node.removeNextNode(node_to_delete);
        String result = head.printForward();
        assertNotEquals(result, notExpected);
        System.out.format("\tResult: %s\n", result);
    }

    @Test
    public void removeMiddleNode_solution_1() {
        System.out.format("\tList\n");
        LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
        String notExpected = head.printForward();
        System.out.format("\tSource: %s\n", notExpected);
        System.out.format("\tRemove '%d' from head\n", 4);
        Q2_03_Delete_Middle_Node.removeMiddleNode_solution_1(head.next.next.next.next);
        String result = head.printForward();
        assertNotEquals(result, notExpected);
        System.out.format("\tResult: %s\n", result);
    }

    @Test
    public void removeXFromHead() {
        System.out.format("\tList\n");
        LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
        String notExpected = head.printForward();
        System.out.format("\tSource: %s\n", notExpected);
        int offset = 3;
        System.out.format("\tRemove '%d' from head\n", offset);
        Q2_03_Delete_Middle_Node.removeXFromHead(head, offset);
        String result = head.printForward();
        assertNotEquals(result, notExpected);
        System.out.format("\tResult: %s\n", result);
    }
}
