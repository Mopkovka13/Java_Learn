package hibetnate_test2;

import hibetnate_test2.entity.Detail;
import hibetnate_test2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveBiConnection {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // Писать не обязательно, если название не менялось
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();;
        try {
            Employee employee = new Employee("Egor", "Ilyushkin",
                    "QA", 2000);

            Detail detail = new Detail("Volgograd", "9047791234", "evil_egor@gmail.com");

            employee.setEmpDetail(detail);
            detail.setEmployee(employee);

            session.beginTransaction();
            session.save(detail);
            session.getTransaction().commit();

            System.out.println("New employee created: " + employee);
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
