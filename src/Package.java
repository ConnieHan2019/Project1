import java.io.*;

public class Package  implements Serializable {
    int score;
    int[][]map;
    String username;
    long time;
    public void Package(String username, long time, int score,int[][]map){
        this.time = time;
        this.score = score;
        this.map = map;
        this.username = username;
    }
   public void setUsername(String username){
       this.username = username;
   }
   public void setScore(int score){
   this.score = score; }
   public void setMap(int[][]map){
       this.map = map;
   }
   public void setTime(long time){
       this.time  = time;
   }

   public String getUsername(){
        return username;
    }
    public int getScore(){
        return score;
    }
    public int[][]getMap(){
        return map;
    }
    public long  getTime(){
        return time;
    }

}
