package Test.CTCI.Q4_01_Route_Between_Nodes;

import CTCI.Ch_04_Trees_and_Graphs.GraphAdjacencyMatrix;
import CTCI_SOURCE.Ch_04_Trees_and_Graphs.Q4_07_Build_Order.DFS.Graph;
import CTCI_SOURCE.Ch_04_Trees_and_Graphs.Q4_07_Build_Order.DFS.Project;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Stack;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q4_07_Build_Order_Test {

    @Rule
    public TestName name = new TestName();

    /* Build the graph, adding the edge (a, b) if b is dependent on a.
     * Assumes a pair is listed in “build order” (which is the reverse
     * of dependency order). The pair (a, b) in dependencies indicates
     * that b depends on a and a must be built before a. */
    public static Graph buildGraph_DFS(String[][] dependencies) {
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
        System.out.format("%s: \n", name.getMethodName());
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
        System.out.format("%s: \n", name.getMethodName());
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
        System.out.format("%s: \n", name.getMethodName());
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
        System.out.format("%s: \n", name.getMethodName());
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
        System.out.format("%s: \n", name.getMethodName());
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
        System.out.format("%s: \n", name.getMethodName());
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
        CTCI_SOURCE.Ch_04_Trees_and_Graphs.Q4_07_Build_Order.EdgeRemoval.Project[] buildOrder =
                findBuildOrder(projects, dependencies);
        if (buildOrder == null) return null;
        return convertToStringList_Edge_Removal(buildOrder);
    }

    public static String[] convertToStringList_Edge_Removal(
            CTCI_SOURCE.Ch_04_Trees_and_Graphs.Q4_07_Build_Order.EdgeRemoval.Project[] projects) {
        String[] buildOrder = new String[projects.length];
        for (int i = 0; i < projects.length; i++) {
            buildOrder[i] = projects[i].getName();
        }
        return buildOrder;
    }

    public static CTCI_SOURCE.Ch_04_Trees_and_Graphs.Q4_07_Build_Order.EdgeRemoval.Project[]
    findBuildOrder(String[] projects, String[][] dependencies) {
        CTCI_SOURCE.Ch_04_Trees_and_Graphs.Q4_07_Build_Order.EdgeRemoval.Graph graph =
                buildGraph_Edge_Removal(projects, dependencies);
        return orderProjects_Edge_Removal(graph.getNodes());
    }

    /* Build the graph, adding the edge (a, b) if b is dependent on a.
     * Assumes a pair is listed in “build order”. The pair (a, b) in
     * dependencies indicates that b depends on a and a must be built
     * before b. */
    public static CTCI_SOURCE.Ch_04_Trees_and_Graphs.Q4_07_Build_Order.EdgeRemoval.Graph
    buildGraph_Edge_Removal(String[] projects, String[][] dependencies) {
        CTCI_SOURCE.Ch_04_Trees_and_Graphs.Q4_07_Build_Order.EdgeRemoval.Graph graph =
                new CTCI_SOURCE.Ch_04_Trees_and_Graphs.Q4_07_Build_Order.EdgeRemoval.Graph();
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

    public static CTCI_SOURCE.Ch_04_Trees_and_Graphs.Q4_07_Build_Order.EdgeRemoval.Project[]
    orderProjects_Edge_Removal(
            ArrayList<CTCI_SOURCE.Ch_04_Trees_and_Graphs.Q4_07_Build_Order.EdgeRemoval.Project>
                    projects) {
        CTCI_SOURCE.Ch_04_Trees_and_Graphs.Q4_07_Build_Order.EdgeRemoval.Project[] order =
                new CTCI_SOURCE.Ch_04_Trees_and_Graphs.Q4_07_Build_Order.EdgeRemoval.Project
                        [projects.size()];

        /* Add “roots” to the build order first.*/
        int endOfList = addNonDependent(order, projects, 0);

        int toBeProcessed = 0;
        while (toBeProcessed < order.length) {
            CTCI_SOURCE.Ch_04_Trees_and_Graphs.Q4_07_Build_Order.EdgeRemoval.Project current =
                    order[toBeProcessed];

            /* We have a circular dependency since there are no remaining
             * projects with zero dependencies. */
            if (current == null) {
                return null;
            }

            /* Remove myself as a dependency. */
            ArrayList<CTCI_SOURCE.Ch_04_Trees_and_Graphs.Q4_07_Build_Order.EdgeRemoval.Project> children =
                    current.getChildren();
            for (CTCI_SOURCE.Ch_04_Trees_and_Graphs.Q4_07_Build_Order.EdgeRemoval.Project child :
                    children) {
                child.decrementDependencies();
            }

            /* Add children that have no one depending on them. */
            endOfList = addNonDependent(order, children, endOfList);

            toBeProcessed++;
        }

        return order;
    }

    /* A helper function to insert projects with zero dependencies
     * into the order array, starting at index offset. */
    public static int addNonDependent(
            CTCI_SOURCE.Ch_04_Trees_and_Graphs.Q4_07_Build_Order.EdgeRemoval.Project[] order,
            ArrayList<CTCI_SOURCE.Ch_04_Trees_and_Graphs.Q4_07_Build_Order.EdgeRemoval.Project> projects,
            int offset) {
        for (CTCI_SOURCE.Ch_04_Trees_and_Graphs.Q4_07_Build_Order.EdgeRemoval.Project project :
                projects) {
            if (project.getNumberDependencies() == 0) {
                order[offset] = project;
                offset++;
            }
        }
        return offset;
    }
}
