import javafx.application.Application;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


public class Main extends Application{
   public static  Music bgm = Music.getInstance();


    private Stage stage = new Stage();

    public  void start(Stage priamryStage) {
    StartGame startGame = new StartGame();
    startGame.start();

        bgm.playBgm();

    }


    public static void main(String[]args){
        launch(args);
    }


    }







