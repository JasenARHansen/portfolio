package Code.Interview.Facebook.practice;

import java.util.*;

public class BinaryTreeAverageValuePerLevel {
  /*
  Given a binary tree, get the average value at each level of the tree
  Signature
  int[] averageValuePerLevel(Node root)
  Input
  The root node of a tree, where the number of nodes is between 1 and 1000, and the value of each node is between 0
   and 1,000,000,000
  Output
  An int representing the number of visible nodes.
  Example

             4  <------ root
            / \
           7   9
          / \   \
        10   2   6
              \
               6
              /
             2

  output = [4,8,6,6,2]
  */
  public static int[] averageValuePerLevel_BFS(Node root) {
    List<Integer> list = new ArrayList<>();
    Queue<Node> level = new LinkedList<>();
    Queue<Node> nextLevel = new LinkedList<>();
    int sum;
    int count;
    Node node;
    level.add(root);
    while (!level.isEmpty()) {
      sum = 0;
      count = 0;
      while (!level.isEmpty()) {
        count++;
        node = level.poll();
        sum += node.data;
        if (node.left != null) {
          nextLevel.add(node.left);
        }
        if (node.right != null) {
          nextLevel.add(node.right);
        }
      }
      list.add(sum / count);
      level.addAll(nextLevel);
      nextLevel.clear();
    }
    return list.stream().mapToInt(i -> i).toArray();
  }

  public static int[] averageValuePerLevel_DFS(Node root) {
    Map<Integer, Tuple> levelMap = new HashMap<>();
    process_DFS(root, levelMap, 0);
    int[] averages = new int[levelMap.size()];
    for (Integer key : levelMap.keySet()) {
      Tuple level = levelMap.get(key);
      averages[key] = level.sum / level.count;
    }
    return averages;
  }

  private static void process_DFS(Node node, Map<Integer, Tuple> levelMap, int depth) {
    if (!levelMap.containsKey(depth)) {
      levelMap.put(depth, new Tuple(node.data, 1));
    } else {
      levelMap.get(depth).sum += node.data;
      levelMap.get(depth).count += 1;
    }
    if (node.left != null) {
      process_DFS(node.left, levelMap, depth + 1);
    }
    if (node.right != null) {
      process_DFS(node.right, levelMap, depth + 1);
    }
  }

  public static class Tuple {
    public int sum;
    public int count;

    public Tuple(int sum, int count) {
      this.sum = sum;
      this.count = count;
    }
  }

  public static class Node {
    public Node left;
    public Node right;
    int data;

    public Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }
}
