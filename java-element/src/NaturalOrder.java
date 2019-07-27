import java.util.*;

class Person3 implements Comparable<Person3> {
    private String name;

    public Person3(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person3 person){
//        return -name.compareTo(person.name);

        int len1 = name.length();
        int len2 = person.name.length();

//        return Integer.compare(len1, len2);

        if(len1 > len2) {
            return 1;
        }
        if(len1 < len2){
            return -1;
        }
//        return 0;
        return name.compareTo(person.name);
    }

    @Override
    public String toString() {
        return name;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Person3 person3 = (Person3) o;
//
//        return name != null ? name.equals(person3.name) : person3.name == null;
//    }
//
//    @Override
//    public int hashCode() {
//        return name != null ? name.hashCode() : 0;
//    }
}

public class NaturalOrder {
    public static void main(String[] args) {
        List<Person3> list = new ArrayList<>();

        SortedSet<Person3> set = new TreeSet<>();

        addElements(list);
        addElements(set);
        Collections.sort(list);

        showElements(list);
        System.out.println();
        showElements(set);

    }

    private static void addElements(Collection<Person3> col) {
        col.add(new Person3("Joe"));
        col.add(new Person3("Sue"));
        col.add(new Person3("Juliet"));
        col.add(new Person3("Clare"));
        col.add(new Person3("Mike"));
    }

    private static void showElements(Collection<Person3> col) {
        for (Person3 el : col) {
            System.out.println(el);
        }
    }
}
