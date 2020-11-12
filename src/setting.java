import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

public class setting {
    private static Stage stageOfSetting = new Stage();
    private static GridPane paneOfSetting= new GridPane();
    private static Scene sceneOfSetting = new Scene(paneOfSetting,200,200);
    public static Label settingButton = new Label();
    public static void setting(){

        settingButton.setText("游戏设置");
        settingButton.setFont(Font.font("Tekton Pro", FontPosture.ITALIC,20));
        settingButton.setTextFill(Color.GOLD);
        settingButton.relocate(500, 540);
        paneOfSetting.setStyle("-fx-background-image:url('/1.jpg')");
        //pane.getChildren().add(settingButton);
        settingButton.setOnMouseClicked((MouseEvent e)->{
            paneOfSetting.setAlignment(Pos.CENTER);
            paneOfSetting.setHgap(20);
            paneOfSetting.setVgap(20);
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
            Label speed = new Label("自动下落时间间隔");
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




}
