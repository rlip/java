package pl.clockworkjava.advanced.jpa;

import pl.clockworkjava.advanced.jpa.domain.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class JPAApp {

    static EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistence");
    static EntityManager entityManager = factory.createEntityManager();

    public static void main(String[] args) {
        //CRUD
        //Create
        createStudent();

        //Read
        readStudents();
        readStudent();

        //Update
        updateStudent();

        //Delete
     //   deleteStudent();

        //namedQueries
        namedQuery();


    }

    private static void namedQuery() {
        System.out.println("getAll ");
        entityManager.createNamedQuery("Student.getAll", Student.class).getResultList().forEach(System.out::println);
    }

    private static void deleteStudent() {
        Student student = entityManager.find(Student.class, 0);
        entityManager.getTransaction().begin();
        entityManager.remove(student);
        entityManager.getTransaction().commit();

        System.out.println("Po usunięciu: ");
        readStudents();
    }

    private static void updateStudent() {
        Student student = entityManager.find(Student.class, 0);
        student.setName("Agusia");

        entityManager.getTransaction().begin();
        entityManager.merge(student);
        entityManager.getTransaction().commit();

        readStudents();
    }

    private static void readStudent() {
        Student student = entityManager.find(Student.class, 0);
        System.out.println("Studentka: " + student);
    }

    private static void readStudents() {
        Query query = entityManager.createQuery("from Student");
        List<Student> resultList = query.getResultList();
        System.out.println(resultList.get(0).getName());
        resultList.forEach(System.out::println);
    }

    private static void createStudent() {

        Student aga = new Student(0, "Aga");
        Student ania = new Student(1, "Ania");

        entityManager.getTransaction().begin();
        entityManager.persist(aga);
        entityManager.persist(ania);
        entityManager.getTransaction().commit();
    }
}
