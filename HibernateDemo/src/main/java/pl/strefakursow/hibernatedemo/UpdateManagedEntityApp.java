package pl.strefakursow.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.strefakursow.hibernatedemo.entity.Employee;

public class UpdateManagedEntityApp {
    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Employee employee = session.get(Employee.class, 9);
        employee.setFirstName("Tadeusz");

        session.getTransaction().commit();


        System.out.println("Dane pracownika: " + employee);

        factory.close();
    }
}
