package course.management.CourseManagementSystem.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Collection;

@Entity
@Data
public class Faculty extends Person{
    @Column(name="Salutation")
    String salutation;
    @OneToMany
    @JoinColumn(name="Faculty_id")
    Collection<FacultyHobby> hobbies;
}
