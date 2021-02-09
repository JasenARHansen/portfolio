package Code.unsorted.classes.classesInstance;

import Code.unsorted.classes.CustomLinkedList;

import java.util.EmptyStackException;

public class Stack<T extends Comparable<T>> {
    protected CustomLinkedList<T> innerList;

    /**
     * Constructor
     */
    public Stack() {
        this.innerList = new CustomLinkedList<>();
    }

    public int getSize() {
        return this.innerList.getSize();
    }

    public boolean isEmpty() {
        return this.innerList.isEmpty();
    }

    public T peek() {
        if (this.innerList.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.innerList.getFirst().getData();
    }

    public T pop() {
        if (this.innerList.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.innerList.removeIndex(0).getData();
    }

    public void push(T data) {
        this.innerList.insertIndex(data, 0);
    }

    @Override
    public String toString() {
        return this.innerList.toString();
    }
}
