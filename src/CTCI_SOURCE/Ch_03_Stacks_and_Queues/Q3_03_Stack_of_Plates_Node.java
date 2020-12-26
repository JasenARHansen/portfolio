package CTCI_SOURCE.Ch_03_Stacks_and_Queues;

public class Q3_03_Stack_of_Plates_Node {
    public Q3_03_Stack_of_Plates_Node above;
    public Q3_03_Stack_of_Plates_Node below;
    public int value;

    public Q3_03_Stack_of_Plates_Node(int value) {
        this.value = value;
    }
}
