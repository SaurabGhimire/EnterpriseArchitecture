package domain;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    long id;

    int employeeNumber;
    String name;

    @ManyToOne
    @JoinColumn(name="department_id")
    Department department;

    public  Employee(){}

    public Employee(int employeeNumber, String name){
        this.employeeNumber = employeeNumber;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeNumber=" + employeeNumber +
                ", name='" + name + '\'' +
                ", department=" + department +
                '}';
    }
}
