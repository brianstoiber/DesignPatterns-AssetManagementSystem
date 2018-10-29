package org.brian.assetmanagement.service;

import java.util.List;
import org.brian.assetmanagement.bean.Employee;

public interface EmployeeService {
	public void save(Employee employee);

	public Employee getEmployee(Long employeeId);

	public void delete(Long employeeId);

	public void delete(Employee employee);

	public List<Employee> getAll();

	public List<String> getEmployeeNamesOnly();

	public void deleteInBatch(List<Employee> selectedEmployees);
}