package Java.code.ctci.old.ch_04_Trees_and_Graphs;

@SuppressWarnings("unused")
public class BinaryTreeNode<T extends Comparable<T>> {
    private T data;
    private int height;
    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;
    private int weight;

    public BinaryTreeNode(T input) {
        this();
        this.data = input;
    }

    public BinaryTreeNode() {
        this.leftChild = null;
        this.rightChild = null;
        this.data = null;
        this.height = 0;
        this.weight = 0;
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

    public BinaryTreeNode<T> getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(BinaryTreeNode<T> input) {
        this.leftChild = input;
    }

    public BinaryTreeNode<T> getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(BinaryTreeNode<T> input) {
        this.rightChild = input;
    }

    public int getWeight() {
        return this.weight;
    }

    private void setWeight(int input) {
        this.weight = input;
    }

    public boolean hasLeftChild() {
        return this.leftChild != null;
    }

    public boolean hasRightChild() {
        return this.rightChild != null;
    }

    @Override
    public String toString() {
        return String.format(
                "(data: %s, height: %d , weight: %d)", this.data, this.height, this.weight);
    }
}
