package hibernate_one_to_many_bi.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "max_salary")
    private int maxSalary;

    @Column(name = "min_salary")
    private int minSalary;

    // Default Download Types (Fetch)
    // One-to-One - Eager
    // One-to-Many - Lazy
    // Many-to-One - Eager
    // Many-to-Many - Lazy
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "department",
            fetch = FetchType.EAGER) // FetchType EAGER means that when you fetch the department, all the employees will be fetched
    // If you use FetchType.LAZY, then only the department will be fetched, and the employees will be fetched when you access them
    //@JoinColumn(name = "department_id") // if you want to use this, you need to add @JoinColumn annotation to the Employee class
    private List<Employee> employeeList;

    public Department(String name, int maxSalary, int minSalary) {
        this.name = name;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
    }

    public Department() {
    }

    public void addEmployeeToDepartment(Employee employee) {
        if (employeeList == null) {
            employeeList = new ArrayList<>();
        }
        employeeList.add(employee);
        employee.setDepartment(this);
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

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maxSalary=" + maxSalary +
                ", minSalary=" + minSalary +
                ", employeeList=" + employeeList +
                '}';
    }
}
