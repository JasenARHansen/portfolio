package Java.test.interview.Amazon.assessment.demo2;

import Java.code.interview.Amazon.assessment.demo2.FizzBuzz;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FizzBuzzTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void fizzBuzz_1() {
        printTestHeader(name.getMethodName());
        int count = 21;
        System.out.format("\tFizzBuzz with '%d' as the input:\n", count);
        FizzBuzz.fizzBuzz(count);
    }

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        FizzBuzz.getDescription();
    }
}
