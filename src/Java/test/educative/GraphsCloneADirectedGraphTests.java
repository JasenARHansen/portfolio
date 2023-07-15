package Java.test.educative;

import Java.code.educative.GraphsCloneADirectedGraph;
import Java.code.educative.GraphsCloneADirectedGraph.Node;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GraphsCloneADirectedGraphTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void clone_1() {
        printTestHeader(name.getMethodName());
        Node N_0 = new Node(0);
        Node N_1 = new Node(1);
        Node N_2 = new Node(2);
        Node N_3 = new Node(3);
        Node N_4 = new Node(4);
        N_0.neighbors.add(N_3);
        N_0.neighbors.add(N_4);
        N_1.neighbors.add(N_2);
        N_2.neighbors.add(N_0);
        N_3.neighbors.add(N_2);
        N_4.neighbors.add(N_1);
        N_4.neighbors.add(N_3);
        Node result = GraphsCloneADirectedGraph.clone(N_0);
        System.out.println(result);
    }

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        GraphsCloneADirectedGraph.getDescription();
    }
}
