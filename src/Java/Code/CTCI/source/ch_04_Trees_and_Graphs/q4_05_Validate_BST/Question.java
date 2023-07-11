package Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_05_Validate_BST;

import Java.code.ctci.source.ctciLibrary.TreeNode;

@SuppressWarnings("DuplicatedCode")
public class Question {
  public static Integer lastPrinted = null;

  public static boolean checkBST(TreeNode node) {
    return checkBST(node, true);
  }

  public static boolean checkBST(TreeNode n, boolean isLeft) {
    /* Allow "equal" value only for left child. This validates the BST property. */
    if (n == null) {
      return true;
    }
    // Check / recurse left
    if (!checkBST(n.left, true)) {
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
    return checkBST(n.right, false);
  }

  public static void main(String[] args) {
    int[] array = {
      Integer.MIN_VALUE, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE
    };
    TreeNode node = TreeNode.createMinimalBST(array);
    System.out.println(checkBST(node));
    test();
  }

  public static void test() {
    TreeNode node;
    boolean condition;
    System.out.println("test cases for equals condition.");
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
    condition = checkBST(node);
    System.out.println("should be true: " + condition);
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
    condition = checkBST(node);
    System.out.println("should be false: " + condition);
  }
}
