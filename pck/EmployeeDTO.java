package employee.rest.pck;

public class EmployeeDTO {
	
	private long id;
	
	private String firstName;
	
	private String lastName;
	
	private String[] addresses;

	
	public String getFirstName() {
        return firstName;
    }
	public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
	
	public String getLastName() {
        return lastName;
    }	
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String[] getAdresses() {
        return addresses;
    }
    public void setAddresses(String[] addresses) {
        this.addresses = addresses;
    }

}
