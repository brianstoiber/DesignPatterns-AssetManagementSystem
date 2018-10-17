package org.brian.assetmanagement.service.impl;

import java.util.List;
import org.brian.assetmanagement.bean.Employee;
import org.brian.assetmanagement.repository.EmployeeRepository;
import org.brian.assetmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	public EmployeeRepository empRepo;

	@Override
	public void save(Employee employee) {
		empRepo.save(employee);
	}

	@Override
	public Employee getEmployee(Long employeeId) {
		return empRepo.findOne(employeeId);
	}

	@Override
	public void delete(Long employeeId) {
		empRepo.delete(employeeId);
	}

	@Override
	public void delete(Employee employee) {
		empRepo.delete(employee);
	}

	@Override
    public List<Employee> getAll() {
        return empRepo.findAll();
    }
