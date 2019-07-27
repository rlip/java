import java.util.ArrayList;

public class ArrayListTut {
    public static void main(String[] args) {
        java.util.ArrayList<Integer> numbers = new java.util.ArrayList<>();
        numbers.add(10);
        numbers.add(100);
        numbers.add(40);

        int a; // primitive type
        Integer b; //class

        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        numbers.remove(numbers.size() - 1);
        //this is slow
        numbers.remove(0);

        //można też tak
        for (Integer value: numbers) {
            System.out.println(value);
        }

    }
}
