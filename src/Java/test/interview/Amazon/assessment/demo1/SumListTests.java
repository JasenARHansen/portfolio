package Java.test.interview.Amazon.assessment.demo1;

import Java.code.interview.Amazon.assessment.demo1.SumList;
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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SumListTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        SumList.getDescription();
    }

    @Test
    public void sumList() {
        int expected = 15;
        printTestHeader(name.getMethodName());
        List<Integer> values = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int result = SumList.sumList(values);
        System.out.format("\tThe sum of the list '%s' is: %d\n", values, result);
        assertEquals(expected, result);
    }
}
