package CTCI.Ch_04_Trees_and_Graphs;

import classes.classesInstance.Tuple;

import java.util.*;

public class BinaryTree<T extends Comparable<T>> {

  // Root node of tree
  private BinaryTreeNode<T> root;

  // Default constructor for empty tree
  public BinaryTree() {
    root = null;
  }

  public BinaryTree(T value) {
    root = new BinaryTreeNode<>(value);
  }

  // removes root reference for garbage collection
  public void clear() {
    root = null;
  }

  public int getHeight() {
    if (this.root != null) {
      return this.root.getHeight();
    }
    return -1;
  }

  public void createMinimalBST(ArrayList<T> data) {
    this.clear();
    Collections.sort(data);
    this.root = this.createBT(data);
  }

  public void createMinimalBT(ArrayList<T> data) {
    this.clear();
    this.root = this.createBT(data);
  }

  private BinaryTreeNode<T> createBT(List<T> data) {
    if (data.isEmpty()) {
      return null;
    }
    int subSize = (int) Math.ceil(data.size() / 2);
    T element = data.get(subSize);
    BinaryTreeNode<T> node = new BinaryTreeNode<>(element);
    node.setLeftChild(this.createBT(data.subList(0, subSize)));
    node.setRightChild(this.createBT(data.subList(subSize + 1, data.size())));
    int leftHeight = 0;
    if (node.getLeftChild() != null) {
      leftHeight = node.getLeftChild().getHeight();
    }
    int rightHeight = 0;
    if (node.hasRightChild()) {
      rightHeight = node.getRightChild().getHeight();
    }
    node.setHeight(1 + Math.max(leftHeight, rightHeight));

    return node;
  }

  private Tuple<T, T> validateBST(BinaryTreeNode<T> entryNode) {

    Tuple<T, T> left = null;
    Tuple<T, T> right = null;
    // Case 1, immediate children are not valid
    if (entryNode.hasLeftChild()) {
      if (entryNode.getLeftChild().getData().compareTo(entryNode.getData()) <= 0) {
        left = validateBST(entryNode.getLeftChild());
        if (left == null) {
          return null;
        }
      } else {
        return null;
      }
    }

    if (entryNode.hasRightChild()) {
      if (entryNode.getData().compareTo(entryNode.getRightChild().getData()) <= 0) {
        right = validateBST(entryNode.getRightChild());
        if (right == null) {
          return null;
        }
      } else {
        return null;
      }
    }
    // Defaults
    T leftData = entryNode.getData();
    T rightData = entryNode.getData();

    // Test boundaries
    if (left != null) {
      if (left.getRightData().compareTo(entryNode.getData()) <= 0) {
        leftData = left.getRightData();
      } else {
        return null;
      }
    }

    if (right != null) {
      if (entryNode.getData().compareTo(right.getLeftData()) <= 0) {
        rightData = right.getLeftData();
      } else {
        return null;
      }
    }

    return new Tuple<>(leftData, rightData);
  }

  public boolean validateBST() {
    Tuple<T, T> temp = validateBST(this.root);
    return (temp != null);
  }

  // Entry point for node count. Uses forwarding logic.
  public int countNodes() {
    return countNodes(root);
  }

  // Recursive call to count number of nodes from current node
  private int countNodes(BinaryTreeNode<T> entryNode) {
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

  public List<ArrayList<BinaryTreeNode<T>>> listByDepth() {
    Queue<BinaryTreeNode<T>> myQueue = new LinkedList<>();
    List<ArrayList<BinaryTreeNode<T>>> returnList = new ArrayList<>();
    if (this.root != null) {
      myQueue.add(this.root);
      myQueue.add(null);
    }
    ArrayList<BinaryTreeNode<T>> progress = new ArrayList<>();
    while (!myQueue.isEmpty()) {
      BinaryTreeNode<T> node = myQueue.remove();
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
        if (node.hasLeftChild()) {
          myQueue.add(node.getLeftChild());
        }
        if (node.hasRightChild()) {
          myQueue.add(node.getRightChild());
        }
      }
    }
    return returnList;
  }

