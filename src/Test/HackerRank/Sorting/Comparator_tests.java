package Test.HackerRank.Sorting;

import HackerRank.Sorting.Player;
import HackerRank.Sorting.PlayerComparator;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Comparator_tests {

  @Rule
  public TestName name = new TestName();

  @Test
  public void maximumToys_1() {
    Player[] expected = {new Player("Jones", 20), new Player("Smith", 20), new Player("Jones", 15)};
    Player[] player = {new Player("Smith", 20), new Player("Jones", 15), new Player("Jones", 20)};

    PlayerComparator checker = new PlayerComparator();
    Arrays.sort(player, checker);
    for (int index = 0; index < player.length; index++) {
      System.out.format(
              "%s: After sorting, player %d is %s with a score of  %d.\n",
              name.getMethodName(), index, player[index].name, expected[index].score);
      assertEquals(expected[index].name, player[index].name);
      assertEquals(expected[index].score, player[index].score);
    }
  }

  @SuppressWarnings("SpellCheckingInspection")
  @Test
  public void maximumToys_2() {
    Player[] expected = {
            new Player("aleksa", 150),
            new Player("amy", 100),
            new Player("david", 100),
            new Player("aakansha", 75),
            new Player("heraldo", 50)
    };
    Player[] player = {
            new Player("amy", 100),
            new Player("david", 100),
            new Player("heraldo", 50),
            new Player("aakansha", 75),
            new Player("aleksa", 150)
    };

    PlayerComparator checker = new PlayerComparator();
    Arrays.sort(player, checker);
    for (int index = 0; index < player.length; index++) {

      System.out.format(
              "%s: After sorting, player %d is %s with a score of  %d.\n",
              name.getMethodName(), index, player[index].name, expected[index].score);
      assertEquals(expected[index].name, player[index].name);
      assertEquals(expected[index].score, player[index].score);
    }
  }

  @SuppressWarnings("SpellCheckingInspection")
  @Test
  public void maximumToys_3() {
    Player[] expected = {
            new Player("davis", 20),
            new Player("davis", 15),
            new Player("edgehill", 15),
            new Player("davis", 10)
    };
    Player[] player = {
            new Player("davis", 15),
            new Player("davis", 20),
            new Player("davis", 10),
            new Player("edgehill", 15)
    };

    PlayerComparator checker = new PlayerComparator();
    Arrays.sort(player, checker);
    for (int index = 0; index < player.length; index++) {

      System.out.format(
              "%s: After sorting, player %d is %s with a score of  %d.\n",
              name.getMethodName(), index, player[index].name, expected[index].score);
      assertEquals(expected[index].name, player[index].name);
      assertEquals(expected[index].score, player[index].score);
    }
  }
}
