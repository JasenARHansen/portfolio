package Java.code.ctci.source.ch_16_Moderate.q16_10_Living_People;

import java.util.Random;

@SuppressWarnings("DuplicatedCode")
public class QuestionB {
    public static void main(String[] args) {

        int n = 3;
        int first = 1900;
        int last = 2000;
        Random random = new Random();
        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            int birth = first + random.nextInt(last - first);
            int death = birth + random.nextInt(last - birth);
            people[i] = new Person(birth, death);
            System.out.println(birth + ", " + death);
        }
        int year = maxAliveYear(people, first, last);
        System.out.println(year);
    }

    public static int maxAliveYear(Person[] people, int min, int max) {
        int[] years = createYearMap(people, min, max);
        int best = getMaxIndex(years);
        return best + min;
    }

    public static int[] createYearMap(Person[] people, int min, int max) {
        /* Add each person's years to a year map. */
        int[] years = new int[max - min + 1];
        for (Person person : people) {
            int left = person.birth - min;
            int right = person.death - min;
            incrementRange(years, left, right);
        }
        return years;
    }

    public static int getMaxIndex(int[] values) {
        /* Get index of largest element in array. */
        int max = 0;
        for (int i = 1; i < values.length; i++) {
            if (values[i] > values[max]) {
                max = i;
            }
        }
        return max;
    }

    public static void incrementRange(int[] values, int left, int right) {
        /* Increment array for each value between left and right. */
        for (int i = left; i <= right; i++) {
            values[i]++;
        }
    }
}
