package Test.unsorted;

import Code.unsorted.classes.classesInstance.Graph;
import Code.unsorted.classes.classesInstance.GraphAdjacency;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GraphTest {

    @Rule
    public TestName name = new TestName();

    @Test
    public void graph_Int() {
        Graph<Integer, String, Integer> graph = new Graph<>();

        System.out.println("Node Inserts:");
        graph.addNode(1, "Cat");
        graph.addNode(2, "Dog");
        graph.addNode(3, "Bird");
        graph.addNode(4, "Fish");
        graph.addNode(5, "Bug");
        graph.addNode(6, "Can");
        graph.addNode(1, "Apple");
        System.out.println(graph.toString());

        System.out.println("Adjacent Inserts:");
        graph.setAdjacent(1, 2);
        graph.setAdjacent(1, 3);
        graph.setAdjacent(2, 1);
        graph.setAdjacent(2, 3);
        graph.setAdjacent(2, 4, 1);
        graph.setAdjacent(2, 5);
        graph.setAdjacent(2, 5, 1);
        graph.setAdjacent(3, 4, 4);
        graph.setAdjacent(4, 5);
        graph.setAdjacent(4, 6);
        System.out.println(graph.toString());

        System.out.println("Print BF for all nodes:");
        for (Integer key : graph.getNodes()) {
            graph.printGraphBredthFirstId(key);
            graph.printGraphBredthFirstNode(key);
        }

        System.out.println("Assign Graph Id:");
        graph.setId("Animals");
        System.out.println(graph.toString());

        System.out.println("Print BFS path existance:");
        System.out.println(graph.pathExistsPathBredthFirst(1, 5));
        System.out.println(graph.pathExistsPathBredthFirst(4, 1));

        System.out.println("Print BFS for nodes:");
        graph.printPathBredthFirstId(1, 3);
        graph.printPathBredthFirstNode(1, 3);

        graph.printPathBredthFirstId(1, 5);
        graph.printPathBredthFirstNode(1, 5);

        graph.printPathBredthFirstId(2, 5);
        graph.printPathBredthFirstNode(2, 5);

        graph.printPathBredthFirstId(5, 2);
        graph.printPathBredthFirstNode(5, 2);

        System.out.println("Print DFS path existance:");
        System.out.println(graph.pathExistsPathDepthFirst(1, 5));
        System.out.println(graph.pathExistsPathDepthFirst(4, 1));

        System.out.println("Print DFS for nodes:");
        graph.printPathDepthFirstShortestId(1, 5);
        graph.printPathDepthFirstShortestNode(1, 5);
        graph.printPathDepthFirstLongestId(1, 5);
        graph.printPathDepthFirstLongestNode(1, 5);

        System.out.println("Print all DFS for nodes:");
        graph.printPathDepthFirstAllId(1, 5);
        graph.printPathDepthFirstAllNode(1, 5);

        System.out.println("Print all DFS for nodes:");
        for (Integer node : graph.getNodes()) {
            graph.printPathDepthFirstAllNode(node);
        }

    }

    // @Test
    public void graphAdjacency_Int() {
        GraphAdjacency<Integer, Integer> graph = new GraphAdjacency<>();
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(1, 4, 1);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 4, 1);
        System.out.println(graph.toString());
    }

    // @Test
    public void graphAdjacency_String() {
        GraphAdjacency<String, Integer> graph = new GraphAdjacency<>();
        graph.addEdge("Cat", "Dog", 1);
        graph.addEdge("Cat", "Bird", 1);
        graph.addEdge("Cat", "Fish", 1);
        graph.addEdge("Dog", "Bird", 1);
        graph.addEdge("Bird", "Cat", 1);
        graph.addEdge("Bird", "Fish", 1);
        graph.addEdge("Bird", "Dog", 1);
        graph.addEdge("Fish", "Cat", 1);
        graph.addEdge("Fish", "Bird", 1);
        System.out.println(graph.toString());
        for (String key : graph.getNodeIDs()) {
            graph.printBreadthFirst(key);
        }
    }

}
