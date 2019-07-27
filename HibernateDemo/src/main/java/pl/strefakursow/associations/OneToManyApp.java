package pl.strefakursow.associations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.strefakursow.associations.entity.Company;
import pl.strefakursow.associations.entity.CompanyDetail;
import pl.strefakursow.associations.entity.Department;
import pl.strefakursow.associations.entity.Property;


public class OneToManyApp {

    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Company.class);
        conf.addAnnotatedClass(CompanyDetail.class);
        conf.addAnnotatedClass(Property.class);
        conf.addAnnotatedClass(Department.class);
        SessionFactory factory = conf.buildSessionFactory();


//        run(factory);
        run2(factory);

        factory.close();
    }

    static private void run(SessionFactory factory) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Company company = session.get(Company.class, 7);
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


    static private void run2(SessionFactory factory) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Company company = session.get(Company.class, 7);

        Department department1 = new Department("sales");
        Department department2 = new Department("sales");
        Department department3 = new Department("sales");

        company.addDepartment(department1);
        company.addDepartment(department2);
        company.addDepartment(department3);

        session.persist(company);

        session.getTransaction().commit();

        session = factory.getCurrentSession();
        session.beginTransaction();
        Company mergedCompany = (Company) session.merge(company);

        System.out.println(company);
        for (Department department: mergedCompany.getDepartments()){
            System.out.println(department);
        }

        session.getTransaction().commit();
    }
}
