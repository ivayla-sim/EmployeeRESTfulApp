package employee.rest.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

//import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*; //for print()

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.qos.logback.core.status.Status;
import employee.rest.pck.EmployeeController;
import employee.rest.pck.EmployeeDTO;
import employee.rest.pck.EmployeeService;
import employee.rest.pck.EmployeeUDTO;
import employee.rest.pck.Employee;
import employee.rest.pck.EmployeeCDTO;
import employee.rest.pck.Addresses;


@RunWith(SpringJUnit4ClassRunner.class)
//@RunWith(MockitoJUnitRunner.class)

public class TestEmployeeController {
	
	private MockMvc mockMvc;
	
	@Mock
	private EmployeeService employeeServiceMock;
	
	@InjectMocks
	private EmployeeController employeeController;
	
	List <EmployeeDTO> listEmp = new ArrayList<EmployeeDTO>();
	
	EmployeeDTO getEmp = new EmployeeDTO();
	EmployeeCDTO postEmp = new EmployeeCDTO();
	EmployeeUDTO putEmp = new EmployeeUDTO();
	
	@Before
    public void setUp() throws Exception {
        //We have to reset our mock between tests because the mock objects
        //are managed by the Spring container. If we would not reset them,
        //stubbing and verified behavior would "leak" from one test to another.
        Mockito.reset(employeeServiceMock);
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
		
        
		Addresses firstAdr = new Addresses(98765, "Test Country", "Test City", "Test VillageType", "Test Street", 111);
		Addresses secondAdr = new Addresses(98765, "Test Country2", "Test City2", "Test VillageType2", "Test Street2", 222);
		
		List<Addresses> listAdr = new ArrayList<Addresses>();
		listAdr.add(firstAdr);
		listAdr.add(secondAdr);
		
		EmployeeDTO firstEmp = new EmployeeDTO(98765, "Test FN", "Test LN", listAdr);
		EmployeeDTO secondEmp = new EmployeeDTO(34567, "Test FN2", "Test LN2", listAdr);
		listEmp.add(firstEmp);
		listEmp.add(secondEmp);
		
		getEmp = firstEmp;
		
		EmployeeCDTO createEmp = new EmployeeCDTO(12345, "Test Create FN", "Test Create LN", "01/01/1900", listAdr);
		postEmp = createEmp;
		
		EmployeeUDTO updateEmp = new EmployeeUDTO("Test Update LN", listAdr);
		putEmp = updateEmp;
    }
	
	
	@Test
	public void listAllEmployeesTest() throws Exception {
		
    	Mockito.when(employeeServiceMock.listAllEmployees()).thenReturn(listEmp);
    	
		mockMvc.perform(MockMvcRequestBuilders
				.get("/employees")
				.accept(MediaType.APPLICATION_JSON_VALUE)
				)
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].id").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].id").isNotEmpty())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].id").value(98765))
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].addresses[1].country").value("Test Country2"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.[1].id").value(34567))
				.andExpect(MockMvcResultMatchers.jsonPath("$.[1].addresses[0].city").value("Test City"));
	}
	
	
	
	@Test
	public void getEmployeeTest() throws Exception {
		
		String id = "98765";
		
		Mockito.when(employeeServiceMock.getEmployee(Integer.parseInt(id))).thenReturn(getEmp);
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/employees/{id}", id)
				//.param("id", id)
				.accept(MediaType.APPLICATION_JSON_VALUE)
				)
				.andDo(print())
				.andExpect(status().isOk())
				//.andExpect(MockMvcResultMatchers.jsonPath("$.length()", is(1))
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(98765))
				.andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("Test LN"));
	}
	
	
	@Test
	public void createEmployeeTest() throws Exception {
		
		Mockito.when(employeeServiceMock.createEmployee(postEmp)).thenReturn(new EmployeeDTO());
		
		ObjectMapper mapper = new ObjectMapper();
		String postEmpStr = mapper.writeValueAsString(postEmp);
		
		MvcResult postResult = mockMvc.perform(MockMvcRequestBuilders
				.post("/employees")
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.content(postEmpStr)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.characterEncoding("utf-8")
				)
		.andDo(print())
		.andExpect(status().isCreated())
		//.andExpect(content().string(containsString("id")))
		//.andExpect(content().)
		.andReturn();
		
		String postResponse = postResult.getResponse().getContentAsString();
		String postRequest = postResult.getRequest().getContentAsString();
		System.out.println("сометхинг");
		System.out.println(postRequest);
		System.out.println(postResponse);
		
		
	}
	
	
	
	@Test
	public void updateEmployeeTest() throws Exception {
		
		String id = "45678";
		String zipCode = "666";
		
		Mockito.when(employeeServiceMock.updateEmployee(Integer.parseInt(id), putEmp, Integer.parseInt(zipCode))).thenReturn(new EmployeeDTO());
		
		ObjectMapper mapper = new ObjectMapper();
		String putEmpStr = mapper.writeValueAsString(putEmp);
		
		mockMvc.perform(MockMvcRequestBuilders
				.put("/employees/{id}/{zipCode}", id, zipCode)
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.content(putEmpStr)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.characterEncoding("utf-8")
				)
		.andDo(print())
		.andExpect(status().isOk())
		//.andExpect(content().string(containsString("id")))
		//.andExpect(content().json(putEmpStr))
		.andReturn();
		
	}
	
	
	
	

}
