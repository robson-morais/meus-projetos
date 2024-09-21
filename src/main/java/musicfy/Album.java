package musicfy;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String title;
    private String artist;
    private List<Track> tracks;

    public Album(String title, String artist, List<Track> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }

    public Album() {
        this("","",new ArrayList<>());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    @Override
    public String toString() {
        return "Album{" +
                "title='" + title + '\'' +
                ", artist=" + artist +
                ", tracks=" + tracks +
                '}';
    }
}
