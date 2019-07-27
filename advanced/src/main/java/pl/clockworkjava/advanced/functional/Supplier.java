package pl.clockworkjava.advanced.functional;


import pl.clockworkjava.advanced.functional.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Supplier {
    public static void main(String[] args) {


//        Supplier<List<Student>> supplierPredefinedStudents = new Supplier<List<Student>>() {
//            @Override
//            public List<Student> get() {
//                return createData();
//            }
//        };
//        Supplier<List<Student>> supplierPredefinedStudents = () -> createData();
        java.util.function.Supplier<List<Student>> supplierPredefinedStudents = Supplier::createData;

                Predicate<Student> isAnia = student ->  student.getName().equals("Ania");

        Consumer<Student> printStudentName = (student) ->  System.out.println(student.getName());
        Consumer<Student> printStudentNameToUppercase = (student) ->  System.out.println(student.getName().toUpperCase());


        consumeStudents(filterStudents(supplierPredefinedStudents, isAnia), printStudentName.andThen(printStudentNameToUppercase));
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

    private static List<Student> filterStudents(java.util.function.Supplier<List<Student>> supplier, Predicate<Student> predicate) {
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