  public String dataBreadth() {
    return dataBreadth(root).trim();
  }

  private String dataBreadth(BinaryTreeNode<T> entryNode) {
    Queue<BinaryTreeNode<T>> myQueue = new LinkedList<>();
    StringBuilder returnValue = new StringBuilder();
    if (entryNode != null) {
      myQueue.add(entryNode);
    }
    while (!myQueue.isEmpty()) {
      BinaryTreeNode<T> node = myQueue.remove();
      returnValue.append(node.getData()).append(" ");
      if (node.hasLeftChild()) {
        myQueue.add(node.getLeftChild());
      }
      if (node.hasRightChild()) {
        myQueue.add(node.getRightChild());
      }
    }
    return returnValue.toString();
  }

  public String dataInorder() {
    return dataInorder(root).trim();
  }

  private String dataInorder(BinaryTreeNode<T> entryNode) {
    String returnValue = "";
    if (entryNode != null) {
      returnValue += dataInorder(entryNode.getLeftChild());
      returnValue += entryNode.getData() + " ";
      returnValue += dataInorder(entryNode.getRightChild());
    }
    return returnValue;
  }

  public String dataPostorder() {
    return dataPostorder(root).trim();
  }

  private String dataPostorder(BinaryTreeNode<T> entryNode) {
    String returnValue = "";
    if (entryNode != null) {
      returnValue += dataPostorder(entryNode.getLeftChild());
      returnValue += dataPostorder(entryNode.getRightChild());
      returnValue += entryNode.getData() + " ";
    }
    return returnValue;
  }

  public String dataPreorder() {
    return dataPreorder(root).trim();
  }

  private String dataPreorder(BinaryTreeNode<T> entryNode) {
    String returnValue = "";
    if (entryNode != null) {
      returnValue += entryNode.getData() + " ";
      returnValue += dataPreorder(entryNode.getLeftChild());
      returnValue += dataPreorder(entryNode.getRightChild());
    }
    return returnValue;
  }

  public BinaryTreeNode<T> getRoot() {
    return this.root;
  }

  public T inorderSuccessor(BinaryTreeNode<T> entryNode) {
    if (entryNode == null) {
      return null;
    }
    if (!entryNode.hasRightChild()) {
      return entryNode.getData();
    }
    BinaryTreeNode<T> testNode = entryNode.getRightChild();
    while (testNode.hasLeftChild()) {
      testNode = testNode.getLeftChild();
    }
    return testNode.getData();
  }

  private int height(BinaryTreeNode<T> entryNode) {
    return entryNode == null ? -1 : entryNode.getHeight();
  }

  // Insert data from root and allow internal logic to handle the sorting
  public void insert(T data) {
    root = insert(data, root);
  }

  // recursive logic to insert data
  private BinaryTreeNode<T> insert(T data, BinaryTreeNode<T> entryNode) {
    if (entryNode == null) {
      entryNode = new BinaryTreeNode<>(data);
    } else if (data.compareTo(entryNode.getData()) < 0) {
      entryNode.setLeftChild(insert(data, entryNode.getLeftChild()));

      if (height(entryNode.getLeftChild()) - height(entryNode.getRightChild()) == 2) {
        if (data.compareTo(entryNode.getLeftChild().getData()) < 0) {
          entryNode = rotateRight(entryNode);
        } else {
          entryNode = reBalanceWithLeftChild(entryNode);
        }
      }
    } else if (data.compareTo(entryNode.getData()) > 0) {
      entryNode.setRightChild(insert(data, entryNode.getRightChild()));

      if (height(entryNode.getRightChild()) - height(entryNode.getLeftChild()) == 2) {
        if (data.compareTo(entryNode.getRightChild().getData()) > 0) {
          entryNode = rotateLeft(entryNode);
        } else {
          entryNode = reBalanceWithRightChild(entryNode);
        }
      }
    }
    entryNode.setHeight(
            maximumValue(height(entryNode.getLeftChild()), height(entryNode.getRightChild())) + 1);
    return entryNode;
  }

  // Test to see if tree is empty
  public boolean isEmpty() {
    return (root == null);
  }

