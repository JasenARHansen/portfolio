package Java.code.ctci.source.ch_17_Hard.q17_07_Baby_Names;

import java.util.ArrayList;
import java.util.HashMap;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Graph {
    private final HashMap<String, GraphNode> map;
    private final ArrayList<GraphNode> nodes;

    public Graph() {
        map = new HashMap<>();
        nodes = new ArrayList<>();
    }

    public void addEdge(String startName, String endName) {
        GraphNode start = getNode(startName);
        GraphNode end = getNode(endName);
        if (start != null && end != null) {
            start.addNeighbor(end);
            end.addNeighbor(start);
        }
    }

    public GraphNode createNode(String name, int freq) {
        if (map.containsKey(name)) {
            return getNode(name);
        }
        GraphNode node = new GraphNode(name, freq);
        nodes.add(node);
        map.put(name, node);
        return node;
    }

    private GraphNode getNode(String name) {
        return map.get(name);
    }

    public ArrayList<GraphNode> getNodes() {
        return nodes;
    }

    public boolean hasNode(String name) {
        return map.containsKey(name);
    }
}
