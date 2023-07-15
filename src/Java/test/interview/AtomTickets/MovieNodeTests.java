package Java.test.interview.AtomTickets;

import Java.code.interview.Atom_Tickets.MovieNode;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertNotNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovieNodeTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void MovieNode() {
        printTestHeader(name.getMethodName());
        MovieNode result = new MovieNode("Movie Title");
        assertNotNull(result);
        System.out.format("\t%s\n", result);
    }

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        MovieNode.getDescription();
    }
}
