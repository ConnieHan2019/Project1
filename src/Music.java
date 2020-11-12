import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Music {
     private static Music instance;
     private MediaPlayer bgmPlayer;
     public double volume=0.3;


     private Music(){
         Media media = new Media((new File("music/bgm1.mp3")).toURI().toString());
         this.bgmPlayer = new MediaPlayer(media);
         this.bgmPlayer .setCycleCount(-1);
         this.bgmPlayer.setVolume(volume);
     }

     public static Music getInstance(){
         if(instance == null){
             instance = new Music();
         }
         return instance;

     }
     public void setvolume(double volumn){
         bgmPlayer.setVolume(volumn);
     }
     private void playWav(String name){
         File file = new File(String.format("music/%s.wav",name));
         Media special = new Media(file.toURI().toString());
         MediaPlayer sp = new MediaPlayer(special);
         sp.play();
     }
     public void playBgm(){this.bgmPlayer.play();}
     public void stopBgm(){this.bgmPlayer.stop();}
     public void playDeleteSound(){this.playWav("delete1");}

}
