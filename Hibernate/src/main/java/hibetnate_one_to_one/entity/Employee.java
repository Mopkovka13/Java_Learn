package hibetnate_one_to_one.entity;

// Используем аннотации JPA, JPA - это спецификация для Java Persistence API
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

    @Column(name = "department")
    private String department;

    //@Column() -- можно не писать name, если название совпадает с названием колонки в базе данных
    @Column(name = "salary")
    private int salary;


    @OneToOne(cascade = CascadeType.ALL) // Почитать подробнее про типы CascadeType
    @JoinColumn(name = "details_id") // Столбец в таблице, который ссылается на другую таблицу
    private Detail empDetail;

    public Employee(String name, String surname, String department, int salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }

    public Employee() {}

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Detail getEmpDetail() {
        return empDetail;
    }

    public void setEmpDetail(Detail empDetail) {
        this.empDetail = empDetail;
    }
}
