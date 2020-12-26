package facebook;

import classesInstance.BinarySearchTreeHeightBalanced;
import classesInstance.NodeTree;

import java.util.ArrayList;

public class FaceBook {
	public static void case1() {
		System.out.println("Integer Test");
		BinarySearchTreeHeightBalanced<Integer> facebook = new BinarySearchTreeHeightBalanced<>();
		facebook.insert(3);
		facebook.insert(2);
		facebook.insert(5);
		facebook.insert(1);
		facebook.insert(4);
		facebook.insert(6);

		System.out.println(
				"For this example: A.data = 3, B.data = 2, C.data = 5, D.data = 1, E.data = 4, and F.data = 6 ");
		printPathsData(facebook);
	}

	public static void case2() {
		System.out.println("Int Test");
		BinarySearchTreeHeightBalanced<Integer> facebook = new BinarySearchTreeHeightBalanced<>();
		facebook.insert(3);
		facebook.insert(2);
		facebook.insert(5);
		facebook.insert(1);
		facebook.insert(4);
		facebook.insert(6);

		System.out.println(
				"For this example: A.data = 3, B.data = 2, C.data = 5, D.data = 1, E.data = 4, and F.data = 6 ");
		printPathsData(facebook);
	}

	public static void case3() {
		System.out.println("String Test");
		BinarySearchTreeHeightBalanced<String> facebook = new BinarySearchTreeHeightBalanced<>();
		facebook.insert("Cat");
		facebook.insert("Banana");
		facebook.insert("Elephant");
		facebook.insert("Apple");
		facebook.insert("Dog");
		facebook.insert("Fig");

		System.out.println(
				"For this example: A.data = Cat, B.data = Banana, C.data = Elephant, D.data = Apple, E.data = Dog, and F.data = Elephant ");
		printPathsData(facebook);
	}

	public static void case4() {
		System.out.println("Print Object");
		BinarySearchTreeHeightBalanced<String> facebook = new BinarySearchTreeHeightBalanced<>();
		facebook.insert("Cat");
		facebook.insert("Banana");
		facebook.insert("Elephant");
		facebook.insert("Apple");
		facebook.insert("Dog");
		facebook.insert("Fig");

		System.out.println(
				"For this example: A.data = Cat, B.data = Banana, C.data = Elephant, D.data = Apple, E.data = Dog, and F.data = Elephant ");
		printPathsNode(facebook);
	}

	private static void getDescription() {
		System.out.println("    For tree:");
		System.out.println("            A");
		System.out.println("          /  \\");
		System.out.println("         B    C");
		System.out.println("        /    / \\");
		System.out.println("       D    E   F");
		System.out.println("    Output should be:");
		System.out.println("      ABD");
		System.out.println("      ACE");
		System.out.println("      ACF");
	}

	public static void main(String[] argv) {
		getDescription();
		case1();
		case2();
		case3();
		case4();
	}

	public static <T extends Comparable<T>> void printPathsData(BinarySearchTreeHeightBalanced<T> tree) {
		ArrayList<T> paths = new ArrayList<>();
		printPathsData(tree.getRoot(), paths);
	}

	private static <T extends Comparable<T>> void printPathsData(NodeTree<T> node, ArrayList<T> paths) {
		if ((node.getLeftChild() == null) && (node.getRightChild() == null)) {
			for (T path : paths) {
				System.out.print(path + " ");
			}
			System.out.print(node.getData() + "\n");
		} else {
			paths.add(node.getData());
			if (node.getLeftChild() != null) {
				printPathsData(node.getLeftChild(), paths);
			}

			if (node.getRightChild() != null) {
				printPathsData(node.getRightChild(), paths);
			}
			paths.remove(paths.size() - 1);
		}
	}

	public static <T extends Comparable<T>> void printPathsNode(BinarySearchTreeHeightBalanced<T> tree) {
		ArrayList<NodeTree<T>> nodes = new ArrayList<>();
		printPathsNode(tree.getRoot(), nodes);
	}

	private static <T extends Comparable<T>> void printPathsNode(NodeTree<T> node,
																 ArrayList<NodeTree<T>> nodes) {
		if ((node.getLeftChild() == null) && (node.getRightChild() == null)) {
			for (NodeTree<T> tNodeTree : nodes) {
				System.out.print(tNodeTree.toString() + " ");
			}
			System.out.print(node.toString() + "\n");
		} else {
			nodes.add(node);
			if (node.getLeftChild() != null) {
				printPathsNode(node.getLeftChild(), nodes);
			}

			if (node.getRightChild() != null) {
				printPathsNode(node.getRightChild(), nodes);
			}
			nodes.remove(nodes.size() - 1);
		}
	}

}
