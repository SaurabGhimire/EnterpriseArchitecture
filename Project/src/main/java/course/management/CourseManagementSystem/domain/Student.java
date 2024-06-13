package course.management.CourseManagementSystem.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Entity
@Data
public class Student extends Person{
    @Column(name="StudentID")
    String studentID;
    @Column(name="Entry")
    String entry;
    @ManyToOne
    @JoinColumn(name="FacultyAdviserID")
    Faculty facultyAdviser;
    @Column(name="AlternateID")
    String alternateId;
    @Column(name="ApplicantID")
    String applicantId;
}
