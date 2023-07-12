package Java.test.ctci.old.ch_02_Linked_Lists;

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
    System.out.format("%s: List\n", name.getMethodName());
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
    System.out.format("%s: Partition with '%d' source\n", name.getMethodName(), value);
    System.out.format("\t%s\n", toSimplify);
    LinkedList.partition(toSimplify, value);
    System.out.format("%s: Partition with '%d' result\n", name.getMethodName(), value);
    System.out.format("\t%s\n", toSimplify);
  }

  @Test
  public void partition_2() {
    System.out.format("%s: List\n", name.getMethodName());
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
    System.out.format("%s: Partition with '%d' source\n", name.getMethodName(), value);
    System.out.format("\t%s\n", toSimplify);
    LinkedList.partition(toSimplify, value);
    System.out.format("%s: Partition with '%d' result\n", name.getMethodName(), value);
    System.out.format("\t%s\n", toSimplify);
  }

  @Test
  public void partition_solution_1() {
    System.out.format("%s: List\n", name.getMethodName());
    /* Create linked list. */
    int[] values = {33, 9, 2, 3, 10, 10389, 838, 874578, 5};
    LinkedListNode head = new LinkedListNode(values[0], null, null);
    LinkedListNode current = head;
    for (int i = 1; i < values.length; i++) {
      current = new LinkedListNode(values[i], null, current);
    }
    int value = 3;
    System.out.format("%s: Partition with '%d' source\n", name.getMethodName(), value);
    System.out.println(head.printForward());
    /* Partition. */
    LinkedListNode h = Q2_04_Partition.partition_solution_1(head, value);
    System.out.format("%s: Partition with '%d' result\n", name.getMethodName(), value);
    /* Print Result. */
    System.out.println(h.printForward());
  }

  @Test
  public void partition_solution_2() {
    System.out.format("%s: List\n", name.getMethodName());
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
    System.out.format("%s: Partition with '%d' source\n", name.getMethodName(), value);
    System.out.println(head.printForward());
    LinkedListNode h = Q2_04_Partition.partition_solution_2(head, value);
    System.out.format("%s: Partition with '%d' result\n", name.getMethodName(), value);
    System.out.println(h.printForward());
  }

  @Test
  public void partition_solution_3() {
    System.out.format("%s: List\n", name.getMethodName());
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
    System.out.format("%s: Partition with '%d' source\n", name.getMethodName(), value);
    System.out.println(head.printForward());
    LinkedListNode h = Q2_04_Partition.partition_solution_3(head, value);
    System.out.format("%s: Partition with '%d' result\n", name.getMethodName(), value);
    System.out.println(h.printForward());
  }
}
