package unsorted.classes.classesInstance;

import unsorted.classes.NodeList;

public class CirularLinkedList<T extends Comparable<T>> {

    private NodeList<T> head;
    private NodeList<T> tail;
    private int size;

    public CirularLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void empty() {
        while (this.size != 0) {
            removeIndex(0);
        }
    }

    // This does not work as expected when the data type is integer...
    public NodeList<T> remove(T data) {
        NodeList<T> pointerNode = this.head;
        for (int index = 0; index < this.size; index++) {
            if (pointerNode.getData().compareTo(data) == 0) {
                return removeIndex(index);
            }
            pointerNode = pointerNode.getNext();
        }
        return null;
    }

    public NodeList<T> getFirst() {
        return this.head;
    }

    public NodeList<T> getIndex(int index) {
        NodeList<T> pointerNode = this.head;
        for (int i = 0; i < index; i++) {
            pointerNode = pointerNode.getNext();
        }
        return pointerNode;
    }

    public NodeList<T> getLast() {
        return this.tail;
    }

    public int getSize() {
        return this.size;
    }

    public void insert(T data) {
        insertIndex(data, this.size);
    }

    public void insertIndex(T data, int index) {
        NodeList<T> node = new NodeList<>(data);

        // Base Case, first entry
        if (this.size == 0) {
            this.head = node;
            this.tail = node;
            node.setNext(node);
            node.setPrevious(node);
        }
        // Insert at front with wrap around
        else if (((index) % this.size) == 1) {
            node.setNext(this.head);
            node.setPrevious(this.tail);
            this.head.setPrevious(node);
            this.tail.setNext(node);
            this.head = node;
        }
        // Insert at end with wrap around
        else if (((index) % this.size) == 0) {
            node.setPrevious(this.tail);
            node.setNext(this.head);
            this.tail.setNext(node);
            this.head.setPrevious(node);
            this.tail = node;
        }
        // Insert in middle
        else {
            NodeList<T> pointerNode = this.head;
            for (int i = 0; i < index - 1; i++) {
                pointerNode = pointerNode.getNext();
            }
            node.setPrevious(pointerNode);
            node.setNext(pointerNode.getNext());
            pointerNode.getNext().setPrevious(node);
            pointerNode.setNext(node);
        }
        this.size++;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void printList() {
        System.out.format("List: '%s'\n", toString());
    }

    @Override
    public String toString() {
        if (this.head == null) {
            return "null";
        }

        StringBuilder stringBuilder = new StringBuilder();
        NodeList<T> pointerNode = this.head;
        stringBuilder.append(pointerNode.toString());

        for (int i = 1; i < this.size; i++) {
            pointerNode = pointerNode.getNext();
            stringBuilder.append(" <-> ");
            stringBuilder.append(pointerNode.toString());
        }
        return stringBuilder.toString();
    }

    public NodeList<T> removeIndex(int index) {
        NodeList<T> pointerNode = this.head;
        // Reset head and tail as needed
        // Front with wrap around
        if (((index + 1) % this.size) == 1) {
            this.head = this.head.getNext();
        }
        // End with wrap around
        else if (((index + 1) % this.size) == 0) {
            this.tail = this.tail.getPrevious();
        }

        // Find the index
        // A <-> B <-> C remove B
        // C.setPrevious(A)
        // A.setNext(C)
        // B.setNext(null);
        // B.setPrevious(null);
        for (int i = 0; i < index; i++) {
            pointerNode = pointerNode.getNext();
        }
        pointerNode.getPrevious().setNext(pointerNode.getNext());
        pointerNode.getNext().setPrevious(pointerNode.getPrevious());
        pointerNode.setNext(null);
        pointerNode.setPrevious(null);

        this.size--;
        if (this.size == 0) {
            this.head = null;
            this.tail = null;
        }
        return pointerNode;
    }
}
