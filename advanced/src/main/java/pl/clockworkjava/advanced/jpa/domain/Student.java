package pl.clockworkjava.advanced.jpa.domain;

import javax.persistence.*;

@Entity
@NamedQueries({
@NamedQuery(name="Student.getAll", query= "Select s From Student s"),
@NamedQuery(name="Student.byName", query= "Select s From Student s where s.name = :name"),
})
public class Student {

    @Id
    private int id;

    @Column(name = "imie", nullable = false)
    private String name;

    @Transient
    private String telephone;

    @Embedded
    private Address address;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
