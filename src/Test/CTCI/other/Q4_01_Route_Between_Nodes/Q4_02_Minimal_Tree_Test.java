package Test.CTCI.other.Q4_01_Route_Between_Nodes;

import Code.CTCI.CTCI_SOURCE.other.CtCILibrary.TreeNode;
import Code.CTCI.other.Ch_04_Trees_and_Graphs.BinaryTree;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Arrays;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q4_02_Minimal_Tree_Test {

    @Rule
    public TestName name = new TestName();

    @Test
    public void createMinimalBST_sorted() {
        System.out.format("%s: \n", name.getMethodName());
        BinaryTree<Integer> myTree = new BinaryTree<>();
        ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.format("%s: Inputs %s\n", name.getMethodName(), data.toString());
        myTree.createMinimalBST(data);
        System.out.format("%s: List version of the tree %s\n", name.getMethodName(), myTree.toString());
        boolean balanced = myTree.validateBST();
        System.out.format("%s: Tree is a BST %b\n", name.getMethodName(), balanced);
        System.out.format("%s: Tree height %d\n", name.getMethodName(), myTree.getHeight());
    }

    @Test
    public void createMinimalBST_unsorted() {
        System.out.format("%s: \n", name.getMethodName());
        BinaryTree<Integer> myTree = new BinaryTree<>();
        ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 10, 3, 9, 5, 8, 7, 4, 6, 9, 2));
        System.out.format("%s: Inputs %s\n", name.getMethodName(), data.toString());
        myTree.createMinimalBST(data);
        System.out.format("%s: List version of the tree %s\n", name.getMethodName(), myTree.toString());
        boolean balanced = myTree.validateBST();
        System.out.format("%s: Tree is a BST %b\n", name.getMethodName(), balanced);
        System.out.format("%s: Tree height %d\n", name.getMethodName(), myTree.getHeight());
    }

    @Test
    public void createMinimalBST_solution_1() {
        System.out.format("%s: \n", name.getMethodName());
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // We needed this code for other files, so check out the code in the library
        TreeNode root = TreeNode.createMinimalBST(array);
        System.out.println("Root? " + root.data);
        System.out.println("Created BST? " + root.isBST());
        System.out.println("Height: " + root.height());
    }
}
