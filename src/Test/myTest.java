package Test;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class myTest {

	private void loopTest() {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int i = 0; i < t; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int n = scan.nextInt();
			List<Integer> loopOut = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				int sum = a;
				for (int k = 0; k <= j; k++) {
					sum += b * Math.pow(2, k);
				}
				loopOut.add(sum);
			}
			String output = "";
			for (int value : loopOut) {
				output += value + " ";
			}

			System.out.println(output.trim());
		}
		scan.close();
	}

	private void highestAssocitivity() {
		Scanner scan = new Scanner(System.in);
		float associtivityThreshold = scan.nextFloat();
		int associationCount = scan.nextInt();

		List<AssociativityNode> associativityNodeList = new ArrayList<>();

		for (int i = 0; i < associationCount; i++) {
			String firstItem = scan.next();
			String secondItem = scan.next();
			float itemAssocitivity = scan.nextFloat();

			/* Create all AssociativityNodes */
			boolean found = false;
			for (AssociativityNode associativityNode : associativityNodeList) {
				if (associativityNode.getName().equals(firstItem)) {
					if (itemAssocitivity > associtivityThreshold) {
						associativityNode.addAssociation(secondItem);
						found = true;
						break;
					}
				}
			}
			if (!found) {
				boolean duplicate = false;
				for (AssociativityNode associativityNode : associativityNodeList) {
					if (associativityNode.getName().equals(firstItem)) {
						duplicate = true;
						break;
					}
				}
				if (duplicate) {
					continue;
				}
				AssociativityNode associativityNode = new AssociativityNode(firstItem);
				if (itemAssocitivity > associtivityThreshold) {
					associativityNode.addAssociation(secondItem);
				}
				/* Add to associativityNodeList */
				associativityNodeList.add(associativityNode);
			}
		}

		/* Create proper links in associativityNodeList */
		for (AssociativityNode associativityNode : associativityNodeList) {
			for (int i = 0; i < associativityNode.getAssociationCount(); i++) {
				for (AssociativityNode associativityNodeInner : associativityNodeList) {
					if (associativityNode.getAssociations(i).getName().equals(associativityNodeInner.getName())) {
						associativityNode.replaceAssociation(associativityNodeInner);
						break;
					}
				}

			}
		}

		/* Determine AssociativityNode with greatest associativity */
		int associativity = 0;
		List<String> associativityHeadList = new ArrayList<>();
		for (AssociativityNode associativityNode : associativityNodeList) {
			List<String> associativityList = associativityNode.getAssociativity();
			if (associativityList.size() > associativity) {
				associativity = associativityList.size();
				associativityHeadList.clear();
			}
			if (associativityList.size() >= associativity) {
				associativityHeadList.add(associativityList.get(0));
			}
		}
		Collections.sort(associativityHeadList);

		System.out.println(associativityHeadList.get(0));
		scan.close();
	}

	private int[] mergeAndSort(int[]... sourceArrays) {
		List<Integer> merged = new ArrayList<>();
		for (int[] array : sourceArrays) {
			merged.addAll(Arrays.stream(array).boxed().collect(Collectors.toList()));
		}
		int[] returnArray = new int[merged.size()];
		Iterator<Integer> iterator = merged.iterator();
		for (int i = 0; i < returnArray.length; i++) {
			returnArray[i] = iterator.next().intValue();
		}
		Arrays.sort(returnArray);
		return returnArray;
	}

	private int search(int element, int[] array1, int[] array2) {
		if ((element < 1) || (element > (array1.length + array2.length))) {
			return -1;
		}
		// Arrays.sort(array1);/* To pre-sort the contents of the Array */
		// Arrays.sort(array2);/* To pre-sort the contents of the Array */
		int value = -1;
		int counter = 0;
		int index1 = 0;
		int index2 = 0;
		while (counter++ < element) {
			if (index1 == array1.length && index2 < array2.length) {
				value = array2[index2];
				index2++;
			} else if (index2 == array2.length && index1 < array1.length) {
				value = array1[index1];
				index1++;
			} else if (array1[index1] <= array2[index2]) {
				value = array1[index1];
				index1++;
			} else {
				value = array2[index2];
				index2++;
			}
		}
		return value;
	}

	private int searchComplex(int element, int[]... sourceArrays) {
		int totalCount = 0;
		for (int[] array : sourceArrays) {
			Arrays.sort(array); /* To pre-sort the contents of the Array */
			totalCount += array.length; /* Ignoring the NPE for simplicity */
		}
		if ((element < 1) || (element > totalCount)) {
			return Integer.MIN_VALUE;
		}
		int[] indexes = new int[sourceArrays.length];
		int value = Integer.MIN_VALUE;
		int counter = 0;
		while (counter++ < element) {
			int indexToAdjust = 0;
			Integer currentValue = null;
			for (int i = 0; i < sourceArrays.length; i++) {
				if (indexes[i] < sourceArrays[i].length) {
					if ((currentValue == null) || (currentValue > sourceArrays[i][indexes[i]])) {
						indexToAdjust = i;
						currentValue = sourceArrays[i][indexes[i]];
					}
				}
			}
			value = currentValue;
			indexes[indexToAdjust]++;
		}
		return value;
	}

	@Test
	public void test1() {
		System.out.println("Test 1");
		int[] array1 = {1, 5, 10, 11, 13, 18};
		int[] array2 = {2, 3, 7, 9, 12, 16, 17};
		int[] answer = mergeAndSort(array1, array2);
		for (int i = 1; i <= answer.length; i++) {
			int value = search(i, array1, array2);
			System.out.println("The answer is: " + value + " and the expected is: " + answer[i - 1] + ".  This is "
					+ (value == answer[i - 1]));
		}
	}

	@Test
	public void test2() {
		System.out.println("Test 2");
		int[] array1 = {1, 2, 3, 4, 5, 6};
		int[] array2 = {7, 8, 9, 10, 11, 12, 13};
		int[] answer = mergeAndSort(array1, array2);
		for (int i = 1; i <= answer.length; i++) {
			int value = search(i, array1, array2);
			System.out.println("The answer is: " + value + " and the expected is: " + answer[i - 1] + ".  This is "
					+ (value == answer[i - 1]));
		}
	}

	@Test
	public void test3() {
		System.out.println("Test 3");
		int[] array1 = {7, 8, 9, 10, 11, 12, 13};
		int[] array2 = {1, 2, 3, 4, 5, 6};
		int[] answer = mergeAndSort(array1, array2);
		for (int i = 1; i <= answer.length; i++) {
			int value = search(i, array1, array2);
			System.out.println("The answer is: " + value + " and the expected is: " + answer[i - 1] + ".  This is "
					+ (value == answer[i - 1]));
		}
	}

	@Test
	public void test4() {
		System.out.println("Test 4");
		int[] array1 = {6, 8, 2, 10, 4, 12, 13};
		int[] array2 = {1, 7, 3, 5, 5, 6};
		int[] answer = mergeAndSort(array1, array2);
		for (int i = 1; i <= answer.length; i++) {
			int value = search(i, array1, array2);
			System.out.println("The answer is: " + value + " and the expected is: " + answer[i - 1] + ".  This is "
					+ (value == answer[i - 1]));
		}
	}

	@Test
	public void test5() {
		System.out.println("Test 5");
		int[] array1 = {1, 2, 3, 4, 5, 6};
		int[] array2 = {7, 8, 9, 10, 11, 12, 13};
		int[] answer = mergeAndSort(array1, array2);
		for (int i = 1; i <= answer.length; i++) {
			int value = search(i, array1, array2);
			System.out.println("The answer is: " + value + " and the expected is: " + answer[i - 1] + ".  This is "
					+ (value == answer[i - 1]));
		}
	}

	@Test
	public void test6() {
		System.out.println("Test 6");
		int[] array1 = {1, 2, 3, 4, 5, 6};
		int[] array2 = {7, 8, 9, 10, 11, 12, 13};
		int[] array3 = {3, 6, 9};
		int[] answer = mergeAndSort(array1, array2, array3);
		for (int i = 1; i <= answer.length; i++) {
			int value = searchComplex(i, array1, array2, array3);
			System.out.println("The answer is: " + value + " and the expected is: " + answer[i - 1] + ".  This is "
					+ (value == answer[i - 1]));
		}
	}

	@Test
	public void test7() {
		System.out.println("Test 6");
		int[] array1 = {5, 3, 1, 2, 4, 6};
		int[] array2 = {11, 12, 7, 9, 8, 10, 13};
		int[] array3 = {6, 3, 9};
		int[] answer = mergeAndSort(array1, array2, array3);
		for (int i = 1; i <= answer.length; i++) {
			int value = searchComplex(i, array1, array2, array3);
			System.out.println("The answer is: " + value + " and the expected is: " + answer[i - 1] + ".  This is "
					+ (value == answer[i - 1]));
		}
	}

	@Test
	public void test9() {
		highestAssocitivity();
	}

	@Test
	public void test10() {
		loopTest();
	}

	public class AssociativityNode {
		private List<AssociativityNode> associations;
		private String name;

		public AssociativityNode(String name) {
			this.name = name;
			associations = new ArrayList<>();
		}

		public void addAssociation(String name) {
			if (!containsName(name)) {
				AssociativityNode association = new AssociativityNode(name);
				associations.add(association);
			}
		}

		private boolean containsName(String name) {
			for (AssociativityNode association : associations) {
				if (association.getName().equals(name)) {
					return true;
				}
			}
			return false;
		}

		private int getAssociationCount() {
			return associations.size();
		}

		private List<String> getAssociationList(List<String> returnList) {
			if (returnList.contains(this.name)) {
				return returnList;
			}
			returnList.add(this.name);
			for (AssociativityNode association : associations) {
				for (String element : association.getAssociationList(returnList)) {
					if (!returnList.contains(element)) {
						returnList.add(element);
					}
				}
			}
			return returnList;
		}

		private AssociativityNode getAssociations(int index) {
			return associations.get(index);
		}

		public List<String> getAssociativity() {
			List<String> returnList = new ArrayList<>();
			return getAssociationList(returnList);
		}

		public String getName() {
			return this.name;
		}

		private void replaceAssociation(AssociativityNode associationNode) {
			for (int i = 0; i < associations.size(); i++) {
				if (associations.get(i).getName().equals(associationNode.getName())) {
					associations.set(i, associationNode);
					break;
				}
			}
		}

		public String toString() {
			return getAssociativity().toString();
		}
	}

}
