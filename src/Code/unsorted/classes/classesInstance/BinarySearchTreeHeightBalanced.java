package Code.unsorted.classes.classesInstance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTreeHeightBalanced<T extends Comparable<T>> {

  // Root node of tree
  private NodeTree<T> root;

  // Default constructor for empty tree
  public BinarySearchTreeHeightBalanced() {
    root = null;
  }

  public BinarySearchTreeHeightBalanced(T value) {
    root = new NodeTree<>(value);
  }

  // removes root reference for garbage collection
  public void clear() {
    root = null;
  }

  // Entry point for node count. Uses forwarding logic.
  public int countNodes() {
    return countNodes(root);
  }

  public List<ArrayList<NodeTree<T>>> listByDepth() {
    Queue<NodeTree<T>> myQueue = new LinkedList<>();
    List<ArrayList<NodeTree<T>>> returnList = new ArrayList<>();
    if (this.root != null) {
      myQueue.add(this.root);
      myQueue.add(null);
    }
    ArrayList<NodeTree<T>> progress = new ArrayList<>();
    while (!myQueue.isEmpty()) {
      NodeTree<T> node = myQueue.remove();
      if (node == null) {
        if (!progress.isEmpty()) {
          returnList.add(progress);
          progress = new ArrayList<>();
        }
        if (!myQueue.isEmpty()) {
          myQueue.add(null);
        }
      } else {
        progress.add(node);
        if (node.getLeftChild() != null) {
          myQueue.add(node.getLeftChild());
        }
        if (node.getRightChild() != null) {
          myQueue.add(node.getRightChild());
        }
      }
    }
    return returnList;
  }

  public String dataInorder() {
    return dataInorder(root).trim();
  }

  public String dataPostorder() {
    return dataPostorder(root).trim();
  }

  public String dataPreorder() {
    return dataPreorder(root).trim();
  }

  public NodeTree<T> getRoot() {
    return root;
  }

  // Insert data from root and allow internal logic to handle the sorting
  public void insert(T data) {
    root = insert(data, root);
  }

  // Test to see if tree is empty
  public boolean isEmpty() {
    return (root == null);
  }

  public T maxValue() {
    return maxValue(root);
  }

  private T maxValue(NodeTree<T> entryNode) {
    T maxValue = entryNode.getData();
    while (entryNode.getRightChild() != null) {
      maxValue = entryNode.getRightChild().getData();
      entryNode = entryNode.getRightChild();
    }
    return maxValue;
  }

  public T minValue() {
    return minValue(root);
  }

  private T minValue(NodeTree<T> entryNode) {
    T minValue = entryNode.getData();
    while (entryNode.getLeftChild() != null) {
      minValue = entryNode.getLeftChild().getData();
      entryNode = entryNode.getLeftChild();
    }
    return minValue;
  }

  public void outputBreadth() {
    System.out.print(dataBreadth());
  }

  public String dataBreadth() {
    return dataBreadth(root).trim();
  }

  private String dataBreadth(NodeTree<T> entryNode) {
    Queue<NodeTree<T>> myQueue = new LinkedList<>();
    StringBuilder returnValue = new StringBuilder();
    if (entryNode != null) {
      myQueue.add(entryNode);
    }
    while (!myQueue.isEmpty()) {
      NodeTree<T> node = myQueue.remove();
      returnValue.append(node.getData()).append(" ");
      if (node.getLeftChild() != null) {
        myQueue.add(node.getLeftChild());
      }
      if (node.getRightChild() != null) {
        myQueue.add(node.getRightChild());
      }
    }
    return returnValue.toString();
  }

  public void outputInorder() {
    System.out.print(dataInorder());
  }

  public void outputPostorder() {
    System.out.print(dataPostorder());
  }

  public void outputPreorder() {
    System.out.print(dataPreorder());
  }

  // Insert data from root and allow internal logic to handle the sorting
  public void remove(T data) {
    remove(data, root);
  }

  public T rootValue() {
    return root.getData();
  }

  // Entry point for data search
  public boolean search(T data) {
    return search(root, data);
  }

  @Override
  public String toString() {
    return String.format("%s", this.dataInorder());
  }

  // Recursive call to count number of nodes from current node
  private int countNodes(NodeTree<T> entryNode) {
    // If node is not assigned it can not have a count
    if (entryNode == null) {
      return 0;
    } else {
      // Assign value for self
      int count = 1;
      // Increment count by count of left child
      count += countNodes(entryNode.getLeftChild());
      // Increment count by count of right child
      count += countNodes(entryNode.getRightChild());
      return count;
    }
  }

  private String dataInorder(NodeTree<T> entryNode) {
    String returnValue = "";
    if (entryNode != null) {
      returnValue += dataInorder(entryNode.getLeftChild());
      returnValue += entryNode.getData() + " ";
      returnValue += dataInorder(entryNode.getRightChild());
    }
    return returnValue;
  }

  private String dataPostorder(NodeTree<T> entryNode) {
    String returnValue = "";
    if (entryNode != null) {
      returnValue += dataPostorder(entryNode.getLeftChild());
      returnValue += dataPostorder(entryNode.getRightChild());
      returnValue += entryNode.getData() + " ";
    }
    return returnValue;
  }

  private String dataPreorder(NodeTree<T> entryNode) {
    String returnValue = "";
    if (entryNode != null) {
      returnValue += entryNode.getData() + " ";
      returnValue += dataPreorder(entryNode.getLeftChild());
      returnValue += dataPreorder(entryNode.getRightChild());
    }
    return returnValue;
  }

  private int height(NodeTree<T> entryNode) {
    return entryNode == null ? -1 : entryNode.getHeight();
  }

  // recursive logic to insert data
  private NodeTree<T> insert(T data, NodeTree<T> entryNode) {
    if (entryNode == null) {
      entryNode = new NodeTree<>(data);
    } else if (data.compareTo(entryNode.getData()) < 0) {
      entryNode.setLeftChild(insert(data, entryNode.getLeftChild()));

      if (height(entryNode.getLeftChild()) - height(entryNode.getRightChild()) == 2) {
        if (data.compareTo(entryNode.getLeftChild().getData()) < 0) {
          entryNode = rotateRight(entryNode);
        } else {
          entryNode = rebalanceWithLeftChild(entryNode);
        }
      }
    } else if (data.compareTo(entryNode.getData()) > 0) {
      entryNode.setRightChild(insert(data, entryNode.getRightChild()));

      if (height(entryNode.getRightChild()) - height(entryNode.getLeftChild()) == 2) {
        if (data.compareTo(entryNode.getRightChild().getData()) > 0) {
          entryNode = rotateLeft(entryNode);
        } else {
          entryNode = rebalanceWithRightChild(entryNode);
        }
      }
    }
    entryNode.setHeight(
            maximumValue(height(entryNode.getLeftChild()), height(entryNode.getRightChild())) + 1);
    return entryNode;
  }

  private int maximumValue(int leftValue, int rightValue) {
    return Math.max(leftValue, rightValue);
  }

  private NodeTree<T> rebalanceWithLeftChild(NodeTree<T> entryNode) {
    entryNode.setLeftChild(rotateLeft(entryNode.getLeftChild()));
    return rotateRight(entryNode);
  }

  private NodeTree<T> rebalanceWithRightChild(NodeTree<T> entryNode) {
    entryNode.setRightChild(rotateRight(entryNode.getRightChild()));
    return rotateLeft(entryNode);
  }

  private NodeTree<T> remove(T data, NodeTree<T> entryNode) {
    if (entryNode == null) {
      return entryNode;
    } else if (data.compareTo(entryNode.getData()) == 0) {
      // if right child is null
      if (entryNode.getRightChild() == null) {
        return entryNode.getLeftChild();
      } else if (entryNode.getLeftChild() == null) {
        return entryNode.getRightChild();
      } else {
        // node with two children: Get the inorder successor (smallest
        // in the right subtree)
        entryNode.setData(minValue(entryNode.getRightChild()));
        // Delete the inorder successor
        entryNode.setRightChild(remove(entryNode.getData(), entryNode.getRightChild()));
      }
    } else if (data.compareTo(entryNode.getData()) < 0) {
      entryNode.setLeftChild(remove(data, entryNode.getLeftChild()));
    } else if (data.compareTo(entryNode.getData()) > 0) {
      entryNode.setRightChild(remove(data, entryNode.getRightChild()));
    }

    // I need to rebalance here
    if (height(entryNode.getLeftChild()) - height(entryNode.getRightChild()) == 2) {
      if (data.compareTo(entryNode.getLeftChild().getData()) < 0) {
        entryNode = rotateRight(entryNode);
      } else {
        entryNode = rebalanceWithLeftChild(entryNode);
      }
    } else if (height(entryNode.getRightChild()) - height(entryNode.getLeftChild()) == 2) {
      if (data.compareTo(entryNode.getRightChild().getData()) > 0) {
        entryNode = rotateLeft(entryNode);
      } else {
        entryNode = rebalanceWithRightChild(entryNode);
      }
    }
    return entryNode;
  }

  private NodeTree<T> rotateLeft(NodeTree<T> entryNode) {
    NodeTree<T> rightChild = entryNode.getRightChild();
    entryNode.setRightChild(rightChild.getLeftChild());
    rightChild.setLeftChild(entryNode);
    entryNode.setHeight(
            maximumValue(height(entryNode.getLeftChild()), height(entryNode.getRightChild())) + 1);
    rightChild.setHeight(
            maximumValue(height(rightChild.getRightChild()), entryNode.getHeight()) + 1);
    return rightChild;
  }

  private NodeTree<T> rotateRight(NodeTree<T> entryNode) {
    NodeTree<T> leftChild = entryNode.getLeftChild();
    entryNode.setLeftChild(leftChild.getRightChild());
    leftChild.setRightChild(entryNode);
    entryNode.setHeight(
            maximumValue(height(entryNode.getLeftChild()), height(entryNode.getRightChild())) + 1);
    leftChild.setHeight(maximumValue(height(leftChild.getLeftChild()), entryNode.getHeight()) + 1);
    return leftChild;
  }

  // recursive method to search tree for data
  private boolean search(NodeTree<T> entryNode, T data) {
    if (entryNode == null) {
      return false;
    }
    // If data is less than searchNode data than traverse tree down the
    // left child path
    else if (data.compareTo(entryNode.getData()) < 0) {
      return search(entryNode.getLeftChild(), data);
    }
    // If data is greater than searchNode data than traverse tree down
    // the right child path
    else if (data.compareTo(entryNode.getData()) > 0) {
      return search(entryNode.getRightChild(), data);
    }
    // If data is equal searchNode data than value found
    else return data.compareTo(entryNode.getData()) == 0;
  }
}
