package CTCI_SOURCE.unprocessed.unprocessed_Ch_17_Hard.Q17_26_Sparse_Similarity;

import java.util.ArrayList;

public class Document {
    private final ArrayList<Integer> words;
    private final int docId;

    public Document(int id, ArrayList<Integer> w) {
        docId = id;
        words = w;
    }

    public ArrayList<Integer> getWords() {
        return words;
    }

    public int getId() {
        return docId;
    }

    public int size() {
        return words == null ? 0 : words.size();
    }
}
