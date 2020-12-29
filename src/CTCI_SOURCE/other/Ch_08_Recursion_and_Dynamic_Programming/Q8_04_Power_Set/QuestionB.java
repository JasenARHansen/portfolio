package CTCI_SOURCE.other.Ch_08_Recursion_and_Dynamic_Programming.Q8_04_Power_Set;

import java.util.ArrayList;

public class QuestionB {

    public static ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
        ArrayList<Integer> subset = new ArrayList<>();
        int index = 0;
        for (int k = x; k > 0; k >>= 1) {
            if ((k & 1) == 1) {
                subset.add(set.get(index));
            }
            index++;
        }
        return subset;
    }

    public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<>();
        int max = 1 << set.size(); /* Compute 2^n */
        for (int k = 0; k < max; k++) {
            ArrayList<Integer> subset = convertIntToSet(k, set);
            allsubsets.add(subset);
        }
        return allsubsets;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }

        ArrayList<ArrayList<Integer>> subsets2 = getSubsets(list);
        System.out.println(subsets2.toString());
    }

}
