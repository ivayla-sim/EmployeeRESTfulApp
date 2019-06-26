package employee.rest.pck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class EmployeeApplication {
	
	public static void main(String[] args ) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

}

@Component
class DemoCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void run(String... args) throws Exception{
		
		Employee emp1 = new Employee();
		System.out.println ("Something");
		emp1.setId(880331);
		emp1.setFirstName("Ivayla");
		emp1.setLastName("Simova");
		emp1.setDateOfBirth("31/03/1988");
		emp1.setAddresses( new String[]{"Bulgaria, Sofia", "Bulgaria, Gradec"} ); 
		//emp1.setAddresses("Sofia"); 
		System.out.println (emp1);
		employeeRepository.save(emp1);
	}
	
	
}
