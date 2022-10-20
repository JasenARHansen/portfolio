package Test.Java.CTCI.other.Q4_01_Route_Between_Nodes;

import Code.Java.CTCI.CTCI_SOURCE.other.Ch_04_Trees_and_Graphs.Q4_01_Route_Between_Nodes.Graph;
import Code.Java.CTCI.CTCI_SOURCE.other.Ch_04_Trees_and_Graphs.Q4_01_Route_Between_Nodes.Node;
import Code.Java.CTCI.CTCI_SOURCE.other.Ch_04_Trees_and_Graphs.Q4_01_Route_Between_Nodes.Question;
import Code.Java.CTCI.other.Ch_04_Trees_and_Graphs.GraphAdjacencyMatrix;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.LinkedList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q4_01_Route_Between_Nodes_Test {

    @Rule
    public TestName name = new TestName();

    @Test
    public void pathExists_true() {
        System.out.format("%s: \n", name.getMethodName());
        GraphAdjacencyMatrix<String> matrix = new GraphAdjacencyMatrix<>();
        matrix.addEdge("1", "2");
        matrix.addEdge("2", "3");
        matrix.addEdge("3", "4");
        matrix.addEdge("4", "5");
        matrix.addEdge("5", "6");
        matrix.addEdge("6", "1");
        String source = "1";
        String target = "4";
        boolean success = matrix.pathExists(source, target);
        System.out.format(
                "%s: A path exists between %s and %s: %b\n", name.getMethodName(), source, target, success);
        assertTrue(success);
    }

    @Test
    public void pathExists_false() {
        System.out.format("%s: \n", name.getMethodName());
        GraphAdjacencyMatrix<Integer> matrix = new GraphAdjacencyMatrix<>();
        matrix.addEdge(1, 2);
        matrix.addEdge(2, 3);
        matrix.addEdge(3, 4);
        matrix.addEdge(4, 5);
        matrix.addEdge(5, 6);
        matrix.addEdge(6, 3);
        int source = 5;
        int target = 1;
        boolean success = matrix.pathExists(source, target);
        System.out.format(
                "%s: A path exists between %d and %d: %b\n", name.getMethodName(), source, target, success);
        assertFalse(success);
    }

    @Test
    public void routeBetween_solution_1() {
        System.out.format("%s: \n", name.getMethodName());
        Graph g = createNewGraph();
        Node[] n = g.getNodes();
        Node start = n[3];
        Node end = n[5];
        System.out.println(search(g, start, end));
    }

    public static Graph createNewGraph() {
        Graph g = new Graph();
        Node[] temp = new Node[6];

        temp[0] = new Node("a", 3);
        temp[1] = new Node("b", 0);
        temp[2] = new Node("c", 0);
        temp[3] = new Node("d", 1);
        temp[4] = new Node("e", 1);
        temp[5] = new Node("f", 0);

        temp[0].addAdjacent(temp[1]);
        temp[0].addAdjacent(temp[2]);
        temp[0].addAdjacent(temp[3]);
        temp[3].addAdjacent(temp[4]);
        temp[4].addAdjacent(temp[5]);
        for (int i = 0; i < 6; i++) {
            g.addNode(temp[i]);
        }
        return g;
    }

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

    public enum State {
        Unvisited,
        Visited,
        Visiting
    }
}
