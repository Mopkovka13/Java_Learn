package hibernate_one_to_many_bi;

import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// Типы загрузок данных
// Eager - это (нетерпеливая) загрузка, то есть все связанные сущности будут загружены в память.
// Lazy - это (ленивая) загрузка, то есть только одна сущность будет загружена в память, а остальные будут загружены по запросу.
public class Get {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // Писать не обязательно, если название не менялось
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();;
        try {
            session.beginTransaction();

            Department department = session.get(Department.class, 1);
            System.out.println(department);

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }


    }
}
