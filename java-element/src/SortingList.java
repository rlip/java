import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

class Person2 {
    private int id;
    private String name;

    public Person2(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return id + ": " + name;
    }
}


class StringLengthComparator implements Comparator<String> {

    public int compare(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        return Integer.compare(len1, len2);
// to co       if(len1 > len2){
//            return 1;
//        }
//        if(len1 < len2){
//            return -1;
//        }
//        return 0;
    }
}
class ReverseAlphabeticalComparator implements Comparator<String> {

    public int compare(String s1, String s2) {
        return -s1.compareTo(s2);
    }
}

public class SortingList {
    public static void main(String[] args) {

        //////////////////////////////// sorting strings
        List<String> animals = new ArrayList<>();

        animals.add("cat");
        animals.add("elephant");
        animals.add("tiger");
        animals.add("lion");
        animals.add("snake");
        animals.add("mongoose");

        animals.sort(new StringLengthComparator()); // można przez klasę, ale można też anonimowo -> jak w liczbach
        animals.sort(new ReverseAlphabeticalComparator());

        for(String animal: animals){
            System.out.println(animal);
        }

        /////////sorting numbers
        List<Integer> numbers = new ArrayList<>();

        numbers.add(3);
        numbers.add(36);
        numbers.add(73);
        numbers.add(40);
        numbers.add(1);

//        Collections.sort(numbers);
        //Collections.sort to co numbers.sort

        numbers.sort(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2){
                return -num1.compareTo(num2);
            }
        });
        //to co
        numbers.sort((num1, num2) -> -num1.compareTo(num2));

        for(Integer number: numbers){
            System.out.println(number);
        }

        ///////////////sorting objects

        List <Person2> people = new ArrayList<>();

        people.add(new Person2(1, "Joe"));
        people.add(new Person2(2, "Sue"));
        people.add(new Person2(3, "Clare"));
        people.add(new Person2(4, "Bob"));

        people.sort(new Comparator<Person2>(){
            public int compare(Person2 p1, Person2 p2) {
//                if(p1.getId() > p2.getId()) {
//                    return 1;
//                }
//                if (p1.getId() < p2.getId()) {
//                    return -1;
//                }
//                return 0;
                return Integer.compare(p1.getId(), p2.getId());
            }
        });
        //to samo co
//        people.sort((p1, p2) -> Integer.compare(p1.getId(), p2.getId()));
        //to samo co
//        people.sort(Comparator.comparingInt(Person2::getId));

        for(Person2 person: people){
            System.out.println(person);
        }
    }
}
