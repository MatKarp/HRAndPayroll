package org.karpisiewicz.service;

import java.util.List;
import org.karpisiewicz.entity.Contract;
import org.karpisiewicz.form.contract.ContractCreateForm;
import org.karpisiewicz.form.contract.ContractEditForm;

public interface ContractService{
    
    Contract createContract(ContractCreateForm contractCreateForm, Long userId, Long scheduleId);
    
    Contract editContract(ContractEditForm contractEditForm, Long contractId);

    Contract getContract(Long contractId);
    
    Contract deleteContract(Long contractId);
    
    List<String> getContractType();
        
}
