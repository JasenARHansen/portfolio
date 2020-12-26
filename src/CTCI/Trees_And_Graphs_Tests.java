package CTCI;

import classesInstance.BinarySearchTreeHeightBalanced;
import classesInstance.Graph;
import classesInstance.NodeGraph;
import classesInstance.NodeTree;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Trees_And_Graphs_Tests {

	private final String testSuite = "Trees And Graphs";
	@Rule
	public TestName name = new TestName();

	@Test
	public void convertToBST() {
		Integer[] array = {23, 127, 234, 19, 8, 3};
		BinarySearchTreeHeightBalanced<Integer> tree = Trees_And_Graphs.convertToBST(array);
		System.out.format("'%s' becomes '%s'\n", Arrays.toString(array), tree.toString());
	}

	@Test
	public <X extends Comparable<X>, Y, Z> void listOfPaths() {
		System.out.format("\n%s '%s'\n", testSuite, name.getMethodName());
		Integer[] array = {23, 127, 234, 19, 8, 3};
		BinarySearchTreeHeightBalanced<Integer> tree = Trees_And_Graphs.convertToBST(array);
		List<ArrayList<NodeTree<Integer>>> lists = Trees_And_Graphs.listOfPaths(tree);
		for (int i = 0; i < lists.size(); i++) {

			System.out.format("Level '%d' is '%s'\n", i, lists.get(i).toString());
		}
	}

	//@Test
	public <X extends Comparable<X>, Y, Z> void findPath() {
		System.out.format("\n%s '%s'\n", testSuite, name.getMethodName());

		// set up nodes
		NodeGraph<X, Y, Z> first = new NodeGraph<>(1, "first");
		NodeGraph<X, Y, Z> second = new NodeGraph<>(2, "second");
		NodeGraph<X, Y, Z> third = new NodeGraph<>(3, "third");
		NodeGraph<X, Y, Z> fourth = new NodeGraph<>(4, "fourth");
		NodeGraph<X, Y, Z> fifth = new NodeGraph<>(5, "fifth");
		NodeGraph<X, Y, Z> sixth = new NodeGraph<>(6, "sixth");
		// create links
		first.addAdjacent(second);
		first.addAdjacent(third);
		first.addAdjacent(fourth);
		fourth.addAdjacent(fifth);
		fifth.addAdjacent(sixth);

		Graph<X, Y, Z> graph = new Graph<>("test");
		graph.addNode(first);
		graph.addNode(second);
		graph.addNode(third);
		graph.addNode(fourth);
		graph.addNode(fifth);
		graph.addNode(sixth);

		NodeGraph<X, Y, Z> start = first;
		NodeGraph<X, Y, Z> stop = second;
		List<X> path = Trees_And_Graphs.findPath(graph, start, stop);
		System.out.format("Path between '%s' and '%s' is %s\n", start, stop, path);
		start = first;
		stop = sixth;
		path = Trees_And_Graphs.findPath(graph, start, stop);
		System.out.format("Path between '%s' and '%s' is %s\n", start, stop, path);
		start = second;
		stop = sixth;
		path = Trees_And_Graphs.findPath(graph, start, stop);
		System.out.format("Path between '%s' and '%s' is %s\n", start, stop, path);
	}
}
