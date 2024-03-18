package hibetnate_test2;

import hibetnate_test2.entity.Detail;
import hibetnate_test2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Get {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // Писать не обязательно, если название не менялось
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();;
        try {
            session.beginTransaction();
            Employee employee = session.get(Employee.class, 2);
            session.getTransaction().commit();

            System.out.println("New employee created: " + employee);
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
