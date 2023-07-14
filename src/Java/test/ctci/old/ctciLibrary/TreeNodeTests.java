package Java.test.ctci.old.ctciLibrary;

import static org.junit.Assert.*;

import Java.code.ctci.source.ctciLibrary.TreeNode;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TreeNodeTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void TreeNode() {
    System.out.format("%s:\n", name.getMethodName());
    int data = 1;
    TreeNode treeNode = new TreeNode(data);
    assertNotNull(treeNode);
    System.out.format("%s:\n", name.getMethodName());
  }

  @Test
  public void size() {
    System.out.format("%s:\n", name.getMethodName());
    int data = 1;
    TreeNode treeNode = new TreeNode(data);
    int result = treeNode.size();
    assertEquals(data, result);
    System.out.format("%s: size - %d\n", name.getMethodName(), result);
  }

  @Test
  public void createMinimalBST() {
    System.out.format("%s:\n", name.getMethodName());
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    TreeNode result = TreeNode.createMinimalBST(array);
    assertNotNull(result);
    System.out.println("\tRoot: " + result.data);
    System.out.println("\tCreated BST: " + result.isBST());
    System.out.println("\tHeight: " + result.height());
  }
}
