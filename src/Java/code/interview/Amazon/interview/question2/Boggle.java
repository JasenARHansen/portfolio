package Java.code.interview.Amazon.interview.question2;

import java.util.Set;
import java.util.TreeSet;

public class Boggle {
    static Character[][] board;
    static boolean[][] used;
    static Set<String> wordlist;

    private static void findWords(int y, int x, TrieNode node, String entry) {
        // Case 1: Are my coordinates valid?
        // coordinates out of bounds
        if ((y < 0) || (x < 0) || (y >= board.length) || (x >= board[0].length) || used[y][x]) {
            return;
        }
        // Case 2: Do I already have a word?
        // TrieNode end indicates that there is a word end found
        if (node.isEnd() && !entry.isEmpty()) {
            wordlist.add(entry);
        }
        // Case 3: Is the current node on the path to a word?
        Character letter = board[y][x];
        if (node.containsChild(letter)) {
            used[y][x] = true;
            // 4 possible adjacent indexes
            findWords(y, x - 1, node.getChild(letter), entry + letter);
            findWords(y, x + 1, node.getChild(letter), entry + letter);
            findWords(y - 1, x, node.getChild(letter), entry + letter);
            findWords(y + 1, x, node.getChild(letter), entry + letter);
            used[y][x] = false;
        }
    }

    public static void getDescription() {
        System.out.println(
                """
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
                        Question 2: Can I use a Trie:  Answer is yes"""
                        .indent(2));
    }

    public static Set<String> getWords(Trie dictionary, Character[][] game_board) {
        wordlist = new TreeSet<>();
        board = game_board;
        used = new boolean[board.length][board[0].length];
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                findWords(y, x, dictionary.root, "");
            }
        }
        return wordlist;
    }
}
