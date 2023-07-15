package Java.code.interview.Amazon.interview.question2;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private final Map<Character, TrieNode> children;
    private char data;
    private boolean isEnd;

    public TrieNode(char data) {
        this();
        this.data = data;
    }

    public TrieNode() {
        this.children = new HashMap<>();
    }

    public static void getDescription() {
        System.out.println("""
                A generic TrieNode.""".indent(2));
    }

    public void addChild(char child) {
        TrieNode newChild = new TrieNode(child);
        this.children.put(child, newChild);
    }

    public boolean containsChild(char child) {
        return this.children.containsKey(child);
    }

    public char getChar() {
        return this.data;
    }

    public TrieNode getChild(char child) {
        return this.children.get(child);
    }

    public boolean isEnd() {
        return this.isEnd;
    }

    public void setEnd() {
        this.isEnd = true;
    }
}
