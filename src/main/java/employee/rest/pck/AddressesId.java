package employee.rest.pck;

import java.io.Serializable;

public class AddressesId implements Serializable {
	
	private int employeeId;
	private int zipCode;
	
	public AddressesId() {};
	
	public AddressesId (int employeeId, int zipCode) {
		this.employeeId = employeeId;
		this.zipCode = zipCode;
	}

}
