package Java.test.interview.AtomTickets;

import Java.code.interview.Atom_Tickets.MovieNode;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovieNodeTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void getDescription() {
    System.out.format("%s: ", name.getMethodName());
    MovieNode.getDescription();
  }

  @Test
  public void MovieNode() {
    System.out.format("%s: MovieNode\n", name.getMethodName());
    new MovieNode("Movie Title");
  }
}
