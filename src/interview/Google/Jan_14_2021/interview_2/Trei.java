package interview.Google.Jan_14_2021.interview_2;

/*
Given a list of letters, the assistant must return all possible words (in some language) that can be created with those letters.
        The returned words can contain all the provided letters or a subset of them.

        For example, if the user has the letters “H”, ‘C”, “A”, “T”, then the assistant should suggest the words “CHAT”, “CAT”, “HAT”, “AT”
        and “A” (valid words in the English dictionary).
*/

import java.util.List;
import java.util.Set;

public class Trei {

    TreiNode root = new TreiNode("");

    public void setup(List<String> dictionary) {
        for (String word : dictionary) {
            char[] letters = word.toLowerCase().toCharArray();
            this.insert(this.root, letters);
        }
    }

    public void insert(String word) {
        insert(this.root, word.toCharArray());
    }

    public void getPaths(List<Character> data, Set<String> words) {
        this.getPaths(this.root, data, words, "");
    }

    private void getPaths(
            TreiNode<Character> node, List<Character> data, Set<String> words, String current) {
        if (node.containsTerminator()) {
            words.add(current);
        }
        if (data.isEmpty()) {
            return;
        }
        TreiNode<Character> child = node.getChild(data.get(0));
        data.remove(0);
        if (child != null) {
            this.getPaths(child, data, words, current + child.getData());
        }
    }

    private void insert(TreiNode<Character> node, char[] letters) {
        if (letters.length == 0) {
            node.setTerminator();
            return;
        }
        node.insert(letters[0]);
        this.insert(node.getChild(letters[0]), getRemainder(0, letters));
    }

    private char[] getRemainder(int index, char[] data) {
        char[] returnArray = new char[data.length - 1];
        for (int lettersIndex = 0, newIndex = 0; lettersIndex < data.length; lettersIndex++) {
            if (index == lettersIndex) {
                continue;
            }
            returnArray[newIndex++] = data[lettersIndex];
        }
        return returnArray;
    }
}
