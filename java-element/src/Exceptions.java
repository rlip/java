import java.io.IOException;
import java.text.ParseException;

public class Exceptions {
    public static void main(String[] args) {
        Test test = new Test();

        try {
            test.run();
        } catch (IOException | ParseException e) {
            System.out.print("Błąd 12");
            e.printStackTrace();
        }
        //to samo co
        try {
            test.run();
        } catch (IOException e) {
            System.out.print("Błąd 1");
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.print("Błąd 2");
            e.printStackTrace();
        }
        //tak też można
        try {
            test.run();
        } catch (Exception e) {
            System.out.print("Błąd 12 ver 2");
            e.printStackTrace();
        }
        //runtime exception nie trzeba deklarować
    }
}
