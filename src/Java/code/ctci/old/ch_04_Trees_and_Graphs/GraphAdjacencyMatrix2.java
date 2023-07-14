package Java.code.ctci.old.ch_04_Trees_and_Graphs;

import Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_01_Route_Between_Nodes.Graph;
import Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_01_Route_Between_Nodes.Node;
import Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_01_Route_Between_Nodes.Question;
import Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_07_Build_Order.dfs.Project;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

@SuppressWarnings("DuplicatedCode")
public class GraphAdjacencyMatrix2 {

  public static boolean search(Graph g, Node start, Node end) {
    LinkedList<Node> q = new LinkedList<>();
    for (Node u : g.getNodes()) {
      u.state = Question.State.Unvisited;
    }
    start.state = Question.State.Visiting;
    q.add(start);
    Node u;
    while (!q.isEmpty()) {
      u = q.removeFirst();
      if (u != null) {
        for (Node v : u.getAdjacent()) {
          if (v.state == Question.State.Unvisited) {
            if (v == end) {
              return true;
            } else {
              v.state = Question.State.Visiting;
              q.add(v);
            }
          }
        }
        u.state = Question.State.Visited;
      }
    }
    return false;
  }

  private static Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_07_Build_Order.dfs.Graph
      buildGraph_DFS(String[][] dependencies) {
    /* Build the graph, adding the edge (A, B) if B is dependent on A.
    Assumes a pair is listed in “build order” (which is the reverse
    of dependency order). The pair (A, B) in dependencies indicates
    that B depends on A and A must be built before A. */
    Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_07_Build_Order.dfs.Graph graph =
        new Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_07_Build_Order.dfs.Graph();
    for (String[] dependency : dependencies) {
      String first = dependency[0];
      String second = dependency[1];
      graph.addEdge(first, second);
    }
    return graph;
  }

  @SuppressWarnings("BooleanMethodIsAlwaysInverted")
  private static boolean doDFS(Project project, Stack<Project> stack) {
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

  private static Stack<Project> orderProjects_DFS(ArrayList<Project> projects) {
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

  private static String[] convertToStringList_DFS(Stack<Project> projects) {
    String[] buildOrder = new String[projects.size()];
    for (int i = 0; i < buildOrder.length; i++) {
      buildOrder[i] = projects.pop().getName();
    }
    return buildOrder;
  }

  private static Stack<Project> findBuildOrder_DFS(String[][] dependencies) {
    Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_07_Build_Order.dfs.Graph graph =
        buildGraph_DFS(dependencies);
    return orderProjects_DFS(graph.getNodes());
  }

  public static String[] buildOrderWrapper_DFS(String[][] dependencies) {
    Stack<Project> buildOrder = findBuildOrder_DFS(dependencies);
    if (buildOrder == null) return null;
    return convertToStringList_DFS(buildOrder);
  }

  public static String[] buildOrderWrapper_Edge_Removal(
      String[] projects, String[][] dependencies) {
    Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_07_Build_Order.edge_removal.Project[]
        buildOrder = findBuildOrder(projects, dependencies);
    if (buildOrder == null) return null;
    return convertToStringList_Edge_Removal(buildOrder);
  }

  private static Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_07_Build_Order.edge_removal.Project
      [] findBuildOrder(String[] projects, String[][] dependencies) {
    Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_07_Build_Order.edge_removal.Graph graph =
        buildGraph_Edge_Removal(projects, dependencies);
    return orderProjects_Edge_Removal(graph.getNodes());
  }

  private static String[] convertToStringList_Edge_Removal(
      Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_07_Build_Order.edge_removal.Project[]
          projects) {
    String[] buildOrder = new String[projects.length];
    for (int i = 0; i < projects.length; i++) {
      buildOrder[i] = projects[i].getName();
    }
    return buildOrder;
  }

  private static Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_07_Build_Order.edge_removal.Graph
      buildGraph_Edge_Removal(String[] projects, String[][] dependencies) {
    /* Build the graph, adding the edge (A, B) if B is dependent on A.
    Assumes a pair is listed in “build order”. The pair (A, B) in
    dependencies indicates that B depends on A and A must be built
    before B. */
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

  private static Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_07_Build_Order.edge_removal.Project
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

  private static int addNonDependent(
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
