package Java.Test.Interview.Facebook.Practice;

import static org.junit.Assert.assertEquals;

import Java.Code.Interview.Facebook.Practice.NodesInASubtree;
import Java.Code.Interview.Facebook.Practice.NodesInASubtree.Node;
import Java.Code.Interview.Facebook.Practice.NodesInASubtree.Query;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings("SpellCheckingInspection")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NodesInASubtreeTests {
  @Rule public TestName name = new TestName();

  @Test
  public void NodesInASubtree() {
    System.out.format("%s: ", name.getMethodName());
    NodesInASubtree.getDescription();
  }

  @Test
  public void countOfNodes_1() {
    int[] expected = {2};
    String s_1 = "aba";
    Node root = new Node(1);
    root.children.add(new Node(2));
    root.children.add(new Node(3));
    ArrayList<Query> queries_1 = new ArrayList<>();
    queries_1.add(new Query(1, 'a'));
    int[] result = NodesInASubtree.countOfNodes(root, queries_1, s_1);
    System.out.format("%s: The array %s\n", name.getMethodName(), Arrays.toString(result));
    assertEquals(Arrays.toString(expected), Arrays.toString(result));
  }

  @Test
  public void countOfNodes_2() {
    int[] expected = {4, 1, 2};
    String s_2 = "abaacab";
    Node root_2 = new Node(1);
    root_2.children.add(new Node(2));
    root_2.children.add(new Node(3));
    root_2.children.add(new Node(7));
    root_2.children.get(0).children.add(new Node(4));
    root_2.children.get(0).children.add(new Node(5));
    root_2.children.get(1).children.add(new Node(6));
    ArrayList<Query> queries_2 = new ArrayList<>();
    queries_2.add(new Query(1, 'a'));
    queries_2.add(new Query(2, 'b'));
    queries_2.add(new Query(3, 'a'));
    int[] result = NodesInASubtree.countOfNodes(root_2, queries_2, s_2);
    System.out.format("%s: The array %s\n", name.getMethodName(), Arrays.toString(result));
    assertEquals(Arrays.toString(expected), Arrays.toString(result));
  }
}
