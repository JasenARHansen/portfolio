package Java.test.ctci.old.ch_04_Trees_and_Graphs.q4_01_Route_Between_Nodes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import Java.code.ctci.old.ch_04_Trees_and_Graphs.BinaryTree;
import Java.code.ctci.source.ctciLibrary.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"NewClassNamingConvention", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q4_09_BST_Sequences_Test {
  @Rule public final TestName name = new TestName();

  public static void weaveLists(
      LinkedList<Integer> first,
      LinkedList<Integer> second,
      ArrayList<LinkedList<Integer>> results,
      LinkedList<Integer> prefix) {
    /* One list is empty. Add the remainder to [a cloned] prefix and
    store result. */
    if (first.size() == 0 || second.size() == 0) {
      //noinspection unchecked
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

  public static ArrayList<LinkedList<Integer>> allSequences(TreeNode node) {
    ArrayList<LinkedList<Integer>> result = new ArrayList<>();
    if (node == null) {
      result.add(new LinkedList<>());
      return result;
    }
    LinkedList<Integer> prefix = new LinkedList<>();
    prefix.add(node.data);
    /* Recurse on left and right subtrees. */
    ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
    ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);
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

  @Test
  public void allSequences() {
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> myTree = new BinaryTree<>();
    ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    myTree.createMinimalBST(data);
    ArrayList<ArrayList<Integer>> results = myTree.allBSTBuildSequences();
    assertNotNull(results);
    assertFalse(results.isEmpty());
    for (ArrayList<Integer> result : results) {
      System.out.format("%s: %s\n", name.getMethodName(), result.toString());
    }
  }

  @Test
  public void allSequences_solution() {
    System.out.format("%s:\n", name.getMethodName());
    TreeNode node = new TreeNode(100);
    int[] array = {1, 2, 3};
    for (int a : array) {
      node.insertInOrder(a);
    }
    ArrayList<LinkedList<Integer>> allSeq = allSequences(node);
    for (LinkedList<Integer> list : allSeq) {
      System.out.println(list);
    }
    System.out.println(allSeq.size());
  }
}
