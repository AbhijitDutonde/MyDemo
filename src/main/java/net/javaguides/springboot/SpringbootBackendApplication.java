package net.javaguides.springboot;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}
	@Autowired
private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {

		Employee employee =new Employee();
		employee.setFirstname("Abhi");
		employee.setLastname("Dutonde");
		employee.setEmailId("abhi@gmail.com");
		employeeRepository.save(employee);

		Employee employee1 =new Employee();
		employee1.setFirstname("John");
		employee1.setLastname("Parker");
		employee1.setEmailId("john@gmail.com");
		employeeRepository.save(employee1);
	}


}
