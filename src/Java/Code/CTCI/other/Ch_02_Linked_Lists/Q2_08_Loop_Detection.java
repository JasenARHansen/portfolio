package Java.Code.CTCI.other.Ch_02_Linked_Lists;

import Java.Code.CTCI.CTCI_SOURCE.other.CtCILibrary.LinkedListNode;

@SuppressWarnings("DuplicatedCode")
public class Q2_08_Loop_Detection {
  public static LinkedListNode FindBeginning_solution_1(LinkedListNode head) {
    LinkedListNode slow = head;
    LinkedListNode fast = head;
    // Find meeting point
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        break;
      }
    }
    // Error check - there is no meeting point, and therefore no loop
    if (fast == null || fast.next == null) {
      return null;
    }
    /* Move slow to Head. Keep fast at Meeting Point. Each are k steps
    /* from the Loop Start. If they move at the same pace, they must
       meet at Loop Start. */
    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    // Both now point to the start of the loop.
    return fast;
  }

  public static void main(String[] args) {}
}
