package course.management.CourseManagementSystem.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FacultyHobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "hobbies")
    String hobby;
}
