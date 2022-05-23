package com.java.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//import com.java.model.Employee;
import com.java.model.Location;
@Repository
public interface LocationRepository extends JpaRepository<Location, String>
{
	Location findByName(String name);
}
