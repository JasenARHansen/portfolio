package Java.test.ctci.old.ch_02_Linked_Lists;

import static org.junit.Assert.assertNotEquals;

import Java.code.ctci.old.ch_02_Linked_Lists.LinkedList;
import Java.code.ctci.old.ch_02_Linked_Lists.Q2_04_Partition;
import Java.code.ctci.source.ctciLibrary.LinkedListNode;
import Java.code.unsorted.classes.CustomLinkedList;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"NewClassNamingConvention", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q2_04_Partition_Test {
  @Rule public final TestName name = new TestName();

  @Test
  public void partition_1() {
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
    int value = 5;
    String notExpected = toSimplify.toString();
    System.out.format("\tSource: %s\n", notExpected);
    LinkedList.partition(toSimplify, value);
    String result = toSimplify.toString();
    assertNotEquals(notExpected, result);
    System.out.format("\tPartition with '%d' Result: %s\n", value, result);
  }

  @Test
  public void partition_2() {
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
    int value = 7;
    String notExpected = toSimplify.toString();
    System.out.format("\tSource: %s\n", notExpected);
    LinkedList.partition(toSimplify, value);
    String result = toSimplify.toString();
    assertNotEquals(notExpected, result);
    System.out.format("\tPartition with '%d' Result: %s\n", value, result);
  }

  @Test
  public void partition_solution_1() {
    System.out.format("%s:\n", name.getMethodName());
    int[] values = {33, 9, 2, 3, 10, 10389, 838, 874578, 5};
    LinkedListNode head = new LinkedListNode(values[0], null, null);
    LinkedListNode current = head;
    for (int i = 1; i < values.length; i++) {
      current = new LinkedListNode(values[i], null, current);
    }
    int value = 3;
    String notExpected = head.printForward();
    System.out.format("\tPartition with '%d' Source: %s\n", value, notExpected);
    LinkedListNode h = Q2_04_Partition.partition_solution_1(head, value);
    String result = h.printForward();
    assertNotEquals(notExpected, result);
    System.out.format("\tResult: %s\n", result);
  }

  @Test
  public void partition_solution_2() {
    System.out.format("%s:\n", name.getMethodName());
    int length = 20;
    LinkedListNode[] nodes = new LinkedListNode[length];
    for (int i = 0; i < length; i++) {
      nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
    }
    for (int i = 0; i < length; i++) {
      if (i < length - 1) {
        nodes[i].setNext(nodes[i + 1]);
      }
      if (i > 0) {
        nodes[i].setPrevious(nodes[i - 1]);
      }
    }
    LinkedListNode head = nodes[0];
    int value = 7;
    String notExpected = head.printForward();
    System.out.format("\tPartition with '%d' Source: %s\n", value, notExpected);
    LinkedListNode h = Q2_04_Partition.partition_solution_2(head, value);
    String result = h.printForward();
    assertNotEquals(notExpected, result);
    System.out.format("\tResult: %s\n", result);
  }

  @Test
  public void partition_solution_3() {
    System.out.format("%s:\n", name.getMethodName());
    int length = 20;
    LinkedListNode[] nodes = new LinkedListNode[length];
    for (int i = 0; i < length; i++) {
      nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
    }
    for (int i = 0; i < length; i++) {
      if (i < length - 1) {
        nodes[i].setNext(nodes[i + 1]);
      }
      if (i > 0) {
        nodes[i].setPrevious(nodes[i - 1]);
      }
    }
    LinkedListNode head = nodes[0];
    int value = 8;
    String notExpected = head.printForward();
    System.out.format("\tPartition with '%d' Source: %s\n", value, notExpected);
    LinkedListNode h = Q2_04_Partition.partition_solution_3(head, value);
    String result = h.printForward();
    assertNotEquals(notExpected, result);
    System.out.format("\tResult: %s\n", result);
  }
}
