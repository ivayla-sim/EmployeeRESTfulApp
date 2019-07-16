package employee.rest.pck;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.http.*;




@RestController
@RequestMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE/*, consumes = MediaType.APPLICATION_JSON_VALUE*/)
@Api(value = "Employee API", description = "Operations to employees in the Employee API")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@ApiOperation(value = "Get all employees")
	@GetMapping
	@ResponseStatus(HttpStatus.OK) 
	public ResponseEntity<List<EmployeeDTO>> listAllEmployees() {
		return new ResponseEntity<>(employeeService.listAllEmployees(), HttpStatus.OK);
	
	}
	
	@ApiOperation(value = "Get an employee by id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<EmployeeDTO> getEmployee(
			@ApiParam(value = "Employee id from which employee object will be retrieved", required = true)
			@PathVariable(value = "id") int id) {
		return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Add an employee")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Integer> createEmployee(@RequestBody EmployeeCDTO employeeCDTO) {
		return new ResponseEntity<>(employeeService.createEmployee(employeeCDTO), HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Update an employee")
	@PutMapping(value = "/{id}/{zipCode}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<EmployeeDTO> updateEmployee(	@ApiParam(value = "Employee Id to update employee object", required = true)
														@PathVariable(value = "id") int id, 
														@ApiParam(value = "Zip Code to update employee object", required = true)
														@PathVariable(value = "zipCode") int zipCode,
														@RequestBody EmployeeUDTO employeeUDTO//,
														/*@RequestBody AddressesDTO addressesDTO*/) {
		return new ResponseEntity<>(employeeService.updateEmployee(id, employeeUDTO, zipCode/*, addressesDTO*/), HttpStatus.OK);
	}
	
	
	
	
	
	

}
