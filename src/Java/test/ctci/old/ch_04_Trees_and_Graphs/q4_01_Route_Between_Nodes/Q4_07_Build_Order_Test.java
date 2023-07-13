package Java.test.ctci.old.ch_04_Trees_and_Graphs.q4_01_Route_Between_Nodes;

import Java.code.ctci.old.ch_04_Trees_and_Graphs.GraphAdjacencyMatrix;
import Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_07_Build_Order.dfs.Graph;
import Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_07_Build_Order.dfs.Project;
import java.util.ArrayList;
import java.util.Stack;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"GrazieInspection", "DuplicatedCode", "NewClassNamingConvention"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q4_07_Build_Order_Test {
  @Rule public final TestName name = new TestName();
  public static Graph buildGraph_DFS(String[][] dependencies) {
  /* Build the graph, adding the edge (a, b) if b is dependent on a.
  Assumes a pair is listed in “build order” (which is the reverse
  of dependency order). The pair (a, b) in dependencies indicates
  that b depends on a and a must be built before a. */
    Graph graph = new Graph();
    for (String[] dependency : dependencies) {
      String first = dependency[0];
      String second = dependency[1];
      graph.addEdge(first, second);
    }
    return graph;
  }

  @SuppressWarnings("BooleanMethodIsAlwaysInverted")
  public static boolean doDFS(Project project, Stack<Project> stack) {
    if (project.getState() == Project.State.PARTIAL) {
      return false; // Cycle
    }
    if (project.getState() == Project.State.BLANK) {
      project.setState(Project.State.PARTIAL);
      ArrayList<Project> children = project.getChildren();
      for (Project child : children) {
        if (!doDFS(child, stack)) {
          return false;
        }
      }
      project.setState(Project.State.COMPLETE);
      stack.push(project);
    }
    return true;
  }

  public static Stack<Project> orderProjects_DFS(ArrayList<Project> projects) {
    Stack<Project> stack = new Stack<>();
    for (Project project : projects) {
      if (project.getState() == Project.State.BLANK) {
        if (!doDFS(project, stack)) {
          return null;
        }
      }
    }
    return stack;
  }

  public static String[] convertToStringList_DFS(Stack<Project> projects) {
    String[] buildOrder = new String[projects.size()];
    for (int i = 0; i < buildOrder.length; i++) {
      buildOrder[i] = projects.pop().getName();
    }
    return buildOrder;
  }

  public static Stack<Project> findBuildOrder_DFS(String[][] dependencies) {
    Graph graph = buildGraph_DFS(dependencies);
    return orderProjects_DFS(graph.getNodes());
  }

  public static String[] buildOrderWrapper_DFS(String[][] dependencies) {
    Stack<Project> buildOrder = findBuildOrder_DFS(dependencies);
    if (buildOrder == null) return null;
    return convertToStringList_DFS(buildOrder);
  }

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
    String order = matrix.buildOrder_BFS();
    System.out.format("%s: A build is %s\n", name.getMethodName(), order);
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
    String order = matrix.buildOrder_BFS();
    System.out.format("%s: A build is %s\n", name.getMethodName(), order);
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
    String order = matrix.buildOrder_DFS();
    System.out.format("%s: A build is %s\n", name.getMethodName(), order);
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
    String order = matrix.buildOrder_DFS();
    System.out.format("%s: A build is %s\n", name.getMethodName(), order);
  }

  @Test
  public void buildOrder_DFS_solution() {
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
    String[] buildOrder = buildOrderWrapper_DFS(dependencies);
    if (buildOrder == null) {
      System.out.println("Circular Dependency.");
    } else {
      StringBuilder order = new StringBuilder();
      for (String s : buildOrder) {
        order.insert(0, " ");
        order.insert(0, s);
      }
      order.insert(0, "Build order: ");
      System.out.println(order.toString().trim());
    }
  }

  @Test
  public void buildOrder_Edge_Removal_solution() {
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
    String[] buildOrder = buildOrderWrapper_Edge_Removal(projects, dependencies);
    if (buildOrder == null) {
      System.out.println("Circular Dependency.");
    } else {
      StringBuilder order = new StringBuilder();
      for (String s : buildOrder) {
        order.insert(0, " ");
        order.insert(0, s);
      }
      order.insert(0, "Build order: ");
      System.out.println(order.toString().trim());
    }
  }

  public static String[] buildOrderWrapper_Edge_Removal(
      String[] projects, String[][] dependencies) {
    Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_07_Build_Order.edge_removal.Project[]
        buildOrder = findBuildOrder(projects, dependencies);
    if (buildOrder == null) return null;
    return convertToStringList_Edge_Removal(buildOrder);
  }

  public static Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_07_Build_Order.edge_removal.Project
      [] findBuildOrder(String[] projects, String[][] dependencies) {
    Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_07_Build_Order.edge_removal.Graph graph =
        buildGraph_Edge_Removal(projects, dependencies);
    return orderProjects_Edge_Removal(graph.getNodes());
  }

  public static String[] convertToStringList_Edge_Removal(
      Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_07_Build_Order.edge_removal.Project[]
          projects) {
    String[] buildOrder = new String[projects.length];
    for (int i = 0; i < projects.length; i++) {
      buildOrder[i] = projects[i].getName();
    }
    return buildOrder;
  }

  public static Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_07_Build_Order.edge_removal.Graph
      buildGraph_Edge_Removal(String[] projects, String[][] dependencies) {
    /* Build the graph, adding the edge (a, b) if b is dependent on a.
    Assumes a pair is listed in “build order”. The pair (a, b) in
    dependencies indicates that b depends on a and a must be built
    before b. */
    Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_07_Build_Order.edge_removal.Graph graph =
        new Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_07_Build_Order.edge_removal.Graph();
    for (String project : projects) {
      graph.getOrCreateNode(project);
    }
    for (String[] dependency : dependencies) {
      String first = dependency[0];
      String second = dependency[1];
      graph.addEdge(first, second);
    }
    return graph;
  }

  public static Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_07_Build_Order.edge_removal.Project
      [] orderProjects_Edge_Removal(
      ArrayList<Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_07_Build_Order.edge_removal.Project>
          projects) {
    Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_07_Build_Order.edge_removal.Project[] order =
        new Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_07_Build_Order.edge_removal.Project
            [projects.size()];
    /* Add “roots” to the build order first. */
    int endOfList = addNonDependent(order, projects, 0);
    int toBeProcessed = 0;
    while (toBeProcessed < order.length) {
      Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_07_Build_Order.edge_removal.Project current =
          order[toBeProcessed];
      /* We have a circular dependency since there are no remaining
      projects with zero dependencies. */
      if (current == null) {
        return null;
      }
      /* Remove myself as a dependency. */
      ArrayList<Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_07_Build_Order.edge_removal.Project>
          children = current.getChildren();
      for (Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_07_Build_Order.edge_removal.Project
          child : children) {
        child.decrementDependencies();
      }
      /* Add children that have no one depending on them. */
      endOfList = addNonDependent(order, children, endOfList);
      toBeProcessed++;
    }
    return order;
  }

  public static int addNonDependent(
      Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_07_Build_Order.edge_removal.Project[] order,
      ArrayList<Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_07_Build_Order.edge_removal.Project>
          projects,
      int offset) {
    /* A helper function to insert projects with zero dependencies
    into the order array, starting at index offset. */
    for (Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_07_Build_Order.edge_removal.Project
        project : projects) {
      if (project.getNumberDependencies() == 0) {
        order[offset] = project;
        offset++;
      }
    }
    return offset;
  }
}
