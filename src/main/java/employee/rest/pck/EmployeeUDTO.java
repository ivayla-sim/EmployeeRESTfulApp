package employee.rest.pck;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "DTO PUT attributes")
public class EmployeeUDTO {
	
	@ApiModelProperty(notes = "Employee last name")
	private String lastName;
	
	@ApiModelProperty(notes = "Employee address list", example = "[AddLine1,AddLine2,AddLine3,AddLine4]")
	private List<Addresses> addresses;
	
	
	
	public String getLastName() {
        return lastName;
    }
	
	public List<Addresses> getAddresses() {
		return addresses;
	}

}
