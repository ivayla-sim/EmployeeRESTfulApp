package employee.rest.pck;

//import javax.persistence.Entity;
//import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class Employee {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//@Column(nullable = false)
	private String firstName;
	
	//@Column(nullable = false)
	private String lastName;
	
	private String dateOfBirth;
	
	private String[] addresses;
	
	//private String addresses;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
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
    
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public String[] getAdresses() {
        return addresses;
    }
    public void setAddresses(String[] addresses) {
        this.addresses = addresses;
    }
    
    
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", addresses='" + addresses + '\'' +
                '}';
    }
	
	

}
