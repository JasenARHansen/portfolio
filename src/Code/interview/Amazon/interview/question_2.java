package Code.interview.Amazon.interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class boggle {

  /*
  Given an NxN board of letters, find all words according to the rules of boggle.
  1) Words can start at any location and connect up, down, left, or right (no diagonals).
  2) A given location on the board can be used only once per word
  3) Words must be valid english words

  e.g.,
  given :
    a b c
    d o g
    e l g

  return:
      bog, boggle, boggled, dog, god, lob, bad, dab, bode, abode, ...
  example *invalid* words:
       bob (uses the 'b' at row 1, column 2 twice)

  Question 1: What about duplicates?  If 'bob' was valid, would it be displayed 2 times?  No duplicates
  Question 2: Can I use a Trie:  Answer is yes
  */

    public static Set getWords(Trie dictionary, Character[][] board) {
        Set wordlist = new HashSet<>();
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                boolean[][] used = new boolean[board.length][board[0].length];
                wordlist.addAll(findWords(y, x, board, used, dictionary.root, ""));
            }
        }
        return wordlist;
    }

    private static Set findWords(
            int y,
            int newY,
            int x,
            int newX,
            Character[][] board,
            boolean[][] used,
            TrieNode node,
            String entry) {
        Set wordlist = new HashSet<>();
        if ((0 <= newY)
                && (newY < board.length)
                && (0 <= newX)
                && (newX < board[0].length)
                && (!used[newY][newX])) {
            Character letter = board[newY][newX];
            if (node.containsChild(letter)) {
                wordlist.addAll(findWords(newY, newX, board, used, node.getChild(letter), entry + letter));
                used[y][x] = false;
            }
        }
        return wordlist;
    }

    private static Set findWords(
            int y, int x, Character[][] board, boolean[][] used, TrieNode node, String entry) {
        used[y][x] = true;

        Set wordlist = new HashSet<>();
        // Case 1: Do I already have a word?
        // TreiNode end indicates that there is a word end found
        if (node.isEnd()) {
            wordlist.add(entry);
        }
        // 4 possible adjacent indexes
        // up
        int newY = y - 1;
        int newX = x;
        wordlist.addAll(findWords(y, newY, x, newX, board, used, node, entry));

        // down
        newY = y + 1;
        newX = x;
        wordlist.addAll(findWords(y, newY, x, newX, board, used, node, entry));

        // left
        newY = y;
        newX = x - 1;
        wordlist.addAll(findWords(y, newY, x, newX, board, used, node, entry));

        // right
        newY = y;
        newX = x + 1;
        wordlist.addAll(findWords(y, newY, x, newX, board, used, node, entry));
        return wordlist;
    }
}

class Trie {
    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode working = this.root;
        for (int index = 0; index < word.length(); index++) {
            if (!working.containsChild(word.charAt(index))) {
                working.addChild(word.charAt(index));
            }
            working = working.getChild(word.charAt(index));
        }
        working.setEnd();
    }
}

class TrieNode {
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
