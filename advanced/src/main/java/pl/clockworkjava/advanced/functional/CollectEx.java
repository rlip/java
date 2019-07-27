package pl.clockworkjava.advanced.functional;


import pl.clockworkjava.advanced.functional.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class CollectEx {
    public static void main(String[] args) {

        List<Integer> agesList = createDataStream().map(student -> student.getAge()).collect(Collectors.toList());
        String agesString = createDataStream().map(student -> student.getAge()).map(age -> age.toString()).collect(Collectors.joining(", "));
        System.out.println(agesString);

        Map<Integer, List<Student>> studentsByAgeMap = createDataStream().collect(groupingBy(Student::getAge));
        studentsByAgeMap.forEach(new BiConsumer<Integer, List<Student>>() {
            @Override
            public void accept(Integer integer, List<Student> students) {
                System.out.println(integer.toString() + ":");
                students.stream().map(Student::getName).forEach(System.out::println);
            }
        });
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
