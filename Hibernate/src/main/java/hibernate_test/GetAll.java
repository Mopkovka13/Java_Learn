package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class GetAll {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // Писать не обязательно, если название не менялось
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            // Создаем запись в базе
            Session session = factory.getCurrentSession(); // Создаем сессию подключения к базе
            List<Employee> employeeList = new ArrayList<>(); // Создаем список
            session.beginTransaction();
            // HQL - Hibernate Query Language, работает по названию класса, а не таблицы (поля указываются тоже класса)
            //employeeList = session.createQuery("from Employee").getResultList(); -- получить всех
            employeeList = session.createQuery("from Employee where name = 'Elena'").getResultList(); // получить по имени

            session.getTransaction().commit();

            for (Employee e : employeeList) {
                System.out.println(e);
            }
        }
        finally {
            factory.close();
        }
    }
}
