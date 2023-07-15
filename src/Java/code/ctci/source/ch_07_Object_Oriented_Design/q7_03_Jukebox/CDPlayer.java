package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_03_Jukebox;

@SuppressWarnings("unused")
public class CDPlayer {
    private CD c;
    private Playlist p;

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

    public CD getCD() {
        return c;
    }

    public void setCD(CD c) {
        this.c = c;
    }

    public Playlist getPlaylist() {
        return p;
    }

    public void setPlaylist(Playlist p) {
        this.p = p;
    }

    public void playSong(Song s) {
    }
}
