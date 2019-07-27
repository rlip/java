package pl.clockworkjava.advanced.functional;


import pl.clockworkjava.advanced.functional.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Reduce {
    public static void main(String[] args) {

        Double reduce = Stream.generate(Math::random).limit(10).reduce(0.0, new BinaryOperator<Double>() {
            @Override
            public Double apply(Double aDouble, Double aDouble2) {
                return aDouble + aDouble2;
            }
        });
        Double reduce2 = Stream.generate(Math::random).limit(10).reduce(0.0,Double::sum);

        System.out.println(reduce2);

        Student odlest = createDataStream().reduce(new Student("aa", 0, null), new BinaryOperator<Student>() {
            @Override
            public Student apply(Student s1, Student s2) {
                return s1.getAge() > s2.getAge() ? s1 : s2;
            }
        });

        System.out.println(odlest);


        createDataStream().map(student -> student.getAge())
//                .reduce( (a1, a2) -> a1 > a2 ? a1 : a2) // to samo co
                .reduce(Integer::max)
                .ifPresent(System.out::println);

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
