package Java.code.ctci.source.ch_17_Hard.q17_26_Sparse_Similarity;

import java.util.ArrayList;

public class Document {
    private final int docId;
    private final ArrayList<Integer> words;

    public Document(int id, ArrayList<Integer> w) {
        docId = id;
        words = w;
    }

    public int getId() {
        return docId;
    }

    public ArrayList<Integer> getWords() {
        return words;
    }

    public int size() {
        return words == null ? 0 : words.size();
    }
}
