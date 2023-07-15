package Java.code.ctci.old.ch_04_Trees_and_Graphs;

import Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_08_First_Common_Ancestor.QuestionE;
import Java.code.ctci.source.ctciLibrary.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

@SuppressWarnings({"DuplicatedCode", "unchecked"})
public class BinaryTree2 {

    private static final int NO_NODES_FOUND = 0;
    private static final int ONE_NODE_FOUND = 1;
    private static final int TWO_NODES_FOUND = 2;
    private static Integer lastPrinted = null;

    public static ArrayList<LinkedList<Integer>> allListSequences(TreeNode node) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();
        if (node == null) {
            result.add(new LinkedList<>());
            return result;
        }
        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(node.data);
        /* Recurse on left and right subtrees. */
        ArrayList<LinkedList<Integer>> leftSeq = allListSequences(node.left);
        ArrayList<LinkedList<Integer>> rightSeq = allListSequences(node.right);
        /* Weave together each list from the left and right sides. */
        for (LinkedList<Integer> left : leftSeq) {
            for (LinkedList<Integer> right : rightSeq) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }
        return result;
    }

    private static TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        boolean pIsOnLeft = covers_solution_5(root.left, p);
        boolean qIsOnLeft = covers_solution_5(root.left, q);
        if (pIsOnLeft != qIsOnLeft) { // Nodes are on different side
            return root;
        }
        TreeNode childSide = pIsOnLeft ? root.left : root.right;
        return ancestorHelper(childSide, p, q);
    }

    public static boolean checkBST_1(TreeNode node) {
        return checkBST_1(node, true);
    }

    private static boolean checkBST_1(TreeNode n, boolean isLeft) {
        // Allow "equal" value only for left child. This validates the BST property.
        if (n == null) {
            return true;
        }
        // Check: recurse left
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
        // Check: recurse right
        return checkBST_1(n.right, false);
    }

    private static boolean checkBST_2(TreeNode n, Integer min, Integer max) {
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

    private static int checkHeight(TreeNode root) {
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

    public static TreeNode commonAncestorBad(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p && root == q) {
            return root;
        }
        TreeNode x = commonAncestorBad(root.left, p, q);
        if (x != null && x != p && x != q) { // Found common ancestor
            return x;
        }
        TreeNode y = commonAncestorBad(root.right, p, q);
        if (y != null && y != p && y != q) {
            return y;
        }
        if (x != null && y != null) {
            return root; // This is the common ancestor
        } else if (root == p || root == q) {
            return root;
        } else {
            return x == null ? y : x;
        }
    }

    private static QuestionE.Result commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new QuestionE.Result(null, false);
        }
        if (root == p && root == q) {
            return new QuestionE.Result(root, true);
        }
        QuestionE.Result rx = commonAncestorHelper(root.left, p, q);
        if (rx.isAncestor) { // Found common ancestor
            return rx;
        }
        QuestionE.Result ry = commonAncestorHelper(root.right, p, q);
        if (ry.isAncestor) { // Found common ancestor
            return ry;
        }
        if (rx.node != null && ry.node != null) {
            return new QuestionE.Result(root, true); // This is the common ancestor
        } else if (root == p || root == q) {
      /* If we�re currently at p or q, and we also found one of those
      nodes in a subtree, then this is truly an ancestor and the
      flag should be true. */
            boolean isAncestor = rx.node != null || ry.node != null;
            return new QuestionE.Result(root, isAncestor);
        } else {
            return new QuestionE.Result(rx.node != null ? rx.node : ry.node, false);
        }
    }

    public static TreeNode commonAncestor_version_1(TreeNode root, TreeNode p, TreeNode q) {
        if (q == p && (root.left == q || root.right == q)) return root;
        int nodesFromLeft = covers_solution_1(root.left, p, q); // Check left side
        if (nodesFromLeft == TWO_NODES_FOUND) {
            if (root.left == p || root.left == q) return root.left;
            else return commonAncestor_version_1(root.left, p, q);
        } else if (nodesFromLeft == ONE_NODE_FOUND) {
            if (root == p) return p;
            else if (root == q) return q;
        }
        int nodesFromRight = covers_solution_1(root.right, p, q); // Check right side
        if (nodesFromRight == TWO_NODES_FOUND) {
            if (root.right == p || root.right == q) return root.right;
            else return commonAncestor_version_1(root.right, p, q);
        } else if (nodesFromRight == ONE_NODE_FOUND) {
            if (root == p) return p;
            else if (root == q) return q;
        }
        if (nodesFromLeft == ONE_NODE_FOUND && nodesFromRight == ONE_NODE_FOUND) return root;
        else return null;
    }

    public static TreeNode commonAncestor_version_2(TreeNode p, TreeNode q) {
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

    private static boolean isOnPath(TreeNode ancestor, TreeNode node) {
        while (node != ancestor && node != null) {
            node = node.parent;
        }
        return node == ancestor;
    }

    public static TreeNode commonAncestor_version_3(TreeNode p, TreeNode q) {
        int delta = depth(p) - depth(q); // get difference in depths
        TreeNode first = delta > 0 ? q : p; // get shallower node
        TreeNode second = delta > 0 ? p : q; // get deeper node
        second = goUpBy(second, Math.abs(delta)); // move shallower node to depth of deeper
        while (first != second && first != null && second != null) {
            first = first.parent;
            second = second.parent;
        }
        return first == null || second == null ? null : first;
    }

    private static int depth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.parent;
            depth++;
        }
        return depth;
    }

    private static TreeNode goUpBy(TreeNode node, int delta) {
        while (delta > 0 && node != null) {
            node = node.parent;
            delta--;
        }
        return node;
    }

    public static TreeNode commonAncestor_version_4(TreeNode root, TreeNode p, TreeNode q) {
        if (!covers_solution_1(root, p) || !covers_solution_1(root, q)) {
            return null;
        } else if (covers_solution_1(p, q)) {
            return p;
        } else if (covers_solution_1(q, p)) {
            return q;
        }
        TreeNode sibling = getSibling(p);
        TreeNode parent = p.parent;
        while (!covers_solution_1(sibling, q)) {
            sibling = getSibling(parent);
            parent = parent.parent;
        }
        return parent;
    }

    public static TreeNode commonAncestor_version_5(TreeNode root, TreeNode p, TreeNode q) {
        if (!covers_solution_5(root, p)
                || !covers_solution_5(root, q)) { // Error check - one node is not in tree
            return null;
        }
        return ancestorHelper(root, p, q);
    }

    public static TreeNode commonAncestor_version_6(TreeNode root, TreeNode p, TreeNode q) {
        QuestionE.Result r = commonAncestorHelper(root, p, q);
        if (r.isAncestor) {
            return r.node;
        }
        return null;
    }

    public static TreeNode commonAncestor_version_7(TreeNode p, TreeNode q) {
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

    public static boolean containsTree_solution_1(TreeNode t1, TreeNode t2) {
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();
        getOrderString(t1, string1);
        getOrderString(t2, string2);
        return string1.indexOf(string2.toString()) != -1;
    }

    public static boolean containsTree_solution_2(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true; // The empty tree is a subtree of every tree.
        }
        return subTree(t1, t2);
    }

    public static int countPathsWithSumFromNode(TreeNode node, int targetSum, int currentSum) {
        /* Returns the number of paths with this sum starting from this node. */
        if (node == null) return 0;
        currentSum += node.data;
        int totalPaths = 0;
        if (currentSum == targetSum) { // Found a path from the root
            totalPaths++;
        }
        totalPaths += countPathsWithSumFromNode(node.left, targetSum, currentSum); // Go left
        totalPaths += countPathsWithSumFromNode(node.right, targetSum, currentSum); // Go right
        return totalPaths;
    }

    public static int countPathsWithSum_solution_1(TreeNode root, int targetSum) {
        if (root == null) return 0;
        /* Count paths with sum starting from the root. */
        int pathsFromRoot = countPathsWithSumFromNode(root, targetSum, 0);
        /* Try the nodes on the left and right. */
        int pathsOnLeft = countPathsWithSum_solution_1(root.left, targetSum);
        int pathsOnRight = countPathsWithSum_solution_1(root.right, targetSum);
        return pathsFromRoot + pathsOnLeft + pathsOnRight;
    }

    public static int countPathsWithSum_solution_2(TreeNode root, int targetSum) {
        return countPathsWithSum_solution_2(root, targetSum, 0, new HashMap<>());
    }

    public static int countPathsWithSum_solution_2(
            TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
        if (node == null) return 0; // Base case
        runningSum += node.data;
        /* Count paths with sum ending at the current node. */
        int sum = runningSum - targetSum;
        int totalPaths = pathCount.getOrDefault(sum, 0);
        /* If runningSum equals targetSum, then one additional path starts at root. Add in this path. */
        if (runningSum == targetSum) {
            totalPaths++;
        }
        /* Add runningSum to pathCounts. */
        incrementHashTable(pathCount, runningSum, 1);
        /* Count paths with sum on the left and right. */
        totalPaths += countPathsWithSum_solution_2(node.left, targetSum, runningSum, pathCount);
        totalPaths += countPathsWithSum_solution_2(node.right, targetSum, runningSum, pathCount);
        incrementHashTable(pathCount, runningSum, -1); // Remove runningSum
        return totalPaths;
    }

    private static int covers_solution_1(TreeNode root, TreeNode p, TreeNode q) {
        // Checks how many 'special' nodes are located under this root
        int ret = NO_NODES_FOUND;
        if (root == null) return ret;
        if (root == p || root == q) ret += 1;
        ret += covers_solution_1(root.left, p, q);
        if (ret == TWO_NODES_FOUND) // Found p and q
        {
            return ret;
        }
        return ret + covers_solution_1(root.right, p, q);
    }

    private static boolean covers_solution_1(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root == p) return true;
        return covers_solution_1(root.left, p) || covers_solution_1(root.right, p);
    }

    private static boolean covers_solution_5(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root == p) return true;
        return covers_solution_5(root.left, p) || covers_solution_5(root.right, p);
    }

    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedListBFS(TreeNode root) {
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

    private static void createLevelLinkedListDFS(
            TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        if (root == null) return;
        LinkedList<TreeNode> list;
        if (lists.size() == level) { // Level not contained in list
            list = new LinkedList<>();
      /* Levels are always traversed in order. So, if this is the first time we've visited level i,
      we must have seen levels 0 through i - 1. We can therefore safely add the level at the end. */
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

    private static int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public static void getOrderString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("X"); // Add null indicator
            return;
        }
        sb.append(node.data); // Add root
        getOrderString(node.left, sb); // Add left
        getOrderString(node.right, sb); // Add right
    }

    private static TreeNode getSibling(TreeNode node) {
        if (node == null || node.parent == null) {
            return null;
        }
        TreeNode parent = node.parent;
        return parent.left == node ? parent.right : parent.left;
    }

    public static void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
        int newCount = hashTable.getOrDefault(key, 0) + delta;
        if (newCount == 0) { // Remove when zero to reduce space usage
            hashTable.remove(key);
        } else {
            hashTable.put(key, newCount);
        }
    }

    public static TreeNode inorderSuccessor(TreeNode n) {
        if (n == null) return null;
        // Found right children -> return left most node of right subtree
        if (n.parent == null || n.right != null) {
            return leftMostChild(n.right);
        } else {
            TreeNode q = n;
            TreeNode x = q.parent;
            // Go up until we're on left instead of right
            while (x != null && x.left != q) {
                q = x;
                x = x.parent;
            }
            return x;
        }
    }

    private static TreeNode leftMostChild(TreeNode n) {
        if (n == null) {
            return null;
        }
        while (n.left != null) {
            n = n.left;
        }
        return n;
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

    public static boolean isBalanced_Improved(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    public static boolean matchTree(TreeNode r1, TreeNode r2) {
    /* Checks if the binary tree rooted at r1 contains the
    binary tree rooted at r2 as a subtree starting at r1. */
        if (r1 == null && r2 == null) {
            return true; // nothing left in the subtree
        } else if (r1 == null || r2 == null) {
            return false; // exactly one tree is empty, therefore trees don't match
        } else if (r1.data != r2.data) {
            return false; // data doesn't match
        } else {
            return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
        }
    }

    public static String printResultBFS(ArrayList<LinkedList<TreeNode>> result) {
        StringBuilder returnValue = new StringBuilder();
        int depth = 0;
        for (LinkedList<TreeNode> entry : result) {
            Iterator<TreeNode> i = entry.listIterator();
            returnValue.append("Level ").append(depth).append(":");
            while (i.hasNext()) {
                returnValue.append(" ").append(i.next().data);
            }
            returnValue.append("\n");
            depth++;
        }
        return returnValue.toString().trim();
    }

    public static String printResultDFS(ArrayList<LinkedList<TreeNode>> result) {
        StringBuilder returnValue = new StringBuilder();
        int depth = 0;
        for (LinkedList<TreeNode> entry : result) {
            Iterator<TreeNode> i = entry.listIterator();
            returnValue.append("Level").append(depth).append(":");
            while (i.hasNext()) {
                returnValue.append(" ").append(i.next().data);
            }
            returnValue.append("\n");
            depth++;
        }
        return returnValue.toString().trim();
    }

    public static boolean subTree(TreeNode r1, TreeNode r2) {
    /* Checks if the binary tree rooted at r1 contains the binary tree
    rooted at r2 as a subtree somewhere within it. */
        if (r1 == null) {
            return false; // big tree empty & subtree still not found.
        } else if (r1.data == r2.data && matchTree(r1, r2)) {
            return true;
        }
        return subTree(r1.left, r2) || subTree(r1.right, r2);
    }

    public static void test() {
        TreeNode node;
        boolean condition;
        System.out.println("\tTest cases for equals condition.");
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
        condition = checkBST_1(node);
        System.out.println("\tShould be true: " + condition);
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
        condition = checkBST_1(node);
        System.out.println("\tShould be false: " + condition);
    }

    private static void weaveLists(
            LinkedList<Integer> first,
            LinkedList<Integer> second,
            ArrayList<LinkedList<Integer>> results,
            LinkedList<Integer> prefix) {
    /* One list is empty. Add the remainder to [a cloned] prefix and
    store result. */
        if (first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }
    /* Recurse with head of first added to the prefix. Removing the
    head will damage first, so we’ll need to put it back where we
    found it afterward. */
        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);
    /* Do the same thing with second, damaging and then restoring
    the list. */
        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }
}
