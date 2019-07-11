package employee.rest.pck;

import java.util.List;

public class EmployeeCDTO {
	
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String dateOfBirth;
	
	private List<Addresses> addresses;
	
	
	
	public int getId() {
		return id;
	}
	public String getFirstName() {
        return firstName;
    }
	public String getLastName() {
        return lastName;
    }
	public String getDateOfBirth() {
        return dateOfBirth;
    }
	public List<Addresses> getAddresses() {
		return addresses;
	}
	
}
