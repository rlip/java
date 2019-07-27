import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListLinkedList {
    public static void main(String[] args) {
        /*
         *
         * Arraylist manage arrays internally [0][1][2][3]...
         *
         * LinkedList consists of element where c=each element has reference to previous and next element
         */
        ArrayList<Integer> arrayList = new ArrayList<>(); //tylko jeśli chcemy usuwać elementy z końca, bo wtedy to krótko trwa
        LinkedList<Integer> linkedList = new LinkedList<>();

        doTimings("ArrayList", arrayList);
        doTimings("LinkedList", linkedList);
    }

    private static void doTimings(String type, List<Integer> list) {

        for (int i = 0; i < 1E5; i++) {
            list.add(i);
        }

        long start = System.currentTimeMillis();

        //add at the and of list
//        for (int i = 0; i < 1E5; i++) {
//            list.add(i);
//        }

        //add items elsewhere in the list
        for (int i = 0; i < 1E5; i++) {
            list.add(0, i);
        }
        long end = System.currentTimeMillis();

        System.out.println("Time taken: " + (end - start) + " ms for " + type);
    }
}
