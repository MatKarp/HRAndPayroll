package org.karpisiewicz.service;

import org.karpisiewicz.entity.Employee;
import org.karpisiewicz.form.employee.EmployeeCreateForm;
import org.karpisiewicz.form.employee.EmployeeEditForm;

public interface EmployeeService {
    
    Employee createEmployee(EmployeeCreateForm employeeCreateForm, Long companyId);
    
    Employee editEmployee(EmployeeEditForm employeeEditForm, Long employeeId);

    Employee getEmployee(Long employeeId);
    
    Employee deleteEmployee(Long employeeId);
        
    }
