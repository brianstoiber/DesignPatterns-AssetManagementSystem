package org.brian.assetmanagement.repository;

import org.brian.assetmanagement.bean.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Employee getByEmail(String email);
}