  private int maximumValue(int leftValue, int rightValue) {
    return Math.max(leftValue, rightValue);
  }

  public T maxValue() {
    return maxValue(root);
  }

  private T maxValue(BinaryTreeNode<T> entryNode) {
    T maxValue = entryNode.getData();
    while (entryNode.hasRightChild()) {
      maxValue = entryNode.getRightChild().getData();
      entryNode = entryNode.getRightChild();
    }
    return maxValue;
  }

  public T minValue() {
    return minValue(root);
  }

  private T minValue(BinaryTreeNode<T> entryNode) {
    T minValue = entryNode.getData();
    while (entryNode.hasLeftChild()) {
      minValue = entryNode.getLeftChild().getData();
      entryNode = entryNode.getLeftChild();
    }
    return minValue;
  }

  public void outputBreadth() {
    System.out.print(dataBreadth());
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

  private BinaryTreeNode<T> reBalanceWithLeftChild(BinaryTreeNode<T> entryNode) {
    entryNode.setLeftChild(rotateLeft(entryNode.getLeftChild()));
    return rotateRight(entryNode);
  }

  private BinaryTreeNode<T> reBalanceWithRightChild(BinaryTreeNode<T> entryNode) {
    entryNode.setRightChild(rotateRight(entryNode.getRightChild()));
    return rotateLeft(entryNode);
  }

  // Insert data from root and allow internal logic to handle the sorting
  public void remove(T data) {
    remove(data, root);
  }

  private BinaryTreeNode<T> remove(T data, BinaryTreeNode<T> entryNode) {
    if (entryNode == null) {
      return null;
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
        entryNode = reBalanceWithLeftChild(entryNode);
      }
    } else if (height(entryNode.getRightChild()) - height(entryNode.getLeftChild()) == 2) {
      if (data.compareTo(entryNode.getRightChild().getData()) > 0) {
        entryNode = rotateLeft(entryNode);
      } else {
        entryNode = reBalanceWithRightChild(entryNode);
      }
    }
    return entryNode;
  }

  public T rootValue() {
    return root.getData();
  }

  private BinaryTreeNode<T> rotateLeft(BinaryTreeNode<T> entryNode) {
    BinaryTreeNode<T> rightChild = entryNode.getRightChild();
    entryNode.setRightChild(rightChild.getLeftChild());
    rightChild.setLeftChild(entryNode);
    entryNode.setHeight(
            maximumValue(height(entryNode.getLeftChild()), height(entryNode.getRightChild())) + 1);
    rightChild.setHeight(
            maximumValue(height(rightChild.getRightChild()), entryNode.getHeight()) + 1);
    return rightChild;
  }

  private BinaryTreeNode<T> rotateRight(BinaryTreeNode<T> entryNode) {
    BinaryTreeNode<T> leftChild = entryNode.getLeftChild();
    entryNode.setLeftChild(leftChild.getRightChild());
    leftChild.setRightChild(entryNode);
    entryNode.setHeight(
            maximumValue(height(entryNode.getLeftChild()), height(entryNode.getRightChild())) + 1);
    leftChild.setHeight(maximumValue(height(leftChild.getLeftChild()), entryNode.getHeight()) + 1);
    return leftChild;
  }

