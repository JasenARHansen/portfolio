package Java.Code.Interview.Amazon.Interview.Question2;

public class Trie {
  public TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public static void getDescription() {
    System.out.println("""
                A generic Trie.""".indent(2));
  }

  public void insert(String... words) {
    // Inserts a word into the trie.
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
