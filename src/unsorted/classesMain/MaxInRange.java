package unsorted.classesMain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MaxInRange {
    static List<Integer> values = new ArrayList<>();

    public static void main(String[] argv) {
        getDescription();
        populate();
        highestInRange(values.size(), 5);
        highestInRange(-1, values.size());
        highestInRange(-2, -3);
        highestInRange(2, 3);
        highestInRange(2, 300);
        highestInRange(200, 300);
    }

    private static void getDescription() {
        System.out.println(
                "You are given an array of million numbers and provided a range of index (say left, right). For multiple queries, each with input left and right indexes, output the maximum in that range.");
    }

    private static void highestInRange(int start, int finish) {

        boolean search = true;
        if (start >= values.size()) {
            System.out.format(
                    "The starting value '%d' can not be  greater than or equal to the data size '%d'\n",
                    start, values.size());
            search = false;
        }
        if (finish >= values.size()) {
            System.out.format(
                    "The finishing value '%d' can not be  greater than or equal to the data size '%d'\n",
                    finish, values.size());
            search = false;
        }
        if (start < 0) {
            System.out.format(
                    "The starting value '%d' is below the minimum searchable index '0'\n", start);
            search = false;
        }
        if (finish < 0) {
            System.out.format(
                    "The finishing value '%d' is below the minimum searchable index '0'\n", start);
            search = false;
        }
        if (start > finish) {
            System.out.format("The starting index '%d' is below the ending index '%d'\n", start, finish);
            search = false;
        }

        if (search) {
            int found = values.get(start);
            for (int i = start + 1; i <= finish; i++) {
                if (values.get(i) > found) {
                    found = values.get(i);
                }
            }
            System.out.format(
                    "The maximum value between index '%d' and index '%d' is '%d'\n", start, finish, found);
        }
    }

    private static void populate() {
        Random generator = new Random();
        for (int i = 0; i < 1000000; i++) {
            addValue(generator.nextInt(1000000));
        }
    }

    private static void addValue(int input) {
        values.add(input);
    }
}
