package employee.rest.pck;

public class EmployeeDTO {
	
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String[] addresses;
	
	public EmployeeDTO(int id, String firstName, String lastName, String[] addresses) {
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
    
    public String[] getAdresses() {
        return addresses;
    }

}
