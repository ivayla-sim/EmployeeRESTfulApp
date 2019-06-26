package employee.rest.pck;

public class EmployeeCDTO {
	
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String dateOfBirth;
	
	private String[] addresses;
	
	
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
	public String[] getAdresses() {
		return addresses;
	}
	      

}
