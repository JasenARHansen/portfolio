package Java.Code.Educative;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DesignSerializeAndDeserializeBinaryTree {
  /*
  Serialize a binary tree to a file and then deserialize it back to a tree so that the original and the deserialized
   trees are identical.
      Serialize: write the tree in a file.
      Deserialize: read from a file and reconstruct the tree in memory.
  There is no restriction regarding the format of a serialized stream, therefore you can serialize it in any
   efficient format. However, after deserializing the tree from the stream, it should be exactly like the original
    tree. Consider the below tree as the input tree.

  Consider this tree
              100
           /       \
         50        200
       /    \         \
     25     75         350


  Runtime complexity: Linear O(n)

  Memory Complexity: Logarithmic, O(log n)

  There can be multiple approaches to serialize and deserialize the tree. One approach is to perform a depth-first
   traversal and serialize individual nodes to the stream. We’ll use a pre-order traversal here. We’ll also serialize
    some markers to represent a null pointer to help deserialize the tree.

  Consider the below binary tree as an example. Markers (M*) have been added in this tree to represent null nodes.
   The number with each marker i.e. 1 in M1, 2 in M2, merely represents the relative position of a marker in the stream.
              100
           /       \
         50        200
       /    \     /   \
     25     75   M5   350
    /  \   /  \      /   \
   M1  M2 M3  M4    M7   M8

   The serialized tree (pre-order traversal) from the above example would look like the below list.
  100 50 25 M1 M2 75 M3 M4 200 M5 350 M6 M7

  When deserializing the tree we’ll again use the pre-order traversal and create a new node for every non-marker node.
   Encountering a marker indicates that it was a null node.
  */

  public static Node deserialize(String serialized) {
    if ((serialized == null) || (serialized.isEmpty())) {
      return null;
    }
    Queue<String> tokens = new LinkedList<>(Arrays.asList(serialized.split("\\s+")));

    Node node = null;
    assert tokens.peek() != null;
    if (!tokens.peek().equals("null")) {
      node = new Node(Integer.parseInt(tokens.poll()));
      _deserialize(node, tokens);
    }
    return node;
  }

  @SuppressWarnings("UnusedReturnValue")
  public static Node _deserialize(Node node, Queue<String> tokens) {
    if ((tokens == null) || (tokens.isEmpty())) {
      return node;
    }
    // Left Path
    if (tokens.peek().equals("null")) {
      tokens.poll();
    } else {
      node.left = new Node(Integer.parseInt(tokens.poll()));
      _deserialize(node.left, tokens);
    }

    // Right Path
    if ((tokens.isEmpty()) || (tokens.peek().equals("null"))) {
      tokens.poll();
    } else {
      node.right = new Node(Integer.parseInt(tokens.poll()));
      _deserialize(node.right, tokens);
    }
    return node;
  }

  public static String serialize(Node node) {
    if (node == null) {
      return "null";
    }
    // self
    String returnString = String.valueOf(node.data);
    // left child
    returnString += " " + serialize(node.left);
    // right child
    returnString += " " + serialize(node.right);
    return returnString;
  }

  public static class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }
}
