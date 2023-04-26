package Test.Java.CTCI.other.Q4_01_Route_Between_Nodes;

import Java.Code.CTCI.CTCI_SOURCE.other.CtCILibrary.AssortedMethods;
import Java.Code.CTCI.CTCI_SOURCE.other.CtCILibrary.TreeNode;
import Java.Code.CTCI.other.Ch_04_Trees_and_Graphs.BinaryTree;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Arrays;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q4_04_Check_Balanced_Test {

    @Rule
    public TestName name = new TestName();

    public static int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public static boolean isBalanced_Brute(TreeNode root) {
        if (root == null) {
            return true;
        }
        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1) {
            return false;
        } else {
            return isBalanced_Brute(root.left) && isBalanced_Brute(root.right);
        }
    }

    public static int checkHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Propagate error up

        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Propagate error up

        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE; // Found error -> pass it back
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static boolean isBalanced_Improved(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    @Test
    public void isBalanced() {
        System.out.format("%s: \n", name.getMethodName());
        BinaryTree<Integer> myTree = new BinaryTree<>();
        ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.format("%s: Inputs %s\n", name.getMethodName(), data);
        myTree.createMinimalBST(data);
        System.out.format("%s: Is balanced: %b\n", name.getMethodName(), myTree.isBalanced());
    }

    @Test
    public void isBalanced_solution_1() {
        System.out.format("%s: \n", name.getMethodName());
        // Create balanced tree
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        System.out.println("Root? " + root.data);
        System.out.println("Is balanced? " + isBalanced_Brute(root));

        // Could be balanced, actually, but it's very unlikely...
        TreeNode unbalanced = new TreeNode(10);
        for (int i = 0; i < 10; i++) {
            unbalanced.insertInOrder(AssortedMethods.randomIntInRange(0, 100));
        }
        System.out.println("Root? " + unbalanced.data);
        System.out.println("Is balanced(unlikely)? " + isBalanced_Brute(unbalanced));
    }

    @Test
    public void isBalanced_solution_2() {
        System.out.format("%s: \n", name.getMethodName());
        // Create balanced tree
        int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);

        System.out.println("Is balanced? " + isBalanced_Improved(root));

        root.insertInOrder(4); // Add 4 to make it unbalanced

        System.out.println("Is balanced (no)? " + isBalanced_Improved(root));
    }
}
