package app;

import domain.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.StudentRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
//import repositories.CustomerRepository;


@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain")
@Transactional
public class Application implements CommandLineRunner{
	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Department csDept = new Department("Computer Science");
		Department bioDept = new Department("Biology");

		Course javaCourse = new Course("Java Programming");
		Course dbCourse = new Course("Databases");
		Course bioCourse = new Course("Biology 101");

		Grade gradeA = new Grade("A", javaCourse);
		Grade gradeB = new Grade("B", dbCourse);
		Grade gradeC = new Grade("C", bioCourse);

		Collection<Grade> grades1 = Arrays.asList(gradeA, gradeB);
		Collection<Grade> grades2 = List.of(gradeC);

		Student student1 = new Student("John Doe", 12345, csDept, grades1);
		Student student2 = new Student("Jane Smith", 67890, bioDept, grades2);

		studentRepository.save(student1);
		studentRepository.save(student2);

		for(Student student: studentRepository.findByDepartment("Computer Science")){
			System.out.println(student);
		}

		for(Student student: studentRepository.findByCourse("A")){
			System.out.println(student);
		}
	}
}
