package employee.rest.pck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private AddressesRepository addressesRepository;
	
	//GET employee by Id
	public EmployeeDTO getEmployee(int id) {
		if (employeeRepository.findById(id).isPresent()) {
			Employee fetchedEmployee = employeeRepository.findById(id).get();
			
			return new EmployeeDTO(fetchedEmployee.getId(), fetchedEmployee.getFirstName(), fetchedEmployee.getLastName(), fetchedEmployee.getAddresses());
		}
		else {
			return null;
		}
	}
	
	//GET all employees
	public List<EmployeeDTO> listAllEmployees() {
		List<EmployeeDTO> employeeList = new ArrayList<>();
		
		employeeRepository.findAll().forEach(employee -> {employeeList.add(new EmployeeDTO(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getAddresses()));
		});
		return employeeList;
	}
	
	//POST new employee
	public int createEmployee(EmployeeCDTO employeeCDTO) {
		
		Employee newEmp = new Employee();
		
		newEmp.setId(employeeCDTO.getId());
		newEmp.setFirstName(employeeCDTO.getFirstName());
		newEmp.setLastName(employeeCDTO.getLastName());
		newEmp.setDateOfBirth(employeeCDTO.getDateOfBirth());
		newEmp.setAddresses(employeeCDTO.getAddresses());
		
		employeeRepository.save(newEmp);
		
		
		
		substrAddressesAttr(employeeCDTO.getId(), null, employeeCDTO);
		
		
		return 1;

	}
	
	
	//PUT updates to existing employee
	public EmployeeDTO updateEmployee(int id, EmployeeUDTO employeeUDTO, int zipCode) {
		
		if(employeeRepository.findById(id).isPresent() && !addressesRepository.findByEmployeeIdAndZipCode(id, zipCode).isEmpty()) {
			Employee existingEmp = employeeRepository.findById(id).get();
			
			existingEmp.setLastName(employeeUDTO.getLastName());
			
			Employee updatedEmp = employeeRepository.save(existingEmp);
			
			
			substrAddressesAttr(id, employeeUDTO, null);
			
			return new EmployeeDTO(updatedEmp.getId(), updatedEmp.getFirstName(), updatedEmp.getLastName(),
					updatedEmp.getAddresses());
		}
		
		else {
			return null;
		}
			
		
	}
	
	
public int substrAddressesAttr (int id, EmployeeUDTO employeeUDTO, EmployeeCDTO employeeCDTO) {
		
		int cntAdr = (employeeUDTO == null) ? (employeeCDTO.getAddresses().toString().split("Addresses", -1).length) -1 : 
			(employeeUDTO.getAddresses().toString().split("Addresses", -1).length) -1;
		
		int indx = 0;
		
		for(int i = 0; i <= cntAdr - 1; i++) {
			
			Addresses newAdr = new Addresses();	
	
		String tmpAdrStr = (employeeUDTO == null) ? employeeCDTO.getAddresses().toString() : employeeUDTO.getAddresses().toString();
		String tmpAdrStrOrig = tmpAdrStr;
		
		if(i == cntAdr - 1) {
			tmpAdrStr = tmpAdrStr.substring(tmpAdrStr.indexOf("Addresses", indx-1) , tmpAdrStr.length());				
		}
		else {
			tmpAdrStr = tmpAdrStr.substring(tmpAdrStr.indexOf("Addresses", indx) , tmpAdrStr.indexOf("Addresses", tmpAdrStr.indexOf("Addresses") + (indx + 1)));
			
		}
		
		
		indx = tmpAdrStrOrig.indexOf("Addresses", tmpAdrStrOrig.indexOf("Addresses") + (indx + 1));	
		
		newAdr.setEmployeeId(id);
		newAdr.setCountry(tmpAdrStr.substring(tmpAdrStr.indexOf("country")+8+1, 
				tmpAdrStr.indexOf(',', tmpAdrStr.indexOf("country")+8)-1));
		newAdr.setCity(tmpAdrStr.substring(tmpAdrStr.indexOf("city")+5+1, 
				tmpAdrStr.indexOf(',', tmpAdrStr.indexOf("city")+5)-1));
		newAdr.setVillageType(tmpAdrStr.substring(tmpAdrStr.indexOf("villageType")+12+1, 
				tmpAdrStr.indexOf(',', tmpAdrStr.indexOf("villageType")+12)-1));
		newAdr.setStreet(tmpAdrStr.substring(tmpAdrStr.indexOf("street")+7+1, 
				tmpAdrStr.indexOf(',', tmpAdrStr.indexOf("street")+8)-1));
		newAdr.setZipCode(Integer.parseInt(tmpAdrStr.substring(tmpAdrStr.indexOf("zipCode")+8, 
				tmpAdrStr.indexOf('}', tmpAdrStr.indexOf("zipCode")+8))));
		
		addressesRepository.save(newAdr);
	
	
		}
		
		return 1;
		
		
	}
	
	
}
