package course.management.CourseManagementSystem;

import course.management.CourseManagementSystem.domain.AttendanceRecord;
import course.management.CourseManagementSystem.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collection;

@SpringBootApplication
public class CourseManagementSystemApplication implements CommandLineRunner {
//	@Autowired
//	AttendanceRepository attendanceRepository;

	public static void main(String[] args) {
		SpringApplication.run(CourseManagementSystemApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
//		Collection<AttendanceRecord> records =  attendanceRepository.findAll();
//		for(AttendanceRecord a: records){
//			System.out.println(a);
//		}
	}
}
