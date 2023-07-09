package Java.Code.CTCI.CTCI_SOURCE.Ch_07_Object_Oriented_Design.Q7_03_Jukebox;

@SuppressWarnings("unused")
public class CDPlayer {
  private Playlist p;
  private CD c;

  public CDPlayer(Playlist p) {
    this.p = p;
  }

  public CDPlayer(CD c, Playlist p) {
    this.p = p;
    this.c = c;
  }

  public CDPlayer(CD c) {
    this.c = c;
  }

  public Playlist getPlaylist() {
    return p;
  }

  public void setPlaylist(Playlist p) {
    this.p = p;
  }

  public CD getCD() {
    return c;
  }

  public void setCD(CD c) {
    this.c = c;
  }

  public void playSong(Song s) {}
}
