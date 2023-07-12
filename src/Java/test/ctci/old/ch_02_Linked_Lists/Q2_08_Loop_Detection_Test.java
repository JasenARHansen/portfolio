package Java.test.ctci.old.ch_02_Linked_Lists;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import Java.code.ctci.old.ch_02_Linked_Lists.LinkedList;
import Java.code.ctci.old.ch_02_Linked_Lists.Q2_08_Loop_Detection;
import Java.code.ctci.source.ctciLibrary.LinkedListNode;
import Java.code.unsorted.classes.NodeList;
import Java.code.unsorted.classes.classesInstance.CircularLinkedList;
import java.lang.reflect.Field;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"NewClassNamingConvention", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q2_08_Loop_Detection_Test {
  @Rule public final TestName name = new TestName();

  @Test
  public void detectCycle_1() {
    System.out.format("%s:\n", name.getMethodName());
    CircularLinkedList<String> stringValues = new CircularLinkedList<>();
    stringValues.insert("a");
    stringValues.insert("b");
    stringValues.insert("c");
    stringValues.insert("d");
    stringValues.insert("e");
    stringValues.insert("f");
    stringValues.list();
    System.out.format("\tSource: %s\n", stringValues);
    NodeList<String> result = LinkedList.detectCycle(stringValues);
    assertNull(result);
    System.out.format("\tCycle Node: null\n");
  }

  @Test
  public void detectCycle_2() throws IllegalAccessException {
    System.out.format("%s:\n", name.getMethodName());
    CircularLinkedList<String> stringValues = new CircularLinkedList<>();
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
    System.out.println("\tSource:  Can't print List due to cycle");
    NodeList<String> result = LinkedList.detectCycle(stringValues);
    assertNotNull(result);
    System.out.format("\tCycle Node: %s\n", result);
  }

  @Test
  public void findIntersection_solution_1() {
    System.out.format("%s:\n", name.getMethodName());
    int list_length = 20;
    int offset = 10;
    // Create linked list
    LinkedListNode[] nodes = new LinkedListNode[list_length];
    for (int i = 0; i < list_length; i++) {
      nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
    }
    // Create loop;
    nodes[list_length - 1].next = nodes[list_length - offset];
    System.out.println("\tSource:  Can't print List due to cycle");
    LinkedListNode result = Q2_08_Loop_Detection.FindBeginning_solution_1(nodes[0]);
    assertNotNull(result);
    System.out.format("\tCycle Node: %s\n", result.data);
  }
}
