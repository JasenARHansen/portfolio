package Java.test.interview.AtomTickets;

import Java.code.interview.Atom_Tickets.AtomTickets;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertNotNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AtomTicketsTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void addMovie_1() {
        System.out.format("\tAtomTickets\n");
        AtomTickets movies = new AtomTickets();
        movies.addMovie("La La Land");
        movies.printMovies();
    }

    @Test
    public void addMovie_2() {
        System.out.format("\tAtomTickets\n");
        AtomTickets movies = new AtomTickets();
        movies.addMovie("La La Land");
        movies.addMovie("Hidden Figures", "La La Land", "Left");
        movies.addMovie("Arrival", "Hidden Figures", "Left");
        movies.addMovie("Resident Evil", "La La Land", "Right");
        movies.addMovie("Lion", "Resident Evil", "Left");
        movies.addMovie("Split", "Resident Evil", "Right");
        movies.printMovies();
    }

    @Test
    public void addMovie_3() {
        System.out.format("\tAtomTickets\n");
        AtomTickets movies = new AtomTickets();
        movies.addMovie("La La Land");
        movies.addMovie("Arrival", "Hidden Figures", "Left");
        movies.printMovies();
    }

    @Test
    public void constructor() {
        System.out.format("\tAtomTickets\n");
        AtomTickets result = new AtomTickets();
        assertNotNull(result);
    }

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        AtomTickets.getDescription();
    }
}
