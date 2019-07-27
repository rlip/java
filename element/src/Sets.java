import java.util.HashSet; //tylko unikalne elementy
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sets {
    public static void main(String[] args) {

        //HashSet does not retain order - najlepiej go używać, bo jest najlżejszy
//        Set<String> set1 = new HashSet<String>();

        //remembers the order
//        Set<String> set1 = new LinkedHashSet<String>();

        //natural order
        Set<String> set1 = new TreeSet<>();

        if(set1.isEmpty()){
            System.out.println("Set 1 is empty");
        }

        set1.add("dog");
        set1.add("cat");
        set1.add("mouse");
        set1.add("snake");
        set1.add("bear");

        set1.add("bear"); // nie doda się

        System.out.println(set1);

        // iteration

        for(String element: set1){
            System.out.println(element);
        }
        // Does set contain a given item
        if(set1.contains("addrvark")){
            System.out.println("Contains addrvark");
        }
        if(set1.contains("cat")){
            System.out.println("Contains cat");
        }

        Set<String> set2 = new TreeSet<>();

        set2.add("dog");
        set2.add("cat");
        set2.add("giraffe");
        set2.add("monkey");
        set2.add("ant");
        /// intersection
        Set<String> intersection = new HashSet<>(set1);

        System.out.println(intersection);
        intersection.retainAll(set2); // usuń z set1, te które nie sią w set2
        System.out.println(intersection);

        //difference
        Set<String> difference = new HashSet<>(set1);
        difference.removeAll(set2); // usuń z set1, te które są w set2
        System.out.println(difference);
    }
}
