package Java.test.interview.Facebook.practice;

import static org.junit.Assert.assertArrayEquals;

import Java.code.interview.Facebook.practice.BinaryTreeAverageValuePerLevel;
import Java.code.interview.Facebook.practice.BinaryTreeAverageValuePerLevel.Node;
import java.util.Arrays;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings("DuplicatedCode")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BinaryTreeAverageValuePerLevelTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void BinaryTreeAverageValuePerLevel() {
    System.out.format("%s: ", name.getMethodName());
    BinaryTreeAverageValuePerLevel.getDescription();
  }

  @Test
  public void averageValuePerLevel_1() {
    int[] expected = {4, 8, 6, 6, 2};
    Node root = new Node(4);
    root.left = new Node(7);
    root.left.left = new Node(10);
    root.left.right = new Node(2);
    root.left.right.right = new Node(6);
    root.left.right.right.left = new Node(2);
    root.right = new Node(9);
    root.right.right = new Node(6);
    int[] result = BinaryTreeAverageValuePerLevel.averageValuePerLevel_BFS(root);
    System.out.format(
        "%s: The are tree has '%s' as the average values per level\n",
        name.getMethodName(), Arrays.toString(result));
    assertArrayEquals(expected, result);
  }

  @Test
  public void averageValuePerLevel_2() {
    int[] expected = {4, 8, 6, 6, 2};
    Node root = new Node(4);
    root.left = new Node(7);
    root.left.left = new Node(10);
    root.left.right = new Node(2);
    root.left.right.right = new Node(6);
    root.left.right.right.left = new Node(2);
    root.right = new Node(9);
    root.right.right = new Node(6);
    int[] result = BinaryTreeAverageValuePerLevel.averageValuePerLevel_DFS(root);
    System.out.format(
        "%s: The are tree has '%s' as the average values per level\n",
        name.getMethodName(), Arrays.toString(result));
    assertArrayEquals(expected, result);
  }
}
