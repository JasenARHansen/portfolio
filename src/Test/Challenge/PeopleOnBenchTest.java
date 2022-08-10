package Test.Challenge;

import Code.Challenge.PeopleOnBench;
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
        PeopleOnBench.getDescription();
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
    }
}
