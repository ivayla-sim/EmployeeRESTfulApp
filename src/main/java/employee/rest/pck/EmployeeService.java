package employee.rest.pck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//@Override
	public EmployeeDTO getEmployee(int id) {
		if (employeeRepository.findById(id).isPresent()) {
			Employee fetchedEmployee = employeeRepository.findById(id).get();
			
			return new EmployeeDTO(fetchedEmployee.getId(), fetchedEmployee.getFirstName(), fetchedEmployee.getLastName(), fetchedEmployee.getAdresses());
		}
		else {
			return null;
		}
	}
	
	//@Override
	public List<EmployeeDTO> listAllEmployees() {
		List<EmployeeDTO> employeeList = new ArrayList<>();
		
		employeeRepository.findAll().forEach(employee -> {employeeList.add(new EmployeeDTO(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getAdresses()));
		});
		return employeeList;
	}
}
