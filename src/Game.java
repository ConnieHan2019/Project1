import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

import static javafx.scene.input.KeyEvent.KEY_PRESSED;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import javafx.scene.text.FontPosture;

import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


import javafx.event.EventHandler;
import javafx.util.Duration;


import java.io.Serializable;
import java.text.SimpleDateFormat;

import java.util.TimeZone;
import java.util.Timer;




public class Game implements Serializable {


    /**
     * Part 1  1）	建立各种需要的变量,初始化，建立Game类型的实例game等
     */
    private static int x = 0, y = 4;
    static int score = 0, scoreThisTime = 0;
    public static int[][] map = new int[18][12];//数组加大 防止溢出
    public static double second ;

    /**
     * 建立操作中的对象和下一个操作对象
     */


     static Block currentBlock;
    static Block nextBlock;
    private static Pane pane = new Pane();


    public static long startTime;
    public static long endTime;
    public static long previousTime;
    public static long caculateTime;
    public static String totalTime;

    public static String username;
    private static Label ShowScore = new Label();
    private static Label ShowTime = new Label() ;
    private static Timeline timeline;
    public static Scene scene2;
    public static Stage gameStage = new Stage();
    private static Stage stageOfSetting = new Stage();
    private static GridPane paneOfSetting= new GridPane();
    private static Scene sceneOfSetting = new Scene(paneOfSetting,300,300);

     public Game(){//不写，默认的构造方法为public

         // this.game = new Game();

      }
    public String toString(){
         return  username;
    }

      /**
       * Part2  2）	随机方块
       */
    public static void randomBlock() {
        int random = (int) (Math.random() * 6);
        switch (random) {
            case 0:
                currentBlock = new ZBlock();
                break;
            case 1:
                currentBlock = new IBlock();
                break;
            case 2:
                currentBlock = new LBlock();
                break;
            case 3:
                currentBlock = new LLBlock();
                break;
            case 4:
                currentBlock = new OBlock();
                break;
            case 5:
                currentBlock = new TBlock();
                break;
            case 6:
                currentBlock = new SBlock();
                break;
        }

    }


    public static void randomNextBlock() {
        int random = (int) (Math.random() * 6);
        switch (random) {
            case 0:
                nextBlock = new ZBlock();
                break;
            case 1:
                nextBlock = new IBlock();
                break;
            case 2:
                nextBlock = new LBlock();
                break;
            case 3:
                nextBlock = new LLBlock();
                break;
            case 4:
                nextBlock = new OBlock();
                break;
            case 5:
                nextBlock = new TBlock();
                break;
            case 6:
                nextBlock = new SBlock();
                break;
        }

    }



    /**
     * Part 3  基础功能中的建立和显示部分：
     */

    /**打印初始界面
     *
     */

    /**
     * 初始化地图，打印等基本功能
     */


    public static void initial() {//刷新
        for (int i = 0; i <18; i++) {
            for (int j = 0; j < 12; j++) {
                if (map[i][j] != 9)
                    map[i][j] = 0;
            }
        }


    }

