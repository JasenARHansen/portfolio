package Java.code.unsorted.classes;

@SuppressWarnings("unused")
public class NodeList<T extends Comparable<T>> {
    private T data;
    private NodeList<T> next;
    private NodeList<T> previous;

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
        return String.format(
                "(data: %s, previous: %s, next: %s)",
                this.data.toString(),
                this.previous == null ? "?" : this.previous.getData(),
                this.next == null ? "?" : this.next.getData());
    }

    public T getData() {
        return this.data;
    }

    public void setData(T input) {
        this.data = input;
    }
}
