import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;

public class Rule {
    static Text ruleText1 = new Text(20,20,"游戏规则:");
    static Text ruleText2 = new Text(20,40,"键盘操作");
    static Text ruleText3 = new Text(20,60,"a:左移    d:右移");
    static  Text ruleText4 = new Text(20,80,"w:旋转     s:下落");
   static  Text ruleText5 = new Text(20,100,"q:退出    x：落底") ;
   static Text ruleText6 = new Text(20,120,"p:暂停     b：开始");
   static Text ruleText7 = new Text(20,140,"每一次暂停，下落速度增加");
    public static void showrule(){

        ruleText1.setFont(Font.font("Tekton Pro", FontPosture.ITALIC,20));

        ruleText2.setFont(Font.font("Tekton Pro",FontPosture.ITALIC,18));

        ruleText3.setFont(Font.font("Tekton Pro",FontPosture.ITALIC,18));

        ruleText4.setFont(Font.font("Tekton Pro",FontPosture.ITALIC,18));

        ruleText5.setFont(Font.font("Tekton Pro",FontPosture.ITALIC,18));

        ruleText6.setFont(Font.font("Tekton Pro",FontPosture.ITALIC,18));

        ruleText7.setFont(Font.font("Tekton Pro",FontPosture.ITALIC,18));

    }
}
