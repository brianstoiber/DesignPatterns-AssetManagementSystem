package org.brian.assetmanagement.repository;

import java.util.List;
import org.brian.assetmanagement.bean.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Employee getByEmail(String email);

	@Query("select e.name from Employee e")
	List<String> getNameonly();
}