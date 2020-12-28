package CTCI_SOURCE.Ch_10_Sorting_and_Searching.Q10_02_Group_Anagrams;

import CTCI_SOURCE.CtCILibrary.AssortedMethods;

import java.util.Arrays;

public class Question {
	public static void main(String[] args) {
		String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
		System.out.println(AssortedMethods.stringArrayToString(array));
		Arrays.sort(array, new AnagramComparator());
		System.out.println(AssortedMethods.stringArrayToString(array));
	}
}
