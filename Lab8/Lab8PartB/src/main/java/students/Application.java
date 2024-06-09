package students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Address address = new Address("123 Maple St", "New York", "10001");
		Student student = new Student(1, "John Doe", "555123456", "john.doe@example.com");
		student.setAddress(address);
		student.addGrade(new Grade("Data Structures", "A"));
		student.addGrade(new Grade("Algorithms", "B+"));
		studentRepository.save(student);

		address = new Address("456 Elm St", "San Francisco", "94101");
		student = new Student(2, "Jane Smith", "555987654", "jane.smith@example.com");
		student.setAddress(address);
		student.addGrade(new Grade("Machine Learning", "A-"));
		student.addGrade(new Grade("Artificial Intelligence", "A"));
		studentRepository.save(student);

		address = new Address("789 Oak St", "Chicago", "60601");
		student = new Student(3, "Alice Johnson", "555654321", "alice.johnson@example.com");
		student.setAddress(address);
		student.addGrade(new Grade("Database Systems", "B"));
		student.addGrade(new Grade("Computer Networks", "A-"));
		studentRepository.save(student);

// Get students
		System.out.println(studentRepository.findById(1).get());
		System.out.println(studentRepository.findById(2).get());
		System.out.println(studentRepository.findById(3).get());

		System.out.println("-----------All students ----------------");
		System.out.println(studentRepository.findAll());

		System.out.println("-----------find by name ----------------");
		List<Student> students = studentRepository.findByName("Jane Smith");
		students.forEach(s -> System.out.println(s));

		System.out.println("-----------find by phone ----------------");
		System.out.println(studentRepository.findByPhone("555123456"));

		System.out.println("-----------find by city ----------------");
		students = studentRepository.findByCity("Chicago");
		students.forEach(s -> System.out.println(s));

		System.out.println("-----------find by course name ----------------");
		students = studentRepository.findByCourse("Data Structures");
		students.forEach(s -> System.out.println(s));

		System.out.println("-----------find by course name and grade----------------");
		students = studentRepository.findByCourseAndGrade("Machine Learning", "A-");
		students.forEach(s -> System.out.println(s));
	}

}
