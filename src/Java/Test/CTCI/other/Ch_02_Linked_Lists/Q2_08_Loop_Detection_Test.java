package Java.Test.CTCI.other.Ch_02_Linked_Lists;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import Java.Code.CTCI.CTCI_SOURCE.other.CtCILibrary.LinkedListNode;
import Java.Code.CTCI.other.Ch_02_Linked_Lists.Linked_List;
import Java.Code.CTCI.other.Ch_02_Linked_Lists.Q2_08_Loop_Detection;
import Java.Code.unsorted.classes.NodeList;
import Java.Code.unsorted.classes.classesInstance.CirularLinkedList;
import java.lang.reflect.Field;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q2_08_Loop_Detection_Test {

  @Rule
  public TestName name = new TestName();

  @Test
  public void detectCycle_1() {
    System.out.format("%s: List\n", name.getMethodName());
    CirularLinkedList<String> stringValue = new CirularLinkedList<>();
    stringValue.insert("a");
    stringValue.insert("b");
    stringValue.insert("c");
    stringValue.insert("d");
    stringValue.insert("e");
    stringValue.insert("f");

    stringValue.printList();

    NodeList<String> resultNode = Linked_List.detectCycle(stringValue);
    assertNull(resultNode);
    System.out.format("Cycle Node: null\n");
  }

  @Test
  public void detectCycle_2() throws IllegalAccessException {
    System.out.format("%s: Can't print List due to cycle\n", name.getMethodName());
    CirularLinkedList<String> stringValues = new CirularLinkedList<>();
    stringValues.insert("a");
    stringValues.insert("b");
    stringValues.insert("c");
    stringValues.insert("d");
    stringValues.insert("e");
    stringValues.insert("f");

    // Corrupting the list to make a cycle
    NodeList<String> cyclePoint = stringValues.getIndex(3);
    NodeList<String> cyclePointStart = stringValues.getLast();
    Field declaredField;
    try {
      declaredField = NodeList.class.getDeclaredField("next");
      declaredField.setAccessible(true);
      declaredField.set(cyclePointStart, cyclePoint);
    } catch (NoSuchFieldException | SecurityException | IllegalArgumentException e) {
      e.printStackTrace();
    }
    NodeList<String> resultNode = Linked_List.detectCycle(stringValues);
    System.out.format("Cycle Node: %s\n", resultNode);
    assertNotNull(resultNode);
  }

  @Test
  public void findIntersection_solution_1() {
    System.out.format("%s: Can't print List due to cycle\n", name.getMethodName());

    int list_length = 100;
    int k = 10;

    // Create linked list
    LinkedListNode[] nodes = new LinkedListNode[list_length];
    for (int i = 0; i < list_length; i++) {
      nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
    }

    // Create loop;
    nodes[list_length - 1].next = nodes[list_length - k];

    LinkedListNode loop = Q2_08_Loop_Detection.FindBeginning_solution_1(nodes[0]);
    if (loop == null) {
      System.out.println("No Cycle.");
    } else {
      System.out.println(loop.data);
    }
  }
}
