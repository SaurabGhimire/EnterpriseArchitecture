package app;

import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.BookRepository;
import repositories.DepartmentRepository;
import repositories.PassengerRepository;
import repositories.SchoolRepository;

import java.time.LocalDate;
import java.util.*;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain") 
public class Application implements CommandLineRunner{
	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	PassengerRepository passengerRepository;

	@Autowired
	SchoolRepository schoolRepository;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("---------------a------------");

		Department department1 = new Department("compro");
		Department department2 = new Department("mba");
		Employee employee1 = new Employee(1, "Bisho");
		Employee employee2 = new Employee(2, "Gaurav");
		Employee employee3 = new Employee(3, "Roshan");
		Employee employee4 = new Employee(4, "Yogen");
		Employee employee5 = new Employee(5, "Sagar");

		department1.addEmployee(employee1);
		department1.addEmployee(employee2);
		department2.addEmployee(employee3);
		department2.addEmployee(employee4);
		department2.addEmployee(employee5);

		departmentRepository.save(department1);
		departmentRepository.save(department2);

		Collection<Department> departments = departmentRepository.findAll();
		for(Department department: departments){
			System.out.println(department);
		}

		System.out.println("---------------b------------");

		Publisher publisher1 = new Publisher("Publisher A");
		Book book1 = new Book("12345", "Java Fundamentals", "Author A", publisher1);
		Book book2 = new Book("54321", "Python Fundamentals", "Author B"	);
//		Book book3 = new Book("78976", "C++ Fundamentals", "Author C" ,publisher1);


		book1.setPublisher(publisher1);
//		book3.setPublisher(publisher1);

		bookRepository.save(book1);
		bookRepository.save(book2);
//		bookRepository.save(book3);

		Collection<Book> books = bookRepository.findAll();
		for(Book book: books){
			System.out.println(book);
		}

		System.out.println("---------------c------------");
		List<Flight> flight1 = new ArrayList<>();
		flight1.add(new Flight("3", "Kathmandu", "iowa", LocalDate.now()));
		flight1.add(new Flight("4", "Kathmandu", "iowa", LocalDate.now()));
		Passenger passenger1 = new Passenger("Passenger A", flight1);
		passengerRepository.save(passenger1);

		Collection<Passenger> passengers = passengerRepository.findAll();
		for(Passenger passenger: passengers){
			System.out.println(passenger);
		}

		System.out.println("---------------d------------");
		Map<Long, Student> schoolMap = new HashMap<>();
		Student student1 = new Student(1, "Bisho", "Silwal");
		Student student2 = new Student(2, "Gaurav", "Neupane");
		schoolMap.put(student1.getId(), student1);
		schoolMap.put(student2.getId(), student2);
		School school1 = new School("School A");
		school1.setStudents(schoolMap);
		schoolRepository.save(school1);

		Collection<School> schools = schoolRepository.findAll();
		for(School school: schools){
			System.out.println(school);
		}
	}
}
