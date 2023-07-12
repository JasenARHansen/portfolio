package Java.test.ctci.old.ch_02_Linked_Lists;

import Java.code.ctci.old.ch_02_Linked_Lists.LinkedList;
import Java.code.ctci.old.ch_02_Linked_Lists.Q2_05_Sum_Lists;
import Java.code.ctci.source.ctciLibrary.LinkedListNode;
import Java.code.unsorted.classes.CustomLinkedList;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"NewClassNamingConvention", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q2_05_Sum_Lists_Test {
  @Rule public final TestName name = new TestName();

  @Test
  public void sumList() {
    System.out.format("%s: List\n", name.getMethodName());
    CustomLinkedList<Integer> intValue1 = new CustomLinkedList<>();
    intValue1.insert(7);
    intValue1.insert(1);
    intValue1.insert(6);
    CustomLinkedList<Integer> intValue2 = new CustomLinkedList<>();
    intValue2.insert(5);
    intValue2.insert(9);
    intValue2.insert(3);
    System.out.format("\tOperand list 1: %s\n", intValue1);
    System.out.format("\tOperand list 2: %s\n", intValue2);
    CustomLinkedList<Integer> result = LinkedList.sumList(intValue1, intValue2);
    System.out.format("\tResult list: %s\n", result);
  }

  @Test
  public void sumListReverse() {
    System.out.format("%s: List\n", name.getMethodName());
    CustomLinkedList<Integer> intValue1 = new CustomLinkedList<>();
    intValue1.insert(7);
    intValue1.insert(1);
    intValue1.insert(6);
    CustomLinkedList<Integer> intValue2 = new CustomLinkedList<>();
    intValue2.insert(5);
    intValue2.insert(9);
    intValue2.insert(3);
    System.out.format("\tOperand list 1: %s\n", intValue1);
    System.out.format("\tOperand list 2: %s\n", intValue2);
    CustomLinkedList<Integer> result = LinkedList.sumListReverse(intValue1, intValue2);
    System.out.format("\tResult list: %s\n", result);
  }

  @Test
  public void sumLists_solution_1() {
    System.out.format("%s: List\n", name.getMethodName());
    LinkedListNode lA1 = new LinkedListNode(9, null, null);
    LinkedListNode lA2 = new LinkedListNode(9, null, lA1);
    new LinkedListNode(9, null, lA2);
    LinkedListNode lB1 = new LinkedListNode(1, null, null);
    LinkedListNode lB2 = new LinkedListNode(0, null, lB1);
    new LinkedListNode(0, null, lB2);
    LinkedListNode list3 = Q2_05_Sum_Lists.sumLists_solution_1(lA1, lB1);
    System.out.format("\tOperand list 1: %s\n", lA1.printForward());
    System.out.format("\tOperand list 2: %s\n", lB1.printForward());
    System.out.format("\tResult list: %s\n", list3.printForward());
    int l1 = Q2_05_Sum_Lists.linkedListToIntReverse(lA1);
    int l2 = Q2_05_Sum_Lists.linkedListToIntReverse(lB1);
    int l3 = Q2_05_Sum_Lists.linkedListToIntReverse(list3);
    System.out.format("\tResult from list addition: %d + %d = %d\n", l1, l2, l3);
    System.out.format("\tResult from normal addition: %d + %d = %d\n", l1, l2, (l1 + l2));
  }

  @Test
  public void sumLists_solution_2() {
    System.out.format("%s: List\n", name.getMethodName());
    LinkedListNode lA1 = new LinkedListNode(3, null, null);
    new LinkedListNode(1, null, lA1);
    LinkedListNode lB1 = new LinkedListNode(5, null, null);
    LinkedListNode lB2 = new LinkedListNode(9, null, lB1);
    new LinkedListNode(1, null, lB2);
    System.out.format("\tOperand list 1: %s\n", lA1.printForward());
    System.out.format("\tOperand list 2: %s\n", lB1.printForward());
    LinkedListNode list3 = Q2_05_Sum_Lists.sumLists_solution_2(lA1, lB1);
    System.out.format("\tResult list: %s\n", list3.printForward());
    int l1 = Q2_05_Sum_Lists.linkedListToIntForward(lA1);
    int l2 = Q2_05_Sum_Lists.linkedListToIntForward(lB1);
    int l3 = Q2_05_Sum_Lists.linkedListToIntForward(list3);
    System.out.format("\tResult from list addition: %d + %d = %d\n", l1, l2, l3);
    System.out.format("\tResult from normal addition: %d + %d = %d\n", l1, l2, (l1 + l2));
  }
}
