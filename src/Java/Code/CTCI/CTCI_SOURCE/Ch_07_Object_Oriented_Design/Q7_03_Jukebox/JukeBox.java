package Java.Code.CTCI.CTCI_SOURCE.Ch_07_Object_Oriented_Design.Q7_03_Jukebox;

import java.util.Set;

public class JukeBox {
    private final CDPlayer cdPlayer;
    private final Set<CD> cdCollection;
    private final SongSelector ts;
    private User user;

    public JukeBox(CDPlayer cdPlayer, User user, Set<CD> cdCollection,
                   SongSelector ts) {
        super();
        this.cdPlayer = cdPlayer;
        this.user = user;
        this.cdCollection = cdCollection;
        this.ts = ts;
    }

    public Song getCurrentSong() {
        return ts.getCurrentSong();
    }

    public void setUser(User u) {
        this.user = u;
    }
}
