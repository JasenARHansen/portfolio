package Java.Test.Educative;
import static org.junit.Assert.assertEquals;

import Java.Code.Educative.BacktrackingFindAllPossibleSubsets;
import java.util.Arrays;
import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings("DuplicatedCode")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BacktrackingFindAllPossibleSubsetsTests {
  @Rule public TestName name = new TestName();
  @Test
  public void BacktrackingFindAllPossibleSubsets() {
    System.out.format("%s:", name.getMethodName());
    BacktrackingFindAllPossibleSubsets.getDescription();
  }

  @Test
  public void get_all_subsets_1() {
    int[] data = {1, 2, 3};
    List<List<Integer>> result = BacktrackingFindAllPossibleSubsets.get_all_subsets(data);
    System.out.format(
        "%s: Given the the array '%s' there are %d possible subsets.\n",
        name.getMethodName(), Arrays.toString(data), result.size());
    for (List<Integer> subset : result) {
      System.out.format("\t'%s'\n", subset.toString());
    }
    assertEquals((int) Math.pow(2, data.length), result.size());
  }

  @Test
  public void get_all_subsets_2() {
    int[] data = {1, 2, 3, 4};
    List<List<Integer>> result = BacktrackingFindAllPossibleSubsets.get_all_subsets(data);
    System.out.format(
        "%s: Given the the array '%s' there are %d possible subsets.\n",
        name.getMethodName(), Arrays.toString(data), result.size());
    for (List<Integer> subset : result) {
      System.out.format("\t'%s'\n", subset.toString());
    }
    assertEquals((int) Math.pow(2, data.length), result.size());
  }
}
