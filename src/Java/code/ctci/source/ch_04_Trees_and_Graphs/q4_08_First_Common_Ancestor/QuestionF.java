package Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_08_First_Common_Ancestor;

import Java.code.ctci.source.ctciLibrary.TreeNode;

@SuppressWarnings("DuplicatedCode")
public class QuestionF {
    public static void main(String[] args) {
        int[] array = {5, 3, 6, 1, 9, 11};
        TreeNode root = new TreeNode(20);
        for (int a : array) {
            root.insertInOrder(a);
        }
        TreeNode n1 = root.find(1);
        TreeNode n9 = root.find(9);
        TreeNode ancestor = commonAncestor(n1, n9);
        System.out.println(ancestor.data);
    }

    public static TreeNode commonAncestor(TreeNode p, TreeNode q) {
        if ((p == null) || (q == null)) {
            return null;
        }
        TreeNode ap = p.parent;
        while (ap != null) {
            TreeNode aq = q.parent;
            while (aq != null) {
                if (aq == ap) {
                    return aq;
                }
                aq = aq.parent;
            }
            ap = ap.parent;
        }
        return null;
    }
}
