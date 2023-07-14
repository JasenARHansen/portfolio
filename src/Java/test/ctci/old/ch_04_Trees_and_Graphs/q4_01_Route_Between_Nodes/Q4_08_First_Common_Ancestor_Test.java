package Java.test.ctci.old.ch_04_Trees_and_Graphs.q4_01_Route_Between_Nodes;

import static org.junit.Assert.*;

import Java.code.ctci.old.ch_04_Trees_and_Graphs.BinaryTree;
import Java.code.ctci.old.ch_04_Trees_and_Graphs.BinaryTree2;
import Java.code.ctci.old.ch_04_Trees_and_Graphs.BinaryTreeNode;
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
public class Q4_08_First_Common_Ancestor_Test {
  @Rule public final TestName name = new TestName();

  @Test
  public void commonAncestorBT() {
    String expected = "(data: 3, height: 1 , weight: 0)";
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> myTree = new BinaryTree<>();
    ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    myTree.createMinimalBST(data);
    int first = 3;
    int second = 2;
    BinaryTreeNode<Integer> result = myTree.commonAncestorBT(first, second);
    assertNotNull(result);
    assertEquals(expected, result.toString());
    System.out.format(
        "\tThe common ancestor between %d and %d is: %s\n",
        first, second, result.getData().toString());
  }

  @Test
  public void commonAncestorBST() {
    String expected = "(data: 3, height: 1 , weight: 0)";
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> myTree = new BinaryTree<>();
    ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    myTree.createMinimalBST(data);
    int first = 3;
    int second = 2;
    BinaryTreeNode<Integer> result = myTree.commonAncestorBST(first, second);
    assertNotNull(result);
    assertEquals(expected, result.toString());
    System.out.format(
        "\tThe common ancestor between %d and %d is: %s\n",
        first, second, result.getData().toString());
  }

  @Test
  public void commonAncestor_BST_null() {
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> myTree = new BinaryTree<>();
    ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    myTree.createMinimalBST(data);
    int first = 10;
    int second = 2;
    BinaryTreeNode<Integer> result = myTree.commonAncestorBST(first, second);
    assertNull(result);
    System.out.format("\tThe common ancestor between %d and %d is: null\n", first, second);
  }

  @Test
  public void commonAncestor_BT_null() {
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> myTree = new BinaryTree<>();
    ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    myTree.createMinimalBST(data);
    int first = 10;
    int second = 2;
    BinaryTreeNode<Integer> result = myTree.commonAncestorBT(first, second);
    assertNull(result);
    System.out.format("\tThe common ancestor between %d and %d is: null\n", first, second);
  }

  @Test
  public void commonAncestor_solution_1() {
    String expected = "(data: 5, Size: 1)";
    System.out.format("%s:\n", name.getMethodName());
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    TreeNode root = TreeNode.createMinimalBST(array);
    TreeNode n3 = root.find(1);
    TreeNode n7 = root.find(7);
    TreeNode result = BinaryTree2.commonAncestor_version_1(root, n3, n7);
    assertNotNull(result);
    assertEquals(expected, result.toString());
    System.out.format("\tcommonAncestor: between %s and %s is %s\n", n3, n7, result);
  }

  @Test
  public void commonAncestor_solution_2() {
    String expected = "(data: 8, Size: 1)";
    System.out.format("%s:\n", name.getMethodName());
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    TreeNode root = TreeNode.createMinimalBST(array);
    TreeNode n3 = root.find(8);
    TreeNode n7 = root.find(8);
    TreeNode result = BinaryTree2.commonAncestor_version_2(n3, n7);
    assertNotNull(result);
    assertEquals(expected, result.toString());
    System.out.format("\tcommonAncestor: between %s and %s is %s\n", n3, n7, result);
  }

  @Test
  public void commonAncestor_solution_3() {
    String expected = "(data: 5, Size: 1)";
    System.out.format("%s:\n", name.getMethodName());
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    TreeNode root = TreeNode.createMinimalBST(array);
    TreeNode n3 = root.find(3);
    TreeNode n7 = root.find(7);
    TreeNode result = BinaryTree2.commonAncestor_version_3(n3, n7);
    assertNotNull(result);
    assertEquals(expected, result.toString());
    System.out.format("\tcommonAncestor: between %s and %s is %s\n", n3, n7, result);
  }

  @Test
  public void commonAncestor_solution_4() {
    String expected = "(data: 5, Size: 1)";
    System.out.format("%s:\n", name.getMethodName());
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    TreeNode root = TreeNode.createMinimalBST(array);
    TreeNode n3 = root.find(1);
    TreeNode n7 = root.find(7);
    TreeNode result = BinaryTree2.commonAncestor_version_4(root, n3, n7);
    assertNotNull(result);
    assertEquals(expected, result.toString());
    System.out.format("\tcommonAncestor: between %s and %s is %s\n", n3, n7, result);
  }

  @Test
  public void commonAncestor_solution_5() {
    String expected = "(data: 5, Size: 1)";
    System.out.format("%s:\n", name.getMethodName());
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    TreeNode root = TreeNode.createMinimalBST(array);
    TreeNode n3 = root.find(1);
    TreeNode n7 = root.find(7);
    TreeNode result = BinaryTree2.commonAncestor_version_5(root, n3, n7);
    assertNotNull(result);
    assertEquals(expected, result.toString());
    System.out.format("\tcommonAncestor: between %s and %s is %s\n", n3, n7, result);
  }

  @Test
  public void commonAncestor_solution_6() {
    String expected = "(data: 8, Size: 1)";
    System.out.format("%s:\n", name.getMethodName());
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    TreeNode root = TreeNode.createMinimalBST(array);
    TreeNode n3 = root.find(10);
    TreeNode n7 = root.find(6);
    TreeNode result = BinaryTree2.commonAncestor_version_6(root, n3, n7);
    assertNotNull(result);
    assertEquals(expected, result.toString());
    if (result != null) {
      System.out.format("\tcommonAncestor: between %s and %s is %s\n", n3, n7, result);
    } else {
      System.out.println("\tnull");
    }
  }

  @Test
  public void commonAncestor_solution_7() {
    String expected = "(data: 9, Size: 1)";
    System.out.format("%s:\n", name.getMethodName());
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    TreeNode root = TreeNode.createMinimalBST(array);
    TreeNode n3 = root.find(9);
    TreeNode n7 = new TreeNode(6); // root.find(10);
    TreeNode result = BinaryTree2.commonAncestorBad(root, n3, n7);
    assertNotNull(result);
    assertEquals(expected, result.toString());
    if (result != null) {
      System.out.format("\tcommonAncestor: between %s and %s is %s\n", n3, n7, result);
    } else {
      System.out.println("\tnull");
    }
  }

  @Test
  public void commonAncestor_solution_8() {
    String expected = "(data: 5, Size: 6)";
    System.out.format("%s:\n", name.getMethodName());
    int[] array = {5, 3, 6, 1, 9, 11};
    TreeNode root = new TreeNode(20);
    for (int a : array) {
      root.insertInOrder(a);
    }
    TreeNode n1 = root.find(1);
    TreeNode n9 = root.find(9);
    TreeNode result = BinaryTree2.commonAncestor_version_7(n1, n9);
    assertNotNull(result);
    assertEquals(expected, result.toString());
    System.out.format("\tcommonAncestor: between %s and %s is %s\n", n1, n9, result);
  }
}
