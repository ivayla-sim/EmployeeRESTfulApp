package employee.rest.pck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//GET employee by Id
	public EmployeeDTO getEmployee(int id) {
		if (employeeRepository.findById(id).isPresent()) {
			Employee fetchedEmployee = employeeRepository.findById(id).get();
			
			return new EmployeeDTO(fetchedEmployee.getId(), fetchedEmployee.getFirstName(), fetchedEmployee.getLastName(), fetchedEmployee.getAdresses());
		}
		else {
			return null;
		}
	}
	
	//GET all employees
	public List<EmployeeDTO> listAllEmployees() {
		List<EmployeeDTO> employeeList = new ArrayList<>();
		
		employeeRepository.findAll().forEach(employee -> {employeeList.add(new EmployeeDTO(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getAdresses()));
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
		newEmp.setAddresses(employeeCDTO.getAdresses());
		
		return employeeRepository.save(newEmp).getId();
	}
	
	//PUT updates to existing employee
	public EmployeeDTO updateEmployee(int id, EmployeeUDTO employeeUDTO) {
		
		if(employeeRepository.findById(id).isPresent()) {
			Employee existingEmp = employeeRepository.findById(id).get();
			
			existingEmp.setLastName(employeeUDTO.getLastName());
			existingEmp.setAddresses(employeeUDTO.getAdresses());
			
			Employee updatedEmp = employeeRepository.save(existingEmp);
			
			return new EmployeeDTO(updatedEmp.getId(), updatedEmp.getFirstName(), updatedEmp.getLastName(),
					updatedEmp.getAdresses());
		}
		
		else {
			return null;
		}
	}
	
	
}
