package Code.Java.Interview.Facebook.Practice;

import java.util.ArrayList;
import java.util.List;

public class NumberOfVisibleNodes {

    public static void getDescription() {
        System.out.println("""
                Number of Visible Nodes
                There is a binary tree with N nodes. You are viewing the tree from its left side and can see only the leftmost nodes at each level. Return the number of visible nodes.
                Note: You can see only the leftmost nodes, but that doesn't mean they have to be left nodes. The leftmost node at a
                 level could be a right node.
                Signature
                 int visibleNodes(Node root) {
                Input
                 The root node of a tree, where the number of nodes is between 1 and 1000, and the value of each node is between 0 and 1,000,000,000
                Output
                 An int representing the number of visible nodes.
                Example
                            8  <------ root
                           / \\
                         3    10
                        / \\     \\
                       1   6     14
                          / \\    /
                         4   7  13
                output = 4
                """.indent(2));
    }

    public static int visibleNodes(Node root) {
        int count = 0;
        List<Node> level = new ArrayList<>();
        level.add(root);
        while (!level.isEmpty()) {
            count++;
            List<Node> nextLevel = new ArrayList<>();
            while (!level.isEmpty()) {
                Node current = level.remove(0);
                if (current.left != null) {
                    nextLevel.add(current.left);
                }
                if (current.right != null) {
                    nextLevel.add(current.right);
                }
            }
            level = nextLevel;
        }
        return count;
    }

    public static class Node {
        public Node left;
        public Node right;
        int data;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
