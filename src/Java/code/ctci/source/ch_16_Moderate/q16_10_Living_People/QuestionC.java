package Java.code.ctci.source.ch_16_Moderate.q16_10_Living_People;

import java.util.Arrays;
import java.util.Random;

@SuppressWarnings({"DuplicatedCode", "unused"})
public class QuestionC {
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
        int[] births = getSortedYears(people, true);
        int[] deaths = getSortedYears(people, false);
        int birthIndex = 0;
        int deathIndex = 0;
        int currentlyAlive = 0;
        int maxAlive = 0;
        int maxAliveYear = min;
        /* Walk through arrays. */
        while (birthIndex < births.length) {
            if (births[birthIndex] <= deaths[deathIndex]) {
                currentlyAlive++; // include birth
                if (currentlyAlive > maxAlive) {
                    maxAlive = currentlyAlive;
                    maxAliveYear = births[birthIndex];
                }
                birthIndex++; // move birth index
            } else {
                currentlyAlive--; // include death
                deathIndex++; // move death index
            }
        }
        return maxAliveYear;
    }

    public static int[] getSortedYears(Person[] people, boolean copyBirthYear) {
    /* Copy birth years or death years (depending on the value of copyBirthYear)
    into integer array, then sort array. */
        int[] years = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            years[i] = copyBirthYear ? people[i].birth : people[i].death;
        }
        Arrays.sort(years);
        return years;
    }
}
