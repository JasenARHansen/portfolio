package Code.Java.Interview.Amazon.Interview.Question2;

public class Trie {
    public TrieNode root;

    public static void getDescription() {
        System.out.println("""
                A generic Trie.""".indent(2));
    }

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String... words) {
        for (String word : words) {
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
}