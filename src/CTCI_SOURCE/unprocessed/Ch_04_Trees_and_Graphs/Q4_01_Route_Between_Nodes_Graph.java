package CTCI_SOURCE.unprocessed.Ch_04_Trees_and_Graphs;

public class Q4_01_Route_Between_Nodes_Graph {
    public static int MAX_VERTICES = 6;
    private final Q4_01_Route_Between_Nodes_Node[] vertices;
    public int count;

    public Q4_01_Route_Between_Nodes_Graph() {
        vertices = new Q4_01_Route_Between_Nodes_Node[MAX_VERTICES];
        count = 0;
    }

    public void addNode(Q4_01_Route_Between_Nodes_Node x) {
        if (count < vertices.length) {
            vertices[count] = x;
            count++;
        } else {
            System.out.print("Graph full");
        }
    }

    public Q4_01_Route_Between_Nodes_Node[] getNodes() {
        return vertices;
    }
}

