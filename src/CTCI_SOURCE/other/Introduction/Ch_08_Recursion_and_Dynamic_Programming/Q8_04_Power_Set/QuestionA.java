package CTCI_SOURCE.other.Introduction.Ch_08_Recursion_and_Dynamic_Programming.Q8_04_Power_Set;

import java.util.ArrayList;

public class QuestionA {

    public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allSubsets;
        if (set.size() == index) { // Base case - add empty set
            allSubsets = new ArrayList<>();
            allSubsets.add(new ArrayList<>());
        } else {
            allSubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<>();
            for (ArrayList<Integer> subset : allSubsets) {
                ArrayList<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }
            allSubsets.addAll(moreSubsets);
        }
        return allSubsets;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }
        ArrayList<ArrayList<Integer>> subsets = getSubsets(list, 0);
        System.out.println(subsets.toString());
    }

}
