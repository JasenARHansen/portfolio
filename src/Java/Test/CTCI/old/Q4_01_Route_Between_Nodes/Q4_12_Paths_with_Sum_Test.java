package Java.test.ctci.old.q4_01_Route_Between_Nodes;

import static org.junit.Assert.assertEquals;

import Java.code.ctci.old.ch_04_Trees_and_Graphs.BinaryTree;
import Java.code.ctci.source.ctciLibrary.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"NewClassNamingConvention", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q4_12_Paths_with_Sum_Test {
  @Rule public final TestName name = new TestName();

  public static int countPathsWithSum_solution_1(TreeNode root, int targetSum) {
    if (root == null) return 0;
    /* Count paths with sum starting from the root. */
    int pathsFromRoot = countPathsWithSumFromNode(root, targetSum, 0);
    /* Try the nodes on the left and right. */
    int pathsOnLeft = countPathsWithSum_solution_1(root.left, targetSum);
    int pathsOnRight = countPathsWithSum_solution_1(root.right, targetSum);
    return pathsFromRoot + pathsOnLeft + pathsOnRight;
  }

  public static int countPathsWithSumFromNode(TreeNode node, int targetSum, int currentSum) {
    /* Returns the number of paths with this sum starting from this node. */
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
    /* If runningSum equals targetSum, then one additional path starts at root. Add in this path. */
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
  public void countPathsWithSum() {
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> myTree = new BinaryTree<>();
    ArrayList<Integer> data =
        new ArrayList<>(Arrays.asList(-2, 4, 0, 2, -1, 3, 3, 1, 0, 1, 1, 3, 0, -1, 2));
    myTree.createMinimalBT(data);
    int sum = 5;
    int total = myTree.countPathsWithSum(sum);
    System.out.format(
        "%s: the tree with values %s has %d paths that have a sum of %d\n",
        name.getMethodName(), myTree, total, sum);
    assertEquals(5, total);
  }

  @Test
  public void countPathsWithSum_solution_1() {
    System.out.format("%s:\n", name.getMethodName());
    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(0);
    root.right = new TreeNode(0);
    root.right.left = new TreeNode(0);
    root.right.left.right = new TreeNode(0);
    root.right.right = new TreeNode(0);
    System.out.println(countPathsWithSum_solution_1(root, 0));
    System.out.println(countPathsWithSum_solution_1(root, 4));
  }

  @Test
  public void countPathsWithSum_solution_2() {
    System.out.format("%s:\n", name.getMethodName());
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
