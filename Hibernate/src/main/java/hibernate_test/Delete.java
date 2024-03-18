package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Delete {
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
            // Достаточно удалять по id
            //session.delete(new Employee(1));

            // case 2
            session.createQuery("delete from Employee where id = 2").executeUpdate();

            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }
    }
}
