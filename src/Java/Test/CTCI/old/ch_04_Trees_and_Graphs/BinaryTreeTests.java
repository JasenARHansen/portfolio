package Java.test.ctci.old.ch_04_Trees_and_Graphs;

import static org.junit.Assert.*;

import Java.code.ctci.old.ch_04_Trees_and_Graphs.BinaryTree;
import Java.code.ctci.old.ch_04_Trees_and_Graphs.BinaryTreeNode;
import java.util.ArrayList;
import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"ConstantValue", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BinaryTreeTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void BinaryTree_1() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>();
    assertNotNull(binaryTree);
    System.out.format("%s:\n", name.getMethodName());
  }

  @Test
  public void BinaryTree_2() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    assertNotNull(binaryTree);
    System.out.format("%s:\n", name.getMethodName());
  }

  @Test
  public void countNodes() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    int count = binaryTree.countNodes();
    assertEquals(1, count);
    System.out.format("%s: countNodes %d\n", name.getMethodName(), count);
  }

  @Test
  public void remove() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(15);
    int count_1 = binaryTree.countNodes();
    binaryTree.remove(15);
    int count_2 = binaryTree.countNodes();
    assertNotEquals(count_1, count_2);
    System.out.format("%s: remove %d\n", name.getMethodName(), count_2);
  }

  @Test
  public void insert() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(15);
    int count = binaryTree.countNodes();
    assertEquals(3, count);
    System.out.format("%s: insert %d\n", name.getMethodName(), count);
  }

  @Test
  public void rootValue() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(15);
    int count = binaryTree.rootValue();
    assertEquals(10, count);
    System.out.format("%s: rootValue %d\n", name.getMethodName(), count);
  }

  @Test
  public void search() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(15);
    boolean data = binaryTree.search(5);
    assertTrue(data);
    System.out.format("%s: search %b\n", name.getMethodName(), data);
  }

  @Test
  public void isBalanced_1() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(15);
    boolean count = binaryTree.isBalanced();
    assertTrue(count);
    System.out.format("%s: isBalanced %b\n", name.getMethodName(), count);
  }

  @Test
  public void isBalanced_2() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(15);
    binaryTree.insert(20);
    binaryTree.insert(21);
    binaryTree.insert(22);
    binaryTree.insert(23);
    binaryTree.insert(24);
    boolean count = binaryTree.isBalanced();
    assertTrue(count);
    System.out.format("%s: isBalanced %b\n", name.getMethodName(), count);
  }

  @Test
  public void listByDepth() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(15);
    List<ArrayList<BinaryTreeNode<Integer>>> data = binaryTree.listByDepth();
    String data_string = data.toString();
    assertEquals(
        "[[(data: 10, height: 1 , weight: 0)], [(data: 5, height: 0 , weight: 0), (data: 15, height: 0 , weight: 0)]]",
        data_string);
    System.out.format("%s: listByDepth %s\n", name.getMethodName(), data_string);
  }

  @Test
  public void printResultBFS() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(15);
    String data = binaryTree.printResultBFS();
    assertEquals("Level 0: 10\n" + "Level 1: 5 15", data);
    System.out.format("%s: printResultBFS %s\n", name.getMethodName(), data);
  }

  @Test
  public void printResultDFS() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(15);
    String data = binaryTree.printResultDFS();
    assertEquals("Level 0: 10\n" + "Level 1: 5 15", data);
    System.out.format("%s: printResultDFS %s\n", name.getMethodName(), data);
  }

  @Test
  public void dataBreadth() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(15);
    String data = binaryTree.dataBreadth();
    assertEquals("10 5 15", data);
    System.out.format("%s: dataBreadth %s\n", name.getMethodName(), data);
  }

  @Test
  public void outputInorder() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(15);
    System.out.format("%s: outputInorder\n", name.getMethodName());
    binaryTree.outputInorder();
  }

  @Test
  public void outputPreorder() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(14);
    binaryTree.insert(15);
    binaryTree.insert(16);
    System.out.format("%s: outputPreorder\n", name.getMethodName());
    binaryTree.outputPreorder();
  }

  @Test
  public void outputPostorder() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(14);
    binaryTree.insert(15);
    binaryTree.insert(16);
    System.out.format("%s: outputPostorder\n", name.getMethodName());
    binaryTree.outputPostorder();
  }

  @Test
  public void outputBreadth() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(15);
    System.out.format("%s: outputBreadth\n", name.getMethodName());
    binaryTree.outputBreadth();
  }

  @Test
  public void isEmpty() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(15);
    boolean data = binaryTree.isEmpty();
    assertFalse(data);
    System.out.format("%s: isEmpty %b\n", name.getMethodName(), data);
  }

  @Test
  public void clear() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(15);
    binaryTree.clear();
    boolean data = binaryTree.isEmpty();
    assertTrue(data);
    System.out.format("%s: clear %b\n", name.getMethodName(), data);
  }

  @Test
  public void maxValue() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(15);
    int data = binaryTree.maxValue();
    assertEquals(15, data);
    System.out.format("%s: maxValue %d\n", name.getMethodName(), data);
  }

  @Test
  public void minValue() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(15);
    int data = binaryTree.minValue();
    assertEquals(5, data);
    System.out.format("%s: minValue %d\n", name.getMethodName(), data);
  }

  @Test
  public void getHeight() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(14);
    binaryTree.insert(15);
    binaryTree.insert(16);
    binaryTree.insert(17);
    binaryTree.insert(18);
    binaryTree.insert(19);
    int data = binaryTree.getHeight();
    assertEquals(3, data);
    System.out.format("%s: getHeight %d\n", name.getMethodName(), data);
  }

  @Test
  public void allBSTBuildSequences() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(14);
    binaryTree.insert(15);
    binaryTree.insert(16);
    ArrayList<ArrayList<Integer>> data = binaryTree.allBSTBuildSequences();
    String data_string = data.toString();
    assertEquals(
        "[[10, 5, 15, 14, 16], [10, 15, 5, 14, 16], [10, 15, 14, 5, 16], [10, 15, 14, 16, 5]]",
        data_string);
    System.out.format("%s: allBSTBuildSequences %s\n", name.getMethodName(), data);
  }

  @Test
  public void buildOrder() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(14);
    binaryTree.insert(15);
    binaryTree.insert(16);
    ArrayList<Integer> data = binaryTree.buildOrder();
    String data_string = data.toString();
    assertEquals("[10, 5, 15, 14, 16]", data_string);
    System.out.format("%s: buildOrder %s\n", name.getMethodName(), data);
  }

  @Test
  public void createMinimalBST() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(14);
    binaryTree.insert(15);
    binaryTree.insert(16);
    ArrayList<Integer> data = binaryTree.buildOrder();
    String data_string = data.toString();
    BinaryTree<Integer> binaryTree_2 = new BinaryTree<>();
    binaryTree_2.createMinimalBST(data);
    ArrayList<Integer> data_2 = binaryTree_2.buildOrder();
    String data_string_2 = data_2.toString();
    assertEquals("[10, 5, 15, 14, 16]", data_string);
    System.out.format("%s: createMinimalBST %s\n", name.getMethodName(), data_string_2);
  }

  @Test
  public void createMinimalBT() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(14);
    binaryTree.insert(15);
    binaryTree.insert(16);
    ArrayList<Integer> data = binaryTree.buildOrder();
    String data_string = data.toString();
    BinaryTree<Integer> binaryTree_2 = new BinaryTree<>();
    binaryTree_2.createMinimalBT(data);
    ArrayList<Integer> data_2 = binaryTree_2.buildOrder();
    String data_string_2 = data_2.toString();
    assertEquals("[10, 5, 15, 14, 16]", data_string);
    System.out.format("%s: createMinimalBT %s\n", name.getMethodName(), data_string_2);
  }

  @Test
  public void commonAncestorBST() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(14);
    binaryTree.insert(15);
    binaryTree.insert(16);
    BinaryTreeNode<Integer> data = binaryTree.commonAncestorBST(5, 15);
    String data_string = data.toString();
    assertEquals("(data: 5, height: 0 , weight: 0)", data_string);
    System.out.format("%s: commonAncestorBST %s\n", name.getMethodName(), data);
  }

  @Test
  public void findPathBST() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(14);
    binaryTree.insert(15);
    binaryTree.insert(16);
    ArrayList<BinaryTreeNode<Integer>> data = binaryTree.findPathBST(5);
    String data_string = data.toString();
    assertEquals(
        "[(data: 10, height: 2 , weight: 0), (data: 5, height: 0 , weight: 0)]", data_string);
    System.out.format("%s: findPathBST %s\n", name.getMethodName(), data);
  }

  @Test
  public void findPathBT() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(14);
    binaryTree.insert(15);
    binaryTree.insert(16);
    ArrayList<BinaryTreeNode<Integer>> data = binaryTree.findPathBT(5);
    String data_string = data.toString();
    assertEquals(
        "[(data: 10, height: 2 , weight: 0), (data: 5, height: 0 , weight: 0)]", data_string);
    System.out.format("%s: findPathBT %s\n", name.getMethodName(), data);
  }

  @Test
  public void commonAncestorBT() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(14);
    binaryTree.insert(15);
    binaryTree.insert(16);
    BinaryTreeNode<Integer> data = binaryTree.commonAncestorBT(5, 15);
    String data_string = data.toString();
    assertEquals("(data: 5, height: 0 , weight: 0)", data_string);
    System.out.format("%s: commonAncestorBT %s\n", name.getMethodName(), data);
  }

  @Test
  public void findNodeBST() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(14);
    binaryTree.insert(15);
    binaryTree.insert(16);
    BinaryTreeNode<Integer> data = binaryTree.findNodeBST(5);
    String data_string = data.toString();
    assertEquals("(data: 5, height: 0 , weight: 0)", data_string);
    System.out.format("%s: findNodeBST %s\n", name.getMethodName(), data);
  }

  @Test
  public void validateBST() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(14);
    binaryTree.insert(15);
    binaryTree.insert(16);
    boolean data = binaryTree.validateBST();
    assertTrue(data);
    System.out.format("%s: validateBST %b\n", name.getMethodName(), data);
  }

  @Test
  public void inorderSuccessor() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(14);
    binaryTree.insert(15);
    binaryTree.insert(16);
    BinaryTreeNode<Integer> data = binaryTree.getRoot();
    int data_2 = binaryTree.inorderSuccessor(data);
    assertEquals(14, data_2);
    System.out.format("%s: inorderSuccessor %d\n", name.getMethodName(), data_2);
  }

  @Test
  public void countPathsWithSum() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(14);
    binaryTree.insert(15);
    binaryTree.insert(16);
    int data = binaryTree.countPathsWithSum(15);
    assertEquals(1, data);
    System.out.format("%s: countPathsWithSum %d\n", name.getMethodName(), data);
  }

  @Test
  public void getRandomNode() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(14);
    binaryTree.insert(15);
    binaryTree.insert(16);
    int data = binaryTree.getRandomNode();
    System.out.format("%s: getRandomNode %d\n", name.getMethodName(), data);
  }
}
