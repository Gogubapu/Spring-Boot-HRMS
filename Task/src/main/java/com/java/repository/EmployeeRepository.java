package com.java.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import javax.validation.constraints.NotNull;

import com.java.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>
{
//Below query for seraching details with different parameters.

	@Query("SELECT p FROM Employee p WHERE p.firstname LIKE %?1%"
			+ " OR p.lastname LIKE %?1%"
			+ " OR p.email LIKE %?1%"
			+ " OR CONCAT(p.id, '') LIKE %?1%")
	//@Query("SELECT p FROM Employee p WHERE CONCAT(p.firstname, ' ', p.lastname, ' ', p.email, ' ', p.department, ' ', p.location, ' ', p.id) LIKE %?1%")
	
	//declaring methos for search operation.
	@NotNull
	public List<Employee> search(@NotNull String keyword);

	/*@Query("SELECT c.name,e.lastname,e.email,from Contractor c INNER JOIN employee e ON c.id=c.id")
	public List<Employee,Contractor> searchBy(String find);*/
	Employee findByEmail(String email);
}
