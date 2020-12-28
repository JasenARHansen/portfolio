package CTCI.Ch_02_Linked_Lists;

import CTCI_SOURCE.other.Introduction.CtCILibrary.LinkedListNode;
import classesInstance.CustomLinkedList;
import classesInstance.NodeList;

public class Q2_02_Return_Kth_To_Last {

  public static NodeList<Integer> returnKthToLast(int k, CustomLinkedList<Integer> input) {
    if (input.getSize() < k) {
      return null;
    }
    return input.getIndex(input.getSize() - k);
  }

  public static int printKthToLast_solution_1(LinkedListNode head, int k) {
    if (head == null) {
      return 0;
    }
    int index = printKthToLast_solution_1(head.next, k) + 1;
    if (index == k) {
      System.out.println(k + "th to last node is " + head.data);
    }
    return index;
  }

  public static LinkedListNode printKthToLast_solution_2(LinkedListNode head, int k) {
    Index idx = new Index();
    return printKthToLast_solution_2(head, k, idx);
  }

  public static LinkedListNode printKthToLast_solution_2(LinkedListNode head, int k, Index idx) {
    if (head == null) {
      return null;
    }
    LinkedListNode node = printKthToLast_solution_2(head.next, k, idx);
    idx.value = idx.value + 1;
    if (idx.value == k) {
      return head;
    }
    return node;
  }

  public static LinkedListNode printKthToLast_solution_3(LinkedListNode head, int k) {
    LinkedListNode p1 = head;
    LinkedListNode p2 = head;

    /* Move p1 k nodes into the list.*/
    for (int i = 0; i < k; i++) {
      if (p1 == null) return null; // Out of bounds
      p1 = p1.next;
    }

    /* Move them at the same pace. When p1 hits the end,
     * p2 will be at the right element. */
    while (p1 != null) {
      p1 = p1.next;
      p2 = p2.next;
    }
    return p2;
  }

  public static void main(String[] args) {
  }

  public static class Index {
    public int value = 0;
  }
}
