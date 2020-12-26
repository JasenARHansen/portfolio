package CTCI_SOURCE.Ch_03_Stacks_and_Queues;

import java.util.EmptyStackException;

public class Introduction_MyStack<T> {
    private StackNode<T> top;

    public T pop() {
        if (top == null) throw new EmptyStackException();
        T item = top.getData();
        top = top.next;
        return item;
    }

    public void push(T item) {
        StackNode<T> t = new StackNode<>(item);
        t.next = top;
        top = t;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }
}