    public static void location() {//对应方块和背景
        for (int i = 0; i < currentBlock.rows; i++) {
            for (int j = 0; j < currentBlock.columns; j++) {
                if (currentBlock.getBlock()[i][j] == 1) {
                   map[examBottom(x, y, currentBlock.getBlock()) + i][y + j] = 5;
                    map[x + i][y + j] = 1;

                }
            }
        }
    }
    public static void setting(){
        Label settingButton = new Label();
        settingButton.setText("游戏设置");
        settingButton.setFont(Font.font("Tekton Pro", FontPosture.ITALIC,20));
        settingButton.setTextFill(Color.GOLD);
        settingButton.relocate(480, 540);
        pane.getChildren().add(settingButton);
        settingButton.setOnMouseClicked((MouseEvent e)->{
            paneOfSetting.setAlignment(Pos.CENTER);
            paneOfSetting.setHgap(20);
            paneOfSetting.setVgap(20);
            paneOfSetting.setStyle("-fx-background-image:url('/setting.jpg')");
            stageOfSetting.setTitle("游戏设置");
            Label musicOn = new Label();
            musicOn.setText("继续背景音乐");
            musicOn.setFont(Font.font("Tekton Pro",FontPosture.ITALIC,20));
            musicOn.setTextFill(Color.GOLD);
            musicOn.setOnMouseClicked((MouseEvent f)->{
                Main.bgm.playBgm();
            });
           Label musicOff = new Label();
            musicOff.setText("暂停背景音乐");
            musicOff.setFont(Font.font("Tekton Pro",FontPosture.ITALIC,20));
            musicOff.setTextFill(Color.GOLD);
            musicOff.setOnMouseClicked((MouseEvent f)->{
                Main.bgm.stopBgm();
            });
            Label speed = new Label("音乐音量大小");
            speed.setFont(Font.font("Tekton Pro",FontPosture.ITALIC,20));
            speed.setTextFill(Color.GOLD);

            ScrollBar slSpeed = new ScrollBar();
            slSpeed.setMax(1);
            slSpeed.setMin(0.1);
           slSpeed.setUnitIncrement(0.3);

            slSpeed.valueProperty().addListener
               (ov ->{//slSpeed.valueProperty().bindBidirectional(new SimpleDoubleProperty(second));
                   Main.bgm.setvolume(slSpeed.getValue());

               });

            paneOfSetting.setPadding(new Insets(10,10,10,10));
            paneOfSetting.add(musicOn,0,0);
            paneOfSetting.add(musicOff,0,1);
            paneOfSetting.add(speed,0,2);
            paneOfSetting.add(slSpeed,0,3);
            stageOfSetting.setScene(sceneOfSetting);
            stageOfSetting.setTitle("游戏设置");
            stageOfSetting.show();







        });

    }
    public static void score(){
        ShowScore.setText(""+score);

        ShowScore.setFont(Font.font("Tekton Pro",FontPosture.ITALIC,20));
        ShowScore.setTextFill(Color.GOLD);
        ShowScore.setLayoutY(340);
        ShowScore.setLayoutX(480);
        pane.getChildren().add(ShowScore);

    }
    public static void time() {
       endTime = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        caculateTime = endTime - startTime + previousTime;
        totalTime = sdf.format((caculateTime));
        ShowTime.setText(totalTime);
        ShowTime.setLayoutX(480);
        ShowTime.setLayoutY(480);
        ShowTime.setFont(Font.font("Tekton Pro",FontPosture.ITALIC,20));
        ShowTime.setTextFill(Color.GOLD);
        pane.getChildren().add(ShowTime);


    }
    public static void timeline(double second){
        timeline = new Timeline(new KeyFrame(Duration.seconds(second),event -> {
           // System.out.println(second);

            if (collide(x + 1, y, currentBlock.getBlock(), currentBlock.rows, currentBlock.columns)) {
                x++;

               print();
            } else {

                copy();
                eliminate();
                loadBlock();//生成下一个方块
                print();
            }
        } ));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }
    public static void pause(){
        timeline.pause();
    }
    public static void play(){
        timeline.play(); }






    public static  void start() {

        /**timer = new Timer();

        timer.schedule(new TimerTask() {

            public void run() {
                Platform.runLater(() -> {
                    if (collide(x + 1, y, currentBlock.getBlock(), currentBlock.rows, currentBlock.columns)) {
                        x++;
                        print();
                    } else {
                        copy();
                        eliminate();
                        loadBlock();//生成下一个方块
                        print();
                    }
                });
            }
                },1000,1000);*/
        scene2 = new Scene(pane,656, 656);
        pane.setStyle("-fx-background-image:url('/游戏界面3.0.jpg')");
        gameStage.setTitle("Tetris");
        gameStage.setScene(scene2);
           // timeline(second);
           //timeline.play();
           randomBlock();
           randomNextBlock();
           print();
          // setting();

        scene2.addEventFilter(KEY_PRESSED,new EventHandler<KeyEvent>(){
            public void handle(KeyEvent event){
                switch(event.getCode()){
                    case P:
                        pause();
                        second-=0.1;
                        break;
                    case B:
                        play();
                        break;
                case X:
                x = examBottom(x, y, currentBlock.getBlock());
                copy();
                eliminate();
                loadBlock();
                print();
                break;
                case Q:
                    gameStage.close();
                    timeline.stop();
                    second++;
                    Package packageGame = new Package();
                    packageGame.setMap(map);
                    packageGame.setScore(score);
                    packageGame.setTime(caculateTime);
                    packageGame.setUsername(username);

                    SerDemo demo = new SerDemo();
                    demo.Output(packageGame);
                    demo.Input();
                    Rank gameOver = new Rank();
                    gameOver.username = username;
                    gameOver.score = score;

                    gameOver.read();
                    gameOver.print();
                break;
                case W:
                if (collide(x + 1, y, currentBlock.nextRotatedBlock(), currentBlock.rows, currentBlock.columns)) {
                    currentBlock.block = currentBlock.nextRotatedBlock();

                    print();
               }
                break;
                case A:
                if (collide(x + 1, y - 1, currentBlock.getBlock(), currentBlock.rows, currentBlock.columns)) {
                    y--;


                    print();
               }
                break;
                case D:
               if (collide(x + 1, y + 1, currentBlock.getBlock(), currentBlock.rows, currentBlock.columns)) {
                    y++;

                    print();
                }
                break;
                case S:
                if (collide(x + 1, y, currentBlock.getBlock(), currentBlock.rows, currentBlock.columns)) {
                    x++;
                    print();
                }
                else {
                    copy();
                    eliminate();
                    loadBlock();//生成下一个方块
                    print();
                }
                break;
                default:
             }
            }
        });

           gameStage.show();




    }

