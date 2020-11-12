import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;


public class StartGame {

    private static Scene scene1;

    private static Pane pane1 = new Pane();
    private static Pane paneOfRule = new Pane();
    private static GridPane paneOfNickname = new GridPane();
    private static GridPane paneOfLevel = new GridPane();
    private static Scene sceneOfLevel = new Scene(paneOfLevel,300,300);
    private static Stage stageOfLevel = new Stage();
    private static Stage stageOfRule = new Stage();
    private static Stage mainStage = new Stage();
    private static Stage stageOfRank = new Stage();
    private static GridPane paneOfRank = new GridPane();
    private static Scene sceneOfRank = new Scene(paneOfRank,600,600);

    private static Stage stageOfInputRank = new Stage();
    private static Scene sceneOfRule = new Scene(paneOfRule,300,300);
    private static Scene sceneOfNickname = new Scene(paneOfNickname,300,300);
    private static String username;
    public static double second;

    public static boolean isOver(int[][]map){
        boolean isOver = false;
        for (int j = 0; j < 12; j++) {
            if (map[2][j] == 9) {
                isOver = true;

            }
        }

        return isOver;

    }


    public void start(){
        scene1 = new Scene(pane1, 656, 656);
        pane1.setStyle("-fx-background-image:url('/初始界面.jpg')");
        /**创建JavaFX Button对象后，我们可以使用以下方法设置文本并设置安装图标。
         setText(String text) - 设置按钮的文本标题
         setGraphic(Node graphic) - 设置图标
         */
        Button start = new Button();
        start.setText("新的开始");
        start.setFont(Font.font("Tekton Pro",FontPosture.ITALIC,20));
        start.setTextFill(Color.GOLD);
        start.relocate(250, 340);

        Button restart = new Button();
        restart.setText("继续游戏");
        restart.setFont(Font.font("Tekton Pro",FontPosture.ITALIC,20));
        restart.setTextFill(Color.GOLD);
        restart.relocate(250, 400);

        Button rank = new Button();
        rank.setText("排行榜");
        rank.setFont(Font.font("Tekton Pro",FontPosture.ITALIC,20));
        rank.setTextFill(Color.GOLD);
        rank.relocate(250,460);

        Button rule = new Button();
        rule.relocate(250,520);
        rule.setText("游戏规则");
        rule.setFont(Font.font("Tekton Pro",FontPosture.ITALIC,20));
        rule.setTextFill(Color.GOLD);

      start.setStyle("fx-background-radius: 25; -fx-border-radius: 25;");

      rank.setOnAction((ActionEvent e)->{
          paneOfRank.setHgap(10);
          paneOfRank.setVgap(10);
          paneOfRank.setAlignment(Pos.CENTER);

          java.io.File file = new java.io.File("c:\\Users\\20711\\IdeaProjects\\PJ2\\Rank.txt");
          try( FileInputStream fis = new FileInputStream(file);
              // java.io.PrintWriter output = new java.io.PrintWriter(file);

          )
          {String str = null;
           int number = 0;

              Scanner scanner = new Scanner(fis);
              while(scanner.hasNextLine()){
                  number++;
                  str = scanner.nextLine();
                  String read = "No."+number + str;
                  System.out.println(read);
                  Label text = new Label(read);
                  text.setFont(Font.font("Tekton Pro", FontPosture.ITALIC, 15));
                  paneOfRank.add(text,0,number);
                  System.out.println(number);

              }


          }
          catch(FileNotFoundException f){
              System.out.println("output");
          }catch(IOException E){

          }
          paneOfRank.setStyle("-fx-background-image:url('/rank.jpg')");
          stageOfRank.setTitle("排行榜");
          stageOfRank.setScene(sceneOfRank);
          stageOfRank.show();
      });


      restart.setOnAction((ActionEvent e)->{
          SerDemo demo = new SerDemo();
          demo.Input();

          if (isOver(demo.map) == false){
          mainStage.close();
          Game game = new Game();
          game.username = demo.username;
          game.score = demo.score;
          game.previousTime = demo.time;
          game.map = demo.map;

          game.startTime = System.currentTimeMillis();
          game.start();}
          else{
              Label wrong = new Label();
              wrong.setText("上一次游戏已经死亡，请重新开始");
              wrong.setFont(Font.font("Tekton Pro",FontPosture.ITALIC,16));
              paneOfNickname.setAlignment(Pos.CENTER);
              paneOfNickname.setHgap(20);
              paneOfNickname.setVgap(50);
              TextField nickname =  new TextField();
              Button inputUsername = new Button("输入");
              inputUsername.setFont(Font.font("Tekton Pro",FontPosture.ITALIC,16));
              paneOfNickname.add(inputUsername,1,1);
              paneOfNickname.add(new Label("Name:"),0,0);
              paneOfNickname.add(nickname,1,0);
              paneOfNickname.add(wrong,0,2);
              paneOfNickname.setStyle("-fx-background-image:url('/input.jpg')");
              stageOfInputRank.setScene(sceneOfNickname);
              stageOfInputRank.setTitle("输入用户名");
              stageOfInputRank.show();
              inputUsername.setOnAction((ActionEvent error)-> {
                  username = nickname.getText();

                  stageOfInputRank.close();
                  mainStage.close();
                  Game game = new Game();
                  game.start();
                  game.username = username;
                  game.startTime = System.currentTimeMillis();

              });
          }
      });



         rule.setOnAction((ActionEvent e)->{
             Rule ruleOfGame = new Rule();
             paneOfRule.getChildren().addAll(ruleOfGame.ruleText1,ruleOfGame.ruleText2,ruleOfGame.ruleText3,ruleOfGame.ruleText4,ruleOfGame.ruleText5,
                     ruleOfGame.ruleText6,ruleOfGame.ruleText7);
             stageOfRule.setScene(sceneOfRule);
             stageOfRule.show();
         });

         start.setOnAction((ActionEvent e)->{
             paneOfNickname.setAlignment(Pos.CENTER);
             paneOfNickname.setHgap(20);
             paneOfNickname.setVgap(50);
             TextField nickname =  new TextField();
             Button inputUsername = new Button("输入");
             Label name = new Label("Name");
            name.setFont(Font.font("Tekton Pro",FontPosture.ITALIC,16));
             inputUsername.setFont(Font.font("Tekton Pro",FontPosture.ITALIC,16));
             paneOfNickname.add(inputUsername,1,1);
             paneOfNickname.add(name,0,0);
             paneOfNickname.add(nickname,1,0);
             paneOfNickname.setStyle("-fx-background-image:url('/input.jpg')");
             stageOfInputRank.setScene(sceneOfNickname);
             stageOfInputRank.setTitle("输入用户名");
             stageOfInputRank.show();
             inputUsername.setOnAction((ActionEvent error)-> {
                 stageOfInputRank.close();
                 stageOfLevel.setTitle("难度选择");
                 username = nickname.getText();
               //  Label label = new Label("难度选择");
               //  label.setFont(Font.font("Tekton Pro",FontPosture.ITALIC,20));
                 Label easy = new Label("easy");
                 easy.setFont(Font.font("Tekton Pro",FontPosture.ITALIC,16));
                 easy.setTextFill(Color.GOLD);
                 Label normal = new Label("normal");
                 normal.setTextFill(Color.GOLD);
                 normal.setFont(Font.font("Tekton Pro",FontPosture.ITALIC,16));
                 Label hard = new Label("hard");
                 hard.setFont(Font.font("Tekton Pro",FontPosture.ITALIC,16));
                 hard.setTextFill(Color.GOLD);
                 Label hell = new Label("hell");
                 hell.setFont(Font.font("Tekton Pro",FontPosture.ITALIC,16));
                 hell.setTextFill(Color.GOLD);
                 paneOfLevel.setPadding(new Insets(10,10,10,10));
                 paneOfLevel.add(easy,0,0);
                 paneOfLevel.add(normal,0,1);
                 paneOfLevel.add(hard,0,2);
                 paneOfLevel.add(hell,0,3);
                 paneOfLevel.setAlignment(Pos.CENTER);
                 paneOfLevel.setHgap(10);
                 paneOfLevel.setVgap(10);
                 paneOfLevel.setStyle("-fx-background-image:url('/setting.jpg')");
                 stageOfLevel.setScene(sceneOfLevel);

                 stageOfLevel.show();
                 easy.setOnMouseClicked((MouseEvent f)->{

                    stageOfLevel.close();
                     mainStage.close();
                     Game game = new Game();
                     game.start();
                     game.username = username;
                     game.startTime = System.currentTimeMillis();
                     game.second = 1;
                     game.timeline(1);


                 });
                normal.setOnMouseClicked((MouseEvent f)->{

                    stageOfLevel.close();
                    mainStage.close();
                    Game game = new Game();
                    game.start();
                    game.username = username;
                    game.startTime = System.currentTimeMillis();
                    game.second = 0.75;
                    game.timeline(0.75);

                });
                 hard.setOnMouseClicked((MouseEvent f)->{

                     stageOfLevel.close();
                     mainStage.close();
                     Game game = new Game();
                     game.start();
                     game.username = username;
                     game.startTime = System.currentTimeMillis();
                     game.second = 0.5;
                     game.timeline(0.5);

                 });
                 hell.setOnMouseClicked((MouseEvent f)->{

                     stageOfLevel.close();
                     mainStage.close();
                     Game game = new Game();
                     game.start();
                     game.username = username;
                     game.startTime = System.currentTimeMillis();
                     game.second = 0.25;
                     game.timeline(0.25);

                 });


             });

         });



        //在pane的（x,y）上添加按钮

        pane1.getChildren().addAll(start,restart,rank,rule);
        mainStage.setScene(scene1);
        mainStage.setTitle("Tetris");
        mainStage.show();
    }
}
