package Code.unsorted.classes;

public class NodeList<T extends Comparable<T>> {
    private T data;
    private NodeList<T> previous;
    private NodeList<T> next;

    public NodeList() {
        this.previous = null;
        this.next = null;
        this.data = null;
    }

    public NodeList(T data) {
        this.previous = null;
        this.next = null;
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T input) {
        this.data = input;
    }

    public NodeList<T> getNext() {
        return this.next;
    }

    public void setNext(NodeList<T> input) {
        this.next = input;
    }

    public NodeList<T> getPrevious() {
        return this.previous;
    }

    public void setPrevious(NodeList<T> input) {
        this.previous = input;
    }

    @Override
    public String toString() {
        return String.format("(data: %s )", this.data.toString());
    }
}
