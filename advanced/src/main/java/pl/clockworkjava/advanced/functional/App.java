package pl.clockworkjava.advanced.functional;


import pl.clockworkjava.advanced.functional.domain.Index;
import pl.clockworkjava.advanced.functional.domain.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class App {
    public static void main(String[] args) {

        createDataStream().map(Student::getAge).mapToInt(new ToIntFunction<Integer>() {
            @Override
            public int applyAsInt(Integer value) {
                return value + 1;
            }
        }).forEach(System.out::println);
    }


    private static void consumeStudents(List<Student> students, java.util.function.Consumer<Student> consumer) {
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
