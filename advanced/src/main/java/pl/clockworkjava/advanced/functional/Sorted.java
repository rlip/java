package pl.clockworkjava.advanced.functional;


import pl.clockworkjava.advanced.functional.domain.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Sorted {
    public static void main(String[] args) {

        createDataStream().sorted(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        }).map(Student::getName).forEach(System.out::println);
    }


    private static void consumeStudents(List<Student> students, Consumer<Student> consumer) {
        for (Student student : students) {
            consumer.accept(student);
        }
    }

    private static Stream<Student> createDataStream() {
        Student aga = new Student("Aga", 26, "123");
        Student ania = new Student("Ania", 26, "123");
        Student anka = new Student("Anka", 27, "123");
        Student paulina = new Student("Paulina", 25, "123");
        return Stream.of(aga,ania,anka,paulina);
    }


    private static List<Student> filterStudents(List<Student> students, Predicate<Student> predicate) {
        List<Student> result = new ArrayList<>();

        for (Student student : students) {
            if(predicate.test(student)){
                result.add(student);
            }
        }
        return result;
    }





}
