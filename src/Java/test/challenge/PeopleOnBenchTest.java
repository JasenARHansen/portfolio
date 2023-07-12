package Java.test.challenge;

import static org.junit.Assert.*;

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
  public void buildBench() {
    String expected = "Seats:5, People:null";
    int seats = 5;
    PeopleOnBench.buildBench(seats);
    String result = String.format("%s", PeopleOnBench.getBench());
    assertNotNull(result);
    assertEquals(expected, result);
    System.out.format("%s: %s\n", name.getMethodName(), result);
  }

  @Test
  public void getBench() {
    String expected = "Seats:3, People:null";
    int seats = 3;
    PeopleOnBench.buildBench(seats);
    String result = String.format("%s", PeopleOnBench.getBench());
    assertNotNull(result);
    assertEquals(expected, result);
    System.out.format("%s: %s\n", name.getMethodName(), result);
  }

  @Test
  public void personSits() {
    String expected = "Seats:5, People:[5, 1, 3, 2, 4]";
    System.out.format("%s:\n", name.getMethodName());
    int seats = 5;
    PeopleOnBench.buildBench(seats);
    System.out.format("\t%s", PeopleOnBench.personSits());
    System.out.format("\t%s", PeopleOnBench.personSits());
    System.out.format("\t%s", PeopleOnBench.personSits());
    System.out.format("\t%s", PeopleOnBench.personSits());
    System.out.format("\t%s", PeopleOnBench.personSits());
    System.out.format("\t%s", PeopleOnBench.personSits());
    System.out.format("\t%s", PeopleOnBench.personSits());
    System.out.format("\t%s", PeopleOnBench.personSits());
    String result = String.format("%s", PeopleOnBench.getBench());
    assertNotNull(result);
    System.out.format("\tBench: %s\n", result);
  }
}
