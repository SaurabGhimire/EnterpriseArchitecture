package course.management.CourseManagementSystem.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CourseOffering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @ManyToOne
    @JoinColumn(name="CourseID")
    Course course;
    @ManyToOne
    @JoinColumn(name="FacultyID")
    Faculty faculty;
    int capacity;
    String credits;
    @Embedded
    AuditData auditData;
    @Enumerated
    @Column(name="CourseOfferingType")
    CourseOfferingType courseOfferingType;
    @Column(name="Room")
    String room;
}
