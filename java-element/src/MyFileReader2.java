import java.io.*;

public class MyFileReader2 {

    public static void main(String[] args){
        File textFile = new File("file.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(textFile))){
        } catch (FileNotFoundException e) {
            System.out.println("błąd");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("błąd2");
            e.printStackTrace();
        }


    }
}
