package musicfy;

public class Dados {
    public void criarplaylist(){
        Playlist face = new Playlist();
        face.addSong(new Track("Set me...","Jime"));
        face.addSong(new Track("Like Crazy","Jime"));
        face.addSong(new Track("Face off","Jime"));

    }
}
