package musicfy;

import java.util.ArrayList;
import java.util.List;

public class aBiblioteca {

    public static void main(String[] args) {
        Artist ZachBryan = new Artist();
        List<Track> album = new ArrayList<>();
        Track faixa1 = new Track("Snow","ZachBryan","3:26");
        album.add(faixa1);
        System.out.println(album.get(0).toString());
    }
}
