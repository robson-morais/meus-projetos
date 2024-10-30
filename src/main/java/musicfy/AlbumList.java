package musicfy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlbumList {
    private List<Album> albums;

    public AlbumList(List<Album> albums) {
        this.albums = albums;
    }

    public AlbumList() {
        this.albums = new ArrayList<>();
    }

    public void addAlbum(Album album) throws IOException {
        if (!this.contains(album.getTitle())) {
            this.albums.add(album);
        } throw new IOException("Este álbum já está na sua lista de downloads.");
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public boolean contains(String title) {
        boolean contains = false;
        for (Album album1: this.albums) {
            if (album1.getTitle().equalsIgnoreCase(title)){
                contains = true;
            }
        }
        return contains;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}
