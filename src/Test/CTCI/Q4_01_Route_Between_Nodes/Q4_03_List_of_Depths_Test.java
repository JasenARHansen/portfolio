package Test.CTCI.Q4_01_Route_Between_Nodes;

import CTCI.Ch_04_Trees_and_Graphs.BinaryTree;
import CTCI_SOURCE.other.CtCILibrary.AssortedMethods;
import CTCI_SOURCE.other.CtCILibrary.TreeNode;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q4_03_List_of_Depths_Test {

    @Rule
    public TestName name = new TestName();

    public static void printResultDFS(ArrayList<LinkedList<TreeNode>> result) {
        int depth = 0;
        for (LinkedList<TreeNode> entry : result) {
            Iterator<TreeNode> i = entry.listIterator();
            System.out.print("Link list at depth " + depth + ":");
            while (i.hasNext()) {
                System.out.print(" " + i.next().data);
            }
            System.out.println();
            depth++;
        }
    }

    public static void createLevelLinkedListDFS(
            TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        if (root == null) return;
        LinkedList<TreeNode> list;
        if (lists.size() == level) { // Level not contained in list
            list = new LinkedList<>();
            /* Levels are always traversed in order. So, if this is the first time we've visited level i,
             * we must have seen levels 0 through i - 1. We can therefore safely add the level at the end. */
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        createLevelLinkedListDFS(root.left, lists, level + 1);
        createLevelLinkedListDFS(root.right, lists, level + 1);
    }

    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedListDFS(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
        createLevelLinkedListDFS(root, lists, 0);
        return lists;
    }

    @Test
    public void printLevelsBFS() {
        System.out.format("%s: \n", name.getMethodName());
        BinaryTree<Integer> myTree = new BinaryTree<>();
        ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.format("%s: Inputs %s\n", name.getMethodName(), data.toString());
        myTree.createMinimalBST(data);
        System.out.format("%s\n", myTree.printResultBFS());
    }

    @Test
    public void printLevelsDFS() {
        System.out.format("%s: \n", name.getMethodName());
        BinaryTree<Integer> myTree = new BinaryTree<>();
        ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.format("%s: Inputs %s\n", name.getMethodName(), data.toString());
        myTree.createMinimalBST(data);
        System.out.format("%s\n", myTree.printResultDFS());
    }

    @Test
    public void printLevelsBFS_solution_1() {
        System.out.format("%s: \n", name.getMethodName());
        int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
        ArrayList<LinkedList<TreeNode>> list = createLevelLinkedListBFS(root);
        printResultBFS(list);
    }

    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedListBFS(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();

        /* "Visit" the root */
        LinkedList<TreeNode> current = new LinkedList<>();
        if (root != null) {
            current.add(root);
        }

        while (current.size() > 0) {
            result.add(current); // Add previous level
            LinkedList<TreeNode> parents = current; // Go to next level
            current = new LinkedList<>();
            for (TreeNode parent : parents) {
                /* Visit the children */
                if (parent.left != null) {
                    current.add(parent.left);
                }
                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }

        return result;
    }

    public static void printResultBFS(ArrayList<LinkedList<TreeNode>> result) {
        int depth = 0;
        for (LinkedList<TreeNode> entry : result) {
            Iterator<TreeNode> i = entry.listIterator();
            System.out.print("Link list at depth " + depth + ":");
            while (i.hasNext()) {
                System.out.print(" " + i.next().data);
            }
            System.out.println();
            depth++;
        }
    }

    @Test
    public void printLevelsDFS_solution_2() {
        System.out.format("%s: \n", name.getMethodName());
        int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
        ArrayList<LinkedList<TreeNode>> list = createLevelLinkedListDFS(root);
        printResultDFS(list);
    }
}
