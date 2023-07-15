package Java.test.challenge;

import Java.code.challenge.PeopleOnBench;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PeopleOnBenchTest {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void buildBench() {
        String expected = "Seats:5, People:null";
        printTestHeader(name.getMethodName());
        int seats = 5;
        PeopleOnBench.buildBench(seats);
        String result = String.format("%s", PeopleOnBench.getBench());
        assertNotNull(result);
        assertEquals(expected, result);
        System.out.format("\t%s\n", result);
    }

    @Test
    public void getBench() {
        String expected = "Seats:3, People:null";
        printTestHeader(name.getMethodName());
        int seats = 3;
        PeopleOnBench.buildBench(seats);
        String result = String.format("%s", PeopleOnBench.getBench());
        assertNotNull(result);
        assertEquals(expected, result);
        System.out.format("\t%s\n", result);
    }

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        PeopleOnBench.getDescription();
    }

    @Test
    public void personSits() {
        printTestHeader(name.getMethodName());
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
