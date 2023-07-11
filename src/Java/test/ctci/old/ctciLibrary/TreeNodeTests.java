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
    int data = 1;
    TreeNode treeNode = new TreeNode(data);
    assertNotNull(treeNode);
    System.out.format("%s:\n", name.getMethodName());
  }

  @Test
  public void size() {
    int data = 1;
    TreeNode treeNode = new TreeNode(data);
    int result = treeNode.size();
    assertEquals(data, result);
    System.out.format("%s: size - %d\n", name.getMethodName(), result);
  }
}
