package org.karpisiewicz.controller;

import com.vaadin.data.fieldgroup.FieldGroup;
import javax.validation.Valid;
import org.karpisiewicz.entity.Company;
import org.karpisiewicz.form.company.CompanyCreateForm;
import org.karpisiewicz.form.company.CompanyEditForm;
import org.karpisiewicz.form.company.CompanyGetForm;
import org.karpisiewicz.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/user/{user_id}/company", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    CompanyGetForm createCompany(@Valid @RequestBody CompanyCreateForm companyCreateForm, @PathVariable("user_id") Long userId, BindingResult result) throws BindException {

        if(result.hasErrors()){throw new BindException(result);}
        
        Company company = companyService.createCompany(companyCreateForm, userId);
        CompanyGetForm companyGetForm = mapCompanyToCompanyGetForm(company);
        return companyGetForm;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/user/company/{company_id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    CompanyGetForm editCompany(@Valid @RequestBody CompanyEditForm companyEditForm, @PathVariable("company_id") Long companyId, BindingResult result) throws BindException {

        if(result.hasErrors()){throw new BindException(result);}
        
        Company company = companyService.editCompany(companyEditForm, companyId);
        CompanyGetForm companyGetForm = mapCompanyToCompanyGetForm(company);
        return companyGetForm;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/user/company/{company_id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    CompanyGetForm getCompany(@PathVariable("company_id") Long companyId) {

        Company company = companyService.getCompany(companyId);
        CompanyGetForm companyGetForm = mapCompanyToCompanyGetForm(company);
        return companyGetForm;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/user/company/{company_id}", method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody
    CompanyGetForm deleteCompany(@PathVariable("company_id") Long companyId) {

        Company company = companyService.deleteCompany(companyId);
        CompanyGetForm companyGetForm = mapCompanyToCompanyGetForm(company);
        return companyGetForm;
    }

    private CompanyGetForm mapCompanyToCompanyGetForm(Company company) {

        CompanyGetForm companyGetForm = new CompanyGetForm(
                company.getId(),
                company.getName());
        
        return companyGetForm;

    }
}
