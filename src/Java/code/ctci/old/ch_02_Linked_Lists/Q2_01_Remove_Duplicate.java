package Java.code.ctci.old.ch_02_Linked_Lists;

import Java.code.ctci.source.ctciLibrary.LinkedListNode;
import Java.code.unsorted.classes.CustomLinkedList;
import Java.code.unsorted.classes.NodeList;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("DuplicatedCode")
public class Q2_01_Remove_Duplicate {
  public static void removeDuplicate(CustomLinkedList<Integer> input) {
    Set<Integer> containmentSet = new HashSet<>();
    int index = 0;
    while (index < input.getSize()) {
      if (containmentSet.contains(input.getIndex(index).getData())) {
        input.removeIndex(index);
      } else {
        containmentSet.add(input.getIndex(index).getData());
        index++;
      }
    }
  }

  public static void removeDuplicate_no_storage(CustomLinkedList<Integer> input) {
    int startIndex = 0;
    while (startIndex < input.getSize()) {
      int testData = input.getIndex(startIndex).getData();
      int innerIndex = startIndex + 1;
      while (innerIndex < input.getSize()) {
        if (input.getIndex(innerIndex).getData() == testData) {
          input.removeIndex(innerIndex);
        } else {
          innerIndex++;
        }
      }
      startIndex++;
    }
  }

  public static void removeDuplicateAsNode(CustomLinkedList<Integer> toSimplify) {
    // Sending in original list, so I can use its remove method and not reimplement
    NodeList<Integer> currentNode = toSimplify.getFirst();
    int currentIndex = 0;
    while (currentNode.getNext() != null) {
      int offsetIndex = 0;
      NodeList<Integer> nextNode = currentNode;
      do {
        nextNode = nextNode.getNext();
        if (currentNode.getData().equals(nextNode.getData())) {
          nextNode = nextNode.getPrevious();
          toSimplify.removeIndex(currentIndex + offsetIndex + 1);
        } else {
          offsetIndex++;
        }
      } while (nextNode.getNext() != null);
      if (currentNode.getNext() != null) {
        currentNode = currentNode.getNext();
        currentIndex++;
      }
    }
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
      /* Remove all future nodes that have the same value. */
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
}
