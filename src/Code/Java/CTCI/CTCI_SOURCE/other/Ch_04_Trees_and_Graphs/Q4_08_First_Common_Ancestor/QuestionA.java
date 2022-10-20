package Code.Java.CTCI.CTCI_SOURCE.other.Ch_04_Trees_and_Graphs.Q4_08_First_Common_Ancestor;

import Code.Java.CTCI.CTCI_SOURCE.other.CtCILibrary.TreeNode;

public class QuestionA {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        TreeNode n3 = root.find(8);
        TreeNode n7 = root.find(8);
        TreeNode ancestor = commonAncestor(n3, n7);
        assert ancestor != null;
        System.out.println(ancestor.data);
    }

    public static TreeNode commonAncestor(TreeNode p, TreeNode q) {
        if (p == q) return p;

        TreeNode ancestor = p;
        while (ancestor != null) {
            if (isOnPath(ancestor, q)) {
                return ancestor;
            }
            ancestor = ancestor.parent;
        }
        return null;
    }

    public static boolean isOnPath(TreeNode ancestor, TreeNode node) {
        while (node != ancestor && node != null) {
            node = node.parent;
        }
        return node == ancestor;
    }
}
