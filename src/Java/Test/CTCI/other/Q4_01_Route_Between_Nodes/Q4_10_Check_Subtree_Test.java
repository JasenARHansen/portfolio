package Java.Test.CTCI.other.Q4_01_Route_Between_Nodes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Java.Code.CTCI.CTCI_SOURCE.other.CtCILibrary.AssortedMethods;
import Java.Code.CTCI.CTCI_SOURCE.other.CtCILibrary.TreeNode;
import Java.Code.CTCI.other.Ch_04_Trees_and_Graphs.BinaryTree;
import Java.Code.CTCI.other.Ch_04_Trees_and_Graphs.BinaryTreeNode;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q4_10_Check_Subtree_Test {

  @Rule
  public TestName name = new TestName();

  public static boolean containsTree_solution_1(TreeNode t1, TreeNode t2) {
    StringBuilder string1 = new StringBuilder();
    StringBuilder string2 = new StringBuilder();

    getOrderString(t1, string1);
    getOrderString(t2, string2);

    return string1.indexOf(string2.toString()) != -1;
  }

  public static void getOrderString(TreeNode node, StringBuilder sb) {
    if (node == null) {
      sb.append("X"); // Add null indicator
      return;
    }
    sb.append(node.data); // Add root
    getOrderString(node.left, sb); // Add left
    getOrderString(node.right, sb); // Add right
  }

  public static boolean containsTree_solution_2(TreeNode t1, TreeNode t2) {
    if (t2 == null) {
      return true; // The empty tree is a subtree of every tree.
    }
    return subTree(t1, t2);
  }

  /* Checks if the binary tree rooted at r1 contains the binary tree
   * rooted at r2 as a subtree somewhere within it.
   */
  public static boolean subTree(TreeNode r1, TreeNode r2) {
    if (r1 == null) {
      return false; // big tree empty & subtree still not found.
    } else if (r1.data == r2.data && matchTree(r1, r2)) {
      return true;
    }
    return subTree(r1.left, r2) || subTree(r1.right, r2);
  }

  /* Checks if the binary tree rooted at r1 contains the
   * binary tree rooted at r2 as a subtree starting at r1.
   */
  public static boolean matchTree(TreeNode r1, TreeNode r2) {
    if (r1 == null && r2 == null) {
      return true; // nothing left in the subtree
    } else if (r1 == null || r2 == null) {
      return false; // exactly one tree is empty, therefore trees don't match
    } else if (r1.data != r2.data) {
      return false; // data doesn't match
    } else {
      return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
    }
  }

  @Test
  public void containsTree() {
    System.out.format("%s: \n", name.getMethodName());

    BinaryTree<Integer> leftTree = new BinaryTree<>();
    leftTree.insert(5);
    leftTree.insert(3);
    leftTree.insert(1);
    leftTree.insert(2);
    leftTree.insert(7);
    leftTree.insert(6);
    leftTree.insert(9);
    BinaryTree<Integer> rightTree = new BinaryTree<>();
    rightTree.insert(5);
    rightTree.insert(3);
    rightTree.insert(1);
    rightTree.insert(2);
    rightTree.insert(7);
    rightTree.insert(6);
    rightTree.insert(9);
    rightTree.insert(8);

    int number1 = 2;
    int number2 = 7;
    BinaryTreeNode<Integer> leftTreeNode = leftTree.getNode(number1);
    BinaryTreeNode<Integer> rightTreeNode = rightTree.getNode(number2);

    boolean containsRight = leftTree.containsTree(rightTreeNode);
    boolean containsLeft = rightTree.containsTree(leftTreeNode);

    System.out.format(
            "%s: %s and %s share a subtree starting at %d : %b\n",
            name.getMethodName(), leftTree, rightTree, number1, containsRight);
    System.out.format(
            "%s: %s and %s share a subtree starting at %d : %b\n",
            name.getMethodName(), leftTree, rightTree, number2, containsLeft);

    assertTrue(containsLeft);
    assertFalse(containsRight);
  }

  @Test
  public void containsTree_solution_1() {
    System.out.format("%s: \n", name.getMethodName());
    // t2 is a subtree of t1
    int[] array1 = {1, 2, 1, 3, 1, 1, 5};
    int[] array2 = {2, 3, 1};

    TreeNode t1 = AssortedMethods.createTreeFromArray(array1);
    TreeNode t2 = AssortedMethods.createTreeFromArray(array2);

    if (containsTree_solution_1(t1, t2)) {
      System.out.println("t2 is a subtree of t1");
    } else {
      System.out.println("t2 is not a subtree of t1");
    }

    // t4 is not a subtree of t3
    int[] array3 = {1, 2, 3};
    TreeNode t3 = AssortedMethods.createTreeFromArray(array1);
    TreeNode t4 = AssortedMethods.createTreeFromArray(array3);

    if (containsTree_solution_1(t3, t4)) {
      System.out.println("t4 is a subtree of t3");
    } else {
      System.out.println("t4 is not a subtree of t3");
    }
  }

  @Test
  public void containsTree_solution_2() {
    System.out.format("%s: \n", name.getMethodName());
    // t2 is a subtree of t1
    int[] array1 = {1, 2, 1, 3, 1, 1, 5};
    int[] array2 = {2, 3, 1};

    TreeNode t1 = AssortedMethods.createTreeFromArray(array1);
    TreeNode t2 = AssortedMethods.createTreeFromArray(array2);

    if (containsTree_solution_2(t1, t2)) {
      System.out.println("t2 is a subtree of t1");
    } else {
      System.out.println("t2 is not a subtree of t1");
    }

    // t4 is not a subtree of t3
    int[] array3 = {1, 2, 3};
    TreeNode t3 = AssortedMethods.createTreeFromArray(array1);
    TreeNode t4 = AssortedMethods.createTreeFromArray(array3);

    if (containsTree_solution_2(t3, t4)) {
      System.out.println("t4 is a subtree of t3");
    } else {
      System.out.println("t4 is not a subtree of t3");
    }
  }
}
