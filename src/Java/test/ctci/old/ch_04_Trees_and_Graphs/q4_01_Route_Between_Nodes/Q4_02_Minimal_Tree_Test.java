package Java.test.ctci.old.ch_04_Trees_and_Graphs.q4_01_Route_Between_Nodes;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
public class Q4_02_Minimal_Tree_Test {
  @Rule public final TestName name = new TestName();

  @Test
  public void createMinimalBST_sorted() {
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> myTree = new BinaryTree<>();
    ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    System.out.format("\tSource: %s\n", data);
    myTree.createMinimalBST(data);
    boolean result = myTree.validateBST();
    assertTrue(result);
    System.out.format("\tTree is a BST: %b\n", result);
    System.out.format("\tTree height: %d\n", myTree.getHeight());
  }

  @Test
  public void createMinimalBST_unsorted() {
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> myTree = new BinaryTree<>();
    ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 10, 3, 9, 5, 8, 7, 4, 6, 9, 2));
    System.out.format("\tSource: %s\n", data);
    myTree.createMinimalBST(data);
    boolean result = myTree.validateBST();
    assertTrue(result);
    System.out.format("\tTree is a BST: %b\n", result);
    System.out.format("\tTree height: %d\n", myTree.getHeight());
  }

  @Test
  public void createMinimalBST_solution() {
    System.out.format("%s:\n", name.getMethodName());
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    TreeNode result = TreeNode.createMinimalBST(array);
    assertNotNull(result);
    System.out.println("\tRoot: " + result.data);
    System.out.println("\tCreated BST: " + result.isBST());
    System.out.println("\tHeight: " + result.height());
  }
}
