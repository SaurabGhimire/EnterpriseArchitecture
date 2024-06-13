package course.management.CourseManagementSystem.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    long id;
    @Column(name="Name")
    String name;
    @Column(name = "Capacity")
    int capacity;
    @ManyToOne
    @JoinColumn(name="type_id")
    LocationType locationType;
    @Embedded
    AuditData auditData;

}
