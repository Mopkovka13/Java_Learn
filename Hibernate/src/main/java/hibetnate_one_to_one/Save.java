package hibetnate_one_to_one;

import hibetnate_one_to_one.entity.Detail;
import hibetnate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Save {
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

            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();

            System.out.println("New employee created: " + employee);
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
