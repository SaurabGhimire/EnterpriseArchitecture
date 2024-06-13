package course.management.CourseManagementSystem.domain;

import jakarta.persistence.Embeddable;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Embeddable
public class AuditData {
    LocalDateTime createdOn;
    LocalDateTime updatedOn;
    String createdBy;
    String updatedBy;
}
