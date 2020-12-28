package CTCI.Ch_02_Linked_Lists;

import CTCI_SOURCE.other.Introduction.CtCILibrary.LinkedListNode;

public class Q2_04_Partition {

  public static LinkedListNode partition_solution_1(LinkedListNode node, int x) {
    LinkedListNode beforeStart = null;
    LinkedListNode beforeEnd = null;
    LinkedListNode afterStart = null;
    LinkedListNode afterEnd = null;

    /* Partition list */
    while (node != null) {
      LinkedListNode next = node.next;
      node.next = null;
      if (node.data < x) {
        if (beforeStart == null) {
          beforeStart = node;
          beforeEnd = beforeStart;
        } else {
          beforeEnd.next = node;
          beforeEnd = node;
        }
      } else {
        if (afterStart == null) {
          afterStart = node;
          afterEnd = afterStart;
        } else {
          afterEnd.next = node;
          afterEnd = node;
        }
      }
      node = next;
    }

    /* Merge before list and after list */
    if (beforeStart == null) {
      return afterStart;
    }

    beforeEnd.next = afterStart;
    return beforeStart;
  }

  public static LinkedListNode partition_solution_2(LinkedListNode node, int x) {
    LinkedListNode beforeStart = null;
    LinkedListNode afterStart = null;

    /* Partition list */
    while (node != null) {
      LinkedListNode next = node.next;
      if (node.data < x) {
        /* Insert node into start of before list */
        node.next = beforeStart;
        beforeStart = node;
      } else {
        /* Insert node into front of after list */
        node.next = afterStart;
        afterStart = node;
      }
      node = next;
    }

    /* Merge before list and after list */
    if (beforeStart == null) {
      return afterStart;
    }

    LinkedListNode head = beforeStart;
    while (beforeStart.next != null) {
      beforeStart = beforeStart.next;
    }
    beforeStart.next = afterStart;
    return head;
  }

  public static LinkedListNode partition_solution_3(LinkedListNode node, int x) {
    LinkedListNode head = node;
    LinkedListNode tail = node;

    /* Partition list */
    while (node != null) {
      LinkedListNode next = node.next;
      if (node.data < x) {
        /* Insert node at head. */
        node.next = head;
        head = node;
      } else {
        /* Insert node at tail. */
        tail.next = node;
        tail = node;
      }
      node = next;
    }
    assert tail != null;
    tail.next = null;

    return head;
  }

  public static void main(String[] args) {
  }
}
