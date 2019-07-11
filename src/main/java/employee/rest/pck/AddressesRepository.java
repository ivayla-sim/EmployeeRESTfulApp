package employee.rest.pck;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "employees", path = "employees")
public interface AddressesRepository extends CrudRepository<Addresses, Integer> 
{
	
	List<Addresses> findByEmployeeIdAndZipCode(@Param("employeeId") int employeeId, @Param("zipCode") int zipCode);

}
