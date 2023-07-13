package Java.test.ctci.old.ch_04_Trees_and_Graphs.q4_01_Route_Between_Nodes;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import Java.code.ctci.old.ch_04_Trees_and_Graphs.BinaryTree;
import Java.code.ctci.old.ch_04_Trees_and_Graphs.BinaryTreeNode;
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
  @Rule public final TestName name = new TestName();

  @Test
  public void commonAncestorBT() {
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> myTree = new BinaryTree<>();
    ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    myTree.createMinimalBST(data);
    int first = 3;
    int second = 2;
    BinaryTreeNode<Integer> result = myTree.commonAncestorBT(first, second);
    assertNotNull(result);
    System.out.format(
        "\tThe common ancestor between %d and %d is: %s\n",
        first, second, result.getData().toString());
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
        "\tThe common ancestor between %d and %d is: %s\n",
        first, second, ancestor.getData().toString());
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
    System.out.format("\tThe common ancestor between %d and %d is: null\n", first, second);
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
    System.out.format("\tThe common ancestor between %d and %d is: null\n", first, second);
  }
}
