package students;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Student {
    @Id
    private int studentNumber;
    private String name;
    private String phone;
    private String email;
    private Address address;
    private List<Grade> grades = new ArrayList<Grade>();

    public Student(int studentNumber, String name, String phone, String email) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNumber=" + studentNumber +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", grades=" + grades +
                '}';
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void addGrade(Grade grade){
        grades.add(grade);
    }
}
