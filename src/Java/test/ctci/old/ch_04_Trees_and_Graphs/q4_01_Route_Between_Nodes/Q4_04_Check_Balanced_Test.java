package Java.test.ctci.old.ch_04_Trees_and_Graphs.q4_01_Route_Between_Nodes;

import static org.junit.Assert.assertNotNull;

import Java.code.ctci.old.ch_04_Trees_and_Graphs.BinaryTree;
import Java.code.ctci.old.ch_04_Trees_and_Graphs.BinaryTree2;
import Java.code.ctci.source.ctciLibrary.AssortedMethods;
import Java.code.ctci.source.ctciLibrary.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"NewClassNamingConvention", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q4_04_Check_Balanced_Test {
  @Rule public final TestName name = new TestName();

  @Test
  public void BinaryTree() {
    BinaryTree<Integer> result = new BinaryTree<>();
    assertNotNull(result);
    System.out.format("%s:\n", name.getMethodName());
  }

  @Test
  public void isBalanced() {
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> result = new BinaryTree<>();
    ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    System.out.format("\tInput: %s\n", data);
    result.createMinimalBST(data);
    assertNotNull(result);
    System.out.format("\tTree: %s\n", result);
    System.out.format("\tBalanced: %b\n", result.isBalanced());
  }

  @Test
  public void isBalanced_solution_1() {
    System.out.format("%s:\n", name.getMethodName());
    // Create balanced tree
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    TreeNode root = TreeNode.createMinimalBST(array);
    System.out.println("\tRoot: " + root.data);
    System.out.println("\tBalanced: " + BinaryTree2.isBalanced_Brute(root));
    // Could be balanced, actually, but it's very unlikely...
    TreeNode unbalanced = new TreeNode(10);
    for (int i = 0; i < 10; i++) {
      unbalanced.insertInOrder(AssortedMethods.randomIntInRange(0, 100));
    }
    System.out.println("\tRoot: " + unbalanced.data);
    System.out.println("\tBalanced(unlikely): " + BinaryTree2.isBalanced_Brute(unbalanced));
  }

  @Test
  public void isBalanced_solution_2() {
    System.out.format("%s:\n", name.getMethodName());
    // Create balanced tree
    int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
    TreeNode root = TreeNode.createMinimalBST(array);
    System.out.println("\tBalanced: " + BinaryTree2.isBalanced_Improved(root));
    root.insertInOrder(4); // Add 4 to make it unbalanced
    System.out.println("\tBalanced (no): " + BinaryTree2.isBalanced_Improved(root));
  }
}
