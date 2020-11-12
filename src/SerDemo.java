import java.io.*;

public class SerDemo {
    static String username ;
    static long time;
    static int score;
    static int[][]map;
    public static void Output(Package newpackage) {
        File f = new File("store.txt");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
            oos.writeObject(newpackage);

        } catch (FileNotFoundException e1) {
        }catch(IOException e2){
        }
    }

      public static void Input(){
          File f = new File("store.txt");
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))){

        Package readPackage = (Package) ois.readObject();
        username = readPackage.getUsername();
        score = readPackage.getScore();
      map = readPackage.getMap();
      time = readPackage.getTime();


        }catch(FileNotFoundException e3){

        }catch(IOException e4){

        }catch(ClassNotFoundException e5){

        }

    }

}
