package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Update {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // Писать не обязательно, если название не менялось
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            // Создаем запись в базе
            Session session = factory.getCurrentSession(); // Создаем сессию подключения к базе

            session.beginTransaction();

            // case 1
            //Employee employee = session.get(Employee.class, 1);
            //employee.setSalary(1500);

            // case 2
            session.createQuery("update Employee set salary = 2500 where id = 1").executeUpdate();

            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }
    }
}
