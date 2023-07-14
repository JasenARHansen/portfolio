package Java.test.ctci.old.ch_04_Trees_and_Graphs.q4_01_Route_Between_Nodes;

import static org.junit.Assert.*;

import Java.code.ctci.old.ch_04_Trees_and_Graphs.BinaryTree;
import Java.code.ctci.old.ch_04_Trees_and_Graphs.BinaryTree2;
import Java.code.ctci.old.ch_04_Trees_and_Graphs.BinaryTreeNode;
import Java.code.ctci.source.ctciLibrary.AssortedMethods;
import Java.code.ctci.source.ctciLibrary.TreeNode;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({
  "NewClassNamingConvention",
  "DuplicatedCode",
  "ConstantValue",
  "ReassignedVariable"
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q4_10_Check_Subtree_Test {
  @Rule public final TestName name = new TestName();

  @Test
  public void containsTree() {
    System.out.format("%s:\n", name.getMethodName());
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
    assertTrue(containsLeft);
    assertFalse(containsRight);
    System.out.format(
        "\t%s and %s share a subtree starting at %d : %b\n",
        leftTree, rightTree, number1, containsRight);
    System.out.format(
        "\t%s and %s share a subtree starting at %d : %b\n",
        leftTree, rightTree, number2, containsLeft);
  }

  @Test
  public void containsTreeSolution_1() {
    System.out.format("%s:\n", name.getMethodName());
    // t2 is a subtree of t1
    int[] array1 = {1, 2, 1, 3, 1, 1, 5};
    int[] array2 = {2, 3, 1};
    TreeNode t1 = AssortedMethods.createTreeFromArray(array1);
    TreeNode t2 = AssortedMethods.createTreeFromArray(array2);
    boolean result = BinaryTree2.containsTree_solution_1(t1, t2);
    assertTrue(result);
    System.out.format("\t%s is a subtree a of %s : %b", t2, t1, result);
    // t4 is not a subtree of t3
    int[] array3 = {1, 2, 3};
    TreeNode t3 = AssortedMethods.createTreeFromArray(array1);
    TreeNode t4 = AssortedMethods.createTreeFromArray(array3);
    result = BinaryTree2.containsTree_solution_1(t3, t4);
    assertFalse(result);
    System.out.format("\t%s is a subtree of %s : %b", t4, t3, result);
  }

  @Test
  public void containsTreeSolution_2() {
    System.out.format("%s:\n", name.getMethodName());
    // t2 is a subtree of t1
    int[] array1 = {1, 2, 1, 3, 1, 1, 5};
    int[] array2 = {2, 3, 1};
    TreeNode t1 = AssortedMethods.createTreeFromArray(array1);
    TreeNode t2 = AssortedMethods.createTreeFromArray(array2);
    boolean result = BinaryTree2.containsTree_solution_2(t1, t2);
    assertTrue(result);
    System.out.format("\t%s is a subtree of %s : %b", t2, t1, result);
    // t4 is not a subtree of t3
    int[] array3 = {1, 2, 3};
    TreeNode t3 = AssortedMethods.createTreeFromArray(array1);
    TreeNode t4 = AssortedMethods.createTreeFromArray(array3);
    result = BinaryTree2.containsTree_solution_2(t3, t4);
    assertFalse(result);
    System.out.format("\t%s is a subtree of %s : %b", t4, t3, result);
  }
}
