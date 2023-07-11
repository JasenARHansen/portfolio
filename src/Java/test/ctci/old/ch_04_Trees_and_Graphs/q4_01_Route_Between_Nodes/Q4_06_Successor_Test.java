package Java.test.ctci.old.ch_04_Trees_and_Graphs.q4_01_Route_Between_Nodes;

import Java.code.ctci.old.ch_04_Trees_and_Graphs.BinaryTree;
import Java.code.ctci.old.ch_04_Trees_and_Graphs.BinaryTreeNode;
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
public class Q4_06_Successor_Test {
  @Rule public final TestName name = new TestName();

  public static TreeNode inorderSuccessor(TreeNode n) {
    if (n == null) return null;
    // Found right children -> return left most node of right subtree
    if (n.parent == null || n.right != null) {
      return leftMostChild(n.right);
    } else {
      TreeNode q = n;
      TreeNode x = q.parent;
      // Go up until we're on left instead of right
      while (x != null && x.left != q) {
        q = x;
        x = x.parent;
      }
      return x;
    }
  }

  public static TreeNode leftMostChild(TreeNode n) {
    if (n == null) {
      return null;
    }
    while (n.left != null) {
      n = n.left;
    }
    return n;
  }

  @Test
  public void inorderSuccessor_root() {
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> myTree = new BinaryTree<>();
    ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    System.out.format("%s: Inputs %s\n", name.getMethodName(), data);
    myTree.createMinimalBST(data);
    BinaryTreeNode<Integer> root = myTree.getRoot();
    Integer successor = myTree.inorderSuccessor(root);
    System.out.format(
        "%s: The successor of %s is %s\n",
        name.getMethodName(), root.getData().toString(), successor.toString());
  }

  @Test
  public void inorderSuccessor_other() {
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> myTree = new BinaryTree<>();
    ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    System.out.format("%s: Inputs %s\n", name.getMethodName(), data);
    myTree.createMinimalBST(data);
    BinaryTreeNode<Integer> other = myTree.getRoot().getLeftChild();
    Integer successor = myTree.inorderSuccessor(other);
    System.out.format(
        "%s: The successor of %s is %s\n",
        name.getMethodName(), other.getData().toString(), successor.toString());
  }

  @Test
  public void inorderSuccessor_solution_1() {
    System.out.format("%s:\n", name.getMethodName());
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    TreeNode root = TreeNode.createMinimalBST(array);
    for (int j : array) {
      TreeNode node = root.find(j);
      TreeNode next = inorderSuccessor(node);
      if (next != null) {
        System.out.println(node.data + "->" + next.data);
      } else {
        System.out.println(node.data + "->" + null);
      }
    }
  }
}
