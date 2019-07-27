import java.util.HashMap;
import java.util.Map;

public class HashMapTut {

    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<>();

        map.put(5, "Five");
        map.put(8, "Eight");
        map.put(4, "Four");
        map.put(2, "Two");
        map.put(2, "Two2"); //override

        String text = map.get(2);

        System.out.println(text);

        for (Map.Entry<Integer, String> entry: map.entrySet()) {
            int key = entry.getKey();
            String value = entry.getValue();

            System.out.println(key + ": " + value); //TO MOŻE SIE WYSWIETLIC W ROZNEJ KOLEJNOSCI
        }
    }
}
