package Java.test.interview.AtomTickets;

import Java.code.interview.Atom_Tickets.MovieNode;
import Java.code.interview.Atom_Tickets.MovieTree;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovieTreeTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void constructor() {
        System.out.format("\tMovieTree\n");
        MovieNode movie = new MovieNode("Movie Title");
        new MovieTree(movie);
    }

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        MovieTree.getDescription();
    }
}
