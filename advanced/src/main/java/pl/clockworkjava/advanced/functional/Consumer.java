package pl.clockworkjava.advanced.functional;


import pl.clockworkjava.advanced.functional.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Consumer {
    public static void main(String[] args) {

        List<Student> students = createData();

//        Consumer<Student> consumer = new Consumer<Student>() {
//            @Override
//            public void accept(Student student) {
//                System.out.println(student.getName());
//            }
//        };
        Predicate<Student> isAnia = student ->  student.getName().equals("Ania");

        java.util.function.Consumer<Student> printStudentName = (student) ->  System.out.println(student.getName());
        java.util.function.Consumer<Student> printStudentNameToUppercase = (student) ->  System.out.println(student.getName().toUpperCase());


        consumeStudents(filterStudents(students, isAnia), printStudentName.andThen(printStudentNameToUppercase));
//        System.out.println(students);
    }

    private static void consumeStudents(List<Student> students, java.util.function.Consumer<Student> consumer) {
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
