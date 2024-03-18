package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Get {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // Писать не обязательно, если название не менялось
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            // Создаем запись в базе
            Session session = factory.getCurrentSession(); // Создаем сессию подключения к базе

            // Получаем сущность по id из базы
            int myId = 3;
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee1 = session.get(Employee.class, myId);
            session.getTransaction().commit();

            System.out.println(employee1);
        }
        finally {
            factory.close();
        }
    }
}
