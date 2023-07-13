package Java.test.ctci.old.ch_04_Trees_and_Graphs.q4_01_Route_Between_Nodes;

import static org.junit.Assert.assertNotNull;

import Java.code.ctci.old.ch_04_Trees_and_Graphs.GraphAdjacencyMatrix;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"DuplicatedCode", "NewClassNamingConvention", "BooleanMethodIsAlwaysInverted"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q4_07_Build_Order_Test {
  @Rule public final TestName name = new TestName();

  @Test
  public void buildOrder_BFS() {
    System.out.format("%s:\n", name.getMethodName());
    GraphAdjacencyMatrix<String> matrix = new GraphAdjacencyMatrix<>();
    matrix.addEdge("a", "b");
    matrix.addEdge("b", "c");
    matrix.addEdge("a", "c");
    matrix.addEdge("d", "e");
    matrix.addEdge("b", "d");
    matrix.addEdge("e", "f");
    matrix.addEdge("a", "f");
    matrix.addEdge("h", "i");
    matrix.addEdge("h", "j");
    matrix.addEdge("i", "j");
    matrix.addEdge("g", "j");
    String result = matrix.buildOrder_BFS();
    assertNotNull(result);
    System.out.format("\tA build is %s\n", result);
  }

  @Test
  public void buildOrder_BFS_cycle() {
    System.out.format("%s:\n", name.getMethodName());
    GraphAdjacencyMatrix<String> matrix = new GraphAdjacencyMatrix<>();
    matrix.addEdge("a", "b");
    matrix.addEdge("b", "c");
    matrix.addEdge("a", "c");
    matrix.addEdge("d", "e");
    matrix.addEdge("b", "d");
    matrix.addEdge("e", "f");
    matrix.addEdge("a", "f");
    matrix.addEdge("h", "i");
    matrix.addEdge("h", "j");
    matrix.addEdge("i", "j");
    matrix.addEdge("g", "j");
    matrix.addEdge("j", "i");
    String result = matrix.buildOrder_BFS();
    assertNotNull(result);
    System.out.format("\tA build is %s\n", result);
  }

  @Test
  public void buildOrder_DFS() {
    System.out.format("%s:\n", name.getMethodName());
    GraphAdjacencyMatrix<String> matrix = new GraphAdjacencyMatrix<>();
    matrix.addEdge("a", "b");
    matrix.addEdge("b", "c");
    matrix.addEdge("a", "c");
    matrix.addEdge("d", "e");
    matrix.addEdge("b", "d");
    matrix.addEdge("e", "f");
    matrix.addEdge("a", "f");
    matrix.addEdge("h", "i");
    matrix.addEdge("h", "j");
    matrix.addEdge("i", "j");
    matrix.addEdge("g", "j");
    String result = matrix.buildOrder_DFS();
    assertNotNull(result);
    System.out.format("\tA build is %s\n", result);
  }

  @Test
  public void buildOrder_DFS_cycle() {
    System.out.format("%s:\n", name.getMethodName());
    GraphAdjacencyMatrix<String> matrix = new GraphAdjacencyMatrix<>();
    matrix.addEdge("a", "b");
    matrix.addEdge("b", "c");
    matrix.addEdge("a", "c");
    matrix.addEdge("d", "e");
    matrix.addEdge("b", "d");
    matrix.addEdge("e", "f");
    matrix.addEdge("a", "f");
    matrix.addEdge("h", "i");
    matrix.addEdge("h", "j");
    matrix.addEdge("i", "j");
    matrix.addEdge("g", "j");
    matrix.addEdge("j", "i");
    String result = matrix.buildOrder_DFS();
    assertNotNull(result);
    System.out.format("\tA build is %s\n", result);
  }
}
