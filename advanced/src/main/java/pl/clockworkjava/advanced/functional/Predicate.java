package pl.clockworkjava.advanced.functional;


import pl.clockworkjava.advanced.functional.domain.Student;

import java.util.ArrayList;
import java.util.List;

public class Predicate {
    public static void main(String[] args) {

        List<Student> students = createData();

        java.util.function.Predicate<Student> isAniaLongVersion = new java.util.function.Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getName().equals("Ania");
            }
        };

        java.util.function.Predicate<Student> isAnia = student ->  student.getName().equals("Ania");
        java.util.function.Predicate<Student> isUnder30 = student ->  student.getAge() < 30;

        java.util.function.Predicate<Student> isAniaAndUnder30 = isAnia.and(isUnder30);
        java.util.function.Predicate<Student> isAniaORUnder30 = isAnia.or(isUnder30);
        java.util.function.Predicate<Student> isNotAnia = isAnia.negate();


        List<Student> x = filterStudents(students, isNotAnia);
        System.out.println(students);
        System.out.println(x);
    }

    private static List<Student> filterStudents(List<Student> students, java.util.function.Predicate<Student> predicate) {
        List<Student> result = new ArrayList<>();

        for (Student student : students) {
            if(predicate.test(student)){
                result.add(student);
            }
        }
        return result;
    }

    private static List<Student> createData() {
        List<Student> result = new ArrayList<>();

        result.add(new Student("Aga", 26, "123"));
        result.add(new Student("Ania", 26, "123"));
        result.add(new Student("Paulina", 25, "123"));

        return result;
    }
}
