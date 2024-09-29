package musicfy;

import java.util.ArrayList;
import java.util.List;

public class Artist {
    private String nome;
    private List<Album> albums;

    public Artist(String nome, List<Album> albums) {
        this.nome = nome;
        this.albums = albums;
    }

    public Artist() {
        this("",new ArrayList<>());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    @Override
    public String toString() {
        return this.nome+" Albums: {"+this.albums+"}";
    }
}
