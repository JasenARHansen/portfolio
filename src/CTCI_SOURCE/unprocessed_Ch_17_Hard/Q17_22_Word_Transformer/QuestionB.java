package CTCI_SOURCE.unprocessed_Ch_17_Hard.Q17_22_Word_Transformer;

import CTCI.CtCILibrary.HashMapList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class QuestionB {

	/* find path to transform startWord into endWord. */
	public static LinkedList<String> transform(String start, String stop, String[] words) {
		HashMapList<String, String> wildcardToWordList = createWildcardToWordMap(words);
		HashSet<String> visited = new HashSet<>();
		return transform(visited, start, stop, wildcardToWordList);
	}

	/* Do a depth-first search from start to stop, traveling through each word that is one edit away. */
	public static LinkedList<String> transform(HashSet<String> visited, String start, String stop, HashMapList<String, String> wildcardToWordList) {
		if (start.equals(stop)) {
			LinkedList<String> path = new LinkedList<>();
			path.add(start);
			return path;
		} else if (visited.contains(start)) {
			return null;
		}

		visited.add(start);
		ArrayList<String> words = getValidLinkedWords(start, wildcardToWordList);

		for (String word : words) {
			LinkedList<String> path = transform(visited, word, stop, wildcardToWordList);
			if (path != null) {
				path.addFirst(start);
				return path;
			}
		}

		return null;
	}

	/* Insert words in dictionary into mapping from wildcard form -> word. */
	public static HashMapList<String, String> createWildcardToWordMap(String[] words) {
		HashMapList<String, String> wildcardToWords = new HashMapList<>();
		for (String word : words) {
			ArrayList<String> linked = getWildcardRoots(word);
			for (String linkedWord : linked) {
				wildcardToWords.put(linkedWord, word);
			}
		}
		return wildcardToWords;
	}

	/* Get list of wildcards associated with word. */
	public static ArrayList<String> getWildcardRoots(String w) {
		ArrayList<String> words = new ArrayList<>();
		for (int i = 0; i < w.length(); i++) {
			String word = w.substring(0, i) + "_" + w.substring(i + 1);
			words.add(word);
		}
		return words;
	}


	/* Return words that are one edit away. */
	public static ArrayList<String> getValidLinkedWords(String word, HashMapList<String, String> wildcardToWords) {
		ArrayList<String> wildcards = getWildcardRoots(word);
		ArrayList<String> linkedWords = new ArrayList<>();
		for (String wildcard : wildcards) {
			ArrayList<String> words = wildcardToWords.get(wildcard);
			for (String linkedWord : words) {
				if (!linkedWord.equals(word)) {
					linkedWords.add(linkedWord);
				}
			}
		}
		return linkedWords;
	}

	public static void main(String[] args) {
		String[] words = {"maps", "tan", "tree", "apple", "cans", "help", "aped", "pree", "pret", "apes", "flat", "trap", "fret", "trip", "trie", "frat", "fril"};
		LinkedList<String> list = transform("tree", "flat", words);

		if (list == null) {
			System.out.println("No path.");
		} else {
			System.out.println(list.toString());
		}
	}

}
