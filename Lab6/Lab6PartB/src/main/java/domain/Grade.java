package domain;

import jakarta.persistence.*;

@Entity
public class Grade {
    @Id
    @GeneratedValue
    long id;

    String grade;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Course  course;

    public Grade() {
    }

    public Grade(String grade, Course course) {
        this.grade = grade;
        this.course = course;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
