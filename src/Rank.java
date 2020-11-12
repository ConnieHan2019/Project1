import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Rank {
    static java.io.File file = new java.io.File("c:\\Users\\20711\\IdeaProjects\\PJ2\\Rank.txt");
    public static String username;
    public static int score;
    static int finalline;
    public static   String[][]nicknameAndScore = new String[30][2];

    static GridPane paneOfGameOver = new GridPane();
    static Stage stageOfGameOver = new Stage();

    static Scene sceneOfGameOver = new Scene(paneOfGameOver,600,600) ;

    public static void read(){
        int lines = 0;

        try(Scanner input = new Scanner(file)){
            for(lines = 0;;lines++ ){
                if(lines == nicknameAndScore.length){
                    int compacity = nicknameAndScore.length*2;
                    nicknameAndScore = Arrays.copyOf(nicknameAndScore,compacity);
                }
                String next = input.next();
                nicknameAndScore[lines] = next.split("[:]");

            }
        }catch(java.util.NoSuchElementException e){

        }
        catch(FileNotFoundException E){}
        if(lines == nicknameAndScore.length){
            int compacity = nicknameAndScore.length+1;
            nicknameAndScore = Arrays.copyOf(nicknameAndScore,compacity);
        }
        //*/
        nicknameAndScore[lines] = new String[2];
        for(int i = 0;i <lines;i++){
            if(score > Integer.parseInt(nicknameAndScore[i][1])){
                for(int j = lines;j > i;j--){
                    nicknameAndScore[j] = nicknameAndScore[j - 1];
                }
                nicknameAndScore[i] = new String[]{username,String.valueOf(score)};
                break;
            }//最后一名的情况
            if(i == lines - 1){
                nicknameAndScore[lines][0] = username;
                nicknameAndScore[lines][1] = String.valueOf(score);
            }
        }
        //这是第一个用户的情况
        if(lines == 0){
            nicknameAndScore[lines][0] = username;
            nicknameAndScore[lines][1] = String.valueOf(score);
        }

        try(java.io.PrintWriter output = new java.io.PrintWriter(file);

        ){ for(int i = 0; i<= lines;i++){
            output.println(nicknameAndScore[i][0] + ":"+nicknameAndScore[i][1]);
            String str = "No."+(i+1) +"   "+nicknameAndScore[i][0] + "  :  " + nicknameAndScore[i][1];
            Label text = new Label(str);
            text.setFont(Font.font("Tekton Pro", FontPosture.ITALIC,18));
            paneOfGameOver.add(text,0,i);
            paneOfGameOver.setAlignment(Pos.CENTER);
            paneOfGameOver.setVgap(10);
            paneOfGameOver.setHgap(10);
            paneOfGameOver.setPadding(new Insets(10,10,10,10));

        }


        }catch(FileNotFoundException f){
            System.out.println("output");
        }
    }

    public static void print(){

        paneOfGameOver.setStyle("-fx-background-image:url('/rank.jpg')");
        stageOfGameOver.setTitle("排行榜");
        stageOfGameOver.setScene(sceneOfGameOver);
        stageOfGameOver.show();
    }


}
