package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_03_Jukebox;

import java.util.Set;

@SuppressWarnings({"unused", "SpellCheckingInspection", "FieldCanBeLocal"})
public class JukeBox {
    private final Set<CD> cdCollection;
    private final CDPlayer cdPlayer;
    private final SongSelector ts;
    private User user;

    public JukeBox(CDPlayer cdPlayer, User user, Set<CD> cdCollection, SongSelector ts) {
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
