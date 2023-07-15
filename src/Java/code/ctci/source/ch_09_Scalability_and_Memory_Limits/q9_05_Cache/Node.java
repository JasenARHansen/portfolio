package Java.code.ctci.source.ch_09_Scalability_and_Memory_Limits.q9_05_Cache;

public class Node {
    public final String query;
    public Node next;
    public Node prev;
    public String[] results;

    public Node(String q, String[] res) {
        results = res;
        query = q;
    }
}
