package Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_07_Build_Order.dfs;

import java.util.ArrayList;
import java.util.Stack;

@SuppressWarnings({"DuplicatedCode", "GrazieInspection"})
public class Question {
    /* Build the graph, adding the edge (a, b) if b is dependent on a.
    Assumes a pair is listed in “build order” (which is the reverse
    of dependency order). The pair (a, b) in dependencies indicates
    that b depends on a and a must be built before a. */
    public static Graph buildGraph(String[][] dependencies) {
        Graph graph = new Graph();
        for (String[] dependency : dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }
        return graph;
    }

    public static String[] buildOrderWrapper(String[][] dependencies) {
        Stack<Project> buildOrder = findBuildOrder(dependencies);
        if (buildOrder == null) return null;
        return convertToStringList(buildOrder);
    }

    public static String[] convertToStringList(Stack<Project> projects) {
        String[] buildOrder = new String[projects.size()];
        for (int i = 0; i < buildOrder.length; i++) {
            buildOrder[i] = projects.pop().getName();
        }
        return buildOrder;
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

    public static Stack<Project> findBuildOrder(String[][] dependencies) {
        Graph graph = buildGraph(dependencies);
        return orderProjects(graph.getNodes());
    }

    public static void main(String[] args) {
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
        String[] buildOrder = buildOrderWrapper(dependencies);
        if (buildOrder == null) {
            System.out.println("Circular Dependency.");
        } else {
            for (String s : buildOrder) {
                System.out.println(s);
            }
        }
    }

    public static Stack<Project> orderProjects(ArrayList<Project> projects) {
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
}
