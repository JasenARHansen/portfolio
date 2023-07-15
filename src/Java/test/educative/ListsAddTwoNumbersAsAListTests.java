package Java.test.educative;


import Java.code.educative.ListsAddTwoNumbersAsAList;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static Java.test.library.Library.printTestHeader;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ListsAddTwoNumbersAsAListTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void addTwoLists_1() {
        printTestHeader(name.getMethodName());
        List<String> left = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
        List<String> right = new ArrayList<>(Arrays.asList("7", "8", "9"));
        List<String> result =
                ListsAddTwoNumbersAsAList.addTwoLists_most_significant_digit_first(left, right);
        System.out.format(
                "\tThe '%s' plus '%s' is '%s'.\n", left, right, result);
    }

    @Test
    public void addTwoLists_2() {
        printTestHeader(name.getMethodName());
        List<String> left = new ArrayList<>(Arrays.asList("9", "9", "9", "9"));
        List<String> right = new ArrayList<>(Collections.singletonList("1"));
        List<String> result =
                ListsAddTwoNumbersAsAList.addTwoLists_most_significant_digit_first(left, right);
        System.out.format(
                "\tThe '%s' plus '%s' is '%s'.\n", left, right, result);
    }
}
