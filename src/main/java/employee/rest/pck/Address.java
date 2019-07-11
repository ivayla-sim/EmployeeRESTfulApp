package employee.rest.pck;

import java.util.HashMap;
import java.util.Map;

//import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"country",
"city",
"villageType",
"street"
})
public class Address {
	
	private String country;
	
	private String city;
	
	private String villageType;
	
	private String street;
	
	private Map<String, Object> addressProperties = new HashMap<String, Object>();
	
	
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
	
	public Map<String, Object> getAddressProperties() {
		return this.addressProperties;
		}
	
	public void setAddressProperty(String name, Object value) {
		this.addressProperties.put(name, value);
		}

}
