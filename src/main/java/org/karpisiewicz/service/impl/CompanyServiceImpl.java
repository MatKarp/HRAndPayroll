package org.karpisiewicz.service.impl;

import org.karpisiewicz.entity.Company;
import org.karpisiewicz.form.company.CompanyCreateForm;
import org.karpisiewicz.form.company.CompanyEditForm;
import org.karpisiewicz.repository.CompanyRepository;
import org.karpisiewicz.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService{
    
    @Autowired
    CompanyRepository companyRepository;

    @Override
    public Company createCompany(CompanyCreateForm companyCreateForm, Long userId) {
        
        Company company = new Company(companyCreateForm.getName());
        
        company = companyRepository.save(company);
        
        return company;     
    }

    @Override
    public Company editCompany(CompanyEditForm companyEditForm, Long companyId) {
        
        Company company = companyRepository.findOne(companyId);
        
        company.setName(companyEditForm.getName());
        
        company = companyRepository.save(company);
        
        return company;
    }

    @Override
    public Company getCompany(Long companyId) {
        
        Company company = companyRepository.findOne(companyId);
        
        return company;
    }

    @Override
    public Company deleteCompany(Long companyId) {
        
        Company company = companyRepository.findOne(companyId);
        
        companyRepository.delete(company);
        
        return company;
    }
      
}
