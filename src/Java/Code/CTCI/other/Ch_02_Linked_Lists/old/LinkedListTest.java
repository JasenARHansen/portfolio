package Java.Code.CTCI.other.Ch_02_Linked_Lists.old;

import Java.Code.CTCI.other.Ch_02_Linked_Lists.LinkedList;
import Java.Code.unsorted.classes.CustomLinkedList;
import Java.Code.unsorted.classes.NodeList;
import Java.Code.unsorted.classes.classesInstance.CircularLinkedList;
import java.lang.reflect.Field;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings("DuplicatedCode")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LinkedListTest {
  private final String testSuite = "Linked List";
  @Rule public TestName name = new TestName();

  @Test
  public void detectCycle() throws IllegalAccessException {
    System.out.format("\n%s '%s'\n", testSuite, name.getMethodName());
    CircularLinkedList<String> stringValue3 = new CircularLinkedList<>();
    stringValue3.insert("a");
    stringValue3.insert("b");
    stringValue3.insert("c");
    stringValue3.insert("d");
    stringValue3.insert("e");
    stringValue3.insert("f");
    System.out.println("Detect Cycle Test 1 source:");
    stringValue3.printList();
    NodeList<String> resultNode = LinkedList.detectCycle(stringValue3);
    System.out.format("Cycle Node: %s\n", resultNode);
    System.out.println("Detect Cycle Test 2 source:");
    // Corrupting the list to make a cycle
    NodeList<String> cyclePoint = stringValue3.getIndex(3);
    NodeList<String> cyclePointStart = stringValue3.getLast();
    Field declaredField;
    try {
      declaredField = NodeList.class.getDeclaredField("next");
      declaredField.setAccessible(true);
      declaredField.set(cyclePointStart, cyclePoint);
    } catch (NoSuchFieldException | SecurityException | IllegalArgumentException e) {
      e.printStackTrace();
    }
    resultNode = LinkedList.detectCycle(stringValue3);
    System.out.format("Cycle Node: %s\n", resultNode);
  }

  @Test
  public void intersects() {
    System.out.format("\n%s '%s'\n", testSuite, name.getMethodName());
    CustomLinkedList<String> stringValue1 = new CustomLinkedList<>();
    stringValue1.insert("a");
    stringValue1.insert("b");
    stringValue1.insert("c");
    stringValue1.insert("d");
    stringValue1.insert("e");
    stringValue1.insert("f");
    System.out.println("SubList Test 1 source:");
    stringValue1.printList();
    CustomLinkedList<String> stringValue2 = stringValue1.sublist(stringValue1, 3);
    System.out.println("Test 1 result:");
    stringValue2.printList();
    System.out.println("intersects Test 1 source:");
    stringValue1.printList();
    stringValue2.printList();
    NodeList<String> resultNode = LinkedList.intersects(stringValue1, stringValue2);
    assert resultNode != null;
    System.out.format("List intersects at: %s\n", resultNode);
    stringValue1.empty();
    stringValue2.empty();
    stringValue1.insert("a");
    stringValue1.insert("a");
    stringValue1.insert("a");
    stringValue1.insert("a");
    stringValue1.insert("a");
    stringValue2.insert("a");
    stringValue2.insert("a");
    stringValue2.insert("a");
    stringValue2.insert("a");
    System.out.println("intersects Test 2 source:");
    stringValue1.printList();
    stringValue2.printList();
    resultNode = LinkedList.intersects(stringValue1, stringValue2);
    System.out.format("List intersects at: %s\n", resultNode);
  }

  @Test
  public void isPalindrome() {
    System.out.format("\n%s '%s'\n", testSuite, name.getMethodName());
    CustomLinkedList<String> stringValue1 = new CustomLinkedList<>();
    stringValue1.insert("a");
    stringValue1.insert("b");
    stringValue1.insert("b");
    stringValue1.insert("a");
    System.out.println("isPalindrome Test 1 source:");
    stringValue1.printList();
    boolean result = LinkedList.isPalindrome(stringValue1);
    System.out.format("List is Palindrome: %s\n", result);
    stringValue1.empty();
    stringValue1.insert("a");
    stringValue1.insert("b");
    stringValue1.insert("a");
    System.out.println("isPalindrome Test 2 source:");
    stringValue1.printList();
    result = LinkedList.isPalindrome(stringValue1);
    System.out.format("List is Palindrome: %s\n", result);
    stringValue1.empty();
    stringValue1.insert("a");
    stringValue1.insert("b");
    stringValue1.insert("c");
    System.out.println("isPalindrome Test 3 source:");
    stringValue1.printList();
    result = LinkedList.isPalindrome(stringValue1);
    System.out.format("List is Palindrome: %s\n", result);
  }

  @Test
  public void partition() {
    System.out.format("\n%s '%s'\n", testSuite, name.getMethodName());
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
    System.out.println("partition 5 Test 1 source:");
    toSimplify.printList();
    LinkedList.partition(toSimplify, 5);
    System.out.println("Test 1 result:");
    toSimplify.printList();
    toSimplify.empty();
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
    System.out.println("partition 7 Test 2 source:");
    toSimplify.printList();
    LinkedList.partition(toSimplify, 7);
    System.out.println("Test 2 result:");
    toSimplify.printList();
  }

  @Test
  public void removeDuplicate() {
    System.out.format("\n%s '%s'\n", testSuite, name.getMethodName());
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
    System.out.println("Remove Duplicate Test 1 source:");
    toSimplify.printList();
    LinkedList.removeDuplicate(toSimplify);
    System.out.println("Test 1 result:");
    toSimplify.printList();
    toSimplify.empty();
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
    System.out.println("Remove Duplicate Test 2 source:");
    toSimplify.printList();
    LinkedList.removeDuplicateAlt(toSimplify);
    System.out.println("Test 2 result:");
    toSimplify.printList();
    toSimplify.empty();
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
    System.out.println("Remove Duplicate Test 3 source:");
    toSimplify.printList();
    LinkedList.removeDuplicateAsNode(toSimplify, toSimplify.getFirst());
    System.out.println("Test 3 result:");
    toSimplify.printList();
    toSimplify.empty();
  }

  @Test
  public void removeKthFromLast() {
    System.out.format("\n%s '%s'\n", testSuite, name.getMethodName());
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
    System.out.println("Remove Kth from last K = 3 Test 2 source:");
    toSimplify.printList();
    LinkedList.removeKthFromLast(3, toSimplify);
    System.out.println("Test 1 result:");
    toSimplify.printList();
    toSimplify.empty();
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
    System.out.println("Remove Kth from last K = 5 Test 1 source:");
    toSimplify.printList();
    LinkedList.removeKthFromLast2(5, toSimplify);
    System.out.println("Test 2 result:");
    toSimplify.printList();
    toSimplify.empty();
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
    System.out.println("Remove Kth from last K = 5 Test 2 source:");
    toSimplify.printList();
    LinkedList.removeKthFromLast2(5, toSimplify);
    System.out.println("Test 2 result:");
    toSimplify.printList();
  }

  @Test
  public void removeMiddleNode() throws IllegalAccessException {
    System.out.format("\n%s '%s'\n", testSuite, name.getMethodName());
    CustomLinkedList<Integer> toSimplify = new CustomLinkedList<>();
    toSimplify.empty();
    toSimplify.insert(0);
    toSimplify.insert(1);
    toSimplify.insert(6);
    System.out.println("Remove middle Test 1 source:");
    toSimplify.printList();
    LinkedList.removeMiddleNode(toSimplify.getIndex(1), toSimplify);
    System.out.println("Test 1 result:");
    toSimplify.printList();
  }

  @Test
  public void sumList() {
    System.out.format("\n%s '%s'\n", testSuite, name.getMethodName());
    CustomLinkedList<Integer> intValue1 = new CustomLinkedList<>();
    intValue1.insert(7);
    intValue1.insert(1);
    intValue1.insert(6);
    CustomLinkedList<Integer> intValue2 = new CustomLinkedList<>();
    intValue2.insert(5);
    intValue2.insert(9);
    intValue2.insert(2);
    System.out.println("sumList Test 1 source:");
    intValue1.printList();
    intValue2.printList();
    CustomLinkedList<Integer> intValue3 = LinkedList.sumList(intValue1, intValue2);
    System.out.println("Test 1 result:");
    intValue3.printList();
    intValue1 = new CustomLinkedList<>();
    intValue1.insert(6);
    intValue1.insert(1);
    intValue1.insert(7);
    intValue2 = new CustomLinkedList<>();
    intValue2.insert(2);
    intValue2.insert(9);
    intValue2.insert(5);
    System.out.println("sumList Test 2 source:");
    intValue1.printList();
    intValue2.printList();
    intValue3 = LinkedList.sumList(intValue1, intValue2);
    System.out.println("Test 2 result:");
    intValue3.printList();
  }
}
