package Code.Java.Interview.Amazon.Interview.Question2;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private final Map<Character, TrieNode> children;
    private char data;
    private boolean isEnd;

    public static void getDescription() {
        System.out.println("""
                A generic TrieNode.""".indent(2));
    }

    public TrieNode(char data) {
        this();
        this.data = data;
    }

    public TrieNode() {
        this.children = new HashMap<>();
    }

    public char getChar() {
        return this.data;
    }

    public void setEnd() {
        this.isEnd = true;
    }

    public boolean isEnd() {
        return this.isEnd;
    }

    public boolean containsChild(char child) {
        return this.children.containsKey(child);
    }

    public void addChild(char child) {
        TrieNode newChild = new TrieNode(child);
        this.children.put(child, newChild);
    }

    public TrieNode getChild(char child) {
        return this.children.get(child);
    }
}
