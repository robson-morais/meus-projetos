package musicfy;

import java.io.IOException;
import java.util.List;

public class BIBLIOTECA {
    private List<Album> albumsList;
    private List<Playlist> playlists;
    private String[] artists;
    private String user;

    private GravadorDeDados gravadordeAlbums;

    public BIBLIOTECA(List<Album> albumsList, List<Playlist> playlists, String[] artists, String user) {
        this.albumsList = albumsList;
        this.playlists = playlists;
        this.artists = artists;
        this.user = user;
        this.gravadordeAlbums = new GravadorDeDados();
    }

    public String [] nomesAlbums(){
        String [] nomesAlbums = new String[this.albumsList.size()];
        for (int a=0; a<this.albumsList.size();a++){
            nomesAlbums[a]=this.albumsList.get(a).getTitle();
        }
        return nomesAlbums;
    }

    public int totalTracks(){
        int quant = 0;
        for (Album album: this.albumsList){
            quant += album.getTracks().size();
        }
        return quant;
    }

    public String [] showAlbumSongs(Album album){
        int quant = album.getTracks().size();
        String [] namesSongs =new String[quant];
        for (int u=0;u<quant;u++){
            namesSongs[u] = album.getTracks().get(u).getName();
        }
        return namesSongs;
    }

    public String [] searchAlbums(String title){
        int quant = this.albumsList.size();
        String [] albumsFound = new String[quant];
        for (int z=0;z<quant;z++){
            if (this.albumsList.get(z).getTitle().equalsIgnoreCase(title)){
                albumsFound[z] = "'"+this.albumsList.get(z).getTitle()+"' by "+this.albumsList.get(z).getArtist();
            }
        }
        return albumsFound;
    }

    public String [] showPlaylists (){
        int quant = this.playlists.size();
        String [] playlistsf = new String[quant];
        for (int e=0; e<quant; e++){
            playlistsf[e] = this.playlists.get(e).getINDEX()+". "+this.playlists.get(e).getNome();
        }
        return playlistsf; //TODO*/
    }









    public void salvarDados() throws IOException{
        this.gravadordeAlbums.gravaAlbums(this.albumsList);
    }

    public void recuperarDados() throws IOException{
        this.albumsList = this.gravadordeAlbums.recuperaAlbums();
    }










    public List<Playlist> getPlaylists(){
        return this.playlists;
    }
    public void addPlaylist(Playlist playlist){
        this.playlists.add(playlist);
    }



    public String toString(){
        return "username: "+this.user+"\n"+this.playlists.size()+" playlists\n"+this.albumsList.size()+" albums\n"+this.artists.length+" artists";
    }
}
