package course.management.CourseManagementSystem.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String credits;
    @Embedded
    AuditData auditData;
    @Column(name="CourseDescription")
    String description;

    @Column(name="CourseCode")
    String code;

    @Column(name="CourseName")
    String name;
    String department;
    @ManyToMany
    @JoinTable(
            name="CoursePrerequisite",
            joinColumns = {@JoinColumn(name="CourseId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="PrerequisiteId", referencedColumnName = "id")}
    )
    Collection<Course> prerequisites;
}
