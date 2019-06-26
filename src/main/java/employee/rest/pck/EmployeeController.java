package employee.rest.pck;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;




@RestController
@RequestMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK) 
	public ResponseEntity<List<EmployeeDTO>> listAllEmployees() {
		return new ResponseEntity<>(employeeService.listAllEmployees(), HttpStatus.OK);
	
	}
	
	//@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	//@ResponseStatus(HttpStatus.OK)
	//public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable(value = "id") int id) 
		//throws ResourceNotFoundException
	//{
		//try {
			//EmployeeDTO returnedEmployee = employeeService.getEmployee(id);
			//return ResponseEntity.ok().body(returnedEmployee);
			//return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
		//}
		
		//catch (ResourceNotFoundException ex) {
			//ex = new ResourceNotFoundException("There is no employee with id = " + id);
			//return ResponseEntity.body(ex);
		//}
		
		//return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
	//}
	
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable(value = "id") int id) {
		return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
	}
	
	
	//@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	//@ResponseStatus(HttpStatus.OK)
	//public ResponseEntity<EmployeeDTO> putEmployee()
	
	
	
	
	
	

}
