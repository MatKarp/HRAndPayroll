package org.karpisiewicz.service.impl;

import org.karpisiewicz.entity.Company;
import org.karpisiewicz.entity.Employee;
import org.karpisiewicz.form.employee.EmployeeCreateForm;
import org.karpisiewicz.form.employee.EmployeeEditForm;
import org.karpisiewicz.repository.EmployeeRepository;
import org.karpisiewicz.service.CompanyService;
import org.karpisiewicz.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    CompanyService companyService;

    @Override
    public Employee createEmployee(EmployeeCreateForm employeeCreateForm, Long companyId) {

        Company company = companyService.getCompany(companyId);

        Employee employee = new Employee(
                employeeCreateForm.getName(),
                employeeCreateForm.getSurname(),
                company);

        employee = employeeRepository.save(employee);

        return employee;
    }

    @Override
    public Employee editEmployee(EmployeeEditForm employeeEditForm, Long employeeId) {

        Employee employee = employeeRepository.findOne(employeeId);

        employee.setName(employeeEditForm.getName());
        employee.setSurname(employeeEditForm.getSurname());

        employee = employeeRepository.save(employee);

        return employee;

    }

    @Override
    public Employee getEmployee(Long employeeId) {

        Employee employee = employeeRepository.findOne(employeeId);

        return employee;
    }

    @Override
    public Employee deleteEmployee(Long employeeId) {

        Employee employee = employeeRepository.findOne(employeeId);

        employeeRepository.delete(employee);

        return employee;
    }

}
