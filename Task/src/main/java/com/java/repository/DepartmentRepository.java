package com.java.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//import com.java.model.Employee;
import com.java.model.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, String>
{
	Department findByName(String name);
	
}
