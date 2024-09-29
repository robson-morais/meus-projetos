package musicfy;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String nome;
    private int quant;
    private List<Track> tracks;

    public Playlist(String nome, List<Track> tracks) {
        this.nome = nome;
        this.tracks = tracks;
        this.quant = tracks.size();
    }

    public Playlist() {
        this("", new ArrayList<>());
    }

    public void searchSong(String nome){
        for (Track r: this.tracks){
            if (r.getName().equalsIgnoreCase(nome)){
                System.out.println(r.toString());
            }
        }
    }

    public String [] searchSongToString(String name){
        String [] nams = new String[this.tracks.size()];
            for (int a=0; a<this.tracks.size();a++){
                if (this.tracks.get(a).getName().equalsIgnoreCase(name)){
                    nams[a] = this.tracks.get(a).toString();
                }
        }
            return nams;
    }

    public void addSong(Track track){
        this.tracks.add(track);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuant() {
        return this.tracks.size();
    }

    public List<Track> getTracks() {
        return this.tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
    public String toString(){
        return this.nome+"[contains "+this.quant+" songs (lenght undefined)]";
    }
}
