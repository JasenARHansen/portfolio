package CTCI_SOURCE.Ch_07_Object_Oriented_Design.Q7_03_Jukebox;

import java.util.Queue;

public class Playlist {
    private final Song song;
    private final Queue<Song> queue;

    public Playlist(Song song, Queue<Song> queue) {
        super();
        this.song = song;
        this.queue = queue;
    }

    public Song getNextSongToPlay() {
        return queue.peek();
    }

    public void queueUpSong(Song s) {
        queue.add(s);
    }
}

