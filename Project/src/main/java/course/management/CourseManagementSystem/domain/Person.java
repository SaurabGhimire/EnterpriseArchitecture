package course.management.CourseManagementSystem.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    LocalDate birthdate;
    @Column(name="EmailAddress")
    String emailAddress;
    @Column(name="GenderType")
    GenderType genderType;
    String firstName;
    String lastName;
    @Embedded
    AuditData auditData;
    @OneToOne
    PersonAccount personAccount;
}
