package Java.test.ctci.old.ch_04_Trees_and_Graphs.q4_01_Route_Between_Nodes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import Java.code.ctci.old.ch_04_Trees_and_Graphs.BinaryTree;
import Java.code.ctci.old.ch_04_Trees_and_Graphs.BinaryTree2;
import Java.code.ctci.source.ctciLibrary.AssortedMethods;
import Java.code.ctci.source.ctciLibrary.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"NewClassNamingConvention", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q4_03_List_of_Depths_Test {
  @Rule public final TestName name = new TestName();

  @Test
  public void printLevelsBFS() {
    int expected = 10;
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> myTree = new BinaryTree<>();
    ArrayList<Integer> result = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    System.out.format("\tSource: %s\n", result);
    myTree.createMinimalBST(result);
    assertEquals(expected, result.size());
    System.out.format("\tTree:\n%s\n", myTree.printResultBFS());
  }

  @Test
  public void printLevelsDFS() {
    int expected = 10;
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> myTree = new BinaryTree<>();
    ArrayList<Integer> result = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    System.out.format("\tSource %s\n", result);
    myTree.createMinimalBST(result);
    assertEquals(expected, result.size());
    System.out.format("\tTree:\n%s\n", myTree.printResultDFS());
  }

  @Test
  public void printLevelsBFS_solution_1() {
    System.out.format("%s:\n", name.getMethodName());
    int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.format("\tSource %s\n", Arrays.toString(data));
    TreeNode root = AssortedMethods.createTreeFromArray(data);
    ArrayList<LinkedList<TreeNode>> list = BinaryTree2.createLevelLinkedListBFS(root);
    String result = BinaryTree2.printResultBFS(list);
    assertNotNull(result);
    System.out.format("\tTree:\n%s\n", result);
  }

  @Test
  public void printLevelsDFS_solution_2() {
    System.out.format("%s:\n", name.getMethodName());
    int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.format("\tSource %s\n", Arrays.toString(data));
    TreeNode root = AssortedMethods.createTreeFromArray(data);
    ArrayList<LinkedList<TreeNode>> list = BinaryTree2.createLevelLinkedListDFS(root);
    String result = BinaryTree2.printResultDFS(list);
    assertNotNull(result);
    System.out.format("\tTree:\n%s\n", result);
  }
}
