package Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_02_Minimal_Tree;

import Java.code.ctci.source.ctciLibrary.TreeNode;

@SuppressWarnings("DuplicatedCode")
public class Question {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // We needed this code for other files, so check out the code in the library
        TreeNode root = TreeNode.createMinimalBST(array);
        System.out.println("\tRoot: " + root.data);
        System.out.println("Created BST? " + root.isBST());
        System.out.println("Height: " + root.height());
    }
}
