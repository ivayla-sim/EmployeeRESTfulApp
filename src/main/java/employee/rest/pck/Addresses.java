package employee.rest.pck;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//@Table( name = "ADDRESSES", 
	//uniqueConstraints =  @UniqueConstraint( columnNames = { "EMPLOYEE_ID", "ZIP_CODE" } ) )
@IdClass(AddressesId.class)
public class Addresses implements Serializable {
	
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addressId;
	
	@ManyToOne(targetEntity = Employee.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "employeeId", insertable=false, updatable=false)
	private Employee employee;
	
	@JsonIgnore
	//@Column(name = "employee_id")
	@Id
	private int employeeId;
	
	private String country;
	
	private String city;
	
	private String villageType;
	
	private String street;
	
	//@Column(name = "zip_code")
	@Id
	private int zipCode;
	
	
	
	public Addresses() {}
	
	public Addresses(int employeeId, String country, String city, String villageType, String street, int zipCode) {
		this.employeeId = employeeId;
		this.country = country;
		this.city = city;
		this.villageType = villageType;
		this.street = street;
		this.zipCode = zipCode;
	}
	
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getVillageType() {
		return villageType;
	}
	public void setVillageType(String villageType) {
		this.villageType = villageType;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	@Override
	public String toString() {
        return "Addresses{" +
        		"employeeId=" + employeeId +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", villageType='" + villageType + '\'' +
                ", street='" + street + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }

}
