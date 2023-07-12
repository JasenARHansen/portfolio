package Java.test.interview.Facebook.practice;

import static org.junit.Assert.assertEquals;

import Java.code.interview.Facebook.practice.NumberOfVisibleNodes;
import Java.code.interview.Facebook.practice.NumberOfVisibleNodes.Node;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NumberOfVisibleNodesTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void getDescription() {
    System.out.format("%s: ", name.getMethodName());
    NumberOfVisibleNodes.getDescription();
  }

  @Test
  public void visibleNodes_1() {
    int expected = 4;
    Node root = new Node(8);
    root.left = new Node(3);
    root.right = new Node(10);
    root.left.left = new Node(1);
    root.left.right = new Node(6);
    root.right.right = new Node(14);
    root.left.right.left = new Node(4);
    root.left.right.right = new Node(7);
    root.right.right.left = new Node(13);
    int result = NumberOfVisibleNodes.visibleNodes(root);
    System.out.format(
        "%s: The are %d nodes visible from the left\n", name.getMethodName(), expected);
    assertEquals(expected, result);
  }

  @Test
  public void visibleNodes_2() {
    int expected = 5;
    Node root = new Node(10);
    root.left = new Node(8);
    root.right = new Node(15);
    root.left.left = new Node(4);
    root.left.left.right = new Node(5);
    root.left.left.right.right = new Node(6);
    root.right.left = new Node(14);
    root.right.right = new Node(16);
    int result = NumberOfVisibleNodes.visibleNodes(root);
    System.out.format(
        "%s: The are %d nodes visible from the left\n", name.getMethodName(), expected);
    assertEquals(expected, result);
  }
}
