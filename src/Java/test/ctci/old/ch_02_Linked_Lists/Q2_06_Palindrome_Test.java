package Java.test.ctci.old.ch_02_Linked_Lists;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Java.code.ctci.old.ch_02_Linked_Lists.LinkedList;
import Java.code.ctci.old.ch_02_Linked_Lists.Q2_06_Palindrome;
import Java.code.ctci.source.ctciLibrary.LinkedListNode;
import Java.code.unsorted.classes.CustomLinkedList;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"NewClassNamingConvention", "DuplicatedCode", "ConstantValue"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q2_06_Palindrome_Test {
  @Rule public final TestName name = new TestName();

  @Test
  public void isPalindrome_1() {
    System.out.format("%s: List\n", name.getMethodName());
    CustomLinkedList<String> stringValues = new CustomLinkedList<>();
    stringValues.insert("a");
    stringValues.insert("b");
    stringValues.insert("b");
    stringValues.insert("a");
    System.out.format("\t%s\n", stringValues);
    boolean result = LinkedList.isPalindrome(stringValues);
    assertTrue(result);
    System.out.format("\tList is Palindrome: %s\n", result);
  }

  @Test
  public void isPalindrome_2() {
    System.out.format("%s: List\n", name.getMethodName());
    CustomLinkedList<String> stringValues = new CustomLinkedList<>();
    stringValues.insert("a");
    stringValues.insert("b");
    stringValues.insert("a");
    System.out.format("\t%s\n", stringValues);
    boolean result = LinkedList.isPalindrome(stringValues);
    assertTrue(result);
    System.out.format("\tList is Palindrome: %s\n", result);
  }

  @Test
  public void isPalindrome_3() {
    System.out.format("%s: List\n", name.getMethodName());
    CustomLinkedList<String> stringValues = new CustomLinkedList<>();
    stringValues.insert("a");
    stringValues.insert("b");
    stringValues.insert("c");
    System.out.format("\t%s\n", stringValues);
    boolean result = LinkedList.isPalindrome(stringValues);
    assertFalse(result);
    System.out.format("\tList is Palindrome: %s\n", result);
  }

  @Test
  public void isPalindrome_4() {
    System.out.format("%s: List\n", name.getMethodName());
    CustomLinkedList<Integer> integerValues = new CustomLinkedList<>();
    integerValues.insert(1);
    integerValues.insert(2);
    integerValues.insert(1);
    System.out.format("\t%s\n", integerValues);
    boolean result = LinkedList.isPalindrome(integerValues);
    assertTrue(result);
    System.out.format("\tList is Palindrome: %s\n", result);
  }

  @Test
  public void isPalindrome_5() {
    System.out.format("%s: List\n", name.getMethodName());
    CustomLinkedList<Integer> integerValues = new CustomLinkedList<>();
    integerValues.insert(1);
    integerValues.insert(2);
    integerValues.insert(3);
    System.out.format("\t%s\n", integerValues);
    boolean result = LinkedList.isPalindrome(integerValues);
    assertFalse(result);
    System.out.format("\tList is Palindrome: %s\n", result);
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
    LinkedListNode head = nodes[0];
    System.out.format("\t%s\n", head.printForward());
    boolean result = Q2_06_Palindrome.isPalindrome_solution_1(head);
    assertTrue(result);
    System.out.format("\tlist is a palindrome: %b\n", result);
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
    LinkedListNode head = nodes[0];
    System.out.format("\t%s\n", head.printForward());
    boolean result = Q2_06_Palindrome.isPalindrome_solution_2(head);
    assertTrue(result);
    System.out.format("\tlist is a palindrome: %b\n", result);
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
    LinkedListNode head = nodes[0];
    System.out.format("\t%s\n", head.printForward());
    boolean result = Q2_06_Palindrome.isPalindrome_solution_3(head);
    assertTrue(result);
    System.out.format("\tlist is a palindrome: %b\n", result);
  }
}
