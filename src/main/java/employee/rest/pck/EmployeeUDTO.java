package employee.rest.pck;

import java.util.List;

public class EmployeeUDTO {
	
	private String lastName;

	private List<Addresses> addresses;
	
	
	
	public String getLastName() {
        return lastName;
    }
	
	public List<Addresses> getAddresses() {
		return addresses;
	}

}
