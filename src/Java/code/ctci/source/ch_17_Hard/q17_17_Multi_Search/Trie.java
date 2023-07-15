package Java.code.ctci.source.ch_17_Hard.q17_17_Multi_Search;

import java.util.ArrayList;

public class Trie {
    private final TrieNode root = new TrieNode();

    public TrieNode getRoot() {
        return root;
    }

    public void insertString(String str, int location) {
        root.insertString(str, location);
    }

    public ArrayList<Integer> search(String s) {
        return root.search(s);
    }
}
