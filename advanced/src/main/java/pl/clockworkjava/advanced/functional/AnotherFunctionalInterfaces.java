package pl.clockworkjava.advanced.functional;


import pl.clockworkjava.advanced.functional.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.*;

public class AnotherFunctionalInterfaces {
    public static void main(String[] args) {


        Predicate<Student> isAnia = student ->  student.getName().equals("Ania");
        Supplier<List<Student>> supplierPredefinedStudents = AnotherFunctionalInterfaces::createData;

        Function<Student,String> getStudentName = new Function<Student, String>() {
            @Override
            public String apply(Student student) {
                return student.getName();
            }
        };

        Consumer<String> printText = (text) ->  System.out.println(text);

        BiFunction<String, Student, Integer> bifunction = new BiFunction<String, Student, Integer>() {
            @Override
            public Integer apply(String s, Student student) {
                return null;
            }
        };

        BinaryOperator<Student> binaryOperator = new BinaryOperator<Student>() {
            @Override
            public Student apply(Student student, Student student2) {
                return null;
            }
        };

        IntPredicate intPredicate = new IntPredicate() {
            @Override
            public boolean test(int value) {
                return false;
            }
        };


        consumeStudents(filterStudents(supplierPredefinedStudents, isAnia), getStudentName, printText);
    }

    private static void consumeStudents(List<Student> students, Function<Student,String> function, Consumer<String> consumer) {
        for (Student student : students) {
            consumer.accept(function.apply(student));
        }
    }

    private static List<Student> createData() {
        List<Student> result = new ArrayList<>();

        result.add(new Student("Aga", 26, "123"));
        result.add(new Student("Ania", 26, "123"));
        result.add(new Student("Paulina", 25, "123"));

        return result;
    }

    private static List<Student> filterStudents(Supplier<List<Student>> supplier, Predicate<Student> predicate) {
        List<Student> result = new ArrayList<>();
        List<Student> students = supplier.get();

        for (Student student : students) {
            if(predicate.test(student)){
                result.add(student);
            }
        }
        return result;
    }

}
