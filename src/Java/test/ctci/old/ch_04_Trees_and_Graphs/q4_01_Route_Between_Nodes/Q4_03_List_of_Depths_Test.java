package Java.test.ctci.old.ch_04_Trees_and_Graphs.q4_01_Route_Between_Nodes;

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
public class Q4_03_List_of_Depths_Test {
  @Rule public final TestName name = new TestName();

  @Test
  public void printLevelsBFS() {
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> myTree = new BinaryTree<>();
    ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    System.out.format("\tSource: %s\n", data);
    myTree.createMinimalBST(data);
    System.out.format("\tTree:\n%s\n", myTree.printResultBFS());
  }

  @Test
  public void printLevelsDFS() {
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> myTree = new BinaryTree<>();
    ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    System.out.format("\tSource %s\n", data);
    myTree.createMinimalBST(data);
    System.out.format("\tTree:\n%s\n", myTree.printResultDFS());
  }
}
