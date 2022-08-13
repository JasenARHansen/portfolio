package Test.Interview.Atom_Tickets;

import Code.Interview.Atom_Tickets.AtomTickets;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AtomTicketsTests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void AtomTickets() {
        System.out.format("%s: ", name.getMethodName());
        AtomTickets.getDescription();
    }

    @Test
    public void constructor() {
        System.out.format("%s: AtomTickets\n", name.getMethodName());
        new AtomTickets();
    }

    @Test
    public void addMovie_1() {
        System.out.format("%s: AtomTickets\n", name.getMethodName());
        AtomTickets movies = new AtomTickets();
        movies.addMovie("La La Land");
        movies.printMovies();
    }

    @Test
    public void addMovie_2() {
        System.out.format("%s: AtomTickets\n", name.getMethodName());
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
        System.out.format("%s: AtomTickets\n", name.getMethodName());
        AtomTickets movies = new AtomTickets();
        movies.addMovie("La La Land");
        movies.addMovie("Arrival", "Hidden Figures", "Left");
        movies.printMovies();
    }

}
