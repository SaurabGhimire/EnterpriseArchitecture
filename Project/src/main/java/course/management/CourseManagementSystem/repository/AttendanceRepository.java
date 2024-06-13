package course.management.CourseManagementSystem.repository;

import course.management.CourseManagementSystem.domain.AttendanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AttendanceRepository extends JpaRepository<AttendanceRecord, Long> {
}
