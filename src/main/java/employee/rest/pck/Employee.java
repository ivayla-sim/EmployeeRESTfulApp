package employee.rest.pck;

import java.util.List;
import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@RestResource(rel="employees", path="employee")
@ApiModel(description = "All details about the Employee")
public class Employee implements Serializable {
	
	@Id
	@ApiModelProperty(notes = "Employee ID number")
	private int id;
	
	@ApiModelProperty(notes = "Employee first name")
	private String firstName;
	
	@ApiModelProperty(notes = "Employee last name")
	private String lastName;
	
	@ApiModelProperty(notes = "Employee birth date")
	private String dateOfBirth;
	
	@OneToMany(targetEntity = Addresses.class, mappedBy="employee", fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@ApiModelProperty(notes = "Employee address list")
	private List<Addresses> addresses;
	
	
	
	public Employee() {}
	
	
	
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
    
    public List<Addresses> getAddresses() {
    	return addresses;
    }
    
    public void setAddresses(List<Addresses> addresses) {
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
