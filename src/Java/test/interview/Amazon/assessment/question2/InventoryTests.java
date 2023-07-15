package Java.test.interview.Amazon.assessment.question2;

import Java.code.interview.Amazon.assessment.question2.Inventory;
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
public class InventoryTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        Inventory.getDescription();
    }

    @Test
    public void numberOfItems_1() {
        printTestHeader(name.getMethodName());
        String input = "|**|*|*";
        List<Integer> expected = new ArrayList<>(Arrays.asList(0, 0));
        List<Integer> start_original = new ArrayList<>(Arrays.asList(1, 1));
        List<Integer> start = new ArrayList<>(start_original);
        List<Integer> stop_original = new ArrayList<>(Arrays.asList(1, 3));
        List<Integer> stop = new ArrayList<>(stop_original);
        List<Integer> result = Inventory.numberOfItems(input, start, stop);
        System.out.format("\tThe full range '%s':\n", input);
        int index = 0;
        while ((index < start_original.size()) && (index < stop_original.size())) {
            int start_index = start_original.get(index);
            int stop_index = stop_original.get(index);
            int count = result.get(index);
            index++;
            System.out.format(
                    "\tThe range '%s' defined with start index %d and stop index %d, '%s' contains %d items in closed"
                            + " containers:\n",

                    input,
                    start_index,
                    stop_index,
                    input.substring(start_index - 1, stop_index),
                    count);
        }
        assertEquals(expected, result);
    }

    @Test
    public void numberOfItems_2() {
        printTestHeader(name.getMethodName());
        String input = "|**|*|*";
        List<Integer> expected = new ArrayList<>(Arrays.asList(0, 2));
        List<Integer> start_original = new ArrayList<>(Arrays.asList(1, 1));
        List<Integer> start = new ArrayList<>(start_original);
        List<Integer> stop_original = new ArrayList<>(Arrays.asList(1, 4));
        List<Integer> stop = new ArrayList<>(stop_original);
        List<Integer> result = Inventory.numberOfItems(input, start, stop);
        System.out.format("\tThe full range '%s':\n", input);
        int index = 0;
        while ((index < start_original.size()) && (index < stop_original.size())) {
            int start_index = start_original.get(index);
            int stop_index = stop_original.get(index);
            int count = result.get(index);
            index++;
            System.out.format(
                    "\tThe range '%s' defined with start index %d and stop index %d, '%s' contains %d items in closed"
                            + " containers:\n",

                    input,
                    start_index,
                    stop_index,
                    input.substring(start_index - 1, stop_index),
                    count);
        }
        assertEquals(expected, result);
    }

    @Test
    public void numberOfItems_3() {
        printTestHeader(name.getMethodName());
        String input = "|**|*|*";
        List<Integer> expected = new ArrayList<>(Arrays.asList(0, 3));
        List<Integer> start_original = new ArrayList<>(Arrays.asList(1, 1));
        List<Integer> start = new ArrayList<>(start_original);
        List<Integer> stop_original = new ArrayList<>(Arrays.asList(1, 6));
        List<Integer> stop = new ArrayList<>(stop_original);
        List<Integer> result = Inventory.numberOfItems(input, start, stop);
        System.out.format("\tThe full range '%s':\n", input);
        int index = 0;
        while ((index < start_original.size()) && (index < stop_original.size())) {
            int start_index = start_original.get(index);
            int stop_index = stop_original.get(index);
            int count = result.get(index);
            index++;
            System.out.format(
                    "\tThe range '%s' defined with start index %d and stop index %d, '%s' contains %d items in closed"
                            + " containers:\n",

                    input,
                    start_index,
                    stop_index,
                    input.substring(start_index - 1, stop_index),
                    count);
        }
        assertEquals(expected, result);
    }

    @Test
    public void numberOfItems_4() {
        printTestHeader(name.getMethodName());
        String input = "|**|*|*";
        List<Integer> expected = new ArrayList<>(Arrays.asList(0, 1));
        List<Integer> start_original = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> start = new ArrayList<>(start_original);
        List<Integer> stop_original = new ArrayList<>(Arrays.asList(1, 7));
        List<Integer> stop = new ArrayList<>(stop_original);
        List<Integer> result = Inventory.numberOfItems(input, start, stop);
        System.out.format("\tThe full range '%s':\n", input);
        int index = 0;
        while ((index < start_original.size()) && (index < stop_original.size())) {
            int start_index = start_original.get(index);
            int stop_index = stop_original.get(index);
            int count = result.get(index);
            index++;
            System.out.format(
                    "\tThe range '%s' defined with start index %d and stop index %d, '%s' contains %d items in closed"
                            + " containers:\n",

                    input,
                    start_index,
                    stop_index,
                    input.substring(start_index - 1, stop_index),
                    count);
        }
        assertEquals(expected, result);
    }

    @Test
    public void numberOfItems_5() {
        printTestHeader(name.getMethodName());
        String input = "*|*|";
        List<Integer> expected = new ArrayList<>(Arrays.asList(0, 0));
        List<Integer> start_original = new ArrayList<>(Arrays.asList(1, 1));
        List<Integer> start = new ArrayList<>(start_original);
        List<Integer> stop_original = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> stop = new ArrayList<>(stop_original);
        List<Integer> result = Inventory.numberOfItems(input, start, stop);
        System.out.format("\tThe full range '%s':\n", input);
        int index = 0;
        while ((index < start_original.size()) && (index < stop_original.size())) {
            int start_index = start_original.get(index);
            int stop_index = stop_original.get(index);
            int count = result.get(index);
            index++;
            System.out.format(
                    "\tThe range '%s' defined with start index %d and stop index %d, '%s' contains %d items in closed"
                            + " containers:\n",

                    input,
                    start_index,
                    stop_index,
                    input.substring(start_index - 1, stop_index),
                    count);
        }
        assertEquals(expected, result);
    }

    @Test
    public void numberOfItems_6() {
        printTestHeader(name.getMethodName());
        String input = "*|*|";
        List<Integer> expected = new ArrayList<>(Arrays.asList(0, 1));
        List<Integer> start_original = new ArrayList<>(Arrays.asList(1, 1));
        List<Integer> start = new ArrayList<>(start_original);
        List<Integer> stop_original = new ArrayList<>(Arrays.asList(1, 4));
        List<Integer> stop = new ArrayList<>(stop_original);
        List<Integer> result = Inventory.numberOfItems(input, start, stop);
        System.out.format("\tThe full range '%s':\n", input);
        int index = 0;
        while ((index < start_original.size()) && (index < stop_original.size())) {
            int start_index = start_original.get(index);
            int stop_index = stop_original.get(index);
            int count = result.get(index);
            index++;
            System.out.format(
                    "\tThe range '%s' defined with start index %d and stop index %d, '%s' contains %d items in closed"
                            + " containers:\n",

                    input,
                    start_index,
                    stop_index,
                    input.substring(start_index - 1, stop_index),
                    count);
        }
        assertEquals(expected, result);
    }

    @Test
    public void numberOfItems_7() {
        printTestHeader(name.getMethodName());
        String input = "||||||||||||||||";
        List<Integer> expected = new ArrayList<>(Arrays.asList(0, 0));
        List<Integer> start_original = new ArrayList<>(Arrays.asList(1, 1));
        List<Integer> start = new ArrayList<>(start_original);
        List<Integer> stop_original = new ArrayList<>(Arrays.asList(1, 8));
        List<Integer> stop = new ArrayList<>(stop_original);
        List<Integer> result = Inventory.numberOfItems(input, start, stop);
        System.out.format("\tThe full range '%s':\n", input);
        int index = 0;
        while ((index < start_original.size()) && (index < stop_original.size())) {
            int start_index = start_original.get(index);
            int stop_index = stop_original.get(index);
            int count = result.get(index);
            index++;
            System.out.format(
                    "\tThe range '%s' defined with start index %d and stop index %d, '%s' contains %d items in closed"
                            + " containers:\n",

                    input,
                    start_index,
                    stop_index,
                    input.substring(start_index - 1, stop_index),
                    count);
        }
        assertEquals(expected, result);
    }

    @Test
    public void numberOfItems_8() {
        printTestHeader(name.getMethodName());
        String input = "***********";
        List<Integer> expected = new ArrayList<>(Arrays.asList(0, 0));
        List<Integer> start_original = new ArrayList<>(Arrays.asList(1, 1));
        List<Integer> start = new ArrayList<>(start_original);
        List<Integer> stop_original = new ArrayList<>(Arrays.asList(1, 8));
        List<Integer> stop = new ArrayList<>(stop_original);
        List<Integer> result = Inventory.numberOfItems(input, start, stop);
        System.out.format("\tThe full range '%s':\n", input);
        int index = 0;
        while ((index < start_original.size()) && (index < stop_original.size())) {
            int start_index = start_original.get(index);
            int stop_index = stop_original.get(index);
            int count = result.get(index);
            index++;
            System.out.format(
                    "\tThe range '%s' defined with start index %d and stop index %d, '%s' contains %d items in closed"
                            + " containers:\n",

                    input,
                    start_index,
                    stop_index,
                    input.substring(start_index - 1, stop_index),
                    count);
        }
        assertEquals(expected, result);
    }

    @Test
    public void numberOfItems_9() {
        printTestHeader(name.getMethodName());
        String input = "|**|**|*||*|*||***";
        List<Integer> expected = new ArrayList<>(Arrays.asList(0, 4, 0, 2, 1));
        List<Integer> start_original = new ArrayList<>(Arrays.asList(1, 1, 2, 4, 7));
        List<Integer> start = new ArrayList<>(start_original);
        List<Integer> stop_original = new ArrayList<>(Arrays.asList(1, 8, 5, 7, 9));
        List<Integer> stop = new ArrayList<>(stop_original);
        List<Integer> result = Inventory.numberOfItems(input, start, stop);
        System.out.format("\tThe full range '%s':\n", input);
        int index = 0;
        while ((index < start_original.size()) && (index < stop_original.size())) {
            int start_index = start_original.get(index);
            int stop_index = stop_original.get(index);
            int count = result.get(index);
            index++;
            System.out.format(
                    "\tThe range '%s' defined with start index %d and stop index %d, '%s' contains %d items in closed"
                            + " containers:\n",

                    input,
                    start_index,
                    stop_index,
                    input.substring(start_index - 1, stop_index),
                    count);
        }
        assertEquals(expected, result);
    }
}
