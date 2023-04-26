package Test.Java.Interview.Atom_Tickets;

import Java.Code.Interview.Atom_Tickets.MovieNode;
import Java.Code.Interview.Atom_Tickets.MovieTree;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovieTreeTests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void MovieTree() {
        System.out.format("%s: ", name.getMethodName());
        MovieTree.getDescription();
    }

    @Test
    public void constructor() {
        System.out.format("%s: MovieTree\n", name.getMethodName());
        MovieNode movie = new MovieNode("Movie Title");
        new MovieTree(movie);
    }

}
