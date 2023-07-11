package Java.test.interview.Google.jan_14_2021.interview_1;

import Java.code.interview.Google.jan_14_2021.interview_1.PlayList;
import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings("DuplicatedCode")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PlayListTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void songs() throws Exception {
    List<String> songs = List.of("A", "B", "C", "D");
    int k = 2;
    System.out.format("%s: Song List: %s\n", name.getMethodName(), songs);
    System.out.format("%s: K: %d\n", name.getMethodName(), k);
    PlayList playList = new PlayList();
    playList.setup(k, songs);
    for (int i = 0; i < 6; i++) {
      System.out.format("%s: Song: %s\n", name.getMethodName(), playList.getRandom());
    }
  }

  @Test
  public void songs_0_k() throws Exception {
    List<String> songs = List.of("A", "B", "C", "D");
    int k = 0;
    System.out.format("%s: Song List: %s\n", name.getMethodName(), songs);
    System.out.format("%s: K: %d\n", name.getMethodName(), k);
    PlayList playList = new PlayList();
    playList.setup(k, songs);
    for (int i = 0; i < 6; i++) {
      System.out.format("%s: Song: %s\n", name.getMethodName(), playList.getRandom());
    }
  }

  @Test(expected = Exception.class)
  public void invalid_K_not_enough_songs() throws Exception {
    List<String> songs = List.of("A", "B", "C", "D");
    int k = 5;
    System.out.format("%s: Song List: %s\n", name.getMethodName(), songs);
    System.out.format("%s: K: %d\n", name.getMethodName(), k);
    PlayList playList = new PlayList();
    playList.setup(k, songs);
    for (int i = 0; i < 6; i++) {
      System.out.format("%s: Song: %s\n", name.getMethodName(), playList.getRandom());
    }
  }

  @Test(expected = Exception.class)
  public void invalid_K_negative() throws Exception {
    List<String> songs = List.of("A", "B", "C", "D");
    int k = -1;
    System.out.format("%s: Song List: %s\n", name.getMethodName(), songs);
    System.out.format("%s: K: %d\n", name.getMethodName(), k);
    PlayList playList = new PlayList();
    playList.setup(k, songs);
    for (int i = 0; i < 6; i++) {
      System.out.format("%s: Song: %s\n", name.getMethodName(), playList.getRandom());
    }
  }
}