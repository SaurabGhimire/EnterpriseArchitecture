package course.management.CourseManagementSystem.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class LocationType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Embedded
    AuditData auditData;
    String type;
}
