package Test.CTCI.Q4_01_Route_Between_Nodes;

import CTCI.Ch_04_Trees_and_Graphs.BinaryTree;
import CTCI_SOURCE.Ch_04_Trees_and_Graphs.Q4_11_Random_Node.Tree;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q4_11_Random_Node_Test {

  @Rule
  public TestName name = new TestName();

  @Test
  public void getRandomNode() {
    System.out.format("%s: \n", name.getMethodName());

    int[] counts = new int[10];
    BinaryTree<Integer> leftTree = new BinaryTree<>();
    leftTree.insert(0);
    leftTree.insert(1);
    leftTree.insert(2);
    leftTree.insert(3);
    leftTree.insert(4);
    leftTree.insert(5);
    leftTree.insert(6);
    leftTree.insert(7);
    leftTree.insert(8);
    leftTree.insert(9);

    for (int i = 0; i < 1000000; i++) {
      int d = leftTree.getRandomNode();
      counts[d]++;
    }
    for (int i = 0; i < counts.length; i++) {
      System.out.println(i + ": " + counts[i]);
    }
  }

  @Test
  public void getRandomNode_solution_1() {
    System.out.format("%s: \n", name.getMethodName());
    int[] counts = new int[10];
    for (int i = 0; i < 1000000; i++) {
      Tree tree = new Tree();
      int[] array = {1, 0, 6, 2, 3, 9, 4, 5, 8, 7};
      for (int x : array) {
        tree.insertInOrder(x);
      }
      int d = tree.getRandomNode().data;
      counts[d]++;
    }

    for (int i = 0; i < counts.length; i++) {
      System.out.println(i + ": " + counts[i]);
    }
  }
}
