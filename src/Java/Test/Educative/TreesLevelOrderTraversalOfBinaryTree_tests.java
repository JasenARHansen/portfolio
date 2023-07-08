package Java.Test.Educative;

import Java.Code.Educative.TreesLevelOrderTraversalOfBinaryTree;
import Java.Code.Educative.TreesLevelOrderTraversalOfBinaryTree.Node;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TreesLevelOrderTraversalOfBinaryTree_tests {

  @Rule
  public TestName name = new TestName();

  @Test
  public void level_order_traversal_1() {
      Node N_25 = new Node(25);
      Node N_50 = new Node(50);
      Node N_75 = new Node(75);
      Node N_100 = new Node(100);
      Node N_200 = new Node(200);
      Node N_350 = new Node(350);

      // Make tree
      N_100.left = N_50;
      N_100.right = N_200;
      N_50.left = N_25;
      N_50.right = N_75;
      N_200.right = N_350;

      System.out.format("%s:", name.getMethodName());
      String result = TreesLevelOrderTraversalOfBinaryTree.level_order_traversal(N_100);
      System.out.println(result);
  }
}
