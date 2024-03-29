package Java.test.ctci.old.ch_04_Trees_and_Graphs.q4_01_Route_Between_Nodes;

import Java.code.ctci.old.ch_04_Trees_and_Graphs.GraphAdjacencyMatrix;
import Java.code.ctci.old.ch_04_Trees_and_Graphs.GraphAdjacencyMatrix2;
import Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_01_Route_Between_Nodes.Graph;
import Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_01_Route_Between_Nodes.Node;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"NewClassNamingConvention", "DuplicatedCode", "unused", "ConstantValue"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q4_01_Route_Between_Nodes_Test {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void pathExists_false() {
        printTestHeader(name.getMethodName());
        GraphAdjacencyMatrix<Integer> matrix = new GraphAdjacencyMatrix<>();
        matrix.addEdge(1, 2);
        matrix.addEdge(2, 3);
        matrix.addEdge(3, 4);
        matrix.addEdge(4, 5);
        matrix.addEdge(5, 6);
        matrix.addEdge(6, 3);
        int source = 5;
        int target = 1;
        boolean result = matrix.pathExists(source, target);
        assertFalse(result);
        System.out.format("\tA path exists between %d and %d: %b\n", source, target, result);
    }

    @Test
    public void pathExists_true() {
        printTestHeader(name.getMethodName());
        GraphAdjacencyMatrix<String> matrix = new GraphAdjacencyMatrix<>();
        matrix.addEdge("1", "2");
        matrix.addEdge("2", "3");
        matrix.addEdge("3", "4");
        matrix.addEdge("4", "5");
        matrix.addEdge("5", "6");
        matrix.addEdge("6", "1");
        String source = "1";
        String target = "4";
        boolean result = matrix.pathExists(source, target);
        assertTrue(result);
        System.out.format("\tA path exists between %s and %s:  %b\n", source, target, result);
    }

    @Test
    public void routeBetween_solution_1() {
        printTestHeader(name.getMethodName());
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
        Node[] n = g.getNodes();
        Node start = n[3];
        Node end = n[5];
        boolean result = GraphAdjacencyMatrix2.search(g, start, end);
        assertTrue(result);
        System.out.format("\tA path exists between %s and %s: %b\n", start, end, result);
    }
}
