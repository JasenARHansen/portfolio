package CTCI_SOURCE.unprocessed.Ch_03_Stacks_and_Queues;

import java.util.EmptyStackException;

public class Q3_03_Stack_of_Plates_Stack {
    private final int capacity;
    public Q3_03_Stack_of_Plates_Node top;
    public Q3_03_Stack_of_Plates_Node bottom;
    public int size = 0;

    public Q3_03_Stack_of_Plates_Stack(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull() {
        return capacity == size;
    }

    public void join(Q3_03_Stack_of_Plates_Node above, Q3_03_Stack_of_Plates_Node below) {
        if (below != null) below.above = above;
        if (above != null) above.below = below;
    }

    public boolean push(int v) {
        if (size >= capacity) return false;
        size++;
        Q3_03_Stack_of_Plates_Node n = new Q3_03_Stack_of_Plates_Node(v);
        if (size == 1) bottom = n;
        join(n, top);
        top = n;
        return true;
    }

    public int pop() {
        if (top == null) throw new EmptyStackException();
        Q3_03_Stack_of_Plates_Node t = top;
        top = top.below;
        size--;
        return t.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int removeBottom() {
        Q3_03_Stack_of_Plates_Node b = bottom;
        bottom = bottom.above;
        if (bottom != null) bottom.below = null;
        size--;
        return b.value;
    }
}

