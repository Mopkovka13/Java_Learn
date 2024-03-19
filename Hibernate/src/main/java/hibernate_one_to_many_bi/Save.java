package hibernate_one_to_many_bi;

import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Save {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // Писать не обязательно, если название не менялось
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();;
        try {
            session.beginTransaction();
            Department department = new Department("IT", 1500, 800);
            Employee employee = new Employee("Gena", "Na", 1000);
            Employee employee2 = new Employee("As", "Asasa", 1500);
            Employee employee3 = new Employee("Buba", "Huba", 900);

            department.addEmployeeToDepartment(employee);
            department.addEmployeeToDepartment(employee2);
            department.addEmployeeToDepartment(employee3);

            session.save(department);

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }


    }
}
