package musicfy;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TrackList {
    private List<Track> tracks;

    public TrackList(List<Track> tracks) {
        this.tracks = tracks;
    }
    public TrackList() {
        this.tracks = new ArrayList<>();
    }


    public void add(Track track) throws TrackException {
        if (this.tracks.contains(track)){
            throw new TrackException("Track already exists");
        } else {
            this.tracks.add(track);
        }
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public List<String> getArtistsNames() throws TrackException {
        if (this.tracks != null) {
            List<String> artistsNames = new ArrayList<>();
            for (Track track: this.tracks) {
               artistsNames.add(track.getArtist());
            } return artistsNames;
        } throw new TrackException("Lista vazia");
    }

    public List<String> getAlbumsTitles(){
        List<String> albumsTitles = new ArrayList<>();
        for (Track track: this.tracks) {
            albumsTitles.add(track.getAlbum()+"\n");
        } return albumsTitles;
    }

    public List<Track> searchAlbumTracks(String album){
        List<Track> list = new ArrayList<>();
        for (Track track: this.tracks){
            if (track.getAlbum().equalsIgnoreCase(album)){
                list.add(track);
            }
        }
        return list;
    }

    public Track searchSingleTrack(String title) throws IOException{
        Track trackFound = null;
        for (Track track: this.tracks){
            if (track.getName().equalsIgnoreCase(title)) {
                trackFound = track;
            }
        }
        if (trackFound == null) {
            throw new IOException("This song doesn't exist in the list");
        } return trackFound;
    }

    public List<String> searchTracks(String trackName) {
        List<String> foundedTracks = new ArrayList<>();
        for (Track track: this.tracks){
            if (track.getName().equalsIgnoreCase(trackName)) {
                foundedTracks.add(track.toString());
            }
        }
        return foundedTracks;
    }

    public boolean searchArtist(String artistName) {
        boolean artistFound = false;
        for (Track track: this.tracks) {
            if (track.getArtist().equalsIgnoreCase(artistName)) {
                artistFound = true;
            }
        }
        return artistFound;
    }

    public List<String> searchArtistSongs(String artistName) {
        List<String> artistSongs = new ArrayList<>();
        for (Track track: this.tracks) {
            if (track.getArtist().equalsIgnoreCase(artistName)) {
                artistSongs.add(track.getName()+"\n");
            }
        }
        return artistSongs;
    }

    public List<String> searchArtistAlbums(String artistName) {
        //Exibe os álbums de um artista;
        List<String> artistAlbums = new ArrayList<>();
        for (Track track: this.tracks) {
            if (track.getArtist().equalsIgnoreCase(artistName)) {
                artistAlbums.add(track.getAlbum()+"\n");
                break;
            }
        }
        return artistAlbums;
    }
    public String searchAlbumTest (String albumName, AlbumList albumList) throws IOException {
        String finalString = "";
        String albumFoundedTitle = "";
        String artistAlbumFounded = "";

        List<Track> tracksForAlbumFounded = new ArrayList<>();

        // Verifica se o album existe na Biblioteca:
        if (albumList.contains(albumName)) {

            for (Track track: this.tracks) {
                if (track.getAlbum().equalsIgnoreCase(albumName)) {
                    tracksForAlbumFounded.add(track);
                    artistAlbumFounded = track.getArtist();
                    albumFoundedTitle = track.getAlbum();
                }
            }

            // Formatando a string de exibição do álbum:
            finalString = "'"+albumFoundedTitle+"'"+" by "+artistAlbumFounded+"\n\n";
            for (int i = 0; i < tracksForAlbumFounded.size(); i++) {
                finalString += i+1+".  "+tracksForAlbumFounded.get(i).getName()+"\n";
            }
            finalString += "\nTotal : "+tracksForAlbumFounded.size()+" tracks";


        } else {
            finalString = "No matches...";
        }
        return finalString;
    }



    public String lastAddedSongs() {
        //Este método apenas pega um quantidade de faixas para exibir seus títulos na página incial;
        String listN = "";
        for (int k=0; k<5; k++){
            listN += "~"+this.tracks.get(k).toString();

        } return listN;
    }



}