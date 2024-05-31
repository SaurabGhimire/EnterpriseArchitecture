package domain;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;

@Entity
public class School {
    @Id
            @GeneratedValue
    long id;

    String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="id", cascade= CascadeType.PERSIST)
    @MapKey(name="id")
    Map<Long, Student> students = new HashMap<>();
    public School(String name) {
        this.name = name;
    }

    public School(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Long, Student> getStudents() {
        return students;
    }

    public void setStudents(Map<Long, Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
