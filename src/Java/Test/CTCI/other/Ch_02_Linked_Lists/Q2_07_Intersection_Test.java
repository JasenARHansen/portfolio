package Java.Test.CTCI.other.Ch_02_Linked_Lists;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import Java.Code.CTCI.CTCI_SOURCE.other.CtCILibrary.AssortedMethods;
import Java.Code.CTCI.CTCI_SOURCE.other.CtCILibrary.LinkedListNode;
import Java.Code.CTCI.other.Ch_02_Linked_Lists.Linked_List;
import Java.Code.CTCI.other.Ch_02_Linked_Lists.Q2_07_Intersection;
import Java.Code.unsorted.classes.CustomLinkedList;
import Java.Code.unsorted.classes.NodeList;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q2_07_Intersection_Test {

  @Rule
  public TestName name = new TestName();

  @Test
  public void intersects_1() {
    System.out.format("%s: List\n", name.getMethodName());
    CustomLinkedList<String> stringValue1 = new CustomLinkedList<>();
    stringValue1.insert("a");
    stringValue1.insert("b");
    stringValue1.insert("c");
    stringValue1.insert("d");
    stringValue1.insert("e");
    stringValue1.insert("f");
    stringValue1.printList();
    System.out.println("SubList source:");
    CustomLinkedList<String> stringValue2 = stringValue1.sublist(stringValue1, 3);
    stringValue2.printList();
    System.out.println("Test result:");
    NodeList<String> resultNode = Linked_List.intersects(stringValue1, stringValue2);
    assertNotNull(resultNode);
    System.out.format("List intersects at: %s\n", resultNode);
  }

  @Test
  public void intersects_2() {
    System.out.format("%s: List\n", name.getMethodName());
    CustomLinkedList<String> stringValue1 = new CustomLinkedList<>();
    stringValue1.insert("a");
    stringValue1.insert("b");
    stringValue1.insert("c");
    stringValue1.insert("d");
    stringValue1.insert("e");
    stringValue1.insert("f");
    stringValue1.printList();
    System.out.println("Second List source:");
    CustomLinkedList<String> stringValue2 = new CustomLinkedList<>();
    stringValue2.insert("a");
    stringValue2.insert("d");
    stringValue2.insert("f");
    stringValue2.insert("b");
    stringValue2.insert("e");
    stringValue2.insert("c");
    stringValue2.printList();
    System.out.println("Test result:");
    NodeList<String> resultNode = Linked_List.intersects(stringValue1, stringValue2);
    assertNull(resultNode);
    System.out.format("List intersects at: null\n");
  }

  @Test
  public void findIntersection_solution_1() {
    System.out.format("%s: List 1\n", name.getMethodName());
    /* Create linked list */
    int[] vales = {-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8};
    LinkedListNode list1 = AssortedMethods.createLinkedListFromArray(vales);

    int[] vales2 = {12, 14, 15};
    LinkedListNode list2 = AssortedMethods.createLinkedListFromArray(vales2);
    list2.next.next = list1.next.next.next.next;

    System.out.println(list1.printForward());
    System.out.format("%s: List 2\n", name.getMethodName());
    System.out.println(list2.printForward());

    LinkedListNode intersection = Q2_07_Intersection.findIntersection_solution_1(list1, list2);

    System.out.format("%s: List intersection\n", name.getMethodName());
    System.out.println(intersection.printForward());
    assertNotNull(intersection);
  }
}
