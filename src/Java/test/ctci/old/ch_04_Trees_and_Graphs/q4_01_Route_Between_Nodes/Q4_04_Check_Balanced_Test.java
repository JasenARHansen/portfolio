package Java.test.ctci.old.ch_04_Trees_and_Graphs.q4_01_Route_Between_Nodes;

import static org.junit.Assert.assertNotNull;

import Java.code.ctci.old.ch_04_Trees_and_Graphs.BinaryTree;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"NewClassNamingConvention", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q4_04_Check_Balanced_Test {
  @Rule public final TestName name = new TestName();

  @Test
  public void BinaryTree() {
    BinaryTree<Integer> result = new BinaryTree<>();
    assertNotNull(result);
    System.out.format("%s:\n", name.getMethodName());
  }

  @Test
  public void isBalanced() {
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> result = new BinaryTree<>();
    ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    System.out.format("\tInput: %s\n", data);
    result.createMinimalBST(data);
    assertNotNull(result);
    System.out.format("\tTree: %s\n", result);
    System.out.format("\tBalanced: %b\n", result.isBalanced());
  }
}
