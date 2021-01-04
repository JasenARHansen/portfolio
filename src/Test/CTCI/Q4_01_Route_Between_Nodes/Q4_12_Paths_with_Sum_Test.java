package Test.CTCI.Q4_01_Route_Between_Nodes;

import CTCI.Ch_04_Trees_and_Graphs.BinaryTree;
import CTCI_SOURCE.other.CtCILibrary.TreeNode;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q4_12_Paths_with_Sum_Test {

  @Rule
  public TestName name = new TestName();

  public static int countPathsWithSum_solution_1(TreeNode root, int targetSum) {
    if (root == null) return 0;

    /* Count paths with sum starting from the root. */
    int pathsFromRoot = countPathsWithSumFromNode(root, targetSum, 0);

    /* Try the nodes on the left and right. */
    int pathsOnLeft = countPathsWithSum_solution_1(root.left, targetSum);
    int pathsOnRight = countPathsWithSum_solution_1(root.right, targetSum);

    return pathsFromRoot + pathsOnLeft + pathsOnRight;
  }

  /* Returns the number of paths with this sum starting from this node. */
  public static int countPathsWithSumFromNode(TreeNode node, int targetSum, int currentSum) {
    if (node == null) return 0;

    currentSum += node.data;

    int totalPaths = 0;
    if (currentSum == targetSum) { // Found a path from the root
      totalPaths++;
    }

    totalPaths += countPathsWithSumFromNode(node.left, targetSum, currentSum); // Go left
    totalPaths += countPathsWithSumFromNode(node.right, targetSum, currentSum); // Go right

    return totalPaths;
  }

  public static int countPathsWithSum_solution_2(TreeNode root, int targetSum) {
    return countPathsWithSum_solution_2(root, targetSum, 0, new HashMap<>());
  }

  public static int countPathsWithSum_solution_2(
          TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
    if (node == null) return 0; // Base case

    runningSum += node.data;

    /* Count paths with sum ending at the current node. */
    int sum = runningSum - targetSum;
    int totalPaths = pathCount.getOrDefault(sum, 0);

    /* If runningSum equals targetSum, then one additional path starts at root. Add in this path.*/
    if (runningSum == targetSum) {
      totalPaths++;
    }

    /* Add runningSum to pathCounts. */
    incrementHashTable(pathCount, runningSum, 1);

    /* Count paths with sum on the left and right. */
    totalPaths += countPathsWithSum_solution_2(node.left, targetSum, runningSum, pathCount);
    totalPaths += countPathsWithSum_solution_2(node.right, targetSum, runningSum, pathCount);

    incrementHashTable(pathCount, runningSum, -1); // Remove runningSum
    return totalPaths;
  }

  public static void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
    int newCount = hashTable.getOrDefault(key, 0) + delta;
    if (newCount == 0) { // Remove when zero to reduce space usage
      hashTable.remove(key);
    } else {
      hashTable.put(key, newCount);
    }
  }

  @Test
  public void getRandomNode() {
    System.out.format("%s: \n", name.getMethodName());

    BinaryTree<Integer> myTree = new BinaryTree<>();
    ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 10, 2, 9, 3, 8, 4, 7, 5, 6, 14));
    System.out.format("%s: Inputs %s\n", name.getMethodName(), data.toString());
    myTree.createMinimalBT(data);

    System.out.format("%s: %s\n", name.getMethodName(), myTree.toString());

    int foo = 1;
  }

  // @Test
  public void countPathsWithSum_solution_1() {
    System.out.format("%s: \n", name.getMethodName());
    /*
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(-8);
    root.left.right = new TreeNode(8);
    root.right.left = new TreeNode(2);
    root.right.right = new TreeNode(6);
    System.out.println(countPathsWithSum(root, 0));*/

    /*TreeNode root = new TreeNode(-7);
    root.left = new TreeNode(-7);
    root.left.right = new TreeNode(1);
    root.left.right.left = new TreeNode(2);
    root.right = new TreeNode(7);
    root.right.left = new TreeNode(3);
    root.right.right = new TreeNode(20);
    root.right.right.left = new TreeNode(0);
    root.right.right.left.left = new TreeNode(-3);
    root.right.right.left.left.right = new TreeNode(2);
    root.right.right.left.left.right.left = new TreeNode(1);
    System.out.println(countPathsWithSum(root, -14));*/

    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(0);
    root.right = new TreeNode(0);
    root.right.left = new TreeNode(0);
    root.right.left.right = new TreeNode(0);
    root.right.right = new TreeNode(0);
    System.out.println(countPathsWithSum_solution_1(root, 0));
    System.out.println(countPathsWithSum_solution_1(root, 4));
  }

  // @Test
  public void countPathsWithSum_solution_2() {
    System.out.format("%s: \n", name.getMethodName());
    /*
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(-8);
    root.left.right = new TreeNode(8);
    root.right.left = new TreeNode(2);
    root.right.right = new TreeNode(6);
    root.right.left.left = new TreeNode(0);
    System.out.println(countPathsWithSum(root, 0));
    */

    /*TreeNode root = new TreeNode(-7);
    root.left = new TreeNode(-7);
    root.left.right = new TreeNode(1);
    root.left.right.left = new TreeNode(2);
    root.right = new TreeNode(7);
    root.right.left = new TreeNode(3);
    root.right.right = new TreeNode(20);
    root.right.right.left = new TreeNode(0);
    root.right.right.left.left = new TreeNode(-3);
    root.right.right.left.left.right = new TreeNode(2);
    root.right.right.left.left.right.left = new TreeNode(1);
    System.out.println(countPathsWithSum(root, 0));*/

    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(0);
    root.right = new TreeNode(0);
    root.right.left = new TreeNode(0);
    root.right.left.right = new TreeNode(0);
    root.right.right = new TreeNode(0);
    System.out.println(countPathsWithSum_solution_2(root, 0));
    System.out.println(countPathsWithSum_solution_2(root, 4));
  }
}
