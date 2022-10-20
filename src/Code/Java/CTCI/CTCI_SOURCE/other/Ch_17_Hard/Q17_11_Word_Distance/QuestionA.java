package Code.Java.CTCI.CTCI_SOURCE.other.Ch_17_Hard.Q17_11_Word_Distance;

import Code.Java.CTCI.CTCI_SOURCE.other.CtCILibrary.AssortedMethods;

public class QuestionA {

    public static void main(String[] args) {
        String[] wordlist = AssortedMethods.getLongTextBlobAsStringList();
        String word1 = "river";
        String word2 = "life";
        LocationPair pair = findClosest(wordlist, word1, word2);
        System.out.println("Distance between <" + word1 + "> and <" + word2 + ">: " + pair);

    }

    public static LocationPair findClosest(String[] words, String word1, String word2) {
        LocationPair best = new LocationPair(-1, -1);
        LocationPair current = new LocationPair(-1, -1);
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                current.location1 = i;
                best.updateWithMin(current);
            } else if (word.equals(word2)) {
                current.location2 = i;
                best.updateWithMin(current);
            }
        }
        return best;
    }

}
