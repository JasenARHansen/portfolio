package unsorted.classesInstance;

public class NodeTree<T extends Comparable<T>> {
    private T data;
    private int height;
    private int weight;
    private NodeTree<T> leftChild;
    private NodeTree<T> rightChild;

    public NodeTree() {
        this.leftChild = null;
        this.rightChild = null;
        this.data = null;
        this.height = 0;
        this.weight = 0;
    }

    public NodeTree(T input) {
        this.leftChild = null;
        this.rightChild = null;
        this.data = input;
        this.height = 0;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T input) {
        this.data = input;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int input) {
        this.height = input;
    }

    public NodeTree<T> getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(NodeTree<T> input) {
        this.leftChild = input;
    }

    public NodeTree<T> getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(NodeTree<T> input) {
        this.rightChild = input;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int input) {
        this.weight = input;
    }

    @Override
    public String toString() {
        return String.format("(data: %s, height: %d )", this.data.toString(), this.height);
    }
}