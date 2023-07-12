package Java.test.ctci.old.ch_02_Linked_Lists;

import static org.junit.Assert.*;

import Java.code.ctci.old.ch_02_Linked_Lists.Q2_02_Return_Kth_To_Last;
import Java.code.ctci.source.ctciLibrary.AssortedMethods;
import Java.code.ctci.source.ctciLibrary.LinkedListNode;
import Java.code.unsorted.classes.CustomLinkedList;
import Java.code.unsorted.classes.NodeList;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"NewClassNamingConvention", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q2_02_Return_Kt_To_Last_Test {
  @Rule public final TestName name = new TestName();

  @Test
  public void returnKthToLast() {
    int expected = 9;
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
    System.out.format("\tList: %s\n", toSimplify);
    int from_last = 3;
    NodeList<Integer> result = Q2_02_Return_Kth_To_Last.returnKthToLast(from_last, toSimplify);
    assertNotNull(result);
    assertEquals(expected, (int) result.getData());
    System.out.format("\tData: '%d' from last: '%d'\n", from_last, result.getData());
  }

  @Test
  public void printKthToLast_solution_1() {
    System.out.format("%s: List\n", name.getMethodName());
    int[] array = {0, 1, 2, 3, 4, 5, 6};
    LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
    for (int i = 1; i <= array.length; i++) {
      String result = Q2_02_Return_Kth_To_Last.printKthToLast_solution_1(head, i);
      assertNotNull(result);
      System.out.format("\t%s\n", result);
    }
  }

  @Test
  public void printKthToLast_solution_2() {
    System.out.format("%s: List\n", name.getMethodName());
    int[] array = {0, 1, 2, 3, 4, 5, 6};
    LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
    for (int i = 1; i <= array.length; i++) {
      LinkedListNode node = Q2_02_Return_Kth_To_Last.printKthToLast_solution_2(head, i);
      String result = node == null ? "null" : String.valueOf(node.data);
      assertNotNull(result);
      System.out.format("\t%d: %s\n", i, result);
    }
  }

  @Test
  public void printKthToLast_solution_3() {
    System.out.format("%s: List\n", name.getMethodName());
    int[] array = {0, 1, 2, 3};
    LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
    for (int i = 1; i <= array.length; i++) {
      LinkedListNode node = Q2_02_Return_Kth_To_Last.printKthToLast_solution_3(head, i);
      String result = node == null ? "null" : String.valueOf(node.data);
      assertNotNull(result);
      System.out.format("\t%d: %s\n", i, result);
    }
  }
}
