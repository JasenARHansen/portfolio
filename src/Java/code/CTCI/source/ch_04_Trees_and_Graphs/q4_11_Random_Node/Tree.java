package Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_11_Random_Node;

import java.util.Random;

public class Tree {
  TreeNode root = null;

  public void insertInOrder(int value) {
    if (root == null) {
      root = new TreeNode(value);
    } else {
      root.insertInOrder(value);
    }
  }

  public TreeNode getRandomNode() {
    if (root == null) return null;
    Random random = new Random();
    int i = random.nextInt(size());
    return root.getIthNode(i);
  }

  public int size() {
    return root == null ? 0 : root.size();
  }
}
