package musicfy.testesFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.control.Slider;
import javafx.util.Duration;
import musicfy.*;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class PlayerFXcss extends Application {

    private String username = "r0bstark";
    private AlbumList albumsList;
    private TrackList trackList;
    private GravadorDeDados recorder;
    private GravadorAlbum recorderAlbum;
    private Scene mainScene;

    MediaPlayer mediaPlayer; // Variável para controlar o MediaPlayer


    @Override
    public void start(Stage primaryStage) throws IOException {

        // Inicializando os gravadores de dados
        recorder = new GravadorDeDados();
        recorderAlbum = new GravadorAlbum();
        // Recuperando dados salvos
        initializeData();

        // Tela Inicial:
        Label wecomeInfo = new Label("Welcome Back,\n" + username + "!");
        wecomeInfo.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        Label info1 = new Label("Last added songs:  ================\n"+trackList.lastAddedSongs()+"\n=============================");
        info1.setStyle("-fx-font-size: 12px; -fx-font-weight: bold;");

        Button libraryButton = new Button("YOUR LIBRARY");
        Button exitButton = new Button("EXIT");
        Button profile = new Button("Profile");

        libraryButton.setStyle("-fx-padding: 5px 10px; -fx-background-color: #006400; -fx-text-fill: white;");
        exitButton.setStyle("-fx-padding: 5px 10px; -fx-background-color: #006400; -fx-text-fill: white;");
        profile.setStyle("-fx-padding: 5px 10px; -fx-background-color: #006400; -fx-text-fill: white;");


        HBox header = new HBox(80,wecomeInfo, profile);
        //header.setStyle("-fx-alignment: center;");
        HBox buttons = new HBox(30, libraryButton, exitButton);
        buttons.setStyle("-fx-alignment: center;");


        VBox layout = new VBox(30, header, info1, buttons);
        layout.setStyle("-fx-padding: 20px;");

        Scene scene1 = new Scene(layout, 300, 300);
        primaryStage.setTitle("MusicPlayer");
        primaryStage.setScene(scene1);
        primaryStage.show();

        libraryButton.setOnAction(e -> showLibrary(primaryStage));
        exitButton.setOnAction(e -> primaryStage.close());
        profile.setOnAction(e-> profile(primaryStage));

    }
    // Criar uma nova cena para a biblioteca
    private void showLibrary(Stage primaryStage) {

        // Criando os elementos:
        Label searchLabel = new Label("Search: ");
        Label downloads = new Label("Your Downloads");

        TextField inputField = new TextField();
        inputField.setPromptText("Enter your search here: ");
        //TODO

        // Criando botões:
        Button searchButton = new Button("\uD83D\uDD0E");
        Button backButton = new Button(" Back ");
        Button albumsButton = new Button ("Albums");
        Button Songs = new Button ("Songs");
        Button Artists = new Button("Artists ");

        // Estilizando os elementos

        inputField.setStyle("-fx-padding: 4px 5px; -fx-font-size: 11px;");

        // Estilizando os botões:
        backButton.setStyle("-fx-padding: 10px 20px; -fx-text-fill: green;");
        searchButton.setStyle("-fx-padding: 1px 4px; -fx-background-color: #006400; -fx-text-fill: white;");
        searchLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-alignment: center;");
        albumsButton.setStyle("-fx-padding: 10px 20px; -fx-background-color: #006400; -fx-text-fill: white;");

        Songs.setStyle("-fx-padding: 10px 20px; -fx-background-color: #006400; -fx-text-fill: white;");
        Artists.setStyle("-fx-padding: 10px 20px; -fx-background-color: #006400; -fx-text-fill: white;");
        downloads.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        // Colocando os elementos na cena:
        HBox searchHeader = new HBox(5, searchButton, inputField);
        searchHeader.setStyle("-fx-alignment: center;");

        VBox downloadsXsearch = new VBox(10,searchLabel,searchHeader,downloads);
        downloadsXsearch.setStyle("-fx-alignment: center;");

        HBox songsXalbums = new HBox(30,Songs, albumsButton);
        songsXalbums.setStyle("-fx-alignment: center;");
        HBox artistsXback  = new HBox (30,Artists,backButton);
        artistsXback.setStyle("-fx-alignment: center;");

        VBox libraryLayout = new VBox(30, downloadsXsearch, songsXalbums, artistsXback);
        libraryLayout.setStyle("--fx-padding: 20px;-fx-alignment: center;");

        Scene libraryScene = new Scene(libraryLayout, 300,300);
        primaryStage.setScene(libraryScene);

        // Dando ações aos botões:
        backButton.setOnAction(e -> {
            try {
                this.start(primaryStage);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        searchButton.setOnAction(e -> {
            String searchText = inputField.getText();
            try {
                showSearchResults(searchText, primaryStage);
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        });

        albumsButton.setOnAction(e -> ShowAlbums(primaryStage));
    }

    private void ShowAlbums(Stage primaryStage) {
        Button back = new Button("Back");
        back.setStyle("-fx-padding: 5px 10px; -fx-background-color: #0064cc; -fx-text-fill: white;");

        Label albumsHeader = new Label ("\nDownloaded Albums: \n");
        Label albumsTitles = new Label(albumsList.getAlbumsTitles());
        albumsTitles.setStyle("-fx-font-size: 12px; -fx-font-weight: bold;");
        albumsHeader.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        VBox albumsLayout = new VBox(30, albumsHeader,albumsTitles,back);
        albumsLayout.setStyle("--fx-padding: 20px;-fx-alignment: center;");

        Scene albumsScene = new Scene(albumsLayout, 300,300);
        primaryStage.setScene(albumsScene);

        back.setOnAction(e -> showLibrary(primaryStage));
    }

    private void showSearchResults (String searchText, Stage stage) throws IOException {

        String allResultsFounded = "";

        Label resultsLabelHeader = new Label("Results for: '" + searchText+"'===============\n"+allResultsFounded);
        resultsLabelHeader.setStyle("-fx-font-size: 13px; -fx-font-weight: bold;");

        Button backButton = new Button(" Back ");
        backButton.setStyle("-fx-padding: 10px 20px; -fx-background-color: #006400; -fx-text-fill: white;");

        // Ações do botões:
        backButton.setOnAction(e -> showLibrary(stage));

        VBox resultsVBox = new VBox(20,resultsLabelHeader);

        // todo: verificar se o input é uma faixa, álbum ou artista;
        boolean searchIsSong = false;
        if (trackList.getTracks() != null) {

            for (Track track: trackList.getTracks()) {
                if (track.getName().equalsIgnoreCase(searchText)) {
                    searchIsSong = true;
                    Button trackButton = new Button("'"+track.getName()+"' song by "+track.getArtist());
                    trackButton.setOnAction(e -> playTrack(track.getName(),stage));
                    trackButton.setStyle("-fx-font-size: 12px; -fx-background-color: transparent; -fx-font-weight: bold;");
                    //allResultsFounded+=track.getName()+"  by  "+ track.getArtist()+"\n";
                    resultsVBox.getChildren().add(trackButton);
                }
            }

            if (searchIsSong) {
                System.out.println("A lista de tracks não está vazia e o input é uma musica");

            }
        }
        resultsVBox.getChildren().add(backButton);
        resultsVBox.setStyle("--fx-padding: 20px;-fx-alignment: center;");
        Scene scene = new Scene(resultsVBox,300,300);
        stage.setScene(scene);
    }

    private void playTrack(String trackName, Stage stage) {
        // Para qualquer música que esteja tocando, parar antes de reproduzir outra
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }

        for (Track track : trackList.getTracks()) {
            if (track.getName().equalsIgnoreCase(trackName)) {
                // Construa o caminho para o arquivo de áudio
                String filePath = "C:/Users/Robson/Music/" + track.getAlbum() + "/" + track.getName() + ".mp3";
                File file = new File(filePath);

                // Caminho para a imagem do álbum
                String imagePath = "C:/Users/Robson/Pictures/" + track.getAlbum() + "/" + track.getAlbum() + ".jpeg";
                File imageFile = new File(imagePath);

                if (file.exists() || imageFile.exists()) {
                    // Cria o objeto Media e MediaPlayer
                    Media media = new Media(file.toURI().toString());
                    mediaPlayer = new MediaPlayer(media);

                    // Botões Play e Pause
                    Button playButton = new Button("Play");
                    playButton.setOnAction(e -> mediaPlayer.play());
                    Button pauseButton = new Button("Pause");
                    pauseButton.setOnAction(e -> mediaPlayer.pause());

                    Button backButton = new Button("Back");
                    backButton.setStyle("-fx-padding: 5px 10px; -fx-background-color: #006400; -fx-text-fill: white; -fx-alignment: center-left;");

                    // Barra de progresso
                    Slider progressBar = new Slider();
                    progressBar.setMin(0);
                    progressBar.setMax(100);
                    progressBar.setValue(0);

                    // Temporizador para exibir o tempo atual e duração total
                    Label timeLabel = new Label("00:00 / 00:00");

                    // Listener para atualizar a barra de progresso e o temporizador
                    mediaPlayer.currentTimeProperty().addListener((obs, oldTime, newTime) -> {
                        Duration currentTime = mediaPlayer.getCurrentTime();
                        Duration totalDuration = mediaPlayer.getTotalDuration();

                        progressBar.setMax(totalDuration.toSeconds());
                        progressBar.setValue(currentTime.toSeconds());
                        timeLabel.setText(formatTime(currentTime, totalDuration));
                    });

                    // Define o comportamento ao término da faixa para resetar a barra de progresso
                    mediaPlayer.setOnEndOfMedia(() -> {
                        progressBar.setValue(0);
                        timeLabel.setText("00:00 / 00:00");
                    });

                    // Imagem do álbum
                    Image image = new Image(imageFile.toURI().toString());
                    ImageView imageView = new ImageView(image);
                    imageView.setFitWidth(200);
                    imageView.setFitHeight(200);
                    imageView.setStyle("-fx-alignment: center;");

                    // Layout HBox para os botões
                    HBox controlBox = new HBox(10, playButton, pauseButton, timeLabel);
                    controlBox.setStyle("-fx-alignment: center;"); // Centraliza os botões no HBox

                    // Layout VBox para centralizar a imagem, barra de progresso e botões
                    VBox root = new VBox(20, imageView, progressBar, controlBox, backButton);
                    root.setStyle("-fx-alignment: center;"); // Centraliza tudo no VBox

                    // Configura a cena e exibe o player
                    Scene scene = new Scene(root, 400, 400);
                    stage.setTitle("Music Player com Imagem e Barra de Progresso");
                    stage.setScene(scene);
                    stage.show();

                    // Inicia a reprodução da faixa
                    mediaPlayer.play();
                    System.out.println("Tocando pelo media player: " + track.getName());
                    return;
                }
            }
        }
        System.out.println("A faixa não está em seus downloads.");
    }

    // Método para formatar o tempo
    private String formatTime(Duration elapsed, Duration duration) {
        int intElapsed = (int) Math.floor(elapsed.toSeconds());
        int elapsedMinutes = intElapsed / 60;
        int elapsedSeconds = intElapsed % 60;

        int intDuration = (int) Math.floor(duration.toSeconds());
        int durationMinutes = intDuration / 60;
        int durationSeconds = intDuration % 60;

        if (duration.isUnknown()) {
            return String.format("%02d:%02d", elapsedMinutes, elapsedSeconds);
        } else {
            return String.format("%02d:%02d / %02d:%02d",
                    elapsedMinutes, elapsedSeconds,
                    durationMinutes, durationSeconds);
        }
    }

    private void profile (Stage primaryStage) {

        Button changeUsername = new Button ("      Change username      ");
        Button changeSystemLanguage = new Button ("Change System Language");
        Button back = new Button ("Back");

        Label profile = new Label ("Profile");
        Label userName = new Label (username);
        Label profileInfo = new Label ("Joined Oct, 2024");

        profile.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        userName.setStyle("-fx-font-size: 12px; -fx-font-weight: bold;");
        profileInfo.setStyle("-fx-font-size: 12px; -fx-font-weight: bold;");

        //todo Configurando os botões:
        back.setStyle("-fx-padding: 5px 10px; -fx-background-color: #0064cc; -fx-text-fill: white;");
        changeUsername.setStyle("-fx-padding: 5px 50px; -fx-background-color: #006400; -fx-text-fill: white;");
        changeSystemLanguage.setStyle("-fx-padding: 5px 50px; -fx-background-color: #006400; -fx-text-fill: white;");

        //TODO username e profileInfo em um vbox
        VBox usernameXinfo = new VBox(5,userName,profileInfo);
        usernameXinfo.setStyle("--fx-padding: 20px;-fx-alignment: center;");

        // TODO Profile + (username + info) em um vbox
        VBox profileHeaderAndInfo = new VBox(5, profile,usernameXinfo);
        profileHeaderAndInfo.setStyle("--fx-padding: 20px;-fx-alignment: center;");

        VBox profileLayout = new VBox(40,profileHeaderAndInfo,changeUsername,changeSystemLanguage,back);
        profileLayout.setStyle("--fx-padding: 20px;-fx-alignment: center;");

        Scene scene = new Scene(profileLayout, 300,300);
        primaryStage.setScene(scene);

        // todo Buttons actions:
        back.setOnAction(e -> {
            try {
                this.start(primaryStage);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        changeUsername.setOnAction(e-> username = JOptionPane.showInputDialog("Username: "));
    }


    public static void main(String[] args) {
        launch(args);
    }

    private void initializeData() {
        try {
            List<Track> tracksRecovered = recorder.lerDados();
            trackList = new TrackList(tracksRecovered);
        } catch (IOException e) {
            trackList = new TrackList();
        }

        try {
            List<Album> albumsRecovered = recorderAlbum.lerDadosAlbums();
            albumsList = new AlbumList(albumsRecovered);
        } catch (IOException e) {
            albumsList = new AlbumList();
            System.out.println("Erro ao recuperar albums.");
        }
    }
}
