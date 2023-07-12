package Java.test.challenge;

import Java.code.challenge.PeopleOnBench;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PeopleOnBenchTest {
  @Rule public final TestName name = new TestName();

  @Test
  public void getDescription() {
    System.out.format("%s: ", name.getMethodName());
    PeopleOnBench.getDescription();
  }

  @Test
  public void personSits_0() {
    int seats = 5;
    System.out.format("%s: A Bench with %d seats\n", name.getMethodName(), seats);
    PeopleOnBench.buildBench(seats);
    System.out.format("\t%s", PeopleOnBench.personSits());
    System.out.format("\t%s", PeopleOnBench.personSits());
    System.out.format("\t%s", PeopleOnBench.personSits());
    System.out.format("\t%s", PeopleOnBench.personSits());
    System.out.format("\t%s", PeopleOnBench.personSits());
    System.out.format("\t%s", PeopleOnBench.personSits());
    System.out.format("\t%s", PeopleOnBench.personSits());
    System.out.format("\t%s", PeopleOnBench.personSits());
  }
}
