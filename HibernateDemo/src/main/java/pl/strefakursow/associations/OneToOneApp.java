package pl.strefakursow.associations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.strefakursow.associations.entity.CompanyDetail;
import pl.strefakursow.associations.entity.Company;


public class OneToOneApp {

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
        Company company = new Company("StrefaKursów", 100000);
        CompanyDetail detail = new CompanyDetail("Poland", 150);
        company.setCompanyDetail(detail);

        session.save(detail);
        session.save(company);
        session.getTransaction().commit();
    }
}
