package CTCI_SOURCE.unprocessed.unprocessed_Ch_17_Hard.Q17_17_Multi_Search;

import java.util.ArrayList;

public class Trie {
    private final TrieNode root = new TrieNode();

    public ArrayList<Integer> search(String s) {
        return root.search(s);
    }

    public void insertString(String str, int location) {
        root.insertString(str, location);
    }

    public TrieNode getRoot() {
        return root;
    }
}
