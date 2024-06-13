package course.management.CourseManagementSystem.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class AttendanceRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @ManyToOne
    @JoinColumn(name = "StudentId")
    Student student;
    @ManyToOne
    @JoinColumn(name = "LocationId")
    Location location;
    @Column(name="ScanDateTime")
    LocalDate scanDateTime;
}