  // recursive method to search tree for data
  private boolean search(BinaryTreeNode<T> entryNode, T data) {
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

  // Entry point for data search
  public boolean search(T data) {
    return search(root, data);
  }

  public String printResultBFS() {
    StringBuilder returnValue = new StringBuilder();
    if (this.root == null) {
      returnValue.append("Level 0: empty");
    } else {
      Queue<BinaryTreeNode<T>> myQueue = new LinkedList<>();
      myQueue.add(this.root);
      int level = 0;
      while (!myQueue.isEmpty()) {
        returnValue.append("Level ").append(level).append(":");
        Queue<BinaryTreeNode<T>> nextLevel = new LinkedList<>();
        while (!myQueue.isEmpty()) {
          BinaryTreeNode<T> node = myQueue.remove();
          returnValue.append(" ").append(node.getData().toString());
          if (node.hasLeftChild()) {
            nextLevel.add(node.getLeftChild());
          }
          if (node.hasRightChild()) {
            nextLevel.add(node.getRightChild());
          }
        }
        myQueue = nextLevel;
        level++;
        returnValue.append("\n");
      }
    }
    return returnValue.toString().trim();
  }

  private ArrayList<ArrayList<BinaryTreeNode<T>>> generateDFSList(
          ArrayList<ArrayList<BinaryTreeNode<T>>> levels, BinaryTreeNode<T> node, int level) {
    if (node != null) {
      if (levels.size() <= level) {
        ArrayList<BinaryTreeNode<T>> newLevel = new ArrayList<>();
        levels.add(newLevel);
      }
      levels.get(level).add(node);
      level++;
      generateDFSList(levels, node.getLeftChild(), level);
      generateDFSList(levels, node.getRightChild(), level);
    }
    return levels;
  }

  public String printResultDFS() {
    ArrayList<ArrayList<BinaryTreeNode<T>>> levels = new ArrayList<>();
    generateDFSList(levels, this.getRoot(), 0);
    StringBuilder returnValue = new StringBuilder();

    if (levels.isEmpty()) {
      returnValue.append("Level 0: empty");
    } else {
      for (int i = 0; i < levels.size(); i++) {
        returnValue.append("Level ").append(i).append(":");
        for (BinaryTreeNode<T> node : levels.get(i)) {
          returnValue.append(" ").append(node.getData().toString());
        }
        returnValue.append("\n");
      }
    }
    return returnValue.toString().trim();
  }

  public boolean isBalanced() {
    if (this.root != null) {
      Queue<BinaryTreeNode<T>> myQueue = new LinkedList<>();
      myQueue.add(this.root);
      while (!myQueue.isEmpty()) {
        BinaryTreeNode<T> node = myQueue.remove();
        int left = 0;
        if (node.hasLeftChild()) {
          left = node.getLeftChild().getHeight();
          myQueue.add(node.getLeftChild());
        }
        int right = 0;
        if (node.hasRightChild()) {
          right = node.getRightChild().getHeight();
          myQueue.add(node.getRightChild());
        }
        if (Math.abs(left - right) > 1) {
          return false;
        }
      }
    }
    return true;
  }

  public BinaryTreeNode<T> findNodeBST(BinaryTreeNode<T> source, T data) {
    if (source.getData().compareTo(data) == 0) {
      return source;
    } else if (data.compareTo(source.getData()) < 0) {
      if (source.hasLeftChild()) {
        return this.findNodeBST(source.getLeftChild(), data);
      }
    } else {
      if (source.hasRightChild()) {
        return this.findNodeBST(source.getRightChild(), data);
      }
    }
    return null;
  }

  public BinaryTreeNode<T> findNodeBST(T data) {
    return this.findNodeBST(this.root, data);
  }

  private ArrayList<BinaryTreeNode<T>> findPathBST(
          ArrayList<BinaryTreeNode<T>> path, BinaryTreeNode<T> source, T data) {
    if (source.getData().compareTo(data) == 0) {
      path.add(0, source);
      return path;
    }

    if (data.compareTo(source.getData()) < 0) {
      if (source.hasLeftChild()) {
        this.findPathBST(path, source.getLeftChild(), data);
      }
    } else {
      if (source.hasRightChild()) {
        this.findPathBST(path, source.getRightChild(), data);
      }
    }
    if (!path.isEmpty()) {
      path.add(0, source);
    }
    return path;
  }

  public ArrayList<BinaryTreeNode<T>> findPathBST(T data) {
    ArrayList<BinaryTreeNode<T>> path = new ArrayList<>();
    return this.findPathBST(path, this.root, data);
  }

  public BinaryTreeNode<T> commonAncestorBST(T left, T right) {
    ArrayList<BinaryTreeNode<T>> leftPath = this.findPathBST(left);
    ArrayList<BinaryTreeNode<T>> rightPath = this.findPathBST(right);

    if ((leftPath.isEmpty()) || (rightPath.isEmpty())) {
      return null;
    } else {
      int index = 0;
      int max = Math.min(leftPath.size(), rightPath.size());
      while ((index < max) && (leftPath.get(index).equals(rightPath.get(index)))) {
        index++;
      }
      return leftPath.get(index);
    }
  }

  private ArrayList<BinaryTreeNode<T>> findPathBT(
          ArrayList<BinaryTreeNode<T>> path, BinaryTreeNode<T> source, T data) {
    if (source.getData().compareTo(data) == 0) {
      path.add(0, source);
      return path;
    }

    if (source.hasLeftChild()) {
      this.findPathBT(path, source.getLeftChild(), data);
    }

    if ((path.isEmpty()) && (source.hasRightChild())) {
      this.findPathBT(path, source.getRightChild(), data);
    }

    if (!path.isEmpty()) {
      path.add(0, source);
    }
    return path;
  }

  public ArrayList<BinaryTreeNode<T>> findPathBT(T data) {
    ArrayList<BinaryTreeNode<T>> path = new ArrayList<>();
    return this.findPathBT(path, this.root, data);
  }

  public BinaryTreeNode<T> commonAncestorBT(T first, T second) {
    ArrayList<BinaryTreeNode<T>> leftPath = this.findPathBT(first);
    ArrayList<BinaryTreeNode<T>> rightPath = this.findPathBT(second);

    if ((leftPath.isEmpty()) || (rightPath.isEmpty())) {
      return null;
    } else {
      int index = 0;
      int max = Math.min(leftPath.size(), rightPath.size());
      while ((index < max) && (leftPath.get(index).equals(rightPath.get(index)))) {
        index++;
      }
      return leftPath.get(index);
    }
  }

  public ArrayList<T> buildOrder(BinaryTreeNode<T> node) {
    ArrayList<T> buildOrder = new ArrayList<>();
    Queue<BinaryTreeNode<T>> myQueue = new LinkedList<>();
    myQueue.add(node);
    while (!myQueue.isEmpty()) {
      BinaryTreeNode<T> local = myQueue.remove();
      buildOrder.add(local.getData());
      if (local.hasLeftChild()) {
        myQueue.add(local.getLeftChild());
      }
      if (local.hasRightChild()) {
        myQueue.add(local.getRightChild());
      }
    }
    return buildOrder;
  }

  public ArrayList<T> buildOrder() {
    return buildOrder(this.root);
  }

  private void weaveList(BinaryTreeNode<T> root, int index, ArrayList<T> left, ArrayList<T> right) {
    int foo = 1;
    ArrayList<T> list = new ArrayList<>();
    list.add(root.getData());
  }

  public ArrayList<ArrayList<T>> allBuildSequences() {
    ArrayList<ArrayList<T>> results = new ArrayList<>();
    ArrayList<T> left = buildOrder(this.root.getLeftChild());
    ArrayList<T> right = buildOrder(this.root.getRightChild());
    int full_length = left.size() + right.size();
    //noinspection unchecked
    Stack<Integer> indexes = new Stack();
    for (int index = 0; index < left.size(); index++) {
      indexes.push(index);
    }
    while (!indexes.isEmpty()) {
      while (indexes.peek() < full_length) {
        ArrayList<T> result = new ArrayList<>();
        result.add(this.root.getData());
        int indexLeft = 0;
        int indexRight = 0;
        for (int index = 0; index < full_length; index++) {
          if (indexes.contains(index)) {
            result.add(left.get(indexLeft++));
          } else {
            result.add(right.get(indexRight++));
          }
        }
        results.add(result);
        indexes.push(indexes.pop() + 1);
      }
      while ((!indexes.isEmpty())
              && (indexes.peek() >= (full_length - (left.size() - indexes.size())))) {
        indexes.pop();
      }
      if (!indexes.isEmpty()) {
        indexes.push(indexes.pop() + 1);
        for (int i = indexes.size(); i < left.size(); i++) {
          indexes.push(indexes.peek() + 1);
        }
      }
    }
    return results;
  }

  @Override
  public String toString() {
    return String.format("%s", this.dataInorder());
  }
}
