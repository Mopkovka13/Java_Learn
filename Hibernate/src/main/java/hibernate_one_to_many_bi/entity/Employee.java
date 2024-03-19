package hibernate_one_to_many_bi.entity;

// Используем аннотации JPA, JPA - это спецификация для Java Persistence API
import hibetnate_one_to_one.entity.Detail;
import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // по правилам прописанным в бд
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq") - не используется в MySQL
    //GeneratedValue(strategy = GenerationType.AUTO) // автоматический выбор стратегии от базы
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    //@Column() -- можно не писать name, если название совпадает с названием колонки в базе данных
    @Column(name = "salary")
    private int salary;

    // Убираем каскадное удаление
    // Поскольку каскадное удаление при удалении работника удалит и департамент и всех его работников
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee(String name, String surname, int salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public Employee() {}

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
