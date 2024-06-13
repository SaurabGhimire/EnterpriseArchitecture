package course.management.CourseManagementSystem.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class PersonAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String password;
    String username;
}
