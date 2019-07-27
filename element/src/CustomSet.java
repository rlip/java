import org.jetbrains.annotations.Contract;

import java.util.*;

class Person {
    private int id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Person(int id, String name){
        this.id = id;
        this.name = name;
    }

    public String toString(){
        return id + " " + name;
    }

}

public class CustomSet {
    public static void main(String[] args) {

        Person p1 = new Person(3, "Bob");
        Person p2 = new Person(1, "Sue");
        Person p3 = new Person(2, "Mike");
        Person p4 = new Person(3, "Bob");

        Map<Person, Integer> map = new LinkedHashMap<>();

        map.put(p1, 1);
        map.put(p2, 2);
        map.put(p3, 3);
        map.put(p4, 1); // nie może być

        for (Person person: map.keySet()){
            System.out.println(person);
        }

        Set<Person> set = new HashSet<>();
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4); // nie może być

        System.out.println(set);
    }
}
