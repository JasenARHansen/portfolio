package Test.interview.Google.Jan_14_2021.interview_1;

import interview.Google.Jan_14_2021.interview_1.PlayList;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class playlist_tests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void songs() throws Exception {
        List<String> songs = List.of("A", "B", "C", "D");
        int k = 2;
        System.out.format("%s: Song List: %s\n", name.getMethodName(), songs);
        System.out.format("%s: K: %d\n", name.getMethodName(), k);
        interview.Google.Jan_14_2021.interview_1.PlayList playList = new interview.Google.Jan_14_2021.interview_1.PlayList();
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
        interview.Google.Jan_14_2021.interview_1.PlayList playList = new interview.Google.Jan_14_2021.interview_1.PlayList();
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
        interview.Google.Jan_14_2021.interview_1.PlayList playList = new interview.Google.Jan_14_2021.interview_1.PlayList();
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
        interview.Google.Jan_14_2021.interview_1.PlayList playList = new PlayList();
        playList.setup(k, songs);
        for (int i = 0; i < 6; i++) {
            System.out.format("%s: Song: %s\n", name.getMethodName(), playList.getRandom());
        }
    }
}
