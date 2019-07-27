package pl.clockworkjava.advanced.functional;


import pl.clockworkjava.advanced.functional.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MapForEach {
    public static void main(String[] args) {
        Predicate<Student> over25 = student -> student.getAge() > 25;
        Consumer<String> print = System.out::println;
        Function<Student, String> getNameFunction = Student::getName;

        Stream<Student> stream = createDataStream();
//        stream
//                .filter(student -> student.getAge() > 25)
//                .filter((student) -> student.getName().equals("Ania"))
//                .map(student -> student.getName())
//                .forEach(print);

        stream
                .map(student -> student.getIndex())
                .filter(optionalIndex -> optionalIndex.isPresent())
                .map(optionalInddex -> optionalInddex.get())
                .map(index -> index.getName())
                .forEach(System.out::println);
    }


    private static void consumeStudents(List<Student> students, Consumer<Student> consumer) {
        for (Student student : students) {
            consumer.accept(student);
        }
    }

    private static Stream<Student> createDataStream() {
        Student aga = new Student("Aga", 26, "123");
        Student ania = new Student("Ania", 26, "123");
        Student paulina = new Student("Paulina", 25, "123");
        return Stream.of(aga,ania,paulina);
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
