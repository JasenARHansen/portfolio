package Java.test.ctci.old.ch_04_Trees_and_Graphs.q4_01_Route_Between_Nodes;

import static org.junit.Assert.*;

import Java.code.ctci.old.ch_04_Trees_and_Graphs.BinaryTree;
import Java.code.ctci.source.ctciLibrary.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"NewClassNamingConvention", "DuplicatedCode", "ConstantValue"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q4_05_Validate_BST_Test {
  public static Integer lastPrinted = null;
  @Rule public final TestName name = new TestName();

  public static boolean checkBST_1(TreeNode node) {
    return checkBST_1(node, true);
  }

  public static boolean checkBST_1(TreeNode n, boolean isLeft) {
    // Allow "equal" value only for left child. This validates the BST property.
    if (n == null) {
      return true;
    }
    // Check / recurse left
    if (!checkBST_1(n.left, true)) {
      return false;
    }
    // Check current
    if (lastPrinted != null) {
      if (isLeft) {
        // left child "is allowed" be equal to parent.
        if (n.data < lastPrinted) {
          return false;
        }
      } else {
        // Right child "is not allowed" be equal to parent.
        if (n.data <= lastPrinted) {
          return false;
        }
      }
    }
    lastPrinted = n.data;
    // Check / recurse right
    return checkBST_1(n.right, false);
  }

  @Test
  public void checkBST_true() {
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> myTree = new BinaryTree<>();
    ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    System.out.format("\tInputs: %s\n", data);
    myTree.createMinimalBST(data);
    boolean result = myTree.validateBST();
    assertTrue(result);
    System.out.format("\tValid: %b\n", result);
  }

  public static boolean checkBST_2(TreeNode n, Integer min, Integer max) {
    if (n == null) {
      return true;
    }
    if ((min != null && n.data <= min) || (max != null && n.data > max)) {
      return false;
    }
    return checkBST_2(n.left, min, n.data) && checkBST_2(n.right, n.data, max);
  }

  public static boolean checkBST_2(TreeNode n) {
    return checkBST_2(n, null, null);
  }

  @Test
  public void checkBST_False() {
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> myTree = new BinaryTree<>();
    ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 3, 6, 5, 4, 7, 2));
    myTree.createMinimalBT(data);
    System.out.format("\tInputs: %s\n", data);
    boolean result = myTree.validateBST();
    assertFalse(result);
    System.out.format("\tValid: %b\n", result);
  }

  @Test
  public void checkBST_solution_1() {
    System.out.format("%s:\n", name.getMethodName());
    int[] array = {
      Integer.MIN_VALUE, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE
    };
    TreeNode result = TreeNode.createMinimalBST(array);
    assertNotNull(result);
    System.out.format("\tBalanced: %b\n", checkBST_1(result));
    test();
  }

  public static void test() {
    TreeNode node;
    boolean condition;
    System.out.println("\tTest cases for equals condition.");
    /* Expect true: for left child: node.data <= last_printed.
      2
     / \
    /   \
    2   3
         \
         4
    	. */
    int[] array2 = {1, 2, 3, 4};
    node = TreeNode.createMinimalBST(array2);
    node.left.data = 2;
    node.print();
    lastPrinted = null;
    condition = checkBST_1(node);
    System.out.println("\tShould be true: " + condition);
    /* Expect false: for right child: node.data <= last_printed.
      2
     / \
    /   \
    1   2
         \
         4. */
    int[] array3 = {1, 2, 3, 4};
    node = TreeNode.createMinimalBST(array3);
    node.right.data = 2;
    node.print();
    lastPrinted = null;
    condition = checkBST_1(node);
    System.out.println("\tShould be false: " + condition);
  }

  @Test
  public void checkBST_solution_2() {
    System.out.format("%s:\n", name.getMethodName());
    /* Simple test -- create one. */
    int[] array = {Integer.MIN_VALUE, 3, 5, 6, 10, 13, 15, Integer.MAX_VALUE};
    TreeNode node = TreeNode.createMinimalBST(array);
    node.print();
    boolean isBst = checkBST_2(node);
    System.out.println(isBst);
  }
}
