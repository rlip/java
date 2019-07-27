import java.io.*;
import java.util.Scanner;

public class MyFileReader {

    public static void main(String[] args) /* throws FileNotFoundException //to można zamiast */ {
//        String filename = "D:/p/java/src/file.txt";
        String filename = "file.txt";

        File textFile = new File(filename);
        try {
            Scanner in = new Scanner(textFile);
            System.out.println("aa" + in.nextInt());
            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
            }
            in.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Nie znaleziono pliku");
            ex.printStackTrace();
        }

        BufferedReader br = null;

        try {
            FileReader fr = new FileReader(textFile);
            br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }


        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku" + filename);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Nie można odczytać pliku" + filename);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                System.out.println("Unable to close" + filename);
            }
        }


    }
}
