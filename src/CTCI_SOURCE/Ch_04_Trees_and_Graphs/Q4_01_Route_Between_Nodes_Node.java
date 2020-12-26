package CTCI_SOURCE.Ch_04_Trees_and_Graphs;

import CTCI_SOURCE.Ch_04_Trees_and_Graphs.Q4_01_Route_Between_Nodes_Question.State;

class Q4_01_Route_Between_Nodes_Node {
    private final Q4_01_Route_Between_Nodes_Node[] adjacent;
    public int adjacentCount;
    public State state;
    private String vertex;

    public Q4_01_Route_Between_Nodes_Node(String vertex, int adjacentLength) {
        this.vertex = vertex;
        adjacentCount = 0;
        adjacent = new Q4_01_Route_Between_Nodes_Node[adjacentLength];
    }

    public void addAdjacent(Q4_01_Route_Between_Nodes_Node x) {
        if (adjacentCount < adjacent.length) {
            this.adjacent[adjacentCount] = x;
            adjacentCount++;
        } else {
            System.out.print("No more adjacent can be added");
        }
    }

    public Q4_01_Route_Between_Nodes_Node[] getAdjacent() {
        return adjacent;
    }

    public String getVertex() {
        return vertex;
    }
}
