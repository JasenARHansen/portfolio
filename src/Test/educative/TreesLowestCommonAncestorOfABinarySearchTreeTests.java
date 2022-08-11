package Test.educative;

import Code.Educative.TreesLowestCommonAncestorOfABinarySearchTree;
import Code.Educative.TreesLowestCommonAncestorOfABinarySearchTree.TreeNode;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@SuppressWarnings("WriteOnlyObject")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TreesLowestCommonAncestorOfABinarySearchTreeTests {

  @Rule
  public TestName name = new TestName();

  @Test
  public void level_order_traversal_1() {
    TreeNode N_0 = new TreeNode(0);
    TreeNode N_2 = new TreeNode(2);
    TreeNode N_3 = new TreeNode(3);
    TreeNode N_4 = new TreeNode(4);
    TreeNode N_5 = new TreeNode(5);
    TreeNode N_6 = new TreeNode(6);
    TreeNode N_7 = new TreeNode(7);
    TreeNode N_8 = new TreeNode(8);
    TreeNode N_9 = new TreeNode(9);

    // Make tree
    N_6.left = N_2;
    N_6.right = N_8;
    N_2.left = N_0;
    N_2.right = N_4;
    N_4.left = N_3;
    N_4.right = N_5;
    N_8.left = N_7;
    N_8.right = N_9;

    TreeNode result =
            TreesLowestCommonAncestorOfABinarySearchTree.lowestCommonAncestor(N_6, N_2, N_8);
    System.out.format(
            "%s: The lowest common ancestor of %d and %d in the tree starting with %d is %d.\n",
            name.getMethodName(), N_2.data, N_8.data, N_6.data, result.data);
    assertEquals(N_6, result);
  }

  @Test
  public void level_order_traversal_2() {
    TreeNode N_0 = new TreeNode(0);
    TreeNode N_2 = new TreeNode(2);
    TreeNode N_3 = new TreeNode(3);
    TreeNode N_4 = new TreeNode(4);
    TreeNode N_5 = new TreeNode(5);
    TreeNode N_6 = new TreeNode(6);
    TreeNode N_7 = new TreeNode(7);
    TreeNode N_8 = new TreeNode(8);
    TreeNode N_9 = new TreeNode(9);

    // Make tree
    N_6.left = N_2;
    N_6.right = N_8;
    N_2.left = N_0;
    N_2.right = N_4;
    N_4.left = N_3;
    N_4.right = N_5;
    N_8.left = N_7;
    N_8.right = N_9;

    TreeNode result =
            TreesLowestCommonAncestorOfABinarySearchTree.lowestCommonAncestor(N_6, N_2, N_4);
    System.out.format(
            "%s: The lowest common ancestor of %d and %d in the tree starting with %d is %d.\n",
            name.getMethodName(), N_2.data, N_4.data, N_6.data, result.data);
    assertEquals(N_2, result);
  }

  @Test
  public void level_order_traversal_3() {
    TreeNode N_1 = new TreeNode(1);
    TreeNode N_2 = new TreeNode(2);

    // Make tree
    N_2.left = N_1;

    TreeNode result =
            TreesLowestCommonAncestorOfABinarySearchTree.lowestCommonAncestor(N_2, N_2, N_1);
    System.out.format(
            "%s: The lowest common ancestor of %d and %d in the tree starting with %d is %d.\n",
            name.getMethodName(), N_2.data, N_1.data, N_2.data, result.data);
    assertEquals(N_2, result);
  }

  @Test
  public void level_order_traversal_4() {
    TreeNode N_0 = new TreeNode(0);
    TreeNode N_2 = new TreeNode(2);
    TreeNode N_3 = new TreeNode(3);
    TreeNode N_4 = new TreeNode(4);
    TreeNode N_5 = new TreeNode(5);
    TreeNode N_6 = new TreeNode(6);
    TreeNode N_7 = new TreeNode(7);
    TreeNode N_8 = new TreeNode(8);
    TreeNode N_9 = new TreeNode(9);

    // Make tree
    N_6.left = N_2;
    N_6.right = N_8;
    N_2.left = N_0;
    N_2.right = N_4;
    N_4.left = N_3;
    N_4.right = N_5;
    N_8.left = N_7;
    N_8.right = N_9;

    TreeNode result =
            TreesLowestCommonAncestorOfABinarySearchTree.lowestCommonAncestor(N_6, N_5, N_0);
    System.out.format(
            "%s: The lowest common ancestor of %d and %d in the tree starting with %d is %d.\n",
            name.getMethodName(), N_5.data, N_0.data, N_6.data, result.data);
    assertEquals(N_2, result);
  }

  @Test
  public void level_order_traversal_5() {
    TreeNode N_0 = new TreeNode(0);
    TreeNode N_2 = new TreeNode(2);
    TreeNode N_3 = new TreeNode(3);
    TreeNode N_4 = new TreeNode(4);
    TreeNode N_5 = new TreeNode(5);
    TreeNode N_6 = new TreeNode(6);
    TreeNode N_7 = new TreeNode(7);
    TreeNode N_8 = new TreeNode(8);
    TreeNode N_9 = new TreeNode(9);

    // Make tree
    N_6.left = N_2;
    N_6.right = N_8;
    N_2.left = N_0;
    N_2.right = N_4;
    N_4.left = N_3;
    N_4.right = N_5;
    N_8.left = N_7;
    N_8.right = N_9;

    TreeNode result =
            TreesLowestCommonAncestorOfABinarySearchTree.lowestCommonAncestor(N_2, N_5, N_9);
    System.out.format(
            "%s: The lowest common ancestor of %d and %d in the tree starting with %d is %s.\n",
            name.getMethodName(), N_5.data, N_9.data, N_2.data, result);
    assertNull(result);
  }
}
