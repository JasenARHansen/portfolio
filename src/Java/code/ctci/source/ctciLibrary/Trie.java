package Java.code.ctci.source.ctciLibrary;

import java.util.ArrayList;

/* Implements a trie. We store the input list of words in tries so
that we can efficiently find words with a given prefix. */
public class Trie {
    /* The root of this trie. */
    private final TrieNode root;

    /* Takes a list of strings as an argument, and constructs a trie that stores these strings. */
    public Trie(ArrayList<String> list) {
        root = new TrieNode();
        for (String word : list) {
            root.addWord(word);
        }
    }

    public Trie(String[] list) {
        /* Takes a list of strings as an argument, and constructs a trie that stores these strings. */
        root = new TrieNode();
        for (String word : list) {
            root.addWord(word);
        }
    }

    public boolean contains(String prefix) {
        return contains(prefix, false);
    }

    public boolean contains(String prefix, boolean exact) {
    /* Checks whether this trie contains a string with the prefix passed
    in as argument. */
        TrieNode lastNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            lastNode = lastNode.getChild(prefix.charAt(i));
            if (lastNode == null) {
                return false;
            }
        }
        return !exact || lastNode.terminates();
    }

    public TrieNode getRoot() {
        return root;
    }
}
