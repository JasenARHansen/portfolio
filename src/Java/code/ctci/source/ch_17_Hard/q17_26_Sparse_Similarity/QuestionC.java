package Java.code.ctci.source.ch_17_Hard.q17_26_Sparse_Similarity;

import Java.code.ctci.source.ctciLibrary.AssortedMethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

@SuppressWarnings("DuplicatedCode")
public class QuestionC {
    public static void main(String[] args) {
        int numDocuments = 10;
        int docSize = 5;
        HashMap<Integer, Document> documents = new HashMap<>();
        for (int i = 0; i < numDocuments; i++) {
            int[] words = AssortedMethods.randomArray(docSize, 0, 10);
            ArrayList<Integer> w = Tester.removeDuplicates(words);
            System.out.println(i + ": " + w);
            Document doc = new Document(i, w);
            documents.put(i, doc);
        }
        HashMap<DocPair, Double> similarities = computeSimilarities(documents);
        Tester.printSim(similarities);
    }

    public static HashMap<DocPair, Double> computeSimilarities(HashMap<Integer, Document> documents) {
        ArrayList<Element> elements = sortWords(documents);
        HashMap<DocPair, Double> similarities = computeIntersections(elements);
        adjustToSimilarities(documents, similarities);
        return similarities;
    }

    public static ArrayList<Element> sortWords(HashMap<Integer, Document> docs) {
        /* Throw all words into one list, sorting by the word then the document. */
        ArrayList<Element> elements = new ArrayList<>();
        for (Document doc : docs.values()) {
            ArrayList<Integer> words = doc.getWords();
            for (int word : words) {
                elements.add(new Element(word, doc.getId()));
            }
        }
        Collections.sort(elements);
        return elements;
    }

    public static HashMap<DocPair, Double> computeIntersections(ArrayList<Element> elements) {
        /* Adjust the intersection value to become the similarity. */
        HashMap<DocPair, Double> similarities = new HashMap<>();
        for (int i = 0; i < elements.size(); i++) {
            Element left = elements.get(i);
            for (int j = i + 1; j < elements.size(); j++) {
                Element right = elements.get(j);
                if (left.word != right.word) {
                    break;
                }
                increment(similarities, left.document, right.document);
            }
        }
        return similarities;
    }

    public static void adjustToSimilarities(
            /* Adjust the intersection value to become the similarity. */
            HashMap<Integer, Document> documents, HashMap<DocPair, Double> similarities) {
        for (Entry<DocPair, Double> entry : similarities.entrySet()) {
            DocPair pair = entry.getKey();
            Double intersection = entry.getValue();
            Document doc1 = documents.get(pair.doc1);
            Document doc2 = documents.get(pair.doc2);
            double union = (double) doc1.size() + doc2.size() - intersection;
            entry.setValue(intersection / union);
        }
    }

    public static void increment(HashMap<DocPair, Double> similarities, int doc1, int doc2) {
        /* Increment the intersection size of each document pair. */
        DocPair pair = new DocPair(doc1, doc2);
        if (!similarities.containsKey(pair)) {
            similarities.put(pair, 1.0);
        } else {
            similarities.put(pair, similarities.get(pair) + 1);
        }
    }

    public static class Element implements Comparable<Element> {
        public final int document;
        public final int word;

        public Element(int w, int d) {
            word = w;
            document = d;
        }

        public int compareTo(Element e) {
            if (word == e.word) {
                return document - e.document;
            }
            return word - e.word;
        }
    }
}
