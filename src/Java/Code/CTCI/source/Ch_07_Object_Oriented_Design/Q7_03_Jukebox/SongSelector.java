package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_03_Jukebox;

@SuppressWarnings("unused")
public class SongSelector {
  private Song currentSong;

  public SongSelector(Song s) {
    currentSong = s;
  }

  public void setSong(Song s) {
    currentSong = s;
  }

  public Song getCurrentSong() {
    return currentSong;
  }
}
