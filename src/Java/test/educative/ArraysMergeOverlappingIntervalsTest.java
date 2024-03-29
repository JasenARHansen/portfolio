package Java.test.educative;

import Java.code.educative.ArraysMergeOverlappingIntervals;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("DuplicatedCode")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArraysMergeOverlappingIntervalsTest {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        ArraysMergeOverlappingIntervals.getDescription();
    }

    @Test
    public void mergeIntervals_1() {
        List<int[]> expected = new ArrayList<>();
        expected.add(new int[]{1, 8});
        printTestHeader(name.getMethodName());
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 5});
        list.add(new int[]{3, 7});
        list.add(new int[]{4, 6});
        list.add(new int[]{6, 8});
        List<int[]> result = ArraysMergeOverlappingIntervals.mergeIntervalsList(list);
        for (int index = 0; index < result.size(); index++) {
            System.out.format(
                    "\t%d: The merged element is '%s'.\n", index + 1, Arrays.toString(result.get(index)));
            assertEquals(Arrays.toString(expected.get(index)), Arrays.toString(result.get(index)));
        }
    }

    @Test
    public void mergeIntervals_2() {
        List<int[]> expected = new ArrayList<>();
        expected.add(new int[]{10, 15});
        printTestHeader(name.getMethodName());
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{10, 12});
        list.add(new int[]{12, 15});
        List<int[]> result = ArraysMergeOverlappingIntervals.mergeIntervalsList(list);
        for (int index = 0; index < result.size(); index++) {
            System.out.format(
                    "\t%d: The merged element is '%s'.\n", index + 1, Arrays.toString(result.get(index)));
            assertEquals(Arrays.toString(expected.get(index)), Arrays.toString(result.get(index)));
        }
    }

    @Test
    public void mergeIntervals_3() {
        List<int[]> expected = new ArrayList<>();
        expected.add(new int[]{1, 5});
        expected.add(new int[]{6, 8});
        expected.add(new int[]{10, 11});
        printTestHeader(name.getMethodName());
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 5});
        list.add(new int[]{6, 7});
        list.add(new int[]{7, 8});
        list.add(new int[]{10, 11});
        List<int[]> result = ArraysMergeOverlappingIntervals.mergeIntervalsList(list);
        for (int index = 0; index < result.size(); index++) {
            System.out.format(
                    "\t%d: The merged element is '%s'.\n", index + 1, Arrays.toString(result.get(index)));
            assertEquals(Arrays.toString(expected.get(index)), Arrays.toString(result.get(index)));
        }
    }

    @Test
    public void mergeIntervals_4() {
        int[][] expected = new int[1][2];
        expected[0] = new int[]{1, 8};
        printTestHeader(name.getMethodName());
        int[][] list = new int[4][2];
        list[0] = new int[]{1, 5};
        list[1] = new int[]{3, 7};
        list[2] = new int[]{4, 6};
        list[3] = new int[]{6, 8};
        int[][] result = ArraysMergeOverlappingIntervals.mergeIntervalsArray(list);
        assertEquals(expected.length, result.length);
        for (int index = 0; index < result.length; index++) {
            System.out.format(
                    "\t%d: The merged element is '%s'.\n", index + 1, Arrays.toString(result[index]));
            assertEquals(Arrays.toString(expected[index]), Arrays.toString(result[index]));
        }
    }

    @Test
    public void mergeIntervals_5() {
        int[][] expected = new int[1][2];
        expected[0] = new int[]{10, 15};
        printTestHeader(name.getMethodName());
        int[][] list = new int[2][2];
        list[0] = new int[]{10, 12};
        list[1] = new int[]{12, 15};
        int[][] result = ArraysMergeOverlappingIntervals.mergeIntervalsArray(list);
        assertEquals(expected.length, result.length);
        for (int index = 0; index < result.length; index++) {
            System.out.format(
                    "\t%d: The merged element is '%s'.\n", index + 1, Arrays.toString(result[index]));
            assertEquals(Arrays.toString(expected[index]), Arrays.toString(result[index]));
        }
    }

    @Test
    public void mergeIntervals_6() {
        int[][] expected = new int[3][2];
        expected[0] = new int[]{1, 5};
        expected[1] = new int[]{6, 8};
        expected[2] = new int[]{10, 11};
        printTestHeader(name.getMethodName());
        int[][] list = new int[4][2];
        list[0] = new int[]{1, 5};
        list[1] = new int[]{6, 7};
        list[2] = new int[]{7, 8};
        list[3] = new int[]{10, 11};
        int[][] result = ArraysMergeOverlappingIntervals.mergeIntervalsArray(list);
        assertEquals(expected.length, result.length);
        for (int index = 0; index < result.length; index++) {
            System.out.format(
                    "\t%d: The merged element is '%s'.\n", index + 1, Arrays.toString(result[index]));
            assertEquals(Arrays.toString(expected[index]), Arrays.toString(result[index]));
        }
    }
}
