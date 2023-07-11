package Java.test.ctci.old.ch_02_Linked_Lists;

import Java.code.ctci.old.ch_02_Linked_Lists.Q2_03_Delete_Middle_Node;
import Java.code.ctci.source.ctciLibrary.AssortedMethods;
import Java.code.ctci.source.ctciLibrary.LinkedListNode;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings("NewClassNamingConvention")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q2_03_Delete_Middle_Node_Test {
  @Rule public final TestName name = new TestName();

  @Test
  public void removeMiddleNode() {
    System.out.format("%s: List\n", name.getMethodName());
    LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
    System.out.println(head.printForward());
    LinkedListNode node_to_delete = head.next;
    System.out.format("%s: Remove '%d' from head\n", name.getMethodName(), 1);
    Q2_03_Delete_Middle_Node.removeNextNode(node_to_delete);
    System.out.println(head.printForward());
  }

  @Test
  public void removeXFromHead() {
    System.out.format("%s: List\n", name.getMethodName());
    LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
    System.out.println(head.printForward());
    int offset = 3;
    System.out.format("%s: Remove '%d' from head\n", name.getMethodName(), offset);
    Q2_03_Delete_Middle_Node.removeXFromHead(head, offset);
    System.out.println(head.printForward());
  }

  @Test
  public void removeMiddleNode_solution_1() {
    System.out.format("%s: List\n", name.getMethodName());
    LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
    System.out.println(head.printForward());
    System.out.format("%s: Remove '%d' from head\n", name.getMethodName(), 4);
    Q2_03_Delete_Middle_Node.removeMiddleNode_solution_1(head.next.next.next.next); // delete node 4
    System.out.println(head.printForward());
  }
}