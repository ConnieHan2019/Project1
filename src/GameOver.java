
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class GameOver {
    static String username;
     static int score;
     static int finalline;
     static GridPane paneOfGameOver = new GridPane();
     static Stage stageOfGameOver = new Stage();
     static Scene sceneOfGameOver = new Scene(paneOfGameOver,400,500) ;
     static String[]str ;

    public static void gameOver(){
        System.out.println("gameOver start");
        paneOfGameOver.setVgap(10);
        paneOfGameOver.setHgap(10);
        Rank rank = new Rank();
     rank.username = username;
     rank.score = score;
     finalline = rank.nicknameAndScore.length;


         rank.read();
           str = new String[rank.nicknameAndScore.length];
     try(
             FileInputStream input = new FileInputStream(rank.file)
             ){
         for(int i =0; i <rank.nicknameAndScore.length; i++){

             System.out.println("No."+(i + 1) + "  " + rank.nicknameAndScore[i][0] + " : " + rank.nicknameAndScore[i][1] + "分");
            str[i]  = "No." + rank.nicknameAndScore[i][0]+" : "+ rank.nicknameAndScore[i][1] + "分";
            // Text[]text = new Text[rank.nicknameAndScore.length];
            //text[i].setText(str[i]);
//          paneOfGameOver.add(text[i],0,i);
         }
     }catch(IOException E){
         System.out.println("input");
     }
     stageOfGameOver.setScene(sceneOfGameOver);
     stageOfGameOver.show();


    }
}
