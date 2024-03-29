package Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_03_List_of_Depths;

import Java.code.ctci.source.ctciLibrary.AssortedMethods;
import Java.code.ctci.source.ctciLibrary.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@SuppressWarnings("DuplicatedCode")
public class QuestionBFS {
    public static void main(String[] args) {
        int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
        ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root);
        printResult(list);
    }

    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
        /* "Visit" the root. */
        LinkedList<TreeNode> current = new LinkedList<>();
        if (root != null) {
            current.add(root);
        }
        while (current.size() > 0) {
            result.add(current); // Add previous level
            LinkedList<TreeNode> parents = current; // Go to next level
            current = new LinkedList<>();
            for (TreeNode parent : parents) {
                /* Visit the children. */
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

    public static void printResult(ArrayList<LinkedList<TreeNode>> result) {
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
}
