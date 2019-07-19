package employee.rest.pck;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "DTO POST attributes")
public class EmployeeCDTO {
	
	@ApiModelProperty(notes = "Employee ID number", example = "111")
	private int id;
	
	@ApiModelProperty(notes = "Employee first name", example = "ABC")
	private String firstName;
	
	@ApiModelProperty(notes = "Employee last name", example = "ABC")
	private String lastName;
	
	@ApiModelProperty(notes = "Employee birth date", example = "ABC")
	private String dateOfBirth;
	
	@ApiModelProperty(notes = "Employee address list", example = "[AddLine1,AddLine2,AddLine3,AddLine4]")
	private List<Addresses> addresses;
	
	public EmployeeCDTO() {};
	
	public EmployeeCDTO(int id, String firstName, String lastName, String dateOfBirth, List<Addresses> addresses) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
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
	public String getDateOfBirth() {
        return dateOfBirth;
    }
	public List<Addresses> getAddresses() {
		return addresses;
	}
	
}
