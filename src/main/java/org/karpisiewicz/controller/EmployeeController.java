package org.karpisiewicz.controller;

import org.karpisiewicz.entity.Employee;
import org.karpisiewicz.form.employee.EmployeeCreateForm;
import org.karpisiewicz.form.employee.EmployeeEditForm;
import org.karpisiewicz.form.employee.EmployeeGetForm;
import org.karpisiewicz.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/user/company/{company_id}/employee", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    EmployeeGetForm createEmployee(@RequestBody EmployeeCreateForm employeeCreateForm, @PathVariable("company_id") Long companyId) {

        Employee employee = employeeService.createEmployee(employeeCreateForm, companyId);
        EmployeeGetForm employeeGetForm = mapEmployeeToEmployeeGetForm(employee);
        return employeeGetForm;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/user/company/employee/{employee_id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    EmployeeGetForm editEmployee(@RequestBody EmployeeEditForm employeeEditForm, @PathVariable("employee_id") Long employeeId) {

        Employee employee = employeeService.editEmployee(employeeEditForm, employeeId);
        EmployeeGetForm employeeGetForm = mapEmployeeToEmployeeGetForm(employee);
        return employeeGetForm;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/user/company/employee/{employee_id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    EmployeeGetForm getEmployee(@PathVariable("employee_id") Long employeeId) {

        Employee employee = employeeService.getEmployee(employeeId);
        EmployeeGetForm employeeGetForm = mapEmployeeToEmployeeGetForm(employee);
        return employeeGetForm;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/user/company/employee/{employee_id}", method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody
    EmployeeGetForm deleteEmployee(@PathVariable("employee_id") Long employeeId) {

        Employee employee = employeeService.deleteEmployee(employeeId);
        EmployeeGetForm employeeGetForm = mapEmployeeToEmployeeGetForm(employee);
        return employeeGetForm;
    }

    private EmployeeGetForm mapEmployeeToEmployeeGetForm(Employee employee) {

        EmployeeGetForm employeeGetForm = new EmployeeGetForm(
                employee.getId(),
                employee.getName(),
                employee.getSurname());
        
        return employeeGetForm;

    }
}
