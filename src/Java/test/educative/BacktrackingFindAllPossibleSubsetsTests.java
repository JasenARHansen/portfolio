package Java.test.educative;

import Java.code.educative.BacktrackingFindAllPossibleSubsets;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.List;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("DuplicatedCode")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BacktrackingFindAllPossibleSubsetsTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        BacktrackingFindAllPossibleSubsets.getDescription();
    }

    @Test
    public void get_all_subsets_1() {
        printTestHeader(name.getMethodName());
        int[] data = {1, 2, 3};
        List<List<Integer>> result = BacktrackingFindAllPossibleSubsets.get_all_subsets(data);
        System.out.format(
                "\tGiven the the array '%s' there are %d possible subsets.\n",
                Arrays.toString(data), result.size());
        for (List<Integer> subset : result) {
            System.out.format("\t'%s'\n", subset.toString());
        }
        assertEquals((int) Math.pow(2, data.length), result.size());
    }

    @Test
    public void get_all_subsets_2() {
        printTestHeader(name.getMethodName());
        int[] data = {1, 2, 3, 4};
        List<List<Integer>> result = BacktrackingFindAllPossibleSubsets.get_all_subsets(data);
        System.out.format(
                "\tGiven the the array '%s' there are %d possible subsets.\n",
                Arrays.toString(data), result.size());
        for (List<Integer> subset : result) {
            System.out.format("\t'%s'\n", subset.toString());
        }
        assertEquals((int) Math.pow(2, data.length), result.size());
    }
}
