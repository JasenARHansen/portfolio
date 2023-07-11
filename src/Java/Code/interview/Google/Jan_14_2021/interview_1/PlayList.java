package Java.code.interview.Google.jan_14_2021.interview_1;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
  final List<String> played = new ArrayList<>();
  /*
  Given a list of available songs, make sure that a song can not be replayed until K other songs have been played.
  Otherwise, play a random available song.
  One possible sequence of songs played from a series of calls for k = 2 could be:
    from [A, B, C, D],  played B
    from [A, B, C, D],  played C
    from [A, B, C, D],  played D
    from [A, B, C, D],  played B */
  int k;
  List<String> songList;

  public static void main(String[] argv) {
    getDescription();
  }

  public static void getDescription() {
    System.out.println(
        "A tool to access a playlist ensuring that a given song has not played in the last K songs.");
  }

  public void setup(int k, List<String> songs) throws Exception {
    // error cases
    if ((songs == null) || (songs.isEmpty())) {
      throw new Exception("No songs provided");
    }
    if ((k < 0) || (k >= songs.size())) {
      throw new Exception("Invalid K provided");
    }
    this.songList = songs;
    this.k = k;
  }

  public String getRandom() {
    int index;
    while (true) {
      index = (int) ((Math.random() * this.songList.size()));
      if (!this.played.contains(this.songList.get(index))) {
        this.played.add(this.songList.get(index));
        break;
      }
    }
    if (this.played.size() > this.k) {
      this.played.remove(0);
    }
    return this.songList.get(index);
  }
}
