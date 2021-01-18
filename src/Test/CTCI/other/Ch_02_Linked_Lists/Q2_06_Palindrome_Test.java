package Test.CTCI.other.Ch_02_Linked_Lists;

import CTCI.other.Ch_02_Linked_Lists.Linked_List;
import CTCI.other.Ch_02_Linked_Lists.Q2_06_Palindrome;
import CTCI_SOURCE.other.CtCILibrary.LinkedListNode;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import unsorted.classes.CustomLinkedList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q2_06_Palindrome_Test {

  @Rule
  public TestName name = new TestName();

  @Test
  public void isPalindrome_1() {
    System.out.format("%s: List\n", name.getMethodName());
    CustomLinkedList<String> stringValues = new CustomLinkedList<>();
    stringValues.insert("a");
    stringValues.insert("b");
    stringValues.insert("b");
    stringValues.insert("a");
    stringValues.printList();
    boolean success = Linked_List.isPalindrome(stringValues);
    System.out.format("List is Palindrome: %s\n", success);
    assertTrue(success);
  }

  @Test
  public void isPalindrome_2() {
    System.out.format("%s: List\n", name.getMethodName());
    CustomLinkedList<String> stringValues = new CustomLinkedList<>();
    stringValues.insert("a");
    stringValues.insert("b");
    stringValues.insert("a");
    stringValues.printList();
    boolean success = Linked_List.isPalindrome(stringValues);
    System.out.format("List is Palindrome: %s\n", success);
    assertTrue(success);
  }

  @Test
  public void isPalindrome_3() {
    System.out.format("%s: List\n", name.getMethodName());
    CustomLinkedList<String> stringValues = new CustomLinkedList<>();
    stringValues.insert("a");
    stringValues.insert("b");
    stringValues.insert("c");
    stringValues.printList();
    boolean success = Linked_List.isPalindrome(stringValues);
    System.out.format("List is Palindrome: %s\n", success);
    assertFalse(success);
  }

  @Test
  public void isPalindrome_4() {
    System.out.format("%s: List\n", name.getMethodName());
    CustomLinkedList<Integer> integerValues = new CustomLinkedList<>();
    integerValues.insert(1);
    integerValues.insert(2);
    integerValues.insert(1);
    integerValues.printList();
    boolean success = Linked_List.isPalindrome(integerValues);
    System.out.format("List is Palindrome: %s\n", success);
    assertTrue(success);
  }

  @Test
  public void isPalindrome_5() {
    System.out.format("%s: List\n", name.getMethodName());
    CustomLinkedList<Integer> integerValues = new CustomLinkedList<>();
    integerValues.insert(1);
    integerValues.insert(2);
    integerValues.insert(3);
    integerValues.printList();
    boolean success = Linked_List.isPalindrome(integerValues);
    System.out.format("List is Palindrome: %s\n", success);
    assertFalse(success);
  }

  @Test
  public void isPalindrome_solution_1() {
    System.out.format("%s: List\n", name.getMethodName());
    int length = 9;
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
    // nodes[length - 2].data = 9; // Uncomment to ruin palindrome

    LinkedListNode head = nodes[0];

    System.out.println(head.printForward());
    boolean success = Q2_06_Palindrome.isPalindrome_solution_1(head);
    System.out.format("%s: list is a palindrome: %b\n", name.getMethodName(), success);
    assertTrue(success);
  }

  @Test
  public void isPalindrome_solution_2() {
    System.out.format("%s: List\n", name.getMethodName());
    int length = 9;
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
    // nodes[length - 2].data = 9; // Uncomment to ruin palindrome

    LinkedListNode head = nodes[0];
    System.out.println(head.printForward());
    boolean success = Q2_06_Palindrome.isPalindrome_solution_2(head);
    System.out.format("%s: list is a palindrome: %b\n", name.getMethodName(), success);
    assertTrue(success);
  }

  @Test
  public void isPalindrome_solution_3() {
    System.out.format("%s: List\n", name.getMethodName());
    int length = 9;
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
    // nodes[length - 2].data = 9; // Uncomment to ruin palindrome

    LinkedListNode head = nodes[0];
    System.out.println(head.printForward());
    boolean success = Q2_06_Palindrome.isPalindrome_solution_3(head);
    System.out.format("%s: list is a palindrome: %b\n", name.getMethodName(), success);
    assertTrue(success);
  }
}
