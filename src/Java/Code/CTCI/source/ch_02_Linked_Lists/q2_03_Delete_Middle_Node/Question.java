package Java.code.ctci.source.ch_02_Linked_Lists.q2_03_Delete_Middle_Node;

import Java.code.ctci.source.ctciLibrary.AssortedMethods;
import Java.code.ctci.source.ctciLibrary.LinkedListNode;

@SuppressWarnings("UnusedReturnValue")
public class Question {
  public static void main(String[] args) {
    LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
    System.out.println(head.printForward());
    deleteNode(head.next.next.next.next); // delete node 4
    System.out.println(head.printForward());
  }

  public static boolean deleteNode(LinkedListNode n) {
    if (n == null || n.next == null) {
      return false; // Failure
    }
    LinkedListNode next = n.next;
    n.data = next.data;
    n.next = next.next;
    return true;
  }
}
