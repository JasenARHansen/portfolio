package Test.interview.Facebook.Feb_1_2021.practice;

import interview.Facebook.Feb_1_2021.practice.YearWithMostPeopleAlive;
import interview.Facebook.Feb_1_2021.practice.YearWithMostPeopleAlive.Person;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class YearWithMostPeopleAlive_tests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void mostPeople_1() {
        int[] expected = {1803, 3};
        List<Person> people = new ArrayList<>();
        people.add(new Person(2000, 2010));
        people.add(new Person(1975, 2005));
        people.add(new Person(1975, 2003));
        people.add(new Person(1803, 1809));
        people.add(new Person(1750, 1869));
        people.add(new Person(1840, 1935));
        people.add(new Person(1803, 1921));
        people.add(new Person(1894, 1921));

        int[] result = YearWithMostPeopleAlive.mostPeople(people);
        System.out.format(
                "%s: After looking at %d records, the year %d was the first to have the maximum number of %d people\n",
                name.getMethodName(), people.size(), result[0], result[1]);
        assertEquals(Arrays.toString(expected), Arrays.toString(result));
    }

    @Test
    public void mostPeople_2() {
        int[] expected = {2010, 2};
        List<Person> people = new ArrayList<>();
        people.add(new Person(2000, 2010));
        people.add(new Person(2010, 2011));

        int[] result = YearWithMostPeopleAlive.mostPeople(people);
        System.out.format(
                "%s: After looking at %d records, the year %d was the first to have the maximum number of %d people\n",
                name.getMethodName(), people.size(), result[0], result[1]);
        assertEquals(Arrays.toString(expected), Arrays.toString(result));
    }
}
