package CTCI.Ch_02_Linked_Lists;

import CTCI.CtCILibrary.LinkedListNode;
import classesInstance.CustomLinkedList;
import classesInstance.NodeList;

import java.util.HashSet;

public class Q2_02_Remove_Kth_To_Last {

  public static void removeKthFromLast(int k, CustomLinkedList<Integer> input) {
    if (input.getSize() < k) {
      return;
    }
    input.removeIndex(input.getSize() - k);
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

  public static void removeKthFromLast2(int k, CustomLinkedList<Integer> input) {
    if (input.getSize() < k) {
      return;
    }
    NodeList<Integer> pointerNode = input.getFirst();
    for (int i = 0; i < k - 1; i++) {
      pointerNode = pointerNode.getNext();
    }

    int deleteIndex = 0;
    for (int i = k; i < input.getSize(); i++) {
      pointerNode = pointerNode.getNext();
      deleteIndex++;
    }
    input.removeIndex(deleteIndex);
  }

  public static void removeDuplicate_solution_1(LinkedListNode n) {
    HashSet<Integer> set = new HashSet<>();
    LinkedListNode previous = null;
    while (n != null) {
      if (set.contains(n.data)) {
        previous.next = n.next;
      } else {
        set.add(n.data);
        previous = n;
      }
      n = n.next;
    }
  }

  public static void removeDuplicate_solution_2(LinkedListNode head) {
    LinkedListNode current = head;
    while (current != null) {
      /* Remove all future nodes that have the same value */
      LinkedListNode runner = current;
      while (runner.next != null) {
        if (runner.next.data == current.data) {
          runner.next = runner.next.next;
        } else {
          runner = runner.next;
        }
      }
      current = current.next;
    }
  }

  public static void removeDuplicate_solution_3(LinkedListNode head) {
    if (head == null) return;
    LinkedListNode previous = head;
    LinkedListNode current = previous.next;
    while (current != null) {
      // Look backwards for duplicates, and remove any that you see.
      LinkedListNode runner = head;
      while (runner != current) {
        if (runner.data == current.data) {
          LinkedListNode tmp = current.next;
          previous.next = tmp;
          current = tmp;
          // We know we can't have more than one duplicate preceding  our element since it would
          // have been removed earlier.
          break;
        }
        runner = runner.next;
      }

      // If runner == current, then we didn't find any duplicate  elements in the previous for loop.
      //  We then need to increment current.
      // If runner != current, then we must have hit the �break�  condition, in which case we found
      // a duplicate and current has  already been incremented.
      if (runner == current) {
        previous = current;
        current = current.next;
      }
    }
  }

  public static void main(String[] args) {
  }
}
