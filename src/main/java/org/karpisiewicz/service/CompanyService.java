package org.karpisiewicz.service;

import org.karpisiewicz.entity.Company;
import org.karpisiewicz.form.company.CompanyCreateForm;
import org.karpisiewicz.form.company.CompanyEditForm;

public interface CompanyService{
    
    Company createCompany(CompanyCreateForm companyCreateForm, Long userId);
    
    Company editCompany(CompanyEditForm companyEditForm, Long companyId);

    Company getCompany(Long companyId);
    
    Company deleteCompany(Long companyId);
        
}
