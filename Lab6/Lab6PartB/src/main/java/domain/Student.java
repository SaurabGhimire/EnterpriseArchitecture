package domain;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Student {
    @Id
    @GeneratedValue
    long id;
    String name;
    int studentNumber;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Department department;

    @OneToMany(cascade = CascadeType.ALL)
    Collection<Grade> grades;

    public Student() {
    }

    public Student(String name, int studentNumber, Department department, Collection<Grade> grades) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.department = department;
        this.grades = grades;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Collection<Grade> getGrade() {
        return grades;
    }

    public void setGrade(Collection<Grade> grades) {
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentNumber=" + studentNumber +
                ", department=" + department +
                ", grades=" + grades +
                '}';
    }
}
