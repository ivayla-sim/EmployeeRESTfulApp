package employee.rest.pck;

import java.util.List;

public class EmployeeDTO {
	
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private List<Addresses> addresses;
	
	
	
	public EmployeeDTO(int id, String firstName, String lastName, List<Addresses> addresses) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addresses = addresses;
	}

	
	
	public int getId() {
		return id;
	}
	
	public String getFirstName() {
        return firstName;
    }
	
	public String getLastName() {
        return lastName;
    }	
    
    public List <Addresses> getAddresses() {
        return addresses;
    }

}
