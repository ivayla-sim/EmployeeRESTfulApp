package employee.rest.pck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.fasterxml.classmate.AnnotationConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class EmployeeApplication {
	
	//
	/*
	private static org.hibernate.SessionFactory sessionFactory;

	  public static SessionFactory getSessionFactory() {
	    if (sessionFactory == null) {
	      initSessionFactory();
	    }
	    return sessionFactory;
	  }

	  private static synchronized void initSessionFactory() {
	    sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

	  }
	  
	  
	  private static SessionFactory sessionFactory;
	   
	   private InitSessionFactory() []

	  public static Session getSession() {
	    return getSessionFactory().openSession();
	  }
	  */
	  
//
	
	public static void main(String[] args ) {
		
		//
		/*
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		*/
		//
		SpringApplication.run(EmployeeApplication.class, args);
		
		//transaction.commit();
	}

}

@Component
class DemoCommandLineRunner implements CommandLineRunner {
	
	@Value("${spring.application.name}")
	private String springApplicationName;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AddressesRepository addressesRepository;
	
	@Override
	public void run(String... args) throws Exception{
		
		Employee emp1 = new Employee();
		Addresses adr1 = new Addresses();
		Addresses adr2 = new Addresses();
		
		System.out.println ("Something");
		
		List<Addresses> adrList = new ArrayList<Addresses>();
		adrList.add(new Addresses(880331, "Bulgaria", "Sofia", "city", "FirstStreet", 123));
		adrList.add(new Addresses(880331, "Bulgaria", "Gradets", "village", "NoStreet", 321));
		System.out.println(adrList);
		
		adr1.setEmployeeId(880331);
		adr1.setCountry("Bulgaria");
		adr1.setCity("Sofia");
		adr1.setVillageType("city");
		adr1.setStreet("FirstStreet");
		adr1.setZipCode(123);
		
		adr2.setEmployeeId(880331);
		adr2.setCountry("Bulgaria");
		adr2.setCity("Gradets");
		adr2.setVillageType("village");
		adr2.setStreet("NoStreet");
		adr2.setZipCode(321);
		
		
		
		
		emp1.setId(880331);
		emp1.setFirstName("Ivayla");
		emp1.setLastName("Simova");
		emp1.setDateOfBirth("31/03/1988");
		//emp1.setAddresses( new String[]{"Bulgaria, Sofia", "Bulgaria, Gradets"} ); 
		//emp1.setAddresses( new Addresses[]{new Addresses("Bulgaria", "Sofia", "city", "FirstStreet"), new Addresses("Bulgaria", "Gradets", "village", "NoStreet")} );
		
		
		
		emp1.setAddresses(adrList);
		
		//ObjectMapper mapper = new ObjectMapper();
		//mapper.writeValue(System.out, emp1);
		
		//Employee emp2 = mapper.readValue(emp1, Employee.class);
		
	
		
		
		//emp1.setAddresses("Sofia"); 
		System.out.println (emp1);
		employeeRepository.save(emp1);
		addressesRepository.save(adr1);
		addressesRepository.save(adr2);
		
		
		
		System.out.println (springApplicationName);
		
		//EmployeeCDTO emp2 = new EmployeeCDTO();
		System.out.println (emp1.getAddresses());
		//System.out.println (Arrays.toString(emp1.getAddresses()));
		System.out.println(adrList);
		
		EmployeeCDTO employeeCDTO1 = new EmployeeCDTO();
		//employeeCDTO1.setAddresses(emp1.getAddresses());
		System.out.println(employeeCDTO1.getAddresses());
		
		
	}
	
	
}
