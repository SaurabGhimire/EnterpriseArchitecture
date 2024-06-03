package repositories;

import domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("select s from Student s join fetch s.department where s.department.name = :name")
    Collection<Student> findByDepartment(String name);

    @Query("select distinct s from Student s join fetch s.grades g where g.grade = :grade")
    Collection<Student> findByCourse(String grade);
}
