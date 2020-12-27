package CTCI_SOURCE.unprocessed.Ch_04_Trees_and_Graphs;

import java.util.LinkedList;

public class Q4_01_Route_Between_Nodes_Question {
    public static void main(String[] a) {
        Q4_01_Route_Between_Nodes_Graph g = createNewGraph();
        Q4_01_Route_Between_Nodes_Node[] n = g.getNodes();
        Q4_01_Route_Between_Nodes_Node start = n[3];
        Q4_01_Route_Between_Nodes_Node end = n[5];
        System.out.println(search(g, start, end));
    }

    public static Q4_01_Route_Between_Nodes_Graph createNewGraph() {
        Q4_01_Route_Between_Nodes_Graph g = new Q4_01_Route_Between_Nodes_Graph();
        Q4_01_Route_Between_Nodes_Node[] temp = new Q4_01_Route_Between_Nodes_Node[6];

        temp[0] = new Q4_01_Route_Between_Nodes_Node("a", 3);
        temp[1] = new Q4_01_Route_Between_Nodes_Node("b", 0);
        temp[2] = new Q4_01_Route_Between_Nodes_Node("c", 0);
        temp[3] = new Q4_01_Route_Between_Nodes_Node("d", 1);
        temp[4] = new Q4_01_Route_Between_Nodes_Node("e", 1);
        temp[5] = new Q4_01_Route_Between_Nodes_Node("f", 0);

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

    public static boolean search(Q4_01_Route_Between_Nodes_Graph g, Q4_01_Route_Between_Nodes_Node start, Q4_01_Route_Between_Nodes_Node end) {
        LinkedList<Q4_01_Route_Between_Nodes_Node> q = new LinkedList<>();
        for (Q4_01_Route_Between_Nodes_Node u : g.getNodes()) {
            u.state = State.Unvisited;
        }
        start.state = State.Visiting;
        q.add(start);
        Q4_01_Route_Between_Nodes_Node u;
        while (!q.isEmpty()) {
            u = q.removeFirst();
            if (u != null) {
                for (Q4_01_Route_Between_Nodes_Node v : u.getAdjacent()) {
                    if (v.state == State.Unvisited) {
                        if (v == end) {
                            return true;
                        } else {
                            v.state = State.Visiting;
                            q.add(v);
                        }
                    }
                }
                u.state = State.Visited;
            }
        }
        return false;
    }

    public enum State {
        Unvisited, Visited, Visiting
    }
}
