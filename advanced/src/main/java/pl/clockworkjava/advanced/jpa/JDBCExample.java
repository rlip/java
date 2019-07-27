package pl.clockworkjava.advanced.jpa;

import pl.clockworkjava.advanced.jpa.domain.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCExample {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        createTableForStudent();
        Student aga = new Student(1, "Aga");
        Student ania = new Student(2, "Ania");
        insertStudent(aga);
        insertStudent(ania);

        List<Student> students = getStudents();
        students.forEach(System.out::println);
    }



    public static void createTableForStudent() throws SQLException, ClassNotFoundException {
        Connection connection = H2Configuration.getDBConnection();

        Statement statement = connection.createStatement();

        String crateTable = "CREATE TABLE STUDENT(id int primary key, name varchar(255))";

        statement.execute(crateTable);
    }

    private static void insertStudent(Student student) throws SQLException, ClassNotFoundException {
        Connection connection = H2Configuration.getDBConnection();

        Statement statement = connection.createStatement();

        String insert = "INSERT INTO STUDENT VALUES(" + student.getId() + ",'" + student.getName() + "')";

        statement.execute(insert);
    }

    private static List<Student> getStudents() throws SQLException, ClassNotFoundException {
        List<Student> students = new ArrayList<>();

        Connection connection = H2Configuration.getDBConnection();

        Statement statement = connection.createStatement();

        String select = "SELECT * FROM STUDENT";


        ResultSet resultSet = statement.executeQuery(select);

        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");

            students.add(new Student(id, name));
        }

        return students;
    }
}
