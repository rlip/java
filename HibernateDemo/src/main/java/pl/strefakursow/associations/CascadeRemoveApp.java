package pl.strefakursow.associations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.strefakursow.associations.entity.Company;
import pl.strefakursow.associations.entity.CompanyDetail;


public class CascadeRemoveApp {

    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Company.class);
        conf.addAnnotatedClass(CompanyDetail.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        run(session);

        factory.close();
    }

    static private void run(Session session) {
        Company company = session.get(Company.class, 7);

        session.remove(company);
        session.getTransaction().commit();
    }
}
