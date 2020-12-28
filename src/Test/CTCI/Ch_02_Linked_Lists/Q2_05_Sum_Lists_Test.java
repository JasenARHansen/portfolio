package Test.CTCI.Ch_02_Linked_Lists;

import CTCI.Ch_02_Linked_Lists.Linked_List;
import CTCI.Ch_02_Linked_Lists.Q2_05_Sum_Lists;
import CTCI_SOURCE.other.Introduction.CtCILibrary.LinkedListNode;
import classesInstance.CustomLinkedList;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q2_05_Sum_Lists_Test {

  @Rule
  public TestName name = new TestName();

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
    System.out.format("%s: Operand list 1:\n", name.getMethodName());
    intValue1.printList();
    System.out.format("%s: Operand list 2:\n", name.getMethodName());
    intValue2.printList();
    CustomLinkedList<Integer> result = Linked_List.sumList(intValue1, intValue2);
    System.out.format("%s: Result list:\n", name.getMethodName());
    result.printList();
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
    System.out.format("%s: Operand list 1:\n", name.getMethodName());
    intValue1.printList();
    System.out.format("%s: Operand list 2:\n", name.getMethodName());
    intValue2.printList();
    CustomLinkedList<Integer> result = Linked_List.sumListReverse(intValue1, intValue2);
    System.out.format("%s: Result list:\n", name.getMethodName());
    result.printList();
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

    System.out.format("%s: Operand list 1:\n", name.getMethodName());
    System.out.println(lA1.printForward());
    System.out.format("%s: Operand list 2:\n", name.getMethodName());
    System.out.println(lB1.printForward());
    System.out.format("%s: Result list:\n", name.getMethodName());
    System.out.println(list3.printForward());

    int l1 = Q2_05_Sum_Lists.linkedListToIntReverse(lA1);
    int l2 = Q2_05_Sum_Lists.linkedListToIntReverse(lB1);
    int l3 = Q2_05_Sum_Lists.linkedListToIntReverse(list3);

    System.out.format("%s: Result from list addition:\n", name.getMethodName());
    System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
    System.out.format("%s: Result from normal addition:\n", name.getMethodName());
    System.out.print(l1 + " + " + l2 + " = " + (l1 + l2) + "\n");
  }

  @Test
  public void sumLists_solution_2() {
    System.out.format("%s: List\n", name.getMethodName());
    LinkedListNode lA1 = new LinkedListNode(3, null, null);
    new LinkedListNode(1, null, lA1);

    LinkedListNode lB1 = new LinkedListNode(5, null, null);
    LinkedListNode lB2 = new LinkedListNode(9, null, lB1);
    new LinkedListNode(1, null, lB2);

    System.out.format("%s: Operand list 1:\n", name.getMethodName());
    System.out.println(lA1.printForward());
    System.out.format("%s: Operand list 2:\n", name.getMethodName());
    System.out.println(lB1.printForward());
    LinkedListNode list3 = Q2_05_Sum_Lists.sumLists_solution_2(lA1, lB1);
    System.out.format("%s: Result list:\n", name.getMethodName());
    System.out.println(list3.printForward());

    int l1 = Q2_05_Sum_Lists.linkedListToIntForward(lA1);
    int l2 = Q2_05_Sum_Lists.linkedListToIntForward(lB1);
    int l3 = Q2_05_Sum_Lists.linkedListToIntForward(list3);

    System.out.format("%s: Result from list addition:\n", name.getMethodName());
    System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
    System.out.format("%s: Result from normal addition:\n", name.getMethodName());
    System.out.print(l1 + " + " + l2 + " = " + (l1 + l2) + "\n");
  }
}
