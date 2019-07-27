package pl.clockworkjava.advanced.functional;


import pl.clockworkjava.advanced.functional.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SteamEx {
    public static void main(String[] args) {
        List<Student> students = createData();

        Supplier<List<Student>> supplier = () -> createData();
        Supplier<List<Student>> supplier2 = SteamEx::createData;

//        Consumer<Student> consumer = new Consumer<Student>() {
//            @Override
//            public void accept(Student student) {
//                System.out.println(student.getName());
//            }
//        };
        Predicate<Student> isAnia = student ->  student.getName().equals("Ania");

        Consumer<String> print = (str) ->  System.out.println(str);
        Consumer<Student> printStudentName = (student) ->  System.out.println(student.getName());
        Consumer<Student> printStudentNameToUppercase = (student) ->  System.out.println(student.getName().toUpperCase());

        Function<Student,String> getStudentName = new Function<Student, String>() {
            @Override
            public String apply(Student student) {
                return student.getName();
            }
        };


        consumeStudents(filterStudents(students, isAnia), printStudentName.andThen(printStudentNameToUppercase));

        students.stream().filter(isAnia).map(getStudentName).forEach(print);

        Stream<List<Student>> stream = Stream.generate(supplier2);

        Stream.generate(() -> Math.random()).limit(10).forEach((v) -> System.out.println(v));
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

        Stream.iterate(0, i->i+2).limit(20).forEach(System.out::println);

    }


    private static void consumeStudents(List<Student> students, Consumer<Student> consumer) {
        for (Student student : students) {
            consumer.accept(student);
        }
    }

    private static List<Student> createData() {
        List<Student> result = new ArrayList<>();

        result.add(new Student("Aga", 26, "123"));
        result.add(new Student("Ania", 26, "123"));
        result.add(new Student("Paulina", 25, "123"));

        return result;
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
