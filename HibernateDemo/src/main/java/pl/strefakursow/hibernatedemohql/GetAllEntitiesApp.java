package pl.strefakursow.hibernatedemohql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.strefakursow.hibernatedemo.entity.Employee;

import java.util.List;

public class GetAllEntitiesApp {
    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        fromExample(session);
//        selectExample(session);

        factory.close();
    }

    static private void fromExample(Session session) {

        String from = "from Employee where firstName = :name";
//        String from = "from pl.strefakursow.hibernatedemo.entity.Employee"; // tak też można

        Query query = session.createQuery(from);
        query.setParameter("name", "Ellen");
        List<Employee> resultList = query.getResultList(); //setSingleResult
        session.getTransaction().commit();


        for (Employee employee : resultList) {
            System.out.println(employee);
        }
    }

    private static void selectExample(Session session) {
        List<Object[]> resultList = session.createQuery("select firstName, lastName from Employee").getResultList();
        session.getTransaction().commit();

        for (Object[] result : resultList) {
            System.out.println(result[0] + " " + result[1]);
        }
    }
}
