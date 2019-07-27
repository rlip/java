import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortedMap {
    public static void main(String[] args) {
        /* HashMap można zamiast interfejsu */ Map<Integer, String> hashMap = new HashMap<>(); //nie gwarantuje kolejności
        /* LinkedHashMap*/ Map<Integer, String> linkedHashMap = new LinkedHashMap<>(); // zostają w tej samej kolejności - kolejności zadeklarowania
        /* TreeMap */ Map<Integer, String> treeMap = new TreeMap<>(); // sortuje klucze w naturalnej kolejności

        testMap(treeMap);
    }

    public static void testMap(Map<Integer, String> map) {
        map.put(9, "fox");
        map.put(4, "cat");
        map.put(8, "dog");
        map.put(1, "giraffe");
        map.put(0, "swan");
        map.put(15, "beer");
        map.put(6, "snake");
//        map.put(6, "snake"); nie mogą być 2 te same

        for(Integer key: map.keySet()) {
            String value = map.get(key);

            System.out.println(key + ": " + value);
        }
    }
}
