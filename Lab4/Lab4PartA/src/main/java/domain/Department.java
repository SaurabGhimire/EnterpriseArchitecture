package domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue
    long id;
    String name;
    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Employee> employees = new ArrayList<>();

    public Department(String name, List<Employee> employees){
        this.name = name;
        this.employees = employees;
    }

    public Department(String name){
        this.name = name;
    }

    public Department() {

    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void addEmployee(Employee e){
        employees.add(e);
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}
