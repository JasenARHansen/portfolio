package Java.code.ctci.source.ch_03_Stacks_and_Queues.introduction;

import java.util.EmptyStackException;

public class MyStack<T> {
    private Node<T> top;

    public boolean isEmpty() {
        return top == null;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public T pop() {
        if (top == null) throw new EmptyStackException();
        T item = top.getData();
        top = top.next;
        return item;
    }

    public void push(T item) {
        Node<T> t = new Node<>(item);
        t.next = top;
        top = t;
    }

    private static class Node<T> {
        private final T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }
}
