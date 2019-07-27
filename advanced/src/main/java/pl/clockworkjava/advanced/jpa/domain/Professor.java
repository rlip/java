package pl.clockworkjava.advanced.jpa.domain;

import javax.persistence.*;

@Entity
public class Professor {

    @Id
    private int id;

    @Column(name = "imie", nullable = false)
    private String name;

    @Embedded
    private Address address;

    public Professor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private Professor() {
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
