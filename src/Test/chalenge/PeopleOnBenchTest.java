package Test.chalenge;

import Code.chalenge.PeopleOnBench;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PeopleOnBenchTest {

    @Rule
    public TestName name = new TestName();

    @Test
    public void personSits_0() {
        PeopleOnBench.buildBench(5);
        PeopleOnBench.personSits();
        PeopleOnBench.personSits();
        PeopleOnBench.personSits();
        PeopleOnBench.personSits();
        PeopleOnBench.personSits();
        PeopleOnBench.personSits();
        PeopleOnBench.personSits();
        PeopleOnBench.personSits();
        PeopleOnBench.personSits();
        PeopleOnBench.personSits();
        PeopleOnBench.personSits();
        PeopleOnBench.personSits();
        //System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
        //assertEquals(expected, result);
    }

}
