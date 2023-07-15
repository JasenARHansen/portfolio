package Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_01_Route_Between_Nodes;

public class Graph {
    public static final int MAX_VERTICES = 6;
    private final Node[] vertices;
    public int count;

    public Graph() {
        vertices = new Node[MAX_VERTICES];
        count = 0;
    }

    public void addNode(Node x) {
        if (count < vertices.length) {
            vertices[count] = x;
            count++;
        } else {
            System.out.print("Graph full");
        }
    }

    public Node[] getNodes() {
        return vertices;
    }
}
