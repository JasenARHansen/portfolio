package Test.unsorted;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import unsorted.classes.CustomLinkedList;
import unsorted.classes.classesInstance.BinarySearchTreeHeightBalanced;
import unsorted.classes.classesInstance.Median;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DataStructureTest {
	@Rule
	public TestName name = new TestName();

	//	@Test
	public void BinarySearchTreeHeightBalanced_10() {

		BinarySearchTreeHeightBalanced<Integer> HeightBalancedBinarySearchTree = new BinarySearchTreeHeightBalanced<>();
		int count = 10;

		for (int index = 0; index < count; index++)
			HeightBalancedBinarySearchTree.insert(index);

		Integer intTest = HeightBalancedBinarySearchTree.countNodes();
		System.out.println("Node Count   : " + intTest);
		assertEquals("Node Count: 10", intTest, Integer.valueOf(count));

		intTest = HeightBalancedBinarySearchTree.rootValue();
		System.out.println("Root Value   : " + intTest);
		assertEquals("Root Value: 3", intTest, Integer.valueOf(3));

		intTest = HeightBalancedBinarySearchTree.minValue();
		System.out.println("Minumum Value   : " + intTest);
		assertEquals("Minumum Value: 0", intTest, Integer.valueOf(0));

		intTest = HeightBalancedBinarySearchTree.maxValue();
		System.out.println("Maxumum Value   : " + intTest);
		assertEquals("Maxumum Value: 0", intTest, Integer.valueOf(count - 1));

		boolean boolTest = HeightBalancedBinarySearchTree.search(3);
		System.out.println("Contains 3  : " + boolTest);
		assertTrue("Contains 3: true", boolTest);

		boolTest = HeightBalancedBinarySearchTree.search(11);
		System.out.println("Contains 11  : " + boolTest);
		assertFalse("Contains 11: false", boolTest);

		System.out.println("Pre-order  :");
		HeightBalancedBinarySearchTree.outputPreorder();
		String testValue = HeightBalancedBinarySearchTree.dataPreorder();
		assertEquals("Pre-order output: 3 1 0 2 7 5 4 6 8 9", testValue, "3 1 0 2 7 5 4 6 8 9");

		System.out.println("\nIn-order   :");
		HeightBalancedBinarySearchTree.outputInorder();
		testValue = HeightBalancedBinarySearchTree.dataInorder();
		assertEquals("In-orde output: 0 1 2 3 4 5 6 7 8 9", testValue, "0 1 2 3 4 5 6 7 8 9");

		System.out.println("\nPost-order :");
		HeightBalancedBinarySearchTree.outputPostorder();
		testValue = HeightBalancedBinarySearchTree.dataPostorder();
		assertEquals("Post-order output: 0 2 1 4 6 5 9 8 7 3", testValue, "0 2 1 4 6 5 9 8 7 3");

		System.out.println("\nBreadth first :");
		HeightBalancedBinarySearchTree.outputBreadth();

		testValue = HeightBalancedBinarySearchTree.dataBreadth();
		assertEquals("Breadth first output: 3 1 7 0 2 5 8 4 6 9", testValue, "3 1 7 0 2 5 8 4 6 9");

		System.out.println("\nRemove  : 5");
		HeightBalancedBinarySearchTree.remove(5);

		boolTest = HeightBalancedBinarySearchTree.search(5);
		System.out.println("Contains 5  : " + boolTest);
		assertFalse("Contains 5: false", boolTest);

		System.out.println("Pre-order  :");
		HeightBalancedBinarySearchTree.outputPreorder();
		testValue = HeightBalancedBinarySearchTree.dataPreorder();
		assertEquals("Pre-order output: 3 1 0 2 7 6 4 8 9", testValue, "3 1 0 2 7 6 4 8 9");

		System.out.println("\nIn-order   :");
		HeightBalancedBinarySearchTree.outputInorder();
		testValue = HeightBalancedBinarySearchTree.dataInorder();
		assertEquals("In-orde output: 0 1 2 3 4 6 7 8 9", testValue, "0 1 2 3 4 6 7 8 9");

		System.out.println("\nPost-order :");
		HeightBalancedBinarySearchTree.outputPostorder();
		testValue = HeightBalancedBinarySearchTree.dataPostorder();
		assertEquals("Post-order output: 0 2 1 4 6 9 8 7 3", testValue, "0 2 1 4 6 9 8 7 3");

		System.out.println("\nBreadth first :");
		HeightBalancedBinarySearchTree.outputBreadth();
		testValue = HeightBalancedBinarySearchTree.dataBreadth();
		assertEquals("Breadth first output: 3 1 7 0 2 8 4 6 9", testValue, "3 1 7 0 2 6 8 4 9");
	}

	//	@Test
	public void BinarySearchTreeHeightBalanced_100() {
		BinarySearchTreeHeightBalanced<Integer> HeightBalancedBinarySearchTree = new BinarySearchTreeHeightBalanced<>();
		int count = 100;

		for (int index = 0; index < count; index++)
			HeightBalancedBinarySearchTree.insert(index);

		Integer intTest = HeightBalancedBinarySearchTree.countNodes();
		System.out.println("Node Count   : " + intTest);
		assertEquals("Node Count: 100", intTest, Integer.valueOf(count));

		intTest = HeightBalancedBinarySearchTree.rootValue();
		System.out.println("Root Value   : " + intTest);

		intTest = HeightBalancedBinarySearchTree.minValue();
		System.out.println("Minumum Value   : " + intTest);
		assertEquals("Minumum Value: 0", intTest, Integer.valueOf(0));

		intTest = HeightBalancedBinarySearchTree.maxValue();
		System.out.println("Maxumum Value   : " + intTest);
		assertEquals("Maxumum Value: 0", intTest, Integer.valueOf(count - 1));

		boolean boolTest = HeightBalancedBinarySearchTree.search(3);
		System.out.println("Contains 3  : " + boolTest);
		assertTrue("Contains 3: true", boolTest);

		System.out.println("Pre-order  :");
		HeightBalancedBinarySearchTree.outputPreorder();

		System.out.println("\nIn-order   :");
		HeightBalancedBinarySearchTree.outputInorder();

		System.out.println("\nPost-order :");
		HeightBalancedBinarySearchTree.outputPostorder();

		System.out.println("\nBreadth first :");
		HeightBalancedBinarySearchTree.outputBreadth();

		System.out.println("\nRemove  : 5");
		HeightBalancedBinarySearchTree.remove(5);

		boolTest = HeightBalancedBinarySearchTree.search(5);
		System.out.println("Contains 5  : " + boolTest);
		assertFalse("Contains 5: false", boolTest);

		System.out.println("Pre-order  :");
		HeightBalancedBinarySearchTree.outputPreorder();

		System.out.println("\nIn-order   :");
		HeightBalancedBinarySearchTree.outputInorder();

		System.out.println("\nPost-order :");
		HeightBalancedBinarySearchTree.outputPostorder();

		System.out.println("\nBreadth first :");
		HeightBalancedBinarySearchTree.outputBreadth();

	}

	@Test
	public void CustomLinkedList() {

		CustomLinkedList<Integer> test = new CustomLinkedList<>();
		test.printList();
		test.insert(1);
		test.printList();
		test.insert(2);
		test.printList();
		test.insert(4);
		test.printList();
		test.insertIndex(3, 2);
		test.printList();
		test.removeIndex(2);
		test.printList();
		test.remove(2);
		test.printList();
		test.removeIndex(2);
		test.printList();
		test.insert(2);
		test.printList();
		test.removeIndex(0);
		test.printList();
		test.removeIndex(0);
		test.printList();
		test.insert(1);
		test.printList();
		test.removeIndex(1);
		test.printList();

	}

	//	@Test
	public void Median() {
		Median<Integer> median = new Median<>();
		median.getMedian();
		median.insert(5);
		// 5
		median.getMedian();
		median.printMedian();
		median.insert(1);
		// 1, 5
		median.getMedian();
		median.printMedian();
		median.insert(2);
		// 1, 2, 5
		median.getMedian();
		median.printMedian();
		median.insert(4);
		// 1, 2, 4, 5
		median.getMedian();
		median.printMedian();
		median.insert(3);
		// 1, 2, 3, 4, 5
		median.getMedian();
		median.printMedian();
		median.insert(7);
		// 1, 2, 3, 4, 5, 7
		median.getMedian();
		median.printMedian();
		median.insert(8);
		// 1, 2, 3, 4, 5, 7, 8
		median.getMedian();
		median.printMedian();
		median.insert(9);
		// 1, 2, 3, 4, 5, 7, 8, 9
		median.getMedian();
		median.printMedian();
		median.insert(6);
		// 1, 2, 3, 4, 5, 6, 7, 8, 9
		median.getMedian();
		median.printMedian();
	}
}
