package Test.Interview.Amazon.Assessment.Demo2;

import Code.Interview.Amazon.Assessment.Demo2.FizzBuzz;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FizzBuzzTests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void FizzBuzz() {
        System.out.format("%s: ", name.getMethodName());
        FizzBuzz.getDescription();
    }

    @Test
    public void fizzBuzz_1() {
        int count = 21;
        System.out.format("%s: FizzBuzz with '%d' as the input:\n", name.getMethodName(), count);
        FizzBuzz.fizzBuzz(count);
    }
}
