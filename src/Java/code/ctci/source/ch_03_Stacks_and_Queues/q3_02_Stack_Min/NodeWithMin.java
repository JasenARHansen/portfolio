package Java.code.ctci.source.ch_03_Stacks_and_Queues.q3_02_Stack_Min;

public class NodeWithMin {
    public final int min;
    public final int value;

    public NodeWithMin(int v, int min) {
        value = v;
        this.min = min;
    }
}
