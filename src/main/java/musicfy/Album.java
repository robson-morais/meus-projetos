package musicfy;

import java.util.ArrayList;
import java.util.List;

public class Album{
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

    public String [] showOrderTracks(){
        String [] order = new String[this.tracks.size()+1];
        order[0] = "'"+this.getTitle()+"' by "+this.artist;
        for (int t = 0; t<this.tracks.size();t++){
            order[t+1] = t+1+". "+this.tracks.get(t).getName();
        }
        return order;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    @Override
    public String toString() {
        return "Album '"+this.title+"' by "+this.artist+"\nTracks: ";
    }
}
