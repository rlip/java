class Temp implements AutoCloseable {
    public void close() throws  Exception {
        System.out.println("Closing!");
        throw new Exception("oh no");
    }
}


public class AutoClose {
    public static void main(String[] args) {


        try(Temp temp = new Temp()) { // jak się implementuje AutoCloseable to można też tak

        } catch (Exception e) {
            e.printStackTrace();
        }

//        try {
//            temp.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
