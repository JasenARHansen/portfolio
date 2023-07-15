package Java.code.ctci.source.ch_03_Stacks_and_Queues.q3_03_Stack_of_Plates;

public class Node {
    public final int value;
    public Node above;
    public Node below;

    public Node(int value) {
        this.value = value;
    }
}
