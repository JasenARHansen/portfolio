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
    System.out.format("%s:\n", name.getMethodName());
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
    System.out.format("\tSource: %s\n", toSimplify);
    int result_1 = toSimplify.getSize();
    Q2_01_Remove_Duplicate.removeDuplicate(toSimplify);
    int result_2 = toSimplify.getSize();
    assertNotEquals(result_1, result_2);
    System.out.format("\tResult: %s\n", toSimplify);
  }

  @Test
  public void removeDuplicate_no_storage() {
    System.out.format("%s:\n", name.getMethodName());
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
    System.out.format("\tSource: %s\n", toSimplify);
    int result_1 = toSimplify.getSize();
    Q2_01_Remove_Duplicate.removeDuplicate_no_storage(toSimplify);
    int result_2 = toSimplify.getSize();
    assertNotEquals(result_1, result_2);
    System.out.format("\tResult: %s\n", toSimplify);
  }

  @Test
  public void removeDuplicateAsNode() {
    System.out.format("%s:\n", name.getMethodName());
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
    System.out.format("\tSource: %s\n", toSimplify);
    int result_1 = toSimplify.getSize();
    Q2_01_Remove_Duplicate.removeDuplicateAsNode(toSimplify);
    int result_2 = toSimplify.getSize();
    assertNotEquals(result_1, result_2);
    System.out.format("\tResult: %s\n", toSimplify);
  }

  @Test
  public void isUniqueChars_solution_1() {
    String expected = "0->1";
    System.out.format("%s:\n", name.getMethodName());
    LinkedListNode first = new LinkedListNode(0, null, null);
    LinkedListNode head = first;
    LinkedListNode second;
    for (int i = 1; i < 8; i++) {
      second = new LinkedListNode(i % 2, null, null);
      first.setNext(second);
      second.setPrevious(first);
      first = second;
    }
    System.out.format("\tSource: %s\n", head.printForward());
    Q2_01_Remove_Duplicate.removeDuplicate_solution_1(head);
    String result = head.printForward();
    assertEquals(expected, result);
    System.out.format("\tResult: %s\n", head.printForward());
  }

  @Test
  public void isUniqueChars_solution_2() {
    String expected = "0->1";
    System.out.format("%s:\n", name.getMethodName());
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
    System.out.format("\tSource: %s\n", head.printForward());
    Q2_01_Remove_Duplicate.removeDuplicate_solution_2(head);
    String result = head.printForward();
    assertEquals(expected, result);
    System.out.format("\tResult: %s\n", head.printForward());
  }

  @Test
  public void isUniqueChars_solution_3() {
    String expected = "0->1";
    System.out.format("%s:\n", name.getMethodName());
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
    System.out.format("\tSource: %s\n", head.printForward());
    Q2_01_Remove_Duplicate.removeDuplicate_solution_3(head);
    String result = head.printForward();
    assertEquals(expected, result);
    System.out.format("\tResult: %s\n", head.printForward());
  }
}
