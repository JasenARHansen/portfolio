package Test.Java.CTCI.other.Q4_01_Route_Between_Nodes;

import Code.Java.CTCI.CTCI_SOURCE.other.CtCILibrary.TreeNode;
import Code.Java.CTCI.other.Ch_04_Trees_and_Graphs.BinaryTree;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Arrays;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q4_05_Validate_BST_Test {

    public static Integer lastPrinted = null;
    @Rule
    public TestName name = new TestName();

    public static boolean checkBST_1(TreeNode node) {
        return checkBST_1(node, true);
    }

    // Allow "equal" value only for left child. This validates the BST property.
    public static boolean checkBST_1(TreeNode n, boolean isLeft) {
        if (n == null) {
            return true;
        }

        // Check / recurse left
        if (!checkBST_1(n.left, true)) {
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
        return checkBST_1(n.right, false);
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
    	*/
        int[] array2 = {1, 2, 3, 4};
        node = TreeNode.createMinimalBST(array2);
        node.left.data = 2;
        node.print();
        lastPrinted = null;
        condition = checkBST_1(node);
        System.out.println("should be true: " + condition);

    /* Expect false: for right child: node.data <= last_printed.
      2
     / \
    /   \
    1   2
         \
         4
    	 */
        int[] array3 = {1, 2, 3, 4};
        node = TreeNode.createMinimalBST(array3);
        node.right.data = 2;
        node.print();
        lastPrinted = null;
        condition = checkBST_1(node);
        System.out.println("should be false: " + condition);
    }

    public static boolean checkBST_2(TreeNode n, Integer min, Integer max) {
        if (n == null) {
            return true;
        }
        if ((min != null && n.data <= min) || (max != null && n.data > max)) {
            return false;
        }
        return checkBST_2(n.left, min, n.data) && checkBST_2(n.right, n.data, max);
    }

    public static boolean checkBST_2(TreeNode n) {
        return checkBST_2(n, null, null);
    }

    @Test
    public void checkBST_true() {
        System.out.format("%s: \n", name.getMethodName());
        BinaryTree<Integer> myTree = new BinaryTree<>();
        ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        System.out.format("%s: Inputs %s\n", name.getMethodName(), data);
        myTree.createMinimalBST(data);
        System.out.format("%s: Is valid: %b\n", name.getMethodName(), myTree.validateBST());
    }

    @Test
    public void checkBST_False() {
        System.out.format("%s: \n", name.getMethodName());
        BinaryTree<Integer> myTree = new BinaryTree<>();
        ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 3, 6, 5, 4, 7, 2));
        System.out.format("%s: Inputs %s\n", name.getMethodName(), data);
        myTree.createMinimalBT(data);
        System.out.format("%s: Is valid: %b\n", name.getMethodName(), myTree.validateBST());
    }

    @Test
    public void checkBST_solution_1() {
        System.out.format("%s: \n", name.getMethodName());
        int[] array = {
                Integer.MIN_VALUE, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE
        };
        TreeNode node = TreeNode.createMinimalBST(array);
        System.out.println(checkBST_1(node));

        test();
    }

    @Test
    public void checkBST_solution_2() {
        System.out.format("%s: \n", name.getMethodName());
        /* Simple test -- create one */
        int[] array = {Integer.MIN_VALUE, 3, 5, 6, 10, 13, 15, Integer.MAX_VALUE};
        TreeNode node = TreeNode.createMinimalBST(array);
        node.print();
        boolean isBst = checkBST_2(node);
        System.out.println(isBst);
    }
}
