package CTCI_SOURCE.Ch_02_Linked_Lists.Q2_04_Partition;

import CTCI_SOURCE.other.Introduction.CtCILibrary.LinkedListNode;

public class Tester {

  public static LinkedListNode createLinkedList() {
    /* Create linked list */
    int[] vales = {3, 5, 8, 5, 10, 2, 1};
    LinkedListNode head = new LinkedListNode(vales[0], null, null);
    LinkedListNode current = head;
    for (int i = 1; i < vales.length; i++) {
      current = new LinkedListNode(vales[i], null, current);
    }
    return head;
  }

  public static void main(String[] args) {
    System.out.println(createLinkedList().printForward());

    /* Partition */
    LinkedListNode hA = QuestionA.partition(createLinkedList(), 5);
    LinkedListNode hB = QuestionB.partition(createLinkedList(), 5);
    LinkedListNode hC = QuestionC.partition(createLinkedList(), 5);

    /* Print Result */
    System.out.println(hA.printForward());
    System.out.println(hB.printForward());
    System.out.println(hC.printForward());
  }
}
