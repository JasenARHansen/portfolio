package Java.test.ctci.old.ch_04_Trees_and_Graphs.q4_01_Route_Between_Nodes;

import static org.junit.Assert.*;

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
public class Q4_06_Successor_Test {
  @Rule public final TestName name = new TestName();

  @Test
  public void inorderSuccessor_root() {
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> myTree = new BinaryTree<>();
    ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    System.out.format("\tInputs: %s\n", data);
    myTree.createMinimalBST(data);
    BinaryTreeNode<Integer> root = myTree.getRoot();
    Integer result = myTree.inorderSuccessor(root);
    assertNotNull(result);
    System.out.format("\tThe successor of %s is %s\n", root.getData(), result);
  }

  @Test
  public void inorderSuccessor_other() {
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> myTree = new BinaryTree<>();
    ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    System.out.format("\tInputs: %s\n", data);
    myTree.createMinimalBST(data);
    BinaryTreeNode<Integer> other = myTree.getRoot().getLeftChild();
    Integer result = myTree.inorderSuccessor(other);
    assertNotNull(result);
    System.out.format("\tThe successor of %s is %s\n", other.getData(), result);
  }
}
