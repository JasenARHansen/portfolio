package Java.test.ctci.old.ch_04_Trees_and_Graphs.q4_01_Route_Between_Nodes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import Java.code.ctci.old.ch_04_Trees_and_Graphs.GraphAdjacencyMatrix;
import Java.code.ctci.old.ch_04_Trees_and_Graphs.GraphAdjacencyMatrix2;
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
    String expected = "Build order: c f j e g i d h b a";
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
    assertEquals(expected, result);
    System.out.format("\tA build is %s\n", result);
  }

  @Test
  public void buildOrder_BFS_cycle() {
    String expected = "Build order: c f e d b a   Cycle exists in: g h i j";
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
    assertEquals(expected, result);
    System.out.format("\tA build is %s\n", result);
  }

  @Test
  public void buildOrder_DFS() {
    String expected = "Build order: c f e d b a j g i h";
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
    assertEquals(expected, result);
    System.out.format("\tA build is %s\n", result);
  }

  @Test
  public void buildOrder_DFS_cycle() {
    String expected = "Build order: c f e d b a   Cycle exists in: g h i j";
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
    assertEquals(expected, result);
    System.out.format("\tA build is %s\n", result);
  }

  @Test
  public void buildOrder_DFS_solution() {
    String expected = "Build order: c f e d b a j i h g ";
    System.out.format("%s:\n", name.getMethodName());
    String[][] dependencies = {
      {"a", "b"},
      {"b", "c"},
      {"a", "c"},
      {"d", "e"},
      {"b", "d"},
      {"e", "f"},
      {"a", "f"},
      {"h", "i"},
      {"h", "j"},
      {"i", "j"},
      {"g", "j"}
    };
    String[] buildOrder = GraphAdjacencyMatrix2.buildOrderWrapper_DFS(dependencies);
    if (buildOrder == null) {
      System.out.println("\tCircular Dependency.");
    } else {
      StringBuilder order = new StringBuilder();
      for (String s : buildOrder) {
        order.insert(0, " ");
        order.insert(0, s);
      }
      order.insert(0, "Build order: ");
      String result = order.toString();
      assertNotNull(result);
      assertEquals(expected, result);
      System.out.format("\t%s\n", result);
    }
  }

  @Test
  public void buildOrder_Edge_Removal_solution() {
    String expected = "Build order: f e j d c i b h g a ";
    System.out.format("%s:\n", name.getMethodName());
    String[] projects = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
    String[][] dependencies = {
      {"a", "b"},
      {"b", "c"},
      {"a", "c"},
      {"a", "c"},
      {"d", "e"},
      {"b", "d"},
      {"e", "f"},
      {"a", "f"},
      {"h", "i"},
      {"h", "j"},
      {"i", "j"},
      {"g", "j"}
    };
    String[] buildOrder =
        GraphAdjacencyMatrix2.buildOrderWrapper_Edge_Removal(projects, dependencies);
    if (buildOrder == null) {
      System.out.println("\tCircular Dependency.");
    } else {
      StringBuilder order = new StringBuilder();
      for (String s : buildOrder) {
        order.insert(0, " ");
        order.insert(0, s);
      }
      order.insert(0, "Build order: ");
      String result = order.toString();
      assertNotNull(result);
      assertEquals(expected, result);
      System.out.format("\t%s\n", result);
    }
  }
}
