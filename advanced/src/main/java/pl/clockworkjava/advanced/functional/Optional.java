package pl.clockworkjava.advanced.functional;


import pl.clockworkjava.advanced.functional.domain.Index;
import pl.clockworkjava.advanced.functional.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Optional {
    public static void main(String[] args) {
        Supplier<List<Student>> supplierPredefinedStudents = Optional::createData;

        Student student =  supplierPredefinedStudents.get().get(0);

        java.util.Optional<Index> index = student.getIndex();

        if(index.isPresent()) {
            if(index.get().getName().equals("1234")){

            }
        }
        index.filter(new Predicate<Index>() {
            @Override
            public boolean test(Index idx) {
                return idx.getName().equals("1234");
            }
        });

        index.filter(idx -> idx.getName().equals("1234")).ifPresent(new Consumer<Index>() {
            @Override
            public void accept(Index index) {
                System.out.println("Znalazłem");
            }
        });


        index.ifPresent(new Consumer<Index>() {
            @Override
            public void accept(Index index) {
                System.out.println(index.getName());
            }
        });
        index.ifPresent((idx) -> System.out.println(idx.getName()));

        index.map(i -> i.getName()).filter(iName -> iName.equals("111")).ifPresent(indexNr -> System.out.println(indexNr));


        Index aa = index.orElse(new Index("aa")); // zwraca index, a jeśli nie ma to nowy index
        Index aa2 = index.orElseGet(new Supplier<Index>() { // zwraca index, a jeśli go nie ma to zwraca suppliera
            @Override
            public Index get() {
                return null;
            }
        });

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
