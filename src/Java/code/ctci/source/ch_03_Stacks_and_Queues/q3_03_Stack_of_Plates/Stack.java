package Java.code.ctci.source.ch_03_Stacks_and_Queues.q3_03_Stack_of_Plates;

import java.util.EmptyStackException;

public class Stack {
    private final int capacity;
    public Node bottom;
    public int size = 0;
    public Node top;

    public Stack(int capacity) {
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return capacity == size;
    }

    public int pop() {
        if (top == null) throw new EmptyStackException();
        Node t = top;
        top = top.below;
        size--;
        return t.value;
    }

    public boolean push(int v) {
        if (size >= capacity) return false;
        size++;
        Node n = new Node(v);
        if (size == 1) bottom = n;
        join(n, top);
        top = n;
        return true;
    }

    public void join(Node above, Node below) {
        if (below != null) below.above = above;
        if (above != null) above.below = below;
    }

    public int removeBottom() {
        Node b = bottom;
        bottom = bottom.above;
        if (bottom != null) bottom.below = null;
        size--;
        return b.value;
    }
}
