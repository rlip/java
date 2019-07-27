package pl.clockworkjava.advanced.functional.domain;


import java.util.Optional;

final public class Student {

    private String name;
    private Integer age;

    private Index index;

    public Student(String name, Integer age, String indexNumber) {
        this.name = name;
        this.age = age;
        this.index = new Index(indexNumber);
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Optional<Index> getIndex() {
        return Optional.ofNullable(index);
    }

    public Student changeIndexNumber(String newIndexNumber) {
        return new Student(this.name, this.age, newIndexNumber);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", index=" + index +
                '}';
    }
}