    public static void print(){

            Color newColor = new Color(0, 0, 0, 0);
            initial();
            location();
            pane.getChildren().clear();
            setting();

            score();
            time();
            isOver();
        if(isOver()!= true)
       {
        for (int i = 0; i < nextBlock.rows; i++) {
                for (int j = 0; j < nextBlock.columns; j++) {
                    if (nextBlock.getBlock()[i][j] == 1) {
                        ImageView block3 = new ImageView("/gold3.jpg");
                        block3.setFitHeight(25);
                        block3.setFitWidth(25);
                        block3.setX(470 + 25 * j);
                        block3.setY(170 + 25 * i);
                        pane.getChildren().add(block3);
                    } else {
                        Rectangle rectangle1 = new Rectangle(25, 25);
                        rectangle1.setFill(newColor);
                        rectangle1.setX(470 + 25 * j);
                        rectangle1.setY(170 + 25 * i);
                        pane.getChildren().add(rectangle1);
                    }
                }

            }

            for (int i = 0; i < 18; i++) {
                for (int j = 0; j < 12; j++) {
                    if (map[i][j] == 5) {
                        ImageView block1 = new ImageView("/gold3.jpg");
                        block1.setFitHeight(25);
                        block1.setFitWidth(25);
                        block1.setX(60 + 25 * j);
                        block1.setY(100 + 25 * i);
                        pane.getChildren().add(block1);
                        //pane.add(block1, 60+j, 100+i);

                    } else if (map[i][j] == 1 ^ map[i][j] == 9) {

                        ImageView block2 = new ImageView("/blue2.jpg");
                        block2.setFitHeight(25);
                        block2.setFitWidth(25);
                        block2.setX(60 + 25 * j);
                        block2.setY(100 + 25 * i);
                        pane.getChildren().add(block2);
                        //pane.add(block2, 60+j, 100+i);
                    } else if (map[i][j] == 0) {
                        Rectangle rectangle3 = new Rectangle(25, 25);
                        rectangle3.setFill(newColor);
                        rectangle3.setX(60 + 25 * j);
                        rectangle3.setY(100 + 25 * i);
                        pane.getChildren().add(rectangle3);
                    }
                }
            }
        }else {
            gameStage.close();
            timeline.stop();
            Package packageGame = new Package();
            packageGame.setMap(map);
            packageGame.setScore(score);
            packageGame.setTime(caculateTime);
            packageGame.setUsername(username);

            SerDemo demo = new SerDemo();
            demo.Output(packageGame);
            demo.Input();
             Rank gameOver = new Rank();
            gameOver.username = username;
            gameOver.score = score;

          gameOver.read();
          gameOver.print();

        }

    }




    /**
     * Part 4  基础功能中的操作部分
     */


    /*通过isOver()方法判断游戏是否结束
    return:游戏是否结束
     */
    public static boolean isOver() {
        boolean isOver = false;
        for (int j = 0; j < 12; j++) {
            if (map[2][j] == 9) {
                isOver = true;

            }
        }

        return isOver;

    }

    private static boolean collide(int x, int y, int[][] block, int a, int b) {
        boolean judge = true;
       for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (block[i][j] == 1 && (y + j >=12 || y + j < 0 || x + i < 0 || x + i >=18|| map[x + i][y + j] == 9))
                    judge = false;
            }
        }
        return judge;
    }

    public static int examBottom(int x, int y, int[][] currentblock) {
        int bottom;
        for (; x <18; ) {
            if (collide(x+1, y, currentBlock.getBlock(), currentBlock.rows, currentBlock.columns)) {
                x++;
            } else {

                break;
            }
        }
        bottom = x;
        return bottom;
    }




    //到底时把方块的位置拷贝到背景上
    private static void copy() {
        for (int r = x; r < x + currentBlock.rows; r++) {
            for (int c = y; c < y + currentBlock.columns; c++) {
                if (currentBlock.getBlock()[r - x][c - y] == 1)
                    map[r][c] = 9;
            }
        }

    }

    //加载新的方块
    private static void loadBlock() {
        x = 0;
        y = 6;
        currentBlock = nextBlock;

        randomNextBlock();
        currentBlock.initialBlock();

    }

    /*
    当一行满了（all "true")删掉它
     */
    private static void eliminate() {
        int i, j;
        ;//这次操作的得分
            for (i = 0; i < 18; i++) {
            int k = 0;
            for (j = 0; j < 12; j++) {

                if (map[i][j] == 9)
                    k++;
            }
            if (k == 12) {
                scoreThisTime++;
                Music bgm = Music.getInstance();
                bgm.playDeleteSound();
                score += 10 * scoreThisTime;
                for (int m = i; m > 0; m--) {
                    for (int n = 0; n < 12; n++) {
                        map[m][n] = map[m - 1][n];
                    }
                }
                for (int n = 0; n < 12; n++) {
                    map[0][n] = 0;
                }
            }
        }
        if (scoreThisTime != 0) {

        }
    }


}


