package pl.strefakursow.associations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.strefakursow.associations.entity.*;
import pl.strefakursow.hibernatedemo.entity.Employee;


public class ManyToManyApp {

    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Company.class);
        conf.addAnnotatedClass(CompanyDetail.class);
        conf.addAnnotatedClass(Property.class);
        conf.addAnnotatedClass(Department.class);
        conf.addAnnotatedClass(Employee.class);
        conf.addAnnotatedClass(Training.class);
        SessionFactory factory = conf.buildSessionFactory();


        run(factory);

        factory.close();
    }

    static private void run(SessionFactory factory) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Company company = session.get(Company.class, 7);

        Training training = new  Training("sales training");
//        Property property1 = new Property("Warszawa", 40);
//        Property property2 = new Property("Gdynia", 30);

//        company.addProperty(property1);
//        company.addProperty(property2);
//
//        session.persist(company);

        session.getTransaction().commit();

        session = factory.getCurrentSession();
        session.beginTransaction();
        Company mergedCompany = (Company) session.merge(company);

        System.out.println(company);
        for (Property property: mergedCompany.getProperties()){
            System.out.println(property);
        }

        session.getTransaction().commit();
    }

}
