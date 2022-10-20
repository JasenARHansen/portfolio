package Test.Java.Challenge;

import Code.Java.Challenge.PeopleOnBench;
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
    public void PeopleOnBench() {
        System.out.format("%s: ", name.getMethodName());
        PeopleOnBench.getDescription();
    }

    @Test
    public void personSits_0() {
        int seats = 5;
        System.out.format("%s: A Bench with %d seats\n", name.getMethodName(), seats);
        PeopleOnBench.buildBench(seats);
        PeopleOnBench.personSits();
        PeopleOnBench.personSits();
        PeopleOnBench.personSits();
        PeopleOnBench.personSits();
        PeopleOnBench.personSits();
        PeopleOnBench.personSits();
        PeopleOnBench.personSits();
    }
}
