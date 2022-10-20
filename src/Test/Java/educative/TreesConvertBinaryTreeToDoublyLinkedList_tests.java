package Test.Java.educative;

import Code.Java.Educative.TreesConvertBinaryTreeToDoublyLinkedList;
import Code.Java.Educative.TreesConvertBinaryTreeToDoublyLinkedList.Node;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TreesConvertBinaryTreeToDoublyLinkedList_tests {

  @Rule
  public TestName name = new TestName();

  @Test
  public void convert_to_linked_list_1() {
    Node N_25 = new Node(25);
    Node N_30 = new Node(30);
    Node N_50 = new Node(50);
    Node N_60 = new Node(60);
    Node N_75 = new Node(75);
    Node N_100 = new Node(100);
    Node N_125 = new Node(125);
    Node N_200 = new Node(200);
    Node N_350 = new Node(350);

    // Make expected
    List<Node> expected = new ArrayList<>();
    expected.add(N_25);
    expected.add(N_30);
    expected.add(N_50);
    expected.add(N_60);
    expected.add(N_75);
    expected.add(N_100);
    expected.add(N_125);
    expected.add(N_200);
    expected.add(N_350);

    // Make tree
    N_100.left = N_50;
    N_100.right = N_200;
    N_50.left = N_25;
    N_50.right = N_75;
    N_25.right = N_30;
    N_75.left = N_60;
    N_200.left = N_125;
    N_200.right = N_350;

    List<Node> result = TreesConvertBinaryTreeToDoublyLinkedList.convert_to_linked_list(N_100);
    assertEquals(expected.size(), result.size());
    for (int index = 0; index < result.size(); index++) {
      System.out.format(
              """
                      %s: In the new linked list, element %d is '%s'
                      \twith data %d with a left node of '%s'
                      \tand a right node of '%s'.
                      """,
              name.getMethodName(),
              index,
              result.get(index),
              result.get(index).data,
              result.get(index).left,
              result.get(index).right);
      assertEquals(expected.get(index), result.get(index));
      // Test Left
      if (index > 0) {
        assertEquals(expected.get(index - 1), result.get(index).left);
      }
      // Test right
      if (index < result.size() - 1) {
        assertEquals(expected.get(index + 1), result.get(index).right);
      }
    }
  }
}
