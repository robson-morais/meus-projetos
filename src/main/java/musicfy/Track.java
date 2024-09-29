package musicfy;

public class Track implements Comparable<Track> {
    private String name;
    private String artist;

    public Track(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }

    public Track() {
        this("", "");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return"'"+this.name+"'"+ " by " + this.artist;
    }

    public String playback(){
        return"===========\nPlaying '"+this.name+"'\nby "+this.artist+"\n==========";
    }

    @Override
    public int compareTo(Track o) {
        return 0;
    }
}