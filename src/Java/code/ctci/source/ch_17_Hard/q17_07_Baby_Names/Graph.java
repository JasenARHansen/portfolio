package Java.code.ctci.source.ch_17_Hard.q17_07_Baby_Names;

import java.util.ArrayList;
import java.util.HashMap;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Graph {
    private final HashMap<String, Node> map;
    private final ArrayList<Node> nodes;

    public Graph() {
        map = new HashMap<>();
        nodes = new ArrayList<>();
    }

    public void addEdge(String startName, String endName) {
        Node start = getNode(startName);
        Node end = getNode(endName);
        if (start != null && end != null) {
            start.addNeighbor(end);
            end.addNeighbor(start);
        }
    }

    private Node getNode(String name) {
        return map.get(name);
    }

    public Node createNode(String name, int freq) {
        if (map.containsKey(name)) {
            return getNode(name);
        }
        Node node = new Node(name, freq);
        nodes.add(node);
        map.put(name, node);
        return node;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public boolean hasNode(String name) {
        return map.containsKey(name);
    }
}
