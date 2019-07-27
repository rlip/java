import java.util.Iterator;
import java.util.LinkedList;

public class IteratorMy {

    public static void main(String[] args) {

        LinkedList<String> animals = new LinkedList<>();
        animals.add("fox");
        animals.add("cat");
        animals.add("dog");
        animals.add("rabbit");

        Iterator<String> it = animals.iterator();

        while(it.hasNext()) {
            String value = it.next();
            System.out.println(value);
        }

        //to co:

        for(String animal: animals){
            System.out.println(animal);
        }

    }
}
