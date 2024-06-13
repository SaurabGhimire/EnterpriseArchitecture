package course.management.CourseManagementSystem.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CourseRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @ManyToOne
    @JoinColumn(name="CourseOfferingId")
    CourseOffering courseOffering;
    @ManyToOne
    @JoinColumn(name="StudentId")
    Student student;
    @OrderColumn(name="Sequence")
    @Column(name="Sequence")
    int sequence;
}
