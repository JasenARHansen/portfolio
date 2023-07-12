package Java.test.ctci.old.ch_04_Trees_and_Graphs.q4_01_Route_Between_Nodes;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import Java.code.ctci.old.ch_04_Trees_and_Graphs.BinaryTree;
import Java.code.ctci.old.ch_04_Trees_and_Graphs.BinaryTreeNode;
import Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_08_First_Common_Ancestor.QuestionE;
import Java.code.ctci.source.ctciLibrary.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"NewClassNamingConvention", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q4_08_First_Common_Ancestor_Test {
  static final int TWO_NODES_FOUND = 2;
  static final int ONE_NODE_FOUND = 1;
  static final int NO_NODES_FOUND = 0;
  @Rule public final TestName name = new TestName();

  public static int covers_solution_1(TreeNode root, TreeNode p, TreeNode q) {
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

  public static boolean covers_solution_1(TreeNode root, TreeNode p) {
    if (root == null) return false;
    if (root == p) return true;
    return covers_solution_1(root.left, p) || covers_solution_1(root.right, p);
  }

  public static TreeNode getSibling(TreeNode node) {
    if (node == null || node.parent == null) {
      return null;
    }
    TreeNode parent = node.parent;
    return parent.left == node ? parent.right : parent.left;
  }

  public static TreeNode commonAncestor_version_5(TreeNode root, TreeNode p, TreeNode q) {
    if (!covers_solution_5(root, p)
        || !covers_solution_5(root, q)) { // Error check - one node is not in tree
      return null;
    }
    return ancestorHelper(root, p, q);
  }

  public static TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q) {
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

  public static boolean covers_solution_5(TreeNode root, TreeNode p) {
    if (root == null) return false;
    if (root == p) return true;
    return covers_solution_5(root.left, p) || covers_solution_5(root.right, p);
  }

  public static QuestionE.Result commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
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

  public static TreeNode commonAncestor_version_6(TreeNode root, TreeNode p, TreeNode q) {
    QuestionE.Result r = commonAncestorHelper(root, p, q);
    if (r.isAncestor) {
      return r.node;
    }
    return null;
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

  public static boolean isOnPath(TreeNode ancestor, TreeNode node) {
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

  public static TreeNode goUpBy(TreeNode node, int delta) {
    while (delta > 0 && node != null) {
      node = node.parent;
      delta--;
    }
    return node;
  }

  public static int depth(TreeNode node) {
    int depth = 0;
    while (node != null) {
      node = node.parent;
      depth++;
    }
    return depth;
  }

  public static TreeNode commonAncestor_version_8(TreeNode p, TreeNode q) {
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

  @Test
  public void commonAncestorBT() {
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> myTree = new BinaryTree<>();
    ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    myTree.createMinimalBST(data);
    int first = 3;
    int second = 2;
    BinaryTreeNode<Integer> ancestor = myTree.commonAncestorBT(first, second);
    System.out.format(
        "%s: The common ancestor between %d and %d is: %s\n",
        name.getMethodName(), first, second, ancestor.getData().toString());
  }

  @Test
  public void commonAncestorBST() {
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> myTree = new BinaryTree<>();
    ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    myTree.createMinimalBST(data);
    int first = 3;
    int second = 2;
    BinaryTreeNode<Integer> ancestor = myTree.commonAncestorBST(first, second);
    assertNotNull(ancestor);
    System.out.format(
        "%s: The common ancestor between %d and %d is: %s\n",
        name.getMethodName(), first, second, ancestor.getData().toString());
  }

  @Test
  public void commonAncestor_BST_null() {
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> myTree = new BinaryTree<>();
    ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    myTree.createMinimalBST(data);
    int first = 10;
    int second = 2;
    BinaryTreeNode<Integer> ancestor = myTree.commonAncestorBST(first, second);
    assertNull(ancestor);
    System.out.format(
        "%s: The common ancestor between %d and %d is: null\n",
        name.getMethodName(), first, second);
  }

  @Test
  public void commonAncestor_BT_null() {
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> myTree = new BinaryTree<>();
    ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    myTree.createMinimalBST(data);
    int first = 10;
    int second = 2;
    BinaryTreeNode<Integer> ancestor = myTree.commonAncestorBT(first, second);
    assertNull(ancestor);
    System.out.format(
        "%s: The common ancestor between %d and %d is: null\n",
        name.getMethodName(), first, second);
  }

  @Test
  public void commonAncestor_solution_1() {
    System.out.format("%s:\n", name.getMethodName());
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    TreeNode root = TreeNode.createMinimalBST(array);
    TreeNode n3 = root.find(1);
    TreeNode n7 = root.find(7);
    TreeNode ancestor = commonAncestor_version_1(root, n3, n7);
    assertNotNull(ancestor);
    System.out.println(ancestor.data);
  }

  @Test
  public void commonAncestor_solution_2() {
    System.out.format("%s:\n", name.getMethodName());
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    TreeNode root = TreeNode.createMinimalBST(array);
    TreeNode n3 = root.find(8);
    TreeNode n7 = root.find(8);
    TreeNode ancestor = commonAncestor_version_2(n3, n7);
    assertNotNull(ancestor);
    System.out.println(ancestor.data);
  }

  @Test
  public void commonAncestor_solution_3() {
    System.out.format("%s:\n", name.getMethodName());
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    TreeNode root = TreeNode.createMinimalBST(array);
    TreeNode n3 = root.find(3);
    TreeNode n7 = root.find(7);
    TreeNode ancestor = commonAncestor_version_3(n3, n7);
    assertNotNull(ancestor);
    System.out.println(ancestor.data);
  }

  @Test
  public void commonAncestor_solution_4() {
    System.out.format("%s:\n", name.getMethodName());
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    TreeNode root = TreeNode.createMinimalBST(array);
    TreeNode n3 = root.find(1);
    TreeNode n7 = root.find(7);
    TreeNode ancestor = commonAncestor_version_4(root, n3, n7);
    assertNotNull(ancestor);
    System.out.println(ancestor.data);
  }

  @Test
  public void commonAncestor_solution_5() {
    System.out.format("%s:\n", name.getMethodName());
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    TreeNode root = TreeNode.createMinimalBST(array);
    TreeNode n3 = root.find(1);
    TreeNode n7 = root.find(7);
    TreeNode ancestor = commonAncestor_version_5(root, n3, n7);
    assertNotNull(ancestor);
    System.out.println(ancestor.data);
  }

  @Test
  public void commonAncestor_solution_6() {
    System.out.format("%s:\n", name.getMethodName());
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    TreeNode root = TreeNode.createMinimalBST(array);
    TreeNode n3 = root.find(10);
    TreeNode n7 = root.find(6);
    TreeNode ancestor = commonAncestor_version_6(root, n3, n7);
    if (ancestor != null) {
      System.out.println(ancestor.data);
    } else {
      System.out.println("null");
    }
  }

  @Test
  public void commonAncestor_solution_7() {
    System.out.format("%s:\n", name.getMethodName());
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    TreeNode root = TreeNode.createMinimalBST(array);
    TreeNode n3 = root.find(9);
    TreeNode n7 = new TreeNode(6); // root.find(10);
    TreeNode ancestor = commonAncestorBad(root, n3, n7);
    if (ancestor != null) {
      System.out.println(ancestor.data);
    } else {
      System.out.println("null");
    }
  }

  @Test
  public void commonAncestor_solution_8() {
    System.out.format("%s:\n", name.getMethodName());
    int[] array = {5, 3, 6, 1, 9, 11};
    TreeNode root = new TreeNode(20);
    for (int a : array) {
      root.insertInOrder(a);
    }
    TreeNode n1 = root.find(1);
    TreeNode n9 = root.find(9);
    TreeNode ancestor = commonAncestor_version_8(n1, n9);
    System.out.println(ancestor.data);
  }
}
