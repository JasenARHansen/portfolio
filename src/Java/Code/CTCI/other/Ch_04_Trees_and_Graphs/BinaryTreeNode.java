package Java.Code.CTCI.other.Ch_04_Trees_and_Graphs;

public class BinaryTreeNode<T extends Comparable<T>> {
  private T data;
  private int height;
  private int weight;
  private BinaryTreeNode<T> leftChild;
  private BinaryTreeNode<T> rightChild;

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

  public boolean hasLeftChild() {
    return this.leftChild != null;
  }

  public BinaryTreeNode<T> getLeftChild() {
    return this.leftChild;
  }

  public void setLeftChild(BinaryTreeNode<T> input) {
    this.leftChild = input;
  }

  public boolean hasRightChild() {
    return this.rightChild != null;
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

  @Override
  public String toString() {
    return String.format(
        "(data: %s, height: %d , weight: %d)", this.data.toString(), this.height, this.weight);
  }
}
