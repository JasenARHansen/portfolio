package Java.test.ctci.old.ch_02_Linked_Lists;

import static org.junit.Assert.*;

import Java.code.ctci.old.ch_02_Linked_Lists.Q2_01_Remove_Duplicate;
import Java.code.ctci.source.ctciLibrary.LinkedListNode;
import Java.code.unsorted.classes.CustomLinkedList;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"NewClassNamingConvention", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q2_01_Remove_Duplicate_Test {
  @Rule public final TestName name = new TestName();

  @Test
  public void removeDuplicate() {
    System.out.format("%s: Initial list\n", name.getMethodName());
    CustomLinkedList<Integer> toSimplify = new CustomLinkedList<>();
    toSimplify.insert(0);
    toSimplify.insert(1);
    toSimplify.insert(6);
    toSimplify.insert(9);
    toSimplify.insert(4);
    toSimplify.insert(0);
    toSimplify.insert(6);
    toSimplify.insert(9);
    toSimplify.insert(6);
    toSimplify.insert(6);
    toSimplify.printList();
    int length_1 = toSimplify.getSize();
    Q2_01_Remove_Duplicate.removeDuplicate(toSimplify);
    int length_2 = toSimplify.getSize();
    System.out.format("%s: Cleaned list\n", name.getMethodName());
    toSimplify.printList();
    assertNotEquals(length_1, length_2);
  }

  @Test
  public void removeDuplicate_no_storage() {
    System.out.format("%s: Initial list\n", name.getMethodName());
    CustomLinkedList<Integer> toSimplify = new CustomLinkedList<>();
    toSimplify.insert(0);
    toSimplify.insert(1);
    toSimplify.insert(6);
    toSimplify.insert(9);
    toSimplify.insert(4);
    toSimplify.insert(0);
    toSimplify.insert(6);
    toSimplify.insert(9);
    toSimplify.insert(6);
    toSimplify.insert(6);
    toSimplify.printList();
    int length_1 = toSimplify.getSize();
    Q2_01_Remove_Duplicate.removeDuplicate_no_storage(toSimplify);
    int length_2 = toSimplify.getSize();
    System.out.format("%s: Cleaned list\n", name.getMethodName());
    toSimplify.printList();
    assertNotEquals(length_1, length_2);
  }

  @Test
  public void removeDuplicateAsNode() {
    System.out.format("%s: Initial list\n", name.getMethodName());
    CustomLinkedList<Integer> toSimplify = new CustomLinkedList<>();
    toSimplify.insert(0);
    toSimplify.insert(1);
    toSimplify.insert(6);
    toSimplify.insert(9);
    toSimplify.insert(4);
    toSimplify.insert(0);
    toSimplify.insert(6);
    toSimplify.insert(9);
    toSimplify.insert(6);
    toSimplify.insert(6);
    toSimplify.printList();
    int length_1 = toSimplify.getSize();
    Q2_01_Remove_Duplicate.removeDuplicateAsNode(toSimplify);
    int length_2 = toSimplify.getSize();
    System.out.format("%s: Cleaned list\n", name.getMethodName());
    toSimplify.printList();
    assertNotEquals(length_1, length_2);
  }

  @Test
  public void isUniqueChars_solution_1() {
    System.out.format("%s: Initial list\n", name.getMethodName());
    LinkedListNode first =
        new LinkedListNode(0, null, null); // AssortedMethods.randomLinkedList(1000, 0, 2);
    LinkedListNode head = first;
    LinkedListNode second;
    for (int i = 1; i < 8; i++) {
      second = new LinkedListNode(i % 2, null, null);
      first.setNext(second);
      second.setPrevious(first);
      first = second;
    }
    System.out.println(head.printForward());
    Q2_01_Remove_Duplicate.removeDuplicate_solution_1(head);
    System.out.println(head.printForward());
  }

  @Test
  public void isUniqueChars_solution_2() {
    System.out.format("%s: Initial list\n", name.getMethodName());
    LinkedListNode first =
        new LinkedListNode(0, null, null); // AssortedMethods.randomLinkedList(1000, 0, 2);
    LinkedListNode head = first;
    LinkedListNode second;
    for (int i = 1; i < 8; i++) {
      second = new LinkedListNode(i % 2, null, null);
      first.setNext(second);
      second.setPrevious(first);
      first = second;
    }
    System.out.println(head.printForward());
    Q2_01_Remove_Duplicate.removeDuplicate_solution_2(head);
    System.out.println(head.printForward());
  }

  @Test
  public void isUniqueChars_solution_3() {
    System.out.format("%s: Initial list\n", name.getMethodName());
    LinkedListNode first =
        new LinkedListNode(0, null, null); // AssortedMethods.randomLinkedList(1000, 0, 2);
    LinkedListNode head = first;
    LinkedListNode second;
    for (int i = 1; i < 8; i++) {
      second = new LinkedListNode(i % 2, null, null);
      first.setNext(second);
      second.setPrevious(first);
      first = second;
    }
    System.out.println(head.printForward());
    Q2_01_Remove_Duplicate.removeDuplicate_solution_3(head);
    System.out.println(head.printForward());
  }
}
