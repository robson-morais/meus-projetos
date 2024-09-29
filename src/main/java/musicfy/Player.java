package musicfy;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Player {
    public static void main(String[] args) {

        Dados dados = new Dados();
        dados.criarplaylist();

        List<Album> albums = new ArrayList<>();
        String zachbryan = "Zach Bryan";
        List<Track> boysoffaith = new ArrayList<>();
        boysoffaith.add(new Track("Boys of Faith (feat. Bon Iver)", "Zach Byan"));
        boysoffaith.add(new Track("Nine Ball", "Zach Byan"));
        boysoffaith.add(new Track("Sara´s place", "Zach Byan"));
        boysoffaith.add(new Track("Deep Satin", "Zach Byan"));
        boysoffaith.add(new Track("Sweet, pain sweet pain", "Zach Byan"));
        Album BoysOfFaith = new Album("Boys Of Faith", "Zach Bryan", boysoffaith);

        List<Track> dollhouse = new ArrayList<>();
        String mel = "Melanie Martinez";
        dollhouse.add(new Track("Dollhouse", mel));
        dollhouse.add(new Track("Carousel", mel));
        dollhouse.add(new Track("Dead to me", mel));
        dollhouse.add(new Track("Bittersweet Tragedy", mel));
        Album Dollhouse = new Album("Doullhouse EP", mel, dollhouse);

        List<Track> theGreatAmericanBarScene = new ArrayList<>();
        theGreatAmericanBarScene.add(new Track("Lucky Enough (Poem)", "Zach Bryan"));
        theGreatAmericanBarScene.add(new Track("Mechanical Bull", "Zach Bryan"));
        theGreatAmericanBarScene.add(new Track("The Great American Bar Scene", "Zach Bryan"));
        theGreatAmericanBarScene.add(new Track("28", "Zach Bryan"));
        theGreatAmericanBarScene.add(new Track("American Nights", "Zach Bryan"));
        theGreatAmericanBarScene.add(new Track("Oak Island", "Zach Bryan"));
        theGreatAmericanBarScene.add(new Track("Purple Gas", "Zach Bryan"));
        theGreatAmericanBarScene.add(new Track("Boons", "Zach Bryan"));
        theGreatAmericanBarScene.add(new Track("The Way Back", "Zach Bryan"));
        theGreatAmericanBarScene.add(new Track("Memphis; The Blues (feat. John Moreland)", "Zach Bryan"));
        theGreatAmericanBarScene.add(new Track("Like Ida", "Zach Bryan"));
        theGreatAmericanBarScene.add(new Track("Bass Boat", "Zach Bryan"));
        theGreatAmericanBarScene.add(new Track("Better Days (feat. John Mayer)", "Zach Bryan"));
        theGreatAmericanBarScene.add(new Track("Towers", "Zach Bryan"));
        theGreatAmericanBarScene.add(new Track("Sandpaper (feat. Bruce Springsteen)", "Zach Bryan"));
        theGreatAmericanBarScene.add(new Track("Northern Thunder", "Zach Bryan"));
        theGreatAmericanBarScene.add(new Track("Funny Man", "Zach Bryan"));
        theGreatAmericanBarScene.add(new Track("Pink Skies", "Zach Bryan"));
        theGreatAmericanBarScene.add(new Track("Bathwater", "Zach Bryan"));
        Album theGreatAmericanBarSceneAlbum = new Album("The Great American Bar Scene", "Zach Bryan", theGreatAmericanBarScene);

        List<Track> unknownPleasures = new ArrayList<>();
        unknownPleasures.add(new Track("Disorder", "Joy Division"));
        unknownPleasures.add(new Track("Day of the Lords", "Joy Division"));
        unknownPleasures.add(new Track("Candidate", "Joy Division"));
        unknownPleasures.add(new Track("Insight", "Joy Division"));
        unknownPleasures.add(new Track("New Dawn Fades", "Joy Division"));
        unknownPleasures.add(new Track("She's Lost Control", "Joy Division"));
        unknownPleasures.add(new Track("Shadowplay", "Joy Division"));
        unknownPleasures.add(new Track("Wilderness", "Joy Division"));
        unknownPleasures.add(new Track("I Remember Nothing", "Joy Division"));
        Album unknownPleasuresAlbum = new Album("Unknown Pleasures", "Joy Division", unknownPleasures);
        //Adicionando todos os albuns criados na List albums:
        albums.add(BoysOfFaith);
        albums.add(theGreatAmericanBarSceneAlbum);
        albums.add(Dollhouse);
        albums.add(unknownPleasuresAlbum);

        // Criando uma playlist com todas as músicas de acordo com os albuns da List ¨albums¨:
        Playlist allsongs = new Playlist();
        allsongs.setNome("Liked songs");
        for (Album alb: albums){
            for (int j=0; j<alb.getTracks().size(); j++){
                allsongs.addSong(alb.getTracks().get(j));
            }
        }

        Playlist zach = new Playlist();
        zach.setNome("Best of Zach Bryan");
        for (Album ab: albums){
            for (int y=0; y<ab.getTracks().size(); y++){
                if (ab.getTracks().get(y).getArtist().equalsIgnoreCase("zach bryan")){
                    zach.addSong(ab.getTracks().get(y));
                }
            }
        }

        // Fazendo um Array com os nomes das músicas para mostrar no menu:
        String [] allSongsNames = new String[allsongs.getQuant()];
        for (int c=0; c<allsongs.getQuant();c++){
            allSongsNames[c] = allsongs.getTracks().get(c).toString();
        }

        //Criando playlists:
        List<Playlist> playlistsByUser = new ArrayList<>();
        playlistsByUser.add(allsongs);
        playlistsByUser.add(zach);


        String [] artistas = new String[]{mel,zachbryan,"JOY DIVISION"};
        BIBLIOTECA biblioteca = new BIBLIOTECA(albums,playlistsByUser,artistas,"robson m.");
        String [] playliststoshow = biblioteca.showPlaylists();

        boolean exit = false;
        while (!exit){
            int option = Integer.parseInt(JOptionPane.showInputDialog("====| Player (teste) |====\n"+biblioteca.toString()+"\n*choose an option:\n(1) Tracks\n(2) Albums\n(3) Artists\n(4) Playlists\n(5) Sair"));
            switch (option){
                case 1:
                    boolean exit2 = false;
                    while (!exit2){
                        int op = Integer.parseInt(JOptionPane.showInputDialog(null,"(1) Pesquisar música\n(2) Exibir suas músicas\n(3) Voltar"));
                        switch (op) {
                            case 1:
                                String searchThis = JOptionPane.showInputDialog("Pesquisar...");
                                JOptionPane.showMessageDialog(null, allsongs.searchSongToString(searchThis));
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null, allSongsNames);
                                break;
                            case 3:
                                exit2 = true;
                                break;
                        }
                    }
                    break;
                case 2:
                    boolean exit3 = false;
                    while (!exit3){
                        int op2 = Integer.parseInt(JOptionPane.showInputDialog(null,"(1) Pesquisar álbum\n(2) Exibir seus álbuns salvos\n(3) Voltar"));
                        switch (op2){
                            case 1:
                                String searchThis = JOptionPane.showInputDialog("Pesquisar...");
                                JOptionPane.showMessageDialog(null,biblioteca.searchAlbums(searchThis));
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null,biblioteca.nomesAlbums());
                                break;
                            case 3:
                                exit3 = true;
                                break;
                        }
                    }
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null,artistas);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null,playliststoshow); //biblioteca.toString()
                    break;
                case 5:
                    exit = true;
                    break;
            }
        }
    }

    public static String[] showAlbumsByName(List<Album> albums) {
        String[] albumsNames = new String[albums.size()];
        for (int i = 0; i < albums.size(); i++) {
            albumsNames[i] = albums.get(i).getTitle() + " by " + albums.get(i).getArtist();
        }
        return albumsNames;
    }
}