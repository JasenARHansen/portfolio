package CTCI_SOURCE.unprocessed_Ch_07_Object_Oriented_Design.Q7_03_Jukebox;

import CTCI_SOURCE.unprocessed_Ch_07_Object_Oriented_Design.Q7_05_Online_Book_Reader.User;

import java.util.Set;

public class JukeBox {
    private CDPlayer cdPlayer;
    private CTCI_SOURCE.unprocessed_Ch_07_Object_Oriented_Design.Q7_05_Online_Book_Reader.User user;
    private Set<CD> cdCollection;
    private SongSelector ts;

    public JukeBox(CDPlayer cdPlayer, CTCI_SOURCE.unprocessed_Ch_07_Object_Oriented_Design.Q7_05_Online_Book_Reader.User user, Set<CD> cdCollection,
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
