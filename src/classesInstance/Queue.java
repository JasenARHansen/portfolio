package classesInstance;

import java.util.EmptyStackException;

public class Queue<T extends Comparable<T>> {
    private CustomLinkedList<T> innerList;

    /**
     * Constructor
     **/
    public Queue() {
        this.innerList = new CustomLinkedList<>();
    }

    public void add(T data) {
        this.innerList.insertIndex(data, 0);
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

    public T remove() {
        if (this.innerList.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.innerList.removeIndex(this.innerList.getSize() - 1).getData();
    }

    @Override
    public String toString() {
        return this.innerList.toString();
    }
}
