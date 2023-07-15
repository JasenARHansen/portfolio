package Java.code.ctci.source.ch_17_Hard.q17_17_Multi_Search;

import java.util.ArrayList;
import java.util.HashMap;

public class TrieNode {
    private final HashMap<Character, TrieNode> children;
    private final ArrayList<Integer> indexes;

    public TrieNode() {
        children = new HashMap<>();
        indexes = new ArrayList<>();
    }

    public TrieNode getChild(char c) {
        return children.get(c);
    }

    public void insertString(String s, int index) {
        if (s == null) return;
        indexes.add(index);
        if (s.length() > 0) {
            char value = s.charAt(0);
            TrieNode child;
            if (children.containsKey(value)) {
                child = children.get(value);
            } else {
                child = new TrieNode();
                children.put(value, child);
            }
            String remainder = s.substring(1);
            child.insertString(remainder, index + 1);
        } else {
            children.put('\0', null);
        }
    }

    public ArrayList<Integer> search(String s) {
        if (s == null || s.length() == 0) {
            return indexes;
        } else {
            char first = s.charAt(0);
            if (children.containsKey(first)) {
                String remainder = s.substring(1);
                return children.get(first).search(remainder);
            }
        }
        return null;
    }

    public boolean terminates() {
        return children.containsKey('\0');
    }
}
