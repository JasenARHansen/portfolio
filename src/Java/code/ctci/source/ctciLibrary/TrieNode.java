package Java.code.ctci.source.ctciLibrary;

import java.util.HashMap;

/* One node in the trie. Most of the logic of the trie is implemented
in this class. */
public class TrieNode {
    /* The children of this node in the trie. */
    private final HashMap<Character, TrieNode> children;
    // The character stored in this node as data.
    private char character;
    private boolean terminates = false;

    public TrieNode(char character) {
    /* Constructs a trie node and stores in the node the char passed in as the argument.
    Initializes the list of child nodes of this node to an empty hash map. */
        this();
        this.character = character;
    }

    public TrieNode() {
    /* Constructs a trie node and stores this character as the node's value.
    Initializes the list of child nodes of this node to an empty hash map. */
        children = new HashMap<>();
    }

    /* Add this word to the trie, and recursively create the child
    nodes. */
    public void addWord(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }
        char firstChar = word.charAt(0);
        TrieNode child = getChild(firstChar);
        if (child == null) {
            child = new TrieNode(firstChar);
            children.put(firstChar, child);
        }
        if (word.length() > 1) {
            child.addWord(word.substring(1));
        } else {
            child.setTerminates(true);
        }
    }

    /* Returns the character data stored in this node. */
    public char getChar() {
        return character;
    }

    public TrieNode getChild(char c) {
    /* Find a child node of this node that has the char argument as its data.
    Return null if no such child node is present in the trie. */
        return children.get(c);
    }

    public void setTerminates(boolean t) {
        /* Set whether this node is the end of a complete word. */
        terminates = t;
    }

    public boolean terminates() {
        /* Returns whether this node represents the end of a complete word. */
        return terminates;
    }
}
