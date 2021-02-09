package Test.CTCI.other.Ch_02_Linked_Lists;

import Code.CTCI.other.Ch_02_Linked_Lists.Q2_02_Return_Kth_To_Last;
import Code.CTCI_SOURCE.other.CtCILibrary.AssortedMethods;
import Code.CTCI_SOURCE.other.CtCILibrary.LinkedListNode;
import Code.unsorted.classes.CustomLinkedList;
import Code.unsorted.classes.NodeList;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q2_02_Return_Kt_To_Last_Test {

  @Rule
  public TestName name = new TestName();

  @Test
  public void returnKthToLast() {
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
    toSimplify.printList();
    int from_last = 3;
    NodeList<Integer> result = Q2_02_Return_Kth_To_Last.returnKthToLast(from_last, toSimplify);
    assertNotNull(result);
    System.out.format(
            "%s: Data '%d' from last: '%d'\n", name.getMethodName(), from_last, result.getData());
    assertEquals(9, (int) result.getData());
  }

  @Test
  public void printKthToLast_solution_1() {
    System.out.format("%s: List\n", name.getMethodName());
    int[] array = {0, 1, 2, 3, 4, 5, 6};
    LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
    for (int i = 0; i <= array.length + 1; i++) {
      Q2_02_Return_Kth_To_Last.printKthToLast_solution_1(head, i);
    }
  }

  @Test
  public void printKthToLast_solution_2() {
    System.out.format("%s: List\n", name.getMethodName());
    int[] array = {0, 1, 2, 3, 4, 5, 6};
    LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
    for (int i = 0; i <= array.length + 1; i++) {
      LinkedListNode node = Q2_02_Return_Kth_To_Last.printKthToLast_solution_2(head, i);
      String nodeValue = node == null ? "null" : "" + node.data;
      System.out.println(i + ": " + nodeValue);
    }
  }

  @Test
  public void printKthToLast_solution_3() {
    System.out.format("%s: List\n", name.getMethodName());
    int[] array = {0, 1, 2, 3};
    LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
    for (int i = 0; i <= array.length + 1; i++) {
      LinkedListNode node = Q2_02_Return_Kth_To_Last.printKthToLast_solution_3(head, i);
      String nodeValue = node == null ? "null" : "" + node.data;
      System.out.println(i + ": " + nodeValue);
    }
  }
}
