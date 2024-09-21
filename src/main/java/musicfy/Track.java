package musicfy;

public class Track {
    private String name;
    private String artist;
    private String lenght;

    public Track(String name, String artist, String lenght) {
        this.name = name;
        this.artist = artist;
        this.lenght = lenght;
    }

    public Track() {
        this("","new Artist()","");
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

    public String getLenght() {
        return lenght;
    }

    public void setLenght(String lenght) {
        this.lenght = lenght;
    }

    @Override
    public String toString() {
        return "Título: "+this.name+"\nArtista: "+this.artist+"\nDuração: "+this.lenght+"\n \n";
    }
}
