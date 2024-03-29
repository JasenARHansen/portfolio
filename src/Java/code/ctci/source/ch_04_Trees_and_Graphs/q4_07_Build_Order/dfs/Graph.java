package Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_07_Build_Order.dfs;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    private final HashMap<String, Project> map = new HashMap<>();
    private final ArrayList<Project> nodes = new ArrayList<>();

    public void addEdge(String startName, String endName) {
        Project start = getOrCreateNode(startName);
        Project end = getOrCreateNode(endName);
        start.addNeighbor(end);
    }

    public Project getOrCreateNode(String name) {
        if (!map.containsKey(name)) {
            Project node = new Project(name);
            nodes.add(node);
            map.put(name, node);
        }
        return map.get(name);
    }

    public ArrayList<Project> getNodes() {
        return nodes;
    }
}